package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

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

val Int.poppyseeds get() = (this over 1).poppyseeds
val Long.poppyseeds get() = (this over 1).poppyseeds
val FixedBigRational.poppyseeds get() = Poppyseed(this)
val Measure<English, *>.poppyseeds get() = convertTo(Poppyseeds)

object Barleycorns : EnglishLengths<Barleycorns>("barleycorn", 4 over 1) {
    override fun new(value: FixedBigRational) = Barleycorn(value)
    override fun format(value: FixedBigRational) = "$value Bc"
}

class Barleycorn(value: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, value)

val Int.barleycorns get() = (this over 1).barleycorns
val Long.barleycorns get() = (this over 1).barleycorns
val FixedBigRational.barleycorns get() = Barleycorn(this)
val Measure<English, *>.barleycorns get() = convertTo(Barleycorns)

object Inches : EnglishLengths<Inches>("inch", (12 over 1)) {
    override fun new(value: FixedBigRational) = Inch(value)
    override fun format(value: FixedBigRational) = "$value\""
}

class Inch(value: FixedBigRational) :
    Measure<English, Inches>(Inches, value)

val Int.inches get() = (this over 1).inches
val Long.inches get() = (this over 1).inches
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

val Int.sticks get() = (this over 1).sticks
val Long.sticks get() = (this over 1).sticks
val FixedBigRational.sticks get() = Stick(this)
val Measure<English, *>.sticks get() = convertTo(Sticks)

object Hands : EnglishLengths<Hands>("hand", 48 over 1) {
    override fun new(value: FixedBigRational) = Hand(value)
    override fun format(value: FixedBigRational) = "$value hh"
}

class Hand(value: FixedBigRational) :
    Measure<English, Hands>(Hands, value)

val Int.hands get() = (this over 1).hands
val Long.hands get() = (this over 1).hands
val FixedBigRational.hands get() = Hand(this)
val Measure<English, *>.hands get() = convertTo(Hands)

object Feet : EnglishLengths<Feet>("foot", 144 over 1) {
    override fun new(value: FixedBigRational) = Foot(value)
    override fun format(value: FixedBigRational) = "$value'"
}

class Foot(value: FixedBigRational) :
    Measure<English, Feet>(Feet, value)

val Int.feet get() = (this over 1).feet
val Long.feet get() = (this over 1).feet
val FixedBigRational.feet get() = Foot(this)
val Measure<English, *>.feet get() = convertTo(Feet)

object Yards : EnglishLengths<Yards>("yard", 432 over 1) {
    override fun new(value: FixedBigRational) = Yard(value)
    override fun format(value: FixedBigRational) = "$value yd"
}

class Yard(value: FixedBigRational) :
    Measure<English, Yards>(Yards, value)

val Int.yards get() = (this over 1).yards
val Long.yards get() = (this over 1).yards
val FixedBigRational.yards get() = Yard(this)
val Measure<English, *>.yards get() = convertTo(Yards)

object Ells : EnglishLengths<Ells>("ells", 540 over 1) {
    override fun new(value: FixedBigRational) = Ell(value)
    override fun format(value: FixedBigRational) = "$value ells"
}

class Ell(value: FixedBigRational) :
    Measure<English, Ells>(Ells, value)

val Int.ells get() = (this over 1).ells
val Long.ells get() = (this over 1).ells
val FixedBigRational.ells get() = Ell(this)
val Measure<English, *>.ells get() = convertTo(Ells)

object Rods : EnglishLengths<Rods>("rod", 2_376 over 1) {
    override fun new(value: FixedBigRational) = Rod(value)
    override fun format(value: FixedBigRational) = "$value rods"
}

class Rod(value: FixedBigRational) :
    Measure<English, Rods>(Rods, value)

val Int.rods get() = (this over 1).rods
val Long.rods get() = (this over 1).rods
val FixedBigRational.rods get() = Rod(this)
val Measure<English, *>.rods get() = convertTo(Rods)

object Chains : EnglishLengths<Chains>("chain", 9_504 over 1) {
    override fun new(value: FixedBigRational) = Chain(value)
    override fun format(value: FixedBigRational) = "$value ch"
}

class Chain(value: FixedBigRational) :
    Measure<English, Chains>(Chains, value)

val Int.chains get() = (this over 1).chains
val Long.chains get() = (this over 1).chains
val FixedBigRational.chains get() = Chain(this)
val Measure<English, *>.chains get() = convertTo(Chains)

object Furlongs : EnglishLengths<Furlongs>("furlong", 95_040 over 1) {
    override fun new(value: FixedBigRational) = Furlong(value)
    override fun format(value: FixedBigRational) = "$value fur"
}

class Furlong(value: FixedBigRational) :
    Measure<English, Furlongs>(Furlongs, value)

val Int.furlongs get() = (this over 1).furlongs
val Long.furlongs get() = (this over 1).furlongs
val FixedBigRational.furlongs get() = Furlong(this)
val Measure<English, *>.furlongs get() = convertTo(Furlongs)

object Miles : EnglishLengths<Miles>("mile", 760_320 over 1) {
    override fun new(value: FixedBigRational) = Mile(value)
    override fun format(value: FixedBigRational) = "$value mi"
}

class Mile(value: FixedBigRational) :
    Measure<English, Miles>(Miles, value)

val Int.miles get() = (this over 1).miles
val Long.miles get() = (this over 1).miles
val FixedBigRational.miles get() = Mile(this)
val Measure<English, *>.miles get() = convertTo(Miles)

object Leagues : EnglishLengths<Leagues>("league", 2_280_960 over 1) {
    override fun new(value: FixedBigRational) = League(value)
    override fun format(value: FixedBigRational) = "$value lea"
}

class League(value: FixedBigRational) :
    Measure<English, Leagues>(Leagues, value)

val Int.leagues get() = (this over 1).leagues
val Long.leagues get() = (this over 1).leagues
val FixedBigRational.leagues get() = League(this)
val Measure<English, *>.leagues get() = convertTo(Leagues)
