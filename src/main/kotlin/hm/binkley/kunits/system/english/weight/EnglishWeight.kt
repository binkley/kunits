package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Weight
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The English units of weight. */
sealed class EnglishWeight<U : EnglishWeight<U>>(
    name: String,
    drams: FixedBigRational,
) : Weight<English, U>(English, name, drams)

object Grains : EnglishWeight<Grains>("grain", 256 over 7000) {
    override fun new(value: FixedBigRational) = Grain(value)
    override fun format(value: FixedBigRational) = "$value gr"
}

class Grain(value: FixedBigRational) :
    Measure<English, Grains>(Grains, value)

val Int.grains get() = (this over 1).grains
val Long.grains get() = (this over 1).grains
val FixedBigRational.grains get() = Grains.new(this)

object Drams : EnglishWeight<Drams>("dram", ONE) {
    override fun new(value: FixedBigRational) = Dram(value)
    override fun format(value: FixedBigRational) = "$value dr"
}

class Dram(value: FixedBigRational) :
    Measure<English, Drams>(Drams, value)

val Int.drams get() = (this over 1).drams
val Long.drams get() = (this over 1).drams
val FixedBigRational.drams get() = Drams.new(this)

object Ounces : EnglishWeight<Ounces>("ounce", 16 over 1) {
    override fun new(value: FixedBigRational) = Ounce(value)
    override fun format(value: FixedBigRational) = "$value oz"
}

class Ounce(value: FixedBigRational) :
    Measure<English, Ounces>(Ounces, value)

val Int.ounces get() = (this over 1).ounces
val Long.ounces get() = (this over 1).ounces
val FixedBigRational.ounces get() = Ounces.new(this)

object Pounds : EnglishWeight<Pounds>("pound", 256 over 1) {
    override fun new(value: FixedBigRational) = Pound(value)
    override fun format(value: FixedBigRational) = "$value lb"
}

class Pound(value: FixedBigRational) :
    Measure<English, Pounds>(Pounds, value)

val Int.pounds get() = (this over 1).pounds
val Long.pounds get() = (this over 1).pounds
val FixedBigRational.pounds get() = Pounds.new(this)

object Cloves : EnglishWeight<Cloves>("clove", 1_792 over 1) {
    override fun new(value: FixedBigRational) = Clove(value)
    override fun format(value: FixedBigRational) = "$value cloves"
}

class Clove(value: FixedBigRational) :
    Measure<English, Cloves>(Cloves, value)

val Int.cloves get() = (this over 1).cloves
val Long.cloves get() = (this over 1).cloves
val FixedBigRational.cloves get() = Cloves.new(this)

object Stone : EnglishWeight<Stone>("stone", 3_584 over 1) {
    override fun new(value: FixedBigRational) = Stone_(value)
    override fun format(value: FixedBigRational) = "$value st"
}

/** Note the odd naming as "stone" is plural for "stone". */
class Stone_(value: FixedBigRational) :
    Measure<English, Stone>(Stone, value)

val Int.stone get() = (this over 1).stone
val Long.stone get() = (this over 1).stone
val FixedBigRational.stone get() = Stone_(this)

object Tods : EnglishWeight<Tods>("tod", 7_168 over 1) {
    override fun new(value: FixedBigRational) = Tod(value)
    override fun format(value: FixedBigRational) = "$value tods"
}

class Tod(value: FixedBigRational) :
    Measure<English, Tods>(Tods, value)

val Int.tods get() = (this over 1).tods
val Long.tods get() = (this over 1).tods
val FixedBigRational.tods get() = Tods.new(this)

object Hundredweight : EnglishWeight<Hundredweight>(
    "hundredweight", 28_672 over 1
) {
    override fun new(value: FixedBigRational) = Hundredweight_(value)
    override fun format(value: FixedBigRational) = "$value cwt"
}

/** Note the odd naming as "hundredweight" is plural for "hundredweight". */
class Hundredweight_(value: FixedBigRational) :
    Measure<English, Hundredweight>(Hundredweight, value)

val Int.hundredweight get() = (this over 1).hundredweight
val Long.hundredweight get() = (this over 1).hundredweight
val FixedBigRational.hundredweight get() = Hundredweight_(this)

object Tuns : EnglishWeight<Tuns>("tun", 573_440 over 1) {
    override fun new(value: FixedBigRational) = Tun(value)
    override fun format(value: FixedBigRational) = "$value tuns"
}

class Tun(value: FixedBigRational) :
    Measure<English, Tuns>(Tuns, value)

val Int.tuns get() = (this over 1).tuns
val Long.tuns get() = (this over 1).tuns
val FixedBigRational.tuns get() = Tuns.new(this)
