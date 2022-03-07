package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
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
) : Lengths<MIT, U>(MIT, name, smoots)

class Smoot private constructor(value: FixedBigRational) :
    Measure<MIT, Smoots>(Smoots, value) {

    companion object Smoots : MITLengths<Smoots>("smoot", ONE) {
        override fun new(value: FixedBigRational) = Smoot(value)
        override fun format(value: FixedBigRational) = "$value sm"
    }
}

val Int.smoots get() = (this over 1).smoots
val Long.smoots get() = (this over 1).smoots
val FixedBigRational.smoots get() = Smoots.new(this)

class Ear(value: FixedBigRational) :
    Measure<MIT, Ears>(Ears, value) {

    companion object Ears : MITLengths<Ears>("ear", 3 over 67) {
        override fun new(value: FixedBigRational) = Ear(value)
        override fun format(value: FixedBigRational) = "$value ears"
    }
}

val Int.ears get() = (this over 1).ears
val Long.ears get() = (this over 1).ears
val FixedBigRational.ears get() = Ears.new(this)
