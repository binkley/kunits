package hm.binkley.kunit.system.fff.length

import hm.binkley.kunit.Lengths
import hm.binkley.kunit.Measure
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.div
import hm.binkley.math.finite.over
import hm.binkley.math.finite.times

sealed class FffLengths<L : FffLengths<L>>(
    name: String,
    internal val furlongs: FiniteBigRational
) : Lengths<L>(name)

object Furlongs : FffLengths<Furlongs>(
    "Furlong",
    FiniteBigRational.ONE
) {
    override fun new(value: FiniteBigRational) =
        Furlong(
            value
        )

    override fun format(value: FiniteBigRational) = "$value fur"
}

class Furlong(value: FiniteBigRational) :
    Measure<Furlongs>(
        Furlongs, value
    )

val Int.furlongs
    get() = (this over 1).furlongs
val FiniteBigRational.furlongs
    get() = Furlong(
        this
    )

fun <U : FffLengths<U>, V : FffLengths<V>> Measure<U>.to(other: V) =
    other.new(value * unit.furlongs / other.furlongs)
