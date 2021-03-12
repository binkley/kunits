package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over
import hm.binkley.math.fixed.toBigRational

sealed class EnglishLengths<U : EnglishLengths<U>>(
    name: String,
    poppyseeds: FixedBigRational,
) : Lengths<English, U>(
    English, name, poppyseeds
)

object Poppyseeds : EnglishLengths<Poppyseeds>("poppyseed", ONE) {
    override fun new(value: FixedBigRational) = Poppyseed(value)
    override fun format(value: FixedBigRational) = "$value poppyseeds"
}

class Poppyseed(value: FixedBigRational) :
    Measure<English, Poppyseeds>(Poppyseeds, value)

val Int.poppyseeds get() = toBigRational().poppyseeds
val Long.poppyseeds get() = toBigRational().poppyseeds
val FixedBigRational.poppyseeds get() = Poppyseed(this)
val Measure<English, *>.poppyseeds get() = to(Poppyseeds)

object Barleycorns : EnglishLengths<Barleycorns>("barleycorn", 4 over 1) {
    override fun new(value: FixedBigRational) = Barleycorn(value)
    override fun format(value: FixedBigRational) = "$value barleycorns"
}

class Barleycorn(value: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, value)

val Int.barleycorns get() = toBigRational().barleycorns
val Long.barleycorns get() = toBigRational().barleycorns
val FixedBigRational.barleycorns get() = Barleycorn(this)
val Measure<English, *>.barleycorns get() = to(Barleycorns)

object Inches : EnglishLengths<Inches>("inch", (12 over 1)) {
    override fun new(value: FixedBigRational) = Inch(value)
    override fun format(value: FixedBigRational) = "$value\""
}

class Inch(value: FixedBigRational) :
    Measure<English, Inches>(Inches, value)

val Int.inches get() = toBigRational().inches
val Long.inches get() = toBigRational().inches
val FixedBigRational.inches get() = Inch(this)
val Measure<English, *>.inches get() = to(Inches)

object Sticks : EnglishLengths<Sticks>("stick", 24 over 1) {
    override fun new(value: FixedBigRational) = Stick(value)
    override fun format(value: FixedBigRational) = "$value sticks"
}

class Stick(value: FixedBigRational) :
    Measure<English, Sticks>(Sticks, value)

val Int.sticks get() = toBigRational().sticks
val Long.sticks get() = toBigRational().sticks
val FixedBigRational.sticks get() = Stick(this)
val Measure<English, *>.sticks get() = to(Sticks)

object Hands : EnglishLengths<Hands>("hand", 48 over 1) {
    override fun new(value: FixedBigRational) = Hand(value)
    override fun format(value: FixedBigRational) = "$value hh"
}

class Hand(value: FixedBigRational) :
    Measure<English, Hands>(Hands, value)

val Int.hands get() = toBigRational().hands
val Long.hands get() = toBigRational().hands
val FixedBigRational.hands get() = Hand(this)
val Measure<English, *>.hands get() = to(Hands)

object Feet : EnglishLengths<Feet>("foot", 144 over 1) {
    override fun new(value: FixedBigRational) = Foot(value)
    override fun format(value: FixedBigRational) = "$value'"
}

class Foot(value: FixedBigRational) :
    Measure<English, Feet>(Feet, value)

val Int.feet get() = toBigRational().feet
val Long.feet get() = toBigRational().feet
val FixedBigRational.feet get() = Foot(this)
val Measure<English, *>.feet get() = to(Feet)

object Yards : EnglishLengths<Yards>("yard", 432 over 1) {
    override fun new(value: FixedBigRational) = Yard(value)
    override fun format(value: FixedBigRational) = "$value yd"
}

class Yard(value: FixedBigRational) :
    Measure<English, Yards>(Yards, value)

val Int.yards get() = toBigRational().yards
val Long.yards get() = toBigRational().yards
val FixedBigRational.yards get() = Yard(this)
val Measure<English, *>.yards get() = to(Yards)
