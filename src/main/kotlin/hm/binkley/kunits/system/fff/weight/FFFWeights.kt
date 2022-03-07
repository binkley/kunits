package hm.binkley.kunits.system.fff.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Weights
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.weight.Firkin.Firkins
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of weight. */
sealed class FFFWeights<U : FFFWeights<U>>(
    name: String,
    firkins: FixedBigRational,
) : Weights<FFF, U>(FFF, name, firkins)

class Firkin private constructor(value: FixedBigRational) :
    Measure<FFF, Firkins>(Firkins, value) {

    companion object Firkins : FFFWeights<Firkins>("firkin", ONE) {
        override fun new(value: FixedBigRational) = Firkin(value)
        override fun format(value: FixedBigRational) = "$value fir"
    }
}

val Int.firkins get() = (this over 1).firkins
val Long.firkins get() = (this over 1).firkins
val FixedBigRational.firkins get() = Firkins.new(this)
