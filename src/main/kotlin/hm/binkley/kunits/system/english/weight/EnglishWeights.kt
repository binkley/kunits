package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Weights
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.weight.Clove.Cloves
import hm.binkley.kunits.system.english.weight.Dram.Drams
import hm.binkley.kunits.system.english.weight.Grain.Grains
import hm.binkley.kunits.system.english.weight.Hundredweight.Hundredweight
import hm.binkley.kunits.system.english.weight.Ounce.Ounces
import hm.binkley.kunits.system.english.weight.Pound.Pounds
import hm.binkley.kunits.system.english.weight.Stone.Stone
import hm.binkley.kunits.system.english.weight.Tod.Tods
import hm.binkley.kunits.system.english.weight.Tun.Tuns
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The English units of weight. */
sealed class EnglishWeights<U : EnglishWeights<U>>(
    name: String,
    drams: FixedBigRational,
) : Weights<English, U>(English, name, drams)

class Grain private constructor(value: FixedBigRational) :
    Measure<English, Grains>(Grains, value) {

    companion object Grains : EnglishWeights<Grains>("grain", 256 over 7000) {
        override fun new(value: FixedBigRational) = Grain(value)
        override fun format(value: FixedBigRational) = "$value gr"
    }
}

val FixedBigRational.grains get() = Grains.new(this)
val Long.grains get() = (this over 1).grains
val Int.grains get() = (this over 1).grains

class Dram private constructor(value: FixedBigRational) :
    Measure<English, Drams>(Drams, value) {

    companion object Drams : EnglishWeights<Drams>("dram", ONE) {
        override fun new(value: FixedBigRational) = Dram(value)
        override fun format(value: FixedBigRational) = "$value dr"
    }
}

val FixedBigRational.drams get() = Drams.new(this)
val Long.drams get() = (this over 1).drams
val Int.drams get() = (this over 1).drams

class Ounce private constructor(value: FixedBigRational) :
    Measure<English, Ounces>(Ounces, value) {

    companion object Ounces : EnglishWeights<Ounces>("ounce", 16 over 1) {
        override fun new(value: FixedBigRational) = Ounce(value)
        override fun format(value: FixedBigRational) = "$value oz"
    }
}

val FixedBigRational.ounces get() = Ounces.new(this)
val Long.ounces get() = (this over 1).ounces
val Int.ounces get() = (this over 1).ounces

class Pound private constructor(value: FixedBigRational) :
    Measure<English, Pounds>(Pounds, value) {

    companion object Pounds : EnglishWeights<Pounds>("pound", 256 over 1) {
        override fun new(value: FixedBigRational) = Pound(value)
        override fun format(value: FixedBigRational) = "$value lb"
    }
}

val FixedBigRational.pounds get() = Pounds.new(this)
val Long.pounds get() = (this over 1).pounds
val Int.pounds get() = (this over 1).pounds

class Clove private constructor(value: FixedBigRational) :
    Measure<English, Cloves>(Cloves, value) {

    companion object Cloves : EnglishWeights<Cloves>("clove", 1_792 over 1) {
        override fun new(value: FixedBigRational) = Clove(value)
        override fun format(value: FixedBigRational) = "$value cloves"
    }
}

val FixedBigRational.cloves get() = Cloves.new(this)
val Long.cloves get() = (this over 1).cloves
val Int.cloves get() = (this over 1).cloves

class Stone private constructor(value: FixedBigRational) :
    Measure<English, Stone>(Stone, value) {

    companion object Stone : EnglishWeights<Stone>("stone", 3_584 over 1) {
        override fun new(value: FixedBigRational) = Stone(value)
        override fun format(value: FixedBigRational) = "$value st"
    }
}

val FixedBigRational.stone get() = Stone.new(this)
val Long.stone get() = (this over 1).stone
val Int.stone get() = (this over 1).stone

class Tod private constructor(value: FixedBigRational) :
    Measure<English, Tods>(Tods, value) {

    companion object Tods : EnglishWeights<Tods>("tod", 7_168 over 1) {
        override fun new(value: FixedBigRational) = Tod(value)
        override fun format(value: FixedBigRational) = "$value tods"
    }
}

val FixedBigRational.tods get() = Tods.new(this)
val Long.tods get() = (this over 1).tods
val Int.tods get() = (this over 1).tods

class Hundredweight private constructor(value: FixedBigRational) :
    Measure<English, Hundredweight>(Hundredweight, value) {

    companion object Hundredweight : EnglishWeights<Hundredweight>(
        "hundredweight", 28_672 over 1
    ) {
        override fun new(value: FixedBigRational) = Hundredweight(value)
        override fun format(value: FixedBigRational) = "$value cwt"
    }
}

val FixedBigRational.hundredweight get() = Hundredweight.new(this)
val Long.hundredweight get() = (this over 1).hundredweight
val Int.hundredweight get() = (this over 1).hundredweight

class Tun private constructor(value: FixedBigRational) :
    Measure<English, Tuns>(Tuns, value) {

    companion object Tuns : EnglishWeights<Tuns>("tun", 573_440 over 1) {
        override fun new(value: FixedBigRational) = Tun(value)
        override fun format(value: FixedBigRational) = "$value tuns"
    }
}

val FixedBigRational.tuns get() = Tuns.new(this)
val Long.tuns get() = (this over 1).tuns
val Int.tuns get() = (this over 1).tuns
