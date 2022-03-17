package hm.binkley.kunits.system.fff.length

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of length. */
sealed class FFFLengths<U : FFFLengths<U>>(
    name: String,
    furlongs: FixedBigRational,
) : Units<FFF, U>(FFF, name, furlongs)

class Furlong(quantity: FixedBigRational) :
    Measure<FFF, Furlongs>(Furlongs, quantity) {
    companion object Furlongs : FFFLengths<Furlongs>(
        "furlong", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Furlong(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity fur"
    }
}

val FixedBigRational.furlongs get() = Furlongs.new(this)
val Long.furlongs get() = (this over 1).furlongs
val Int.furlongs get() = (this over 1).furlongs
