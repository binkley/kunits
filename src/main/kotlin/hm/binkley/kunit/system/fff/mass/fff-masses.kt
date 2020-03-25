package hm.binkley.kunit.system.fff.mass

import hm.binkley.kunit.Masses
import hm.binkley.kunit.Measure
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.div
import hm.binkley.math.finite.over
import hm.binkley.math.finite.times

sealed class FffMasses<U : FffMasses<U>>(
    name: String,
    internal val firkins: FiniteBigRational
) : Masses<U>(name)

object Firkins : FffMasses<Firkins>(
    "Firkin",
    FiniteBigRational.ONE
) {
    override fun new(value: FiniteBigRational) =
        Firkin(
            value
        )

    override fun format(value: FiniteBigRational) = "$value fir"
}

class Firkin(value: FiniteBigRational) :
    Measure<Firkins>(
        Firkins, value
    )

val Int.firkins
    get() = (this over 1).firkins
val FiniteBigRational.firkins
    get() = Firkin(
        this
    )

fun <U : FffMasses<U>, V : FffMasses<V>> Measure<U>.to(other: V) =
    other.new(value * unit.firkins / other.firkins)
