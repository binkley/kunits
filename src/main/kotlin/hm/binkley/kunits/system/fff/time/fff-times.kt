package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Times
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.finite.FixedBigRational
import hm.binkley.math.finite.FixedBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class FffTimes<U : FffTimes<U>>(
    name: String,
    fortnights: FixedBigRational
) : Times<FFF, U>(FFF, name, fortnights)

object Fortnights : FffTimes<Fortnights>("fortnight", ONE) {
    override fun new(value: FixedBigRational) = Fortnight(value)
    override fun format(value: FixedBigRational) = "$value ftn"
}

class Fortnight(value: FixedBigRational) :
    Measure<FFF, Fortnights>(Fortnights, value)

val Int.fortnights get() = (this over 1).fortnights
val FixedBigRational.fortnights get() = Fortnight(this)
