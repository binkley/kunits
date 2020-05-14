package hm.binkley.kunits.system.fff.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.finite.FixedBigRational
import hm.binkley.math.finite.FixedBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class FffLengths<U : FffLengths<U>>(
    name: String,
    furlongs: FixedBigRational
) : Lengths<FFF, U>(
    FFF, name, furlongs
)

object Furlongs : FffLengths<Furlongs>("furlong", ONE) {
    override fun new(value: FixedBigRational) = Furlong(value)
    override fun format(value: FixedBigRational) = "$value fur"
}

class Furlong(value: FixedBigRational) :
    Measure<FFF, Furlongs>(Furlongs, value)

val Int.furlongs get() = (this over 1).furlongs
val FixedBigRational.furlongs get() = Furlong(this)
