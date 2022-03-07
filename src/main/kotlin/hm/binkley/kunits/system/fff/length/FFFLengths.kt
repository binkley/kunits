package hm.binkley.kunits.system.fff.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of length. */
sealed class FFFLengths<U : FFFLengths<U>>(
    name: String,
    furlongs: FixedBigRational,
) : Lengths<FFF, U>(FFF, name, furlongs)

class Furlong(value: FixedBigRational) :
    Measure<FFF, Furlongs>(Furlongs, value) {

    companion object Furlongs : FFFLengths<Furlongs>("furlong", ONE) {
        override fun new(value: FixedBigRational) = Furlong(value)
        override fun format(value: FixedBigRational) = "$value fur"
    }
}

val Int.furlongs get() = (this over 1).furlongs
val Long.furlongs get() = (this over 1).furlongs
val FixedBigRational.furlongs get() = Furlongs.new(this)
