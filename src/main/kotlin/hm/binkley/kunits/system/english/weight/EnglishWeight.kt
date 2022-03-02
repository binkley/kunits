package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Weight
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
sealed class EnglishWeight<U : EnglishWeight<U>>(
    name: String,
    drams: FixedBigRational,
) : Weight<English, U>(English, name, drams)

class Grain private constructor(value: FixedBigRational) :
    Measure<English, Grains>(Grains, value) {

    companion object Grains : EnglishWeight<Grains>("grain", 256 over 7000) {
        override fun new(value: FixedBigRational) = Grain(value)
        override fun format(value: FixedBigRational) = "$value gr"
    }
}

val Int.grains get() = (this over 1).grains
val Long.grains get() = (this over 1).grains
val FixedBigRational.grains get() = Grains.new(this)

class Dram private constructor(value: FixedBigRational) :
    Measure<English, Drams>(Drams, value) {

    companion object Drams : EnglishWeight<Drams>("dram", ONE) {
        override fun new(value: FixedBigRational) = Dram(value)
        override fun format(value: FixedBigRational) = "$value dr"
    }
}

val Int.drams get() = (this over 1).drams
val Long.drams get() = (this over 1).drams
val FixedBigRational.drams get() = Drams.new(this)

class Ounce private constructor(value: FixedBigRational) :
    Measure<English, Ounces>(Ounces, value) {

    companion object Ounces : EnglishWeight<Ounces>("ounce", 16 over 1) {
        override fun new(value: FixedBigRational) = Ounce(value)
        override fun format(value: FixedBigRational) = "$value oz"
    }
}

val Int.ounces get() = (this over 1).ounces
val Long.ounces get() = (this over 1).ounces
val FixedBigRational.ounces get() = Ounces.new(this)

class Pound private constructor(value: FixedBigRational) :
    Measure<English, Pounds>(Pounds, value) {

    companion object Pounds : EnglishWeight<Pounds>("pound", 256 over 1) {
        override fun new(value: FixedBigRational) = Pound(value)
        override fun format(value: FixedBigRational) = "$value lb"
    }
}

val Int.pounds get() = (this over 1).pounds
val Long.pounds get() = (this over 1).pounds
val FixedBigRational.pounds get() = Pounds.new(this)

class Clove private constructor(value: FixedBigRational) :
    Measure<English, Cloves>(Cloves, value) {

    companion object Cloves : EnglishWeight<Cloves>("clove", 1_792 over 1) {
        override fun new(value: FixedBigRational) = Clove(value)
        override fun format(value: FixedBigRational) = "$value cloves"
    }
}

val Int.cloves get() = (this over 1).cloves
val Long.cloves get() = (this over 1).cloves
val FixedBigRational.cloves get() = Cloves.new(this)

class Stone private constructor(value: FixedBigRational) :
    Measure<English, Stone>(Stone, value) {

    companion object Stone : EnglishWeight<Stone>("stone", 3_584 over 1) {
        override fun new(value: FixedBigRational) = Stone(value)
        override fun format(value: FixedBigRational) = "$value st"
    }
}

val Int.stone get() = (this over 1).stone
val Long.stone get() = (this over 1).stone
val FixedBigRational.stone get() = Stone.new(this)

class Tod private constructor(value: FixedBigRational) :
    Measure<English, Tods>(Tods, value) {

    companion object Tods : EnglishWeight<Tods>("tod", 7_168 over 1) {
        override fun new(value: FixedBigRational) = Tod(value)
        override fun format(value: FixedBigRational) = "$value tods"
    }
}

val Int.tods get() = (this over 1).tods
val Long.tods get() = (this over 1).tods
val FixedBigRational.tods get() = Tods.new(this)

class Hundredweight private constructor(value: FixedBigRational) :
    Measure<English, Hundredweight>(Hundredweight, value) {

    companion object Hundredweight : EnglishWeight<Hundredweight>(
        "hundredweight", 28_672 over 1
    ) {
        override fun new(value: FixedBigRational) = Hundredweight(value)
        override fun format(value: FixedBigRational) = "$value cwt"
    }
}

val Int.hundredweight get() = (this over 1).hundredweight
val Long.hundredweight get() = (this over 1).hundredweight
val FixedBigRational.hundredweight get() = Hundredweight.new(this)

class Tun private constructor(value: FixedBigRational) :
    Measure<English, Tuns>(Tuns, value) {

    companion object Tuns : EnglishWeight<Tuns>("tun", 573_440 over 1) {
        override fun new(value: FixedBigRational) = Tun(value)
        override fun format(value: FixedBigRational) = "$value tuns"
    }
}

val Int.tuns get() = (this over 1).tuns
val Long.tuns get() = (this over 1).tuns
val FixedBigRational.tuns get() = Tuns.new(this)
