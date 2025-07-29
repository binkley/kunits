package hm.binkley.kunits.system.discworld.ankhMorpork.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.discworld.ankhMorpork.AnkhMorpork
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Dollar.Dollars
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Penny.Pence
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Shilling.Shillings
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

/** Note that the "King's Shilling" is in fact a dollar. */
class Shilling private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Shillings, Shilling>(Shillings, quantity) {
    companion object Shillings : AnkhMorporkDenominations<Shillings, Shilling>(
        "shilling",
        (20 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Shilling(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}s"
    }
}

val FixedBigRational.shillings get() = Shillings.new(this)
val Long.shillings get() = (this over 1).shillings
val Int.shillings get() = (this over 1).shillings
