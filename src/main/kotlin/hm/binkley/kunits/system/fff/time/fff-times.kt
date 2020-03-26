package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Times
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class FffTimes<U : FffTimes<U>>(
    name: String,
    fortnights: FiniteBigRational
) : Times<FFF, U>(FFF, name, fortnights)

object Fortnights : FffTimes<Fortnights>("fortnight", ONE) {
    override fun new(value: FiniteBigRational) = Fortnight(value)
    override fun format(value: FiniteBigRational) = "$value ftn"
}

class Fortnight(value: FiniteBigRational) :
    Measure<FFF, Fortnights>(Fortnights, value)

val Int.fortnights get() = (this over 1).fortnights
val FiniteBigRational.fortnights get() = Fortnight(this)
