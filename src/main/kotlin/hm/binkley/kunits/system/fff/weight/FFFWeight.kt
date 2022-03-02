package hm.binkley.kunits.system.fff.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Weight
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of weight. */
sealed class FFFWeight<U : FFFWeight<U>>(
    name: String,
    firkins: FixedBigRational
) : Weight<FFF, U>(FFF, name, firkins)

object Firkins : FFFWeight<Firkins>("firkin", ONE) {
    override fun new(value: FixedBigRational) = Firkin(value)
    override fun format(value: FixedBigRational) = "$value fir"
}

class Firkin(value: FixedBigRational) : Measure<FFF, Firkins>(Firkins, value)

val Int.firkins get() = (this over 1).firkins
val Long.firkins get() = (this over 1).firkins
val FixedBigRational.firkins get() = Firkins.new(this)
