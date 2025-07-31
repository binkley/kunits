package hm.binkley.kunits.system.english.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.denomination.Angel.Angels
import hm.binkley.kunits.system.english.denomination.Crown.Crowns
import hm.binkley.kunits.system.english.denomination.DoubleSovereign.DoubleSovereigns
import hm.binkley.kunits.system.english.denomination.Farthing.Farthings
import hm.binkley.kunits.system.english.denomination.Florin.Florins
import hm.binkley.kunits.system.english.denomination.Groat.Groats
import hm.binkley.kunits.system.english.denomination.Guinea.Guineas
import hm.binkley.kunits.system.english.denomination.HalfAngel.HalfAngels
import hm.binkley.kunits.system.english.denomination.HalfCrown.HalfCrowns
import hm.binkley.kunits.system.english.denomination.Halffarthing.Halffarthings
import hm.binkley.kunits.system.english.denomination.HalfGuinea.HalfGuineas
import hm.binkley.kunits.system.english.denomination.HalfNoble.HalfNobles
import hm.binkley.kunits.system.english.denomination.HalfSovereign.HalfSovereigns
import hm.binkley.kunits.system.english.denomination.Halfpenny.Halfpence
import hm.binkley.kunits.system.english.denomination.Leopard.Leopards
import hm.binkley.kunits.system.english.denomination.Mark.Marks
import hm.binkley.kunits.system.english.denomination.Mite.Mites
import hm.binkley.kunits.system.english.denomination.Noble.Nobles
import hm.binkley.kunits.system.english.denomination.Penny.Pence
import hm.binkley.kunits.system.english.denomination.Pound.Pounds
import hm.binkley.kunits.system.english.denomination.QuarterAngel.QuarterAngels
import hm.binkley.kunits.system.english.denomination.Quarterfarthing.Quarterfarthings
import hm.binkley.kunits.system.english.denomination.QuarterNoble.QuarterNobles
import hm.binkley.kunits.system.english.denomination.QuintupleSovereign.QuintupleSovereigns
import hm.binkley.kunits.system.english.denomination.Shilling.Shillings
import hm.binkley.kunits.system.english.denomination.Sixpenny.Sixpence
import hm.binkley.kunits.system.english.denomination.Sovereign.Sovereigns
import hm.binkley.kunits.system.english.denomination.Thirdfarthing.Thirdfarthings
import hm.binkley.kunits.system.english.denomination.Threefarthing.Threefarthings
import hm.binkley.kunits.system.english.denomination.Threepenny.Threepence
import hm.binkley.kunits.system.english.denomination.Twopenny.Twopence
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over
import hm.binkley.math.isNegative
import hm.binkley.math.isZero

/** The English units of denomination. */
sealed class EnglishDenominations<
    U : EnglishDenominations<U, M>,
    M : EnglishDenomination<U, M>
    >(
    name: String,
    pence: FixedBigRational
) : Units<Denomination, English, U, M>(Denomination, English, name, pence)

sealed class EnglishDenomination<
    U : EnglishDenominations<U, M>,
    M : EnglishDenomination<U, M>
    >(
    units: U,
    quantity: FixedBigRational
) : Measure<Denomination, English, U, M>(units, quantity)

/**
 * Formats this amount in traditional pre-decimal English currency style.
 *
 * Examples:
 * - 0 pence is "0d" rather than "-/-/-"
 * - 2 shillings and 4 pence is "2/4" (no leading "-/" for zero pounds)
 * - 2 pounds, 42 shillings, and 4 pence is "4/2/4" (extra shillings are pounds)
 */
fun EnglishDenomination<*, *>.formatTraditional(): String {
    if (quantity.isZero()) return "0d"
    val (pounds, shillings, pence) = into(Pounds, Shillings, Pence)
    val sign = if (quantity.isNegative()) "-" else ""
    val lbs = pounds.quantity.absoluteValue
    val s = shillings.quantity.absoluteValue
    val d = pence.quantity.absoluteValue
    if (s.isZero() && d.isZero()) return "$sign£$lbs"
    if (lbs.isZero() && s.isZero()) return "$sign${d}d"
    val buffer = StringBuffer(sign)
    if (!lbs.isZero()) buffer.append("£$lbs ")
    if (s.isZero()) buffer.append("-/") else buffer.append("$s/")
    if (d.isZero()) buffer.append("-") else buffer.append("$d")
    return buffer.toString()
}

