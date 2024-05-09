/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package hm.binkley.kunits.system.english.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.denomination.Crown.Crowns
import hm.binkley.kunits.system.english.denomination.DoubleSovereign.DoubleSovereigns
import hm.binkley.kunits.system.english.denomination.Farthing.Farthings
import hm.binkley.kunits.system.english.denomination.Florin.Florins
import hm.binkley.kunits.system.english.denomination.Groat.Groats
import hm.binkley.kunits.system.english.denomination.Guinea.Guineas
import hm.binkley.kunits.system.english.denomination.HalfCrown.HalfCrowns
import hm.binkley.kunits.system.english.denomination.Twopenny.Twopence
import hm.binkley.kunits.system.english.denomination.HalfGuinea.HalfGuineas
import hm.binkley.kunits.system.english.denomination.HalfNoble.HalfNobles
import hm.binkley.kunits.system.english.denomination.HalfSovereign.HalfSovereigns
import hm.binkley.kunits.system.english.denomination.Halfpenny.Halfpence
import hm.binkley.kunits.system.english.denomination.Mark.Marks
import hm.binkley.kunits.system.english.denomination.Noble.Nobles
import hm.binkley.kunits.system.english.denomination.Penny.Pence
import hm.binkley.kunits.system.english.denomination.Pound.Pounds
import hm.binkley.kunits.system.english.denomination.QuarterNoble.QuarterNobles
import hm.binkley.kunits.system.english.denomination.Shilling.Shillings
import hm.binkley.kunits.system.english.denomination.Sixpenny.Sixpence
import hm.binkley.kunits.system.english.denomination.Sovereign.Sovereigns
import hm.binkley.kunits.system.english.denomination.Threepenny.Threepence
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

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
        override fun format(quantity: FixedBigRational) =
            "$quantity halfpennies"
    }
}

val FixedBigRational.halfpence get() = Halfpence.new(this)
val Long.halfpence get() = (this over 1).halfpence
val Int.halfpence get() = (this over 1).halfpence

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
        override fun format(quantity: FixedBigRational) = "$quantity twopence"
    }
}

val FixedBigRational.twopence get() = Twopence.new(this)
val Long.twopence get() = (this over 1).twopence
val Int.twopence get() = (this over 1).twopence

// Aliases for twopenny
val FixedBigRational.tuppence get() = Twopence.new(this)
val Long.tuppence get() = (this over 1).twopence
val Int.tuppence get() = (this over 1).twopence
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
        override fun format(quantity: FixedBigRational) = "$quantity threepence"
    }
}

val FixedBigRational.threepence get() = Threepenny.new(this)
val Long.threepence get() = (this over 1).threepence
val Int.threepence get() = (this over 1).threepence

// Aliases for threepenny
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

// Aliases for sixpenny
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

// Aliases for shilling
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

/** @see Noble */
class QuarterNoble private constructor(quantity: FixedBigRational) :
    EnglishDenomination<QuarterNobles, QuarterNoble>(QuarterNoble, quantity) {
    companion object QuarterNobles :
        EnglishDenominations<QuarterNobles, QuarterNoble>(
            "quarter-noble",
            (25 over 1)
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

/** @see Noble */
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

// Aliases for pound
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
