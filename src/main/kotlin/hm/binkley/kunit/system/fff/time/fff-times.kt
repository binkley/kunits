package hm.binkley.kunit.system.fff.time

import hm.binkley.kunit.Measure
import hm.binkley.kunit.Times
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class FffTimes<U : FffTimes<U>>(
    name: String,
    fortnights: FiniteBigRational
) : Times<U>(name, fortnights)

object Fortnights : FffTimes<Fortnights>("Fortnight", ONE) {
    override fun new(value: FiniteBigRational) = Fortnight(value)
    override fun format(value: FiniteBigRational) = "$value ftn"
}

class Fortnight(value: FiniteBigRational) :
    Measure<Fortnights>(Fortnights, value)

val Int.fortnights get() = (this over 1).fortnights
val FiniteBigRational.fortnights get() = Fortnight(this)
