package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

sealed class EnglishWeights<U : EnglishWeights<U>>(
    name: String,
    drams: FixedBigRational,
) : Lengths<English, U>(
    English, name, drams
)

object Drams : EnglishWeights<Drams>("drams", ONE) {
    override fun new(value: FixedBigRational) = Dram(value)
    override fun format(value: FixedBigRational) = "$value dr"
}

class Dram(value: FixedBigRational) :
    Measure<English, Drams>(Drams, value)

val Int.drams get() = (this over 1).drams
val Long.drams get() = (this over 1).drams
val FixedBigRational.drams get() = Dram(this)
val Measure<English, *>.drams get() = convertTo(Drams)

object Ounces : EnglishWeights<Ounces>("ounces", 16 over 1) {
    override fun new(value: FixedBigRational) = Ounce(value)
    override fun format(value: FixedBigRational) = "$value oz"
}

class Ounce(value: FixedBigRational) :
    Measure<English, Ounces>(Ounces, value)

val Int.ounces get() = (this over 1).ounces
val Long.ounces get() = (this over 1).ounces
val FixedBigRational.ounces get() = Ounce(this)
val Measure<English, *>.ounces get() = convertTo(Ounces)

object Pounds : EnglishWeights<Pounds>("pounds", 256 over 1) {
    override fun new(value: FixedBigRational) = Pound(value)
    override fun format(value: FixedBigRational) = "$value lb"
}

class Pound(value: FixedBigRational) :
    Measure<English, Pounds>(Pounds, value)

val Int.pounds get() = (this over 1).pounds
val Long.pounds get() = (this over 1).pounds
val FixedBigRational.pounds get() = Pound(this)
val Measure<English, *>.pounds get() = convertTo(Pounds)

object Stone : EnglishWeights<Stone>("stone", 3584 over 1) {
    override fun new(value: FixedBigRational) = Stone_(value)
    override fun format(value: FixedBigRational) = "$value st"
}

class Stone_(value: FixedBigRational) :
    Measure<English, Stone>(Stone, value)

val Int.stone get() = (this over 1).stone
val Long.stone get() = (this over 1).stone
val FixedBigRational.stone get() = Stone_(this)
val Measure<English, *>.stone get() = convertTo(Stone)
