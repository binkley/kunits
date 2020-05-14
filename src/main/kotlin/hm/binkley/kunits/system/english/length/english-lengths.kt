package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.finite.FixedBigRational
import hm.binkley.math.finite.FixedBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class EnglishLengths<U : EnglishLengths<U>>(
    name: String,
    poppyseeds: FixedBigRational
) : Lengths<English, U>(
    English, name, poppyseeds
)

object Poppyseeds : EnglishLengths<Poppyseeds>("poppyseed", ONE) {
    override fun new(value: FixedBigRational) = Poppyseed(value)
    override fun format(value: FixedBigRational) = "$value poppyseeds"
}

class Poppyseed(value: FixedBigRational) :
    Measure<English, Poppyseeds>(Poppyseeds, value)

val Int.poppyseeds get() = (this over 1).poppyseeds
val FixedBigRational.poppyseeds get() = Poppyseed(this)

object Barleycorns : EnglishLengths<Barleycorns>("barleycorn", (4 over 1)) {
    override fun new(value: FixedBigRational) = Barleycorn(value)
    override fun format(value: FixedBigRational) = "$value barleycorns"
}

class Barleycorn(value: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, value)

val Int.barleycorns get() = (this over 1).barleycorns
val FixedBigRational.barleycorns get() = Barleycorn(this)

object Inches : EnglishLengths<Inches>("inch", (12 over 1)) {
    override fun new(value: FixedBigRational) = Inch(value)
    override fun format(value: FixedBigRational) = "$value\""
}

class Inch(value: FixedBigRational) :
    Measure<English, Inches>(Inches, value)

val Int.inches get() = (this over 1).inches
val FixedBigRational.inches get() = Inch(this)

object Sticks : EnglishLengths<Sticks>("stick", (24 over 1)) {
    override fun new(value: FixedBigRational) = Stick(value)
    override fun format(value: FixedBigRational) = "$value sticks"
}

class Stick(value: FixedBigRational) :
    Measure<English, Sticks>(Sticks, value)

val Int.sticks get() = (this over 1).sticks
val FixedBigRational.sticks get() = Stick(this)

object Hands : EnglishLengths<Hands>("hand", (48 over 1)) {
    override fun new(value: FixedBigRational) = Hand(value)
    override fun format(value: FixedBigRational) = "$value hh"
}

class Hand(value: FixedBigRational) :
    Measure<English, Hands>(Hands, value)

val Int.hands get() = (this over 1).hands
val FixedBigRational.hands get() = Hand(this)

object Feet : EnglishLengths<Feet>("foot", (144 over 1)) {
    override fun new(value: FixedBigRational) = Foot(value)
    override fun format(value: FixedBigRational) = "$value'"
}

class Foot(value: FixedBigRational) :
    Measure<English, Feet>(Feet, value)

val Int.feet get() = (this over 1).feet
val FixedBigRational.feet get() = Foot(this)

object Yards : EnglishLengths<Yards>("yard", (432 over 1)) {
    override fun new(value: FixedBigRational) = Yard(value)
    override fun format(value: FixedBigRational) = "$value yd"
}

class Yard(value: FixedBigRational) :
    Measure<English, Yards>(Yards, value)

val Int.yards get() = (this over 1).yards
val FixedBigRational.yards get() = Yard(this)
