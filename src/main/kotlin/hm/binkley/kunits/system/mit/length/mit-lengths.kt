package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

sealed class MitLengths<U : MitLengths<U>>(
    name: String,
    smoots: FixedBigRational,
) : Lengths<MIT, U>(MIT, name, smoots)

object Smoots : MitLengths<Smoots>("smoot", ONE) {
    override fun new(value: FixedBigRational) = Smoot(value)
    override fun format(value: FixedBigRational) = "$value sm"
}

class Smoot(value: FixedBigRational) :
    Measure<MIT, Smoots>(Smoots, value)

val Int.smoots get() = (this over 1).smoots
val Long.smoots get() = (this over 1).smoots
val FixedBigRational.smoots get() = Smoot(this)

object Ears : MitLengths<Ears>("ear", 3 over 67) {
    override fun new(value: FixedBigRational) = Ear(value)
    override fun format(value: FixedBigRational) = "$value ears"
}

class Ear(value: FixedBigRational) :
    Measure<MIT, Ears>(Ears, value)

val Int.ears get() = (this over 1).ears
val Long.ears get() = (this over 1).ears
val FixedBigRational.ears get() = Ear(this)
