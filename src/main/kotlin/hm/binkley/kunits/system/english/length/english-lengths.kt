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
val Measure<English, *>.poppyseeds get() = convertTo(Poppyseeds)

object Barleycorns : EnglishLengths<Barleycorns>("barleycorn", 4 over 1) {
    override fun new(value: FixedBigRational) = Barleycorn(value)
    override fun format(value: FixedBigRational) = "$value Bc"
}

class Barleycorn(value: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, value)

val Int.barleycorns get() = toBigRational().barleycorns
val Long.barleycorns get() = toBigRational().barleycorns
val FixedBigRational.barleycorns get() = Barleycorn(this)
val Measure<English, *>.barleycorns get() = convertTo(Barleycorns)

object Inches : EnglishLengths<Inches>("inch", (12 over 1)) {
    override fun new(value: FixedBigRational) = Inch(value)
    override fun format(value: FixedBigRational) = "$value\""
}

class Inch(value: FixedBigRational) :
    Measure<English, Inches>(Inches, value)

val Int.inches get() = toBigRational().inches
val Long.inches get() = toBigRational().inches
val FixedBigRational.inches get() = Inch(this)
val Measure<English, *>.inches get() = convertTo(Inches)

object Sticks : EnglishLengths<Sticks>("stick", 24 over 1) {
    override fun new(value: FixedBigRational) = Stick(value)
    override fun format(value: FixedBigRational) = when (value) {
        ONE -> "1 stick"
        else -> "$value sticks"
    }
}

class Stick(value: FixedBigRational) :
    Measure<English, Sticks>(Sticks, value)

val Int.sticks get() = toBigRational().sticks
val Long.sticks get() = toBigRational().sticks
val FixedBigRational.sticks get() = Stick(this)
val Measure<English, *>.sticks get() = convertTo(Sticks)

object Hands : EnglishLengths<Hands>("hand", 48 over 1) {
    override fun new(value: FixedBigRational) = Hand(value)
    override fun format(value: FixedBigRational) = "$value hh"
}

class Hand(value: FixedBigRational) :
    Measure<English, Hands>(Hands, value)

val Int.hands get() = toBigRational().hands
val Long.hands get() = toBigRational().hands
val FixedBigRational.hands get() = Hand(this)
val Measure<English, *>.hands get() = convertTo(Hands)

object Feet : EnglishLengths<Feet>("foot", 144 over 1) {
    override fun new(value: FixedBigRational) = Foot(value)
    override fun format(value: FixedBigRational) = "$value'"
}

class Foot(value: FixedBigRational) :
    Measure<English, Feet>(Feet, value)

val Int.feet get() = toBigRational().feet
val Long.feet get() = toBigRational().feet
val FixedBigRational.feet get() = Foot(this)
val Measure<English, *>.feet get() = convertTo(Feet)

object Yards : EnglishLengths<Yards>("yard", 432 over 1) {
    override fun new(value: FixedBigRational) = Yard(value)
    override fun format(value: FixedBigRational) = "$value yd"
}

class Yard(value: FixedBigRational) :
    Measure<English, Yards>(Yards, value)

val Int.yards get() = toBigRational().yards
val Long.yards get() = toBigRational().yards
val FixedBigRational.yards get() = Yard(this)
val Measure<English, *>.yards get() = convertTo(Yards)

object Furlongs : EnglishLengths<Furlongs>("furlong", 95_040 over 1) {
    override fun new(value: FixedBigRational) = Furlong(value)
    override fun format(value: FixedBigRational) = "$value fur"
}

class Furlong(value: FixedBigRational) :
    Measure<English, Furlongs>(Furlongs, value)

val Int.furlongs get() = toBigRational().furlongs
val Long.furlongs get() = toBigRational().furlongs
val FixedBigRational.furlongs get() = Furlong(this)
val Measure<English, *>.furlongs get() = convertTo(Furlongs)

object Miles : EnglishLengths<Miles>("mile", 760_320 over 1) {
    override fun new(value: FixedBigRational) = Mile(value)
    override fun format(value: FixedBigRational) = "$value mi"
}

class Mile(value: FixedBigRational) :
    Measure<English, Miles>(Miles, value)

val Int.miles get() = toBigRational().miles
val Long.miles get() = toBigRational().miles
val FixedBigRational.miles get() = Mile(this)
val Measure<English, *>.miles get() = convertTo(Miles)

object Leagues : EnglishLengths<Leagues>("league", 2_280_960 over 1) {
    override fun new(value: FixedBigRational) = League(value)
    override fun format(value: FixedBigRational) = "$value lea"
}

class League(value: FixedBigRational) :
    Measure<English, Leagues>(Leagues, value)

val Int.leagues get() = toBigRational().leagues
val Long.leagues get() = toBigRational().leagues
val FixedBigRational.leagues get() = League(this)
val Measure<English, *>.leagues get() = convertTo(Leagues)
