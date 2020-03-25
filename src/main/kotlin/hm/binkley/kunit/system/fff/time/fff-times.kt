package hm.binkley.kunit.system.fff.time

import hm.binkley.kunit.Measure
import hm.binkley.kunit.Times
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.div
import hm.binkley.math.finite.over
import hm.binkley.math.finite.times

sealed class FffTimes<U : FffTimes<U>>(
    name: String,
    internal val fortnights: FiniteBigRational
) : Times<U>(name)

object Fortnights : FffTimes<Fortnights>(
    "Fortnight",
    FiniteBigRational.ONE
) {
    override fun new(value: FiniteBigRational) =
        Fortnight(
            value
        )

    override fun format(value: FiniteBigRational) = "$value ftn"
}

class Fortnight(value: FiniteBigRational) :
    Measure<Fortnights>(
        Fortnights, value
    )

val Int.fortnights
    get() = (this over 1).fortnights
val FiniteBigRational.fortnights
    get() = Fortnight(
        this
    )

fun <U : FffTimes<U>, V : FffTimes<V>> Measure<U>.to(other: V) =
    other.new(value * unit.fortnights / other.fortnights)
