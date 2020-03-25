package hm.binkley.kunit.system.english.length

import hm.binkley.kunit.Lengths
import hm.binkley.kunit.Measure
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over

sealed class EnglishLengths<U : EnglishLengths<U>>(
    name: String,
    poppyseeds: FiniteBigRational
) : Lengths<U>(name, poppyseeds)

object Poppyseeds : EnglishLengths<Poppyseeds>("Poppyseed", ONE) {
    override fun new(value: FiniteBigRational) = Poppyseed(value)
    override fun format(value: FiniteBigRational) = "$value poppyseeds"
}

class Poppyseed(value: FiniteBigRational) :
    Measure<Poppyseeds>(Poppyseeds, value)

val Int.poppyseeds get() = (this over 1).poppyseeds
val FiniteBigRational.poppyseeds get() = Poppyseed(this)

object Barleycorns : EnglishLengths<Barleycorns>("Barleycorn", (4 over 1)) {
    override fun new(value: FiniteBigRational) = Barleycorn(value)
    override fun format(value: FiniteBigRational) = "$value barleycorns"
}

class Barleycorn(value: FiniteBigRational) :
    Measure<Barleycorns>(Barleycorns, value)

val Int.barleycorns get() = (this over 1).barleycorns
val FiniteBigRational.barleycorns get() = Barleycorn(this)

object Inches : EnglishLengths<Inches>("Inch", (12 over 1)) {
    override fun new(value: FiniteBigRational) = Inch(value)
    override fun format(value: FiniteBigRational) = "$value\""
}

class Inch(value: FiniteBigRational) :
    Measure<Inches>(Inches, value)

val Int.inches get() = (this over 1).inches
val FiniteBigRational.inches get() = Inch(this)

object Sticks : EnglishLengths<Sticks>("Stick", (24 over 1)) {
    override fun new(value: FiniteBigRational) = Stick(value)
    override fun format(value: FiniteBigRational) = "$value sticks"
}

class Stick(value: FiniteBigRational) :
    Measure<Sticks>(Sticks, value)

val Int.sticks get() = (this over 1).sticks
val FiniteBigRational.sticks get() = Stick(this)

object Hands : EnglishLengths<Hands>("Hand", (48 over 1)) {
    override fun new(value: FiniteBigRational) = Hand(value)
    override fun format(value: FiniteBigRational) = "$value hh"
}

class Hand(value: FiniteBigRational) :
    Measure<Hands>(Hands, value)

val Int.hands get() = (this over 1).hands
val FiniteBigRational.hands get() = Hand(this)

object Feet : EnglishLengths<Feet>("Foot", (144 over 1)) {
    override fun new(value: FiniteBigRational) = Foot(value)
    override fun format(value: FiniteBigRational) = "$value'"
}

class Foot(value: FiniteBigRational) :
    Measure<Feet>(Feet, value)

val Int.feet get() = (this over 1).feet
val FiniteBigRational.feet get() = Foot(this)

object Yards : EnglishLengths<Yards>("Yard", (432 over 1)) {
    override fun new(value: FiniteBigRational) = Yard(value)
    override fun format(value: FiniteBigRational) = "$value yd"
}

class Yard(value: FiniteBigRational) :
    Measure<Yards>(Yards, value)

val Int.yards get() = (this over 1).yards
val FiniteBigRational.yards get() = Yard(this)
