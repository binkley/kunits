package hm.binkley.kunits.system.discworld.ankhMorpork.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.discworld.ankhMorpork.AnkhMorpork
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Dollar.Dollars
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Penny.Pennies
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The AnkhMorpork denominations. */
sealed class AnkhMorporkDenominations<
    U : AnkhMorporkDenominations<U, M>,
    M : AnkhMorporkDenomination<U, M>
    >(
    name: String,
    dollars: FixedBigRational
) : Units<Denomination, AnkhMorpork, U, M>(
    Denomination,
    AnkhMorpork,
    name,
    dollars
)

sealed class AnkhMorporkDenomination<
    U : AnkhMorporkDenominations<U, M>,
    M : AnkhMorporkDenomination<U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Denomination, AnkhMorpork, U, M>(unit, quantity)

class Dollar private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Dollars, Dollar>(Dollars, quantity) {
    companion object Dollars : AnkhMorporkDenominations<Dollars, Dollar>(
        "dollar",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Dollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $1"
    }
}

val FixedBigRational.dollars get() = Dollars.new(this)
val Long.dollars get() = (this over 1).dollars
val Int.dollars get() = (this over 1).dollars

class Penny private constructor(quantity: FixedBigRational) :
    AnkhMorporkDenomination<Pennies, Penny>(Pennies, quantity) {
    companion object Pennies : AnkhMorporkDenominations<Pennies, Penny>(
        "penny",
        1 over 240
    ) {
        override fun new(quantity: FixedBigRational) = Penny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 1p"
    }
}

val FixedBigRational.pennies get() = Pennies.new(this)
val Long.pennies get() = (this over 1).pennies
val Int.pennies get() = (this over 1).pennies
