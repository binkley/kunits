package hm.binkley.kunit.system.fff.length

import hm.binkley.kunit.Lengths
import hm.binkley.kunit.Measure
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class FffLengths<L : FffLengths<L>>(
    name: String,
    furlongs: FiniteBigRational
) : Lengths<L>(name, furlongs)

object Furlongs : FffLengths<Furlongs>("Furlong", ONE) {
    override fun new(value: FiniteBigRational) = Furlong(value)
    override fun format(value: FiniteBigRational) = "$value fur"
}

class Furlong(value: FiniteBigRational) :
    Measure<Furlongs>(Furlongs, value)

val Int.furlongs get() = (this over 1).furlongs
val FiniteBigRational.furlongs get() = Furlong(this)
