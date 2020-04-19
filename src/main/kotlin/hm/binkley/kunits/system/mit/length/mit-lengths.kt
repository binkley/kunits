package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class MitLengths<U : MitLengths<U>>(
    name: String,
    smoots: FiniteBigRational
) : Lengths<MIT, U>(
    MIT, name, smoots
)

object Smoots : MitLengths<Smoots>("smoot", ONE) {
    override fun new(value: FiniteBigRational) = Smoot(value)
    override fun format(value: FiniteBigRational) = "$value sm"
}

class Smoot(value: FiniteBigRational) :
    Measure<MIT, Smoots>(Smoots, value)

val Int.smoots get() = (this over 1).smoots
val FiniteBigRational.smoots get() = Smoot(this)

object Ears : MitLengths<Ears>("ear", 3 over 67) {
    override fun new(value: FiniteBigRational) = Ear(value)
    override fun format(value: FiniteBigRational) = "$value ear"
}

class Ear(value: FiniteBigRational) :
    Measure<MIT, Ears>(Ears, value)

val Int.ears get() = (this over 1).ears
val FiniteBigRational.ears get() = Ear(this)