class Mite private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Mites, Mite>(Mites, quantity) {
    companion object Mites : EnglishDenominations<Mites, Mite>(
        "mite",
        (1 over 24)
    ) {
        override fun new(quantity: FixedBigRational) = Mite(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity mites"
    }
}

val FixedBigRational.mites get() = Mites.new(this)
val Long.mites get() = (this over 1).mites
val Int.mites get() = (this over 1).mites

class Quarterfarthing private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Quarterfarthings, Quarterfarthing>(
        Quarterfarthings,
        quantity
    ) {
    companion object Quarterfarthings :
        EnglishDenominations<Quarterfarthings, Quarterfarthing>(
            "quarterfarthing",
            (1 over 16)
        ) {
        override fun new(quantity: FixedBigRational) = Quarterfarthing(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity quarterfarthings"
    }
}

val FixedBigRational.quarterfarthings get() = Quarterfarthings.new(this)
val Long.quarterfarthings get() = (this over 1).quarterfarthings
val Int.quarterfarthings get() = (this over 1).quarterfarthings

class Thirdfarthing private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Thirdfarthings, Thirdfarthing>(
        Thirdfarthings,
        quantity
    ) {
    companion object Thirdfarthings :
        EnglishDenominations<Thirdfarthings, Thirdfarthing>(
            "thirdfarthing",
            (1 over 12)
        ) {
        override fun new(quantity: FixedBigRational) = Thirdfarthing(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity thirdfarthings"
    }
}

val FixedBigRational.thirdfarthings get() = Thirdfarthings.new(this)
val Long.thirdfarthings get() = (this over 1).thirdfarthings
val Int.thirdfarthings get() = (this over 1).thirdfarthings

class Halffarthing private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Halffarthings, Halffarthing>(Halffarthings, quantity) {
    companion object Halffarthings :
        EnglishDenominations<Halffarthings, Halffarthing>(
            "halffarthing",
            (1 over 8)
        ) {
        override fun new(quantity: FixedBigRational) = Halffarthing(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity halffarthings"
    }
}

val FixedBigRational.halffarthings get() = Halffarthings.new(this)
val Long.halffarthings get() = (this over 1).halffarthings
val Int.halffarthings get() = (this over 1).halffarthings

class Farthing private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Farthings, Farthing>(Farthings, quantity) {
    companion object Farthings : EnglishDenominations<Farthings, Farthing>(
        "farthing",
        (1 over 4)
    ) {
        override fun new(quantity: FixedBigRational) = Farthing(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity farthings"
    }
}

val FixedBigRational.farthings get() = Farthings.new(this)
val Long.farthings get() = (this over 1).farthings
val Int.farthings get() = (this over 1).farthings

class Halfpenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Halfpence, Halfpenny>(Halfpence, quantity) {
    companion object Halfpence : EnglishDenominations<Halfpence, Halfpenny>(
        "halfpenny",
        (1 over 2)
    ) {
        override fun new(quantity: FixedBigRational) = Halfpenny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ha'pence"
    }
}

val FixedBigRational.halfpence get() = Halfpence.new(this)
val Long.halfpence get() = (this over 1).halfpence
val Int.halfpence get() = (this over 1).halfpence

// Alias for halfpence (pronounced "hay penny")
// Typical API usage would simply call "halfpence".
val FixedBigRational.`ha'penny` get() = Halfpence.new(this)
val Long.`ha'penny` get() = (this over 1).halfpence
val Int.`ha'penny` get() = (this over 1).halfpence

class Threefarthing private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Threefarthings, Threefarthing>(
        Threefarthing,
        quantity
    ) {
    companion object Threefarthings :
        EnglishDenominations<Threefarthings, Threefarthing>(
            "threefarthing",
            (3 over 4)
        ) {
        override fun new(quantity: FixedBigRational) = Threefarthing(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity threefarthings"
    }
}

val FixedBigRational.threefarthings get() = Threefarthings.new(this)
val Long.threefarthings get() = (this over 1).threefarthings
val Int.threefarthings get() = (this over 1).threefarthings

class Penny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Pence, Penny>(Pence, quantity) {
    companion object Pence : EnglishDenominations<Pence, Penny>(
        "penny",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Penny(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}d"
    }
}

val FixedBigRational.pence get() = Pence.new(this)
val Long.pence get() = (this over 1).pence
val Int.pence get() = (this over 1).pence

class Twopenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Twopence, Twopenny>(Twopence, quantity) {
    companion object Twopence : EnglishDenominations<Twopence, Twopenny>(
        "twopenny",
        (2 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Twopenny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity tuppence"
    }
}

val FixedBigRational.twopence get() = Twopence.new(this)
val Long.twopence get() = (this over 1).twopence
val Int.twopence get() = (this over 1).twopence

// Alias for twopence (pronounced "tuh pence")
// Typical API usage would simply call "twopence".
val FixedBigRational.`tu'penny` get() = Twopence.new(this)
val Long.`tu'penny` get() = (this over 1).twopence
val Int.`tu'penny` get() = (this over 1).twopence

// Alias for twopence
val FixedBigRational.halfGroats get() = Twopence.new(this)
val Long.halfGroats get() = (this over 1).twopence
val Int.halfGroats get() = (this over 1).twopence

class Threepenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Threepence, Threepenny>(Threepenny, quantity) {
    companion object Threepence :
        EnglishDenominations<Threepence, Threepenny>(
            "threepenny",
            (3 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Threepenny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity thruppence"
    }
}

val FixedBigRational.threepence get() = Threepenny.new(this)
val Long.threepence get() = (this over 1).threepence
val Int.threepence get() = (this over 1).threepence

// Alias for threepenny
// Typical API usage would simply call "threepence".
val FixedBigRational.thruppence get() = Threepenny.new(this)
val Long.thruppence get() = (this over 1).threepence
val Int.thruppence get() = (this over 1).threepence

class Groat private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Groats, Groat>(Groats, quantity) {
    companion object Groats : EnglishDenominations<Groats, Groat>(
        "groat",
        (4 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Groat(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity groats"
    }
}

val FixedBigRational.groats get() = Groats.new(this)
val Long.groats get() = (this over 1).groats
val Int.groats get() = (this over 1).groats

class Sixpenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Sixpence, Sixpenny>(Sixpenny, quantity) {
    companion object Sixpence :
        EnglishDenominations<Sixpence, Sixpenny>(
            "sixpenny",
            (6 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Sixpenny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sixpence"
    }
}

val FixedBigRational.sixpence get() = Sixpenny.new(this)
val Long.sixpence get() = (this over 1).sixpence
val Int.sixpence get() = (this over 1).sixpence

// Alias for sixpenny
val FixedBigRational.tanners get() = Sixpenny.new(this)
val Long.tanners get() = (this over 1).sixpence
val Int.tanners get() = (this over 1).sixpence

class Shilling private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Shillings, Shilling>(Shilling, quantity) {
    companion object Shillings :
        EnglishDenominations<Shillings, Shilling>(
            "shilling",
            (12 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Shilling(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}s"
    }
}

val FixedBigRational.shillings get() = Shilling.new(this)
val Long.shillings get() = (this over 1).shillings
val Int.shillings get() = (this over 1).shillings

// Alias for shilling
val FixedBigRational.bob get() = Shilling.new(this)
val Long.bob get() = (this over 1).shillings
val Int.bob get() = (this over 1).shillings

class Florin private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Florins, Florin>(Florin, quantity) {
    companion object Florins :
        EnglishDenominations<Florins, Florin>(
            "florin",
            (24 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Florin(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity florins"
    }
}

val FixedBigRational.florins get() = Florin.new(this)
val Long.florins get() = (this over 1).florins
val Int.florins get() = (this over 1).florins

class QuarterAngel private constructor(quantity: FixedBigRational) :
    EnglishDenomination<QuarterAngels, QuarterAngel>(QuarterAngel, quantity) {
    companion object QuarterAngels :
        EnglishDenominations<QuarterAngels, QuarterAngel>(
            "gold quarter-angel",
            (24 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = QuarterAngel(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold quarter-angels"
    }
}

val FixedBigRational.quarterAngels get() = QuarterAngel.new(this)
val Long.quarterAngels get() = (this over 1).quarterAngels
val Int.quarterAngels get() = (this over 1).quarterAngels

class QuarterNoble private constructor(quantity: FixedBigRational) :
    EnglishDenomination<QuarterNobles, QuarterNoble>(QuarterNoble, quantity) {
    companion object QuarterNobles :
        EnglishDenominations<QuarterNobles, QuarterNoble>(
            "quarter-noble",
            (20 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = QuarterNoble(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity quarter-nobles"
    }
}

val FixedBigRational.quarterNobles get() = QuarterNoble.new(this)
val Long.quarterNobles get() = (this over 1).quarterNobles
val Int.quarterNobles get() = (this over 1).quarterNobles

class HalfCrown private constructor(quantity: FixedBigRational) :
    EnglishDenomination<HalfCrowns, HalfCrown>(HalfCrown, quantity) {
    companion object HalfCrowns :
        EnglishDenominations<HalfCrowns, HalfCrown>(
            "half-crown",
            (30 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = HalfCrown(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity half-crowns"
    }
}

val FixedBigRational.halfCrowns get() = HalfCrown.new(this)
val Long.halfCrowns get() = (this over 1).halfCrowns
val Int.halfCrowns get() = (this over 1).halfCrowns

class HalfNoble private constructor(quantity: FixedBigRational) :
    EnglishDenomination<HalfNobles, HalfNoble>(HalfNoble, quantity) {
    companion object HalfNobles :
        EnglishDenominations<HalfNobles, HalfNoble>(
            "half-noble",
            (50 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = HalfNoble(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity half-nobles"
    }
}

val FixedBigRational.halfNobles get() = HalfNoble.new(this)
val Long.halfNobles get() = (this over 1).halfNobles
val Int.halfNobles get() = (this over 1).halfNobles

class Crown private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Crowns, Crown>(Crown, quantity) {
    companion object Crowns :
        EnglishDenominations<Crowns, Crown>(
            "crown",
            (60 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Crown(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity crowns"
    }
}

val FixedBigRational.crowns get() = Crown.new(this)
val Long.crowns get() = (this over 1).crowns
val Int.crowns get() = (this over 1).crowns

class HalfAngel private constructor(quantity: FixedBigRational) :
    EnglishDenomination<HalfAngels, HalfAngel>(HalfAngel, quantity) {
    companion object HalfAngels :
        EnglishDenominations<HalfAngels, HalfAngel>(
            "gold half-angel",
            (66 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = HalfAngel(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold half-angels"
    }
}

val FixedBigRational.halfAngels get() = HalfAngel.new(this)
val Long.halfAngels get() = (this over 1).halfAngels
val Int.halfAngels get() = (this over 1).halfAngels

/**
 * > Gold coins were first introduced in 1257, when a gold penny, designed for
 * > alms-giving, was issued by the English mints.
 * > Gold coins only became used more generally after 1344, when the leopard coin
 * > was issued.
 * > The leopard was officially valued the same as 72 silver pence, and also had
 * > half and quarter equivalents.
 * > ...
 * > As an example, in theory the value of a gold leopard was fixed at 72 silver
 * > pennies.
 * > But, if the market value of raw gold increased by relative to silver, by,
 * > say, around 10 percent, then it would beneficial to melt down any gold
 * > leopards and sell that raw gold on.
 * > Someone doing this would be realizing a profit of 8 pence on each of the
 * > gold coins they destroyed.
 * > This process quickly tended to drive gold coins out of circulation as they
 * > were melted down by their owners.
 * > If the value of gold fell relative to silver, one could profit by carrying
 * > out the process in reverse.
 */
class Leopard private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Leopards, Leopard>(Leopard, quantity) {
    companion object Leopards :
        EnglishDenominations<Leopards, Leopard>(
            "gold leopard",
            (72 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Leopard(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold leopards"
    }
}

val FixedBigRational.leopards get() = Leopard.new(this)
val Long.leopards get() = (this over 1).leopards
val Int.leopards get() = (this over 1).leopards

/**
 * This coin is troublesome. It changed value over its lifetime, and gold
 * coinage was never popular in England or Britain. So the exact value depends
 * on the year it was in use, however the angel led to many English pubs named
 * after the coin.
 *
 * See https://en.wikipedia.org/wiki/Angel_(coin).
 */
class Angel private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Angels, Angel>(Angel, quantity) {
    companion object Angels :
        EnglishDenominations<Angels, Angel>(
            "gold angel",
            (80 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Angel(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold angels"
    }
}

val FixedBigRational.angels get() = Angel.new(this)
val Long.angels get() = (this over 1).angels
val Int.angels get() = (this over 1).angels

/**
 * This coin is troublesome. It changed value over its lifetime, and gold
 * coinage was never popular in England or Britain. So the exact value depends
 * on the year it was in use, technically up until decimalisation.
 *
 * See https://en.wikipedia.org/wiki/Noble_(English_coin).
 */
class Noble private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Nobles, Noble>(Noble, quantity) {
    companion object Nobles :
        EnglishDenominations<Nobles, Noble>(
            "gold noble",
            (100 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Noble(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold nobles"
    }
}

val FixedBigRational.nobles get() = Noble.new(this)
val Long.nobles get() = (this over 1).nobles
val Int.nobles get() = (this over 1).nobles

class HalfSovereign private constructor(quantity: FixedBigRational) :
    EnglishDenomination<HalfSovereigns, HalfSovereign>(
        HalfSovereign,
        quantity
    ) {
    companion object HalfSovereigns :
        EnglishDenominations<HalfSovereigns, HalfSovereign>(
            "gold half-sovereign",
            (120 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = HalfSovereign(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold half-sovereigns"
    }
}

val FixedBigRational.halfSovereigns get() = HalfSovereign.new(this)
val Long.halfSovereigns get() = (this over 1).halfSovereigns
val Int.halfSovereigns get() = (this over 1).halfSovereigns

class HalfGuinea private constructor(quantity: FixedBigRational) :
    EnglishDenomination<HalfGuineas, HalfGuinea>(HalfGuinea, quantity) {
    companion object HalfGuineas :
        EnglishDenominations<HalfGuineas, HalfGuinea>(
            "half-guinea",
            (126 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = HalfGuinea(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity half-guineas"
    }
}

val FixedBigRational.halfGuineas get() = HalfGuinea.new(this)
val Long.halfGuineas get() = (this over 1).halfGuineas
val Int.halfGuineas get() = (this over 1).halfGuineas

class Mark private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Marks, Mark>(Mark, quantity) {
    companion object Marks :
        EnglishDenominations<Marks, Mark>(
            "mark",
            (160 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Mark(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity marks"
    }
}

val FixedBigRational.marks get() = Mark.new(this)
val Long.marks get() = (this over 1).marks
val Int.marks get() = (this over 1).marks

class Pound private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Pounds, Pound>(Pound, quantity) {
    companion object Pounds :
        EnglishDenominations<Pounds, Pound>(
            "pound",
            (240 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Pound(quantity)
        override fun format(quantity: FixedBigRational) = "£$quantity"
    }
}

val FixedBigRational.pounds get() = Pound.new(this)
val Long.pounds get() = (this over 1).pounds
val Int.pounds get() = (this over 1).pounds

// Alias for pound
val FixedBigRational.quid get() = Pound.new(this)
val Long.quid get() = (this over 1).pounds
val Int.quid get() = (this over 1).pounds

class Sovereign private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Sovereigns, Sovereign>(
        Sovereign,
        quantity
    ) {
    companion object Sovereigns :
        EnglishDenominations<Sovereigns, Sovereign>(
            "gold sovereign",
            (240 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Sovereign(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold sovereigns"
    }
}

val FixedBigRational.sovereigns get() = Sovereign.new(this)
val Long.sovereigns get() = (this over 1).sovereigns
val Int.sovereigns get() = (this over 1).sovereigns

class Guinea private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Guineas, Guinea>(Guinea, quantity) {
    companion object Guineas :
        EnglishDenominations<Guineas, Guinea>(
            "guinea",
            (252 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Guinea(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}gns"
    }
}

val FixedBigRational.guineas get() = Guinea.new(this)
val Long.guineas get() = (this over 1).guineas
val Int.guineas get() = (this over 1).guineas

class DoubleSovereign private constructor(quantity: FixedBigRational) :
    EnglishDenomination<DoubleSovereigns, DoubleSovereign>(
        DoubleSovereign,
        quantity
    ) {
    companion object DoubleSovereigns :
        EnglishDenominations<DoubleSovereigns, DoubleSovereign>(
            "gold double-sovereign",
            (480 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = DoubleSovereign(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity gold double-sovereigns"
    }
}

val FixedBigRational.doubleSovereigns get() = DoubleSovereign.new(this)
val Long.doubleSovereigns get() = (this over 1).doubleSovereigns
val Int.doubleSovereigns get() = (this over 1).doubleSovereigns

class QuintupleSovereign private constructor(quantity: FixedBigRational) :
    EnglishDenomination<QuintupleSovereigns, QuintupleSovereign>(
        QuintupleSovereign,
        quantity
    ) {
    companion object QuintupleSovereigns :
        EnglishDenominations<QuintupleSovereigns, QuintupleSovereign>(
            "gold quintuple-sovereign",
            (1200 over 1)
        ) {
        override fun new(quantity: FixedBigRational) =
            QuintupleSovereign(quantity)

        override fun format(quantity: FixedBigRational) =
            "$quantity gold quintuple-sovereigns"
    }
}

val FixedBigRational.quintupleSovereigns get() = QuintupleSovereign.new(this)
val Long.quintupleSovereigns get() = (this over 1).quintupleSovereigns
val Int.quintupleSovereigns get() = (this over 1).quintupleSovereigns
