package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.kunits.system.mit.length.Ear.Ears
import hm.binkley.kunits.system.mit.length.Smoot.Smoots
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

class Smoot private constructor(quantity: FixedBigRational) :
    Measure<Length, MIT, Smoots, Smoot>(Smoots, quantity) {
    companion object Smoots : Units<Length, MIT, Smoots, Smoot>(
        Length, MIT, "smoot", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Smoot(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sm"
    }
}

val FixedBigRational.smoots get() = Smoots.new(this)
val Long.smoots get() = (this over 1).smoots
val Int.smoots get() = (this over 1).smoots

class Ear(quantity: FixedBigRational) :
    Measure<Length, MIT, Ears, Ear>(Ears, quantity) {
    companion object Ears : Units<Length, MIT, Ears, Ear>(
        Length, MIT, "ear", 3 over 67
    ) {
        override fun new(quantity: FixedBigRational) = Ear(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ears"
    }
}

val FixedBigRational.ears get() = Ears.new(this)
val Long.ears get() = (this over 1).ears
val Int.ears get() = (this over 1).ears
