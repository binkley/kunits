package hm.binkley.kunits.system.fff.mass

import hm.binkley.kunits.Masses
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.finite.FixedBigRational
import hm.binkley.math.finite.FixedBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class FffMasses<U : FffMasses<U>>(
    name: String,
    firkins: FixedBigRational
) : Masses<FFF, U>(FFF, name, firkins)

object Firkins : FffMasses<Firkins>("firkin", ONE) {
    override fun new(value: FixedBigRational) = Firkin(value)
    override fun format(value: FixedBigRational) = "$value fir"
}

class Firkin(value: FixedBigRational) : Measure<FFF, Firkins>(Firkins, value)

val Int.firkins get() = (this over 1).firkins
val Long.firkins get() = (this over 1).firkins
val FixedBigRational.firkins get() = Firkin(this)
