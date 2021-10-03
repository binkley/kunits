package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over
import hm.binkley.math.fixed.toBigRational

sealed class EnglishWeights<U : EnglishWeights<U>>(
    name: String,
    scruples: FixedBigRational,
) : Lengths<English, U>(
    English, name, scruples
)

object Scruples : EnglishWeights<Scruples>("scruples", ONE) {
    override fun new(value: FixedBigRational) = Scruple(value)
    override fun format(value: FixedBigRational) = "$value scruples"
}

class Scruple(value: FixedBigRational) :
    Measure<English, Scruples>(Scruples, value)

val Int.scruples get() = toBigRational().scruples
val Long.scruples get() = toBigRational().scruples
val FixedBigRational.scruples get() = Scruple(this)
val Measure<English, *>.scruples get() = convertTo(Scruples)

object Drams : EnglishWeights<Drams>("drams", 3 over 1) {
    override fun new(value: FixedBigRational) = Dram(value)
    override fun format(value: FixedBigRational) = "$value dr"
}

class Dram(value: FixedBigRational) :
    Measure<English, Drams>(Drams, value)

val Int.drams get() = toBigRational().drams
val Long.drams get() = toBigRational().drams
val FixedBigRational.drams get() = Dram(this)
val Measure<English, *>.drams get() = convertTo(Drams)

object Ounces : EnglishWeights<Ounces>("ounces", 48 over 1) {
    override fun new(value: FixedBigRational) = Ounce(value)
    override fun format(value: FixedBigRational) = "$value oz"
}

class Ounce(value: FixedBigRational) :
    Measure<English, Ounces>(Ounces, value)

val Int.ounces get() = toBigRational().ounces
val Long.ounces get() = toBigRational().ounces
val FixedBigRational.ounces get() = Ounce(this)
val Measure<English, *>.ounces get() = convertTo(Ounces)

object Pounds : EnglishWeights<Pounds>("pounds", 768 over 1) {
    override fun new(value: FixedBigRational) = Pound(value)
    override fun format(value: FixedBigRational) = "$value lb"
}

class Pound(value: FixedBigRational) :
    Measure<English, Pounds>(Pounds, value)

val Int.pounds get() = toBigRational().pounds
val Long.pounds get() = toBigRational().pounds
val FixedBigRational.pounds get() = Pound(this)
val Measure<English, *>.pounds get() = convertTo(Pounds)
