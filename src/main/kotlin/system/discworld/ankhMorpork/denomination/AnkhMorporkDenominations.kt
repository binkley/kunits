package hm.binkley.kunits.system.discworld.ankhMorpork.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.discworld.ankhMorpork.AnkhMorpork
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Dollar.Dollars
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Elim.Elims
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Farthing.Farthings
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Groat.Groats
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Halfpenny.Halfpennies
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Mite.Mites
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Penny.Pence
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Shilling.Shillings
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Sixpence.Sixpences
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Thruppenny.Thruppence
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Tuppenny.Tuppence
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The AnkhMorpork denominations. */
sealed class AnkhMorporkDenominations<
    U : AnkhMorporkDenominations<U, M>,
    M : AnkhMorporkDenomination<U, M>
    >(
    name: String,
    pence: FixedBigRational
) : Units<Denomination, AnkhMorpork, U, M>(
    Denomination,
    AnkhMorpork,
    name,
    pence
)

sealed class AnkhMorporkDenomination<
    U : AnkhMorporkDenominations<U, M>,
    M : AnkhMorporkDenomination<U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Denomination, AnkhMorpork, U, M>(unit, quantity)

class Elim private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Elims, Elim>(Elim, quantity) {
    companion object Elims :
        AnkhMorporkDenominations<Elims, Elim>(
            "elim",
            (1 over 16)
        ) {
        override fun new(quantity: FixedBigRational) = Elim(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity elims"
    }
}

val FixedBigRational.elims get() = Elim.new(this)
val Long.elims get() = (this over 1).elims
val Int.elims get() = (this over 1).elims

class Mite private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Mites, Mite>(Mite, quantity) {
    companion object Mites :
        AnkhMorporkDenominations<Mites, Mite>(
            "mite",
            (1 over 8)
        ) {
        override fun new(quantity: FixedBigRational) = Mite(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity mites"
    }
}

val FixedBigRational.mites get() = Mite.new(this)
val Long.mites get() = (this over 1).mites
val Int.mites get() = (this over 1).mites

class Farthing private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Farthings, Farthing>(Farthing, quantity) {
    companion object Farthings :
        AnkhMorporkDenominations<Farthings, Farthing>(
            "farthing",
            (1 over 4)
        ) {
        override fun new(quantity: FixedBigRational) = Farthing(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity farthings"
    }
}

val FixedBigRational.farthings get() = Farthing.new(this)
val Long.farthings get() = (this over 1).farthings
val Int.farthings get() = (this over 1).farthings

class Halfpenny private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Halfpennies, Halfpenny>(Halfpenny, quantity) {
    companion object Halfpennies :
        AnkhMorporkDenominations<Halfpennies, Halfpenny>(
            "halfpenny",
            (1 over 2)
        ) {
        override fun new(quantity: FixedBigRational) = Halfpenny(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity halfpennies"
    }
}

val FixedBigRational.halfpennies get() = Halfpenny.new(this)
val Long.halfpennies get() = (this over 1).halfpennies
val Int.halfpennies get() = (this over 1).halfpennies

class Penny private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Pence, Penny>(Pence, quantity) {
    companion object Pence : AnkhMorporkDenominations<Pence, Penny>(
        "penny",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Penny(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}p"
    }
}

val FixedBigRational.pence get() = Pence.new(this)
val Long.pence get() = (this over 1).pence
val Int.pence get() = (this over 1).pence

// Common synonym depending on usage
val FixedBigRational.pennies get() = Pence.new(this)
val Long.pennies get() = (this over 1).pence
val Int.pennies get() = (this over 1).pence

class Tuppenny private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Tuppence, Tuppenny>(Tuppenny, quantity) {
    companion object Tuppence :
        AnkhMorporkDenominations<Tuppence, Tuppenny>(
            "tuppenny",
            (2 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Tuppenny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity tuppence"
    }
}

val FixedBigRational.tuppence get() = Tuppenny.new(this)
val Long.tuppence get() = (this over 1).tuppence
val Int.tuppence get() = (this over 1).tuppence

class Thruppenny private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Thruppence, Thruppenny>(Thruppenny, quantity) {
    companion object Thruppence :
        AnkhMorporkDenominations<Thruppence, Thruppenny>(
            "thruppenny",
            (3 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Thruppenny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity thruppence"
    }
}

val FixedBigRational.thruppence get() = Thruppenny.new(this)
val Long.thruppence get() = (this over 1).thruppence
val Int.thruppence get() = (this over 1).thruppence

class Groat private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Groats, Groat>(Groat, quantity) {
    companion object Groats :
        AnkhMorporkDenominations<Groats, Groat>(
            "groat",
            (4 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Groat(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity groats"
    }
}

val FixedBigRational.groats get() = Groat.new(this)
val Long.groats get() = (this over 1).groats
val Int.groats get() = (this over 1).groats

class Sixpence private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Sixpences, Sixpence>(Sixpence, quantity) {
    companion object Sixpences :
        AnkhMorporkDenominations<Sixpences, Sixpence>(
            "sixpence",
            (6 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Sixpence(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sixpences"
    }
}

val FixedBigRational.sixpences get() = Sixpence.new(this)
val Long.sixpences get() = (this over 1).sixpences
val Int.sixpences get() = (this over 1).sixpences

/** Note that the "King's Shilling" is in fact a dollar. */
class Shilling private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Shillings, Shilling>(Shillings, quantity) {
    companion object Shillings : AnkhMorporkDenominations<Shillings, Shilling>(
        "shilling",
        (12 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Shilling(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}s"
    }
}

val FixedBigRational.shillings get() = Shillings.new(this)
val Long.shillings get() = (this over 1).shillings
val Int.shillings get() = (this over 1).shillings

class Dollar private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Dollars, Dollar>(Dollars, quantity) {
    companion object Dollars : AnkhMorporkDenominations<Dollars, Dollar>(
        "dollar",
        (240 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Dollar(quantity)
        override fun format(quantity: FixedBigRational) = "$$quantity"
    }
}

val FixedBigRational.dollars get() = Dollars.new(this)
val Long.dollars get() = (this over 1).dollars
val Int.dollars get() = (this over 1).dollars

class Guinea private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Guinea.Guineas, Guinea>(Guineas, quantity) {
    companion object Guineas : AnkhMorporkDenominations<Guineas, Guinea>(
        "guinea",
        (252 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Guinea(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity guineas"
    }
}

val FixedBigRational.guineas get() = Guinea.Guineas.new(this)
val Long.guineas get() = (this over 1).guineas
val Int.guineas get() = (this over 1).guineas
