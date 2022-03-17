package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.kunits.system.mit.length.Ear.Ears
import hm.binkley.kunits.system.mit.length.Smoot.Smoots
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The MIT units of length. */
sealed class MITLengths<U : MITLengths<U>>(
    name: String,
    smoots: FixedBigRational,
) : Units<MIT, U>(MIT, name, smoots)

class Smoot private constructor(quantity: FixedBigRational) :
    Measure<MIT, Smoots>(Smoots, quantity) {
    companion object Smoots : MITLengths<Smoots>(
        "smoot", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Smoot(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sm"
    }
}

val FixedBigRational.smoots get() = Smoots.new(this)
val Long.smoots get() = (this over 1).smoots
val Int.smoots get() = (this over 1).smoots

class Ear(quantity: FixedBigRational) :
    Measure<MIT, Ears>(Ears, quantity) {
    companion object Ears : MITLengths<Ears>(
        "ear", 3 over 67
    ) {
        override fun new(quantity: FixedBigRational) = Ear(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ears"
    }
}

val FixedBigRational.ears get() = Ears.new(this)
val Long.ears get() = (this over 1).ears
val Int.ears get() = (this over 1).ears
