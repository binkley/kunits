package hm.binkley.kunits.system.fff.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

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
val Long.furlongs get() = (this over 1).furlongs
val FixedBigRational.furlongs get() = Furlong(this)
