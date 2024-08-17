package hm.binkley.kunits.system.fff.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.Weight
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.weight.Firkin.Firkins
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of weight. */
sealed class FFFWeights<
    U : FFFWeights<U, M>,
    M : FFFWeight<U, M>
    >(
    name: String,
    furlongs: FixedBigRational
) : Units<Weight, FFF, U, M>(Weight, FFF, name, furlongs)

sealed class FFFWeight<
    U : FFFWeights<U, M>,
    M : FFFWeight<U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Weight, FFF, U, M>(unit, quantity)

/** One firkin (weight) is the weight of one firkin (volume) of water. */
class Firkin private constructor(quantity: FixedBigRational) :
    FFFWeight<Firkins, Firkin>(Firkins, quantity) {
    companion object Firkins : FFFWeights<Firkins, Firkin>(
        "firkin",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Firkin(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity fir"
    }
}

val FixedBigRational.firkins get() = Firkins.new(this)
val Long.firkins get() = (this over 1).firkins
val Int.firkins get() = (this over 1).firkins
