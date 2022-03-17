package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
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
sealed class EnglishWeights<U : EnglishWeights<U>>(
    name: String,
    drams: FixedBigRational,
) : Units<English, Weight, U>(English, Weight, name, drams)

class Grain private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Grains>(Grains, quantity) {
    companion object Grains : EnglishWeights<Grains>(
        "grain", 256 over 7000
    ) {
        override fun new(quantity: FixedBigRational) = Grain(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity gr"
    }
}

val FixedBigRational.grains get() = Grains.new(this)
val Long.grains get() = (this over 1).grains
val Int.grains get() = (this over 1).grains

class Dram private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Drams>(Drams, quantity) {
    companion object Drams : EnglishWeights<Drams>(
        "dram", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Dram(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity dr"
    }
}

val FixedBigRational.drams get() = Drams.new(this)
val Long.drams get() = (this over 1).drams
val Int.drams get() = (this over 1).drams

class Ounce private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Ounces>(Ounces, quantity) {
    companion object Ounces : EnglishWeights<Ounces>(
        "ounce", 16 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Ounce(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity oz"
    }
}

val FixedBigRational.ounces get() = Ounces.new(this)
val Long.ounces get() = (this over 1).ounces
val Int.ounces get() = (this over 1).ounces

class Pound private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Pounds>(Pounds, quantity) {
    companion object Pounds : EnglishWeights<Pounds>(
        "pound", 256 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Pound(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity lb"
    }
}

val FixedBigRational.pounds get() = Pounds.new(this)
val Long.pounds get() = (this over 1).pounds
val Int.pounds get() = (this over 1).pounds

class Clove private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Cloves>(Cloves, quantity) {
    companion object Cloves : EnglishWeights<Cloves>(
        "clove", 1_792 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Clove(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity cloves"
    }
}

val FixedBigRational.cloves get() = Cloves.new(this)
val Long.cloves get() = (this over 1).cloves
val Int.cloves get() = (this over 1).cloves

class Stone private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Stone>(Stone, quantity) {
    /** Note: The plural of "stone" is "stone" when describing weight. */
    companion object Stone : EnglishWeights<Stone>(
        "stone", 3_584 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Stone(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity st"
    }
}

val FixedBigRational.stone get() = Stone.new(this)
val Long.stone get() = (this over 1).stone
val Int.stone get() = (this over 1).stone

class Tod private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Tods>(Tods, quantity) {
    companion object Tods : EnglishWeights<Tods>(
        "tod", 7_168 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Tod(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity tods"
    }
}

val FixedBigRational.tods get() = Tods.new(this)
val Long.tods get() = (this over 1).tods
val Int.tods get() = (this over 1).tods

class Hundredweight private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Hundredweight>(Hundredweight, quantity) {
    /**
     * Note: The plural of "hundredweight" is "hundredweight" when
     * describing weight.
     */
    companion object Hundredweight : EnglishWeights<Hundredweight>(
        "hundredweight", 28_672 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Hundredweight(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity cwt"
    }
}

val FixedBigRational.hundredweight get() = Hundredweight.new(this)
val Long.hundredweight get() = (this over 1).hundredweight
val Int.hundredweight get() = (this over 1).hundredweight

class Tun private constructor(quantity: FixedBigRational) :
    Measure<English, Weight, Tuns>(Tuns, quantity) {
    companion object Tuns : EnglishWeights<Tuns>(
        "tun", 573_440 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Tun(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity tuns"
    }
}

val FixedBigRational.tuns get() = Tuns.new(this)
val Long.tuns get() = (this over 1).tuns
val Int.tuns get() = (this over 1).tuns
