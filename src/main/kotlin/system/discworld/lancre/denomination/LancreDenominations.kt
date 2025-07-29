package hm.binkley.kunits.system.discworld.lancre.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.discworld.lancre.Lancre
import hm.binkley.kunits.system.discworld.lancre.denomination.Penny.Pennies
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The Lancre denominations. */
sealed class LancreDenominations<
    U : LancreDenominations<U, M>,
    M : LancreDenomination<U, M>
    >(
    name: String,
    pennies: FixedBigRational
) : Units<Denomination, Lancre, U, M>(
    Denomination,
    Lancre,
    name,
    pennies
)

sealed class LancreDenomination<
    U : LancreDenominations<U, M>,
    M : LancreDenomination<U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Denomination, Lancre, U, M>(unit, quantity)

class Penny private constructor(quantity: FixedBigRational) :
    LancreDenomination<Pennies, Penny>(Pennies, quantity) {
    companion object Pennies : LancreDenominations<Pennies, Penny>(
        "penny",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Penny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity¢"
    }
}

val FixedBigRational.pennies get() = Pennies.new(this)
val Long.pennies get() = (this over 1).pennies
val Int.pennies get() = (this over 1).pennies
