package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.length.Barleycorn.Barleycorns
import hm.binkley.kunits.system.english.length.Chain.Chains
import hm.binkley.kunits.system.english.length.Ell.Ells
import hm.binkley.kunits.system.english.length.Foot.Feet
import hm.binkley.kunits.system.english.length.Furlong.Furlongs
import hm.binkley.kunits.system.english.length.Hand.Hands
import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.League.Leagues
import hm.binkley.kunits.system.english.length.Line.Lines
import hm.binkley.kunits.system.english.length.Link.Links
import hm.binkley.kunits.system.english.length.Mile.Miles
import hm.binkley.kunits.system.english.length.Rod.Rods
import hm.binkley.kunits.system.english.length.Shaftment.Shaftments
import hm.binkley.kunits.system.english.length.Stick.Sticks
import hm.binkley.kunits.system.english.length.Yard.Yards
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The English units of length. */
sealed class EnglishLengths<U : EnglishLengths<U>>(
    name: String,
    lines: FixedBigRational,
) : Lengths<English, U>(English, name, lines)

class Line private constructor(value: FixedBigRational) :
    Measure<English, Lines>(Lines, value) {

    companion object Lines : EnglishLengths<Lines>("line", ONE) {
        override fun new(value: FixedBigRational) = Line(value)
        override fun format(value: FixedBigRational) = "$value lines"
    }
}

val FixedBigRational.lines get() = Lines.new(this)
val Long.lines get() = (this over 1).lines
val Int.lines get() = (this over 1).lines

class Barleycorn private constructor(value: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, value) {

    companion object Barleycorns :
        EnglishLengths<Barleycorns>("barleycorn", 4 over 1) {
        override fun new(value: FixedBigRational) = Barleycorn(value)
        override fun format(value: FixedBigRational) = "$value Bc"
    }
}

val FixedBigRational.barleycorns get() = Barleycorns.new(this)
val Long.barleycorns get() = (this over 1).barleycorns
val Int.barleycorns get() = (this over 1).barleycorns

class Inch private constructor(value: FixedBigRational) :
    Measure<English, Inches>(Inches, value) {

    companion object Inches : EnglishLengths<Inches>("inch", (12 over 1)) {
        override fun new(value: FixedBigRational) = Inch(value)
        override fun format(value: FixedBigRational) = "$value\""
    }
}

val FixedBigRational.inches get() = Inches.new(this)
val Long.inches get() = (this over 1).inches
val Int.inches get() = (this over 1).inches

class Stick private constructor(value: FixedBigRational) :
    Measure<English, Sticks>(Sticks, value) {

    companion object Sticks : EnglishLengths<Sticks>("stick", 24 over 1) {
        override fun new(value: FixedBigRational) = Stick(value)
        override fun format(value: FixedBigRational) = when (value) {
            ONE -> "1 stick"
            else -> "$value sticks"
        }
    }
}

val FixedBigRational.sticks get() = Sticks.new(this)
val Long.sticks get() = (this over 1).sticks
val Int.sticks get() = (this over 1).sticks

class Hand private constructor(value: FixedBigRational) :
    Measure<English, Hands>(Hands, value) {

    companion object Hands : EnglishLengths<Hands>("hand", 48 over 1) {
        override fun new(value: FixedBigRational) = Hand(value)
        override fun format(value: FixedBigRational) = "$value hh"
    }
}

val FixedBigRational.hands get() = Hands.new(this)
val Long.hands get() = (this over 1).hands
val Int.hands get() = (this over 1).hands

class Shaftment private constructor(value: FixedBigRational) :
    Measure<English, Shaftments>(Shaftments, value) {

    companion object Shaftments :
        EnglishLengths<Shaftments>("shaftment", 72 over 1) {
        override fun new(value: FixedBigRational) = Shaftment(value)
        override fun format(value: FixedBigRational) = "$value shaftments"
    }
}

val FixedBigRational.shaftments get() = Shaftments.new(this)
val Long.shaftments get() = (this over 1).shaftments
val Int.shaftments get() = (this over 1).shaftments

class Link private constructor(value: FixedBigRational) :
    Measure<English, Links>(Links, value) {

    companion object Links : EnglishLengths<Links>("link", 2_376 over 25) {
        override fun new(value: FixedBigRational) = Link(value)
        override fun format(value: FixedBigRational) = "$value links"
    }
}

val FixedBigRational.links get() = Links.new(this)
val Long.links get() = (this over 1).links
val Int.links get() = (this over 1).links

class Foot private constructor(value: FixedBigRational) :
    Measure<English, Feet>(Feet, value) {

    companion object Feet : EnglishLengths<Feet>("foot", 144 over 1) {
        override fun new(value: FixedBigRational) = Foot(value)
        override fun format(value: FixedBigRational) = "$value'"
    }
}

val FixedBigRational.feet get() = Feet.new(this)
val Long.feet get() = (this over 1).feet
val Int.feet get() = (this over 1).feet

class Yard(value: FixedBigRational) :
    Measure<English, Yards>(Yards, value) {
    companion object Yards : EnglishLengths<Yards>("yard", 432 over 1) {
        override fun new(value: FixedBigRational) = Yard(value)
        override fun format(value: FixedBigRational) = "$value yd"
    }
}

val FixedBigRational.yards get() = Yards.new(this)
val Long.yards get() = (this over 1).yards
val Int.yards get() = (this over 1).yards

class Ell private constructor(value: FixedBigRational) :
    Measure<English, Ells>(Ells, value) {

    companion object Ells : EnglishLengths<Ells>("ells", 540 over 1) {
        override fun new(value: FixedBigRational) = Ell(value)
        override fun format(value: FixedBigRational) = "$value ells"
    }
}

val FixedBigRational.ells get() = Ells.new(this)
val Long.ells get() = (this over 1).ells
val Int.ells get() = (this over 1).ells

class Rod private constructor(value: FixedBigRational) :
    Measure<English, Rods>(Rods, value) {

    companion object Rods : EnglishLengths<Rods>("rod", 2_376 over 1) {
        override fun new(value: FixedBigRational) = Rod(value)
        override fun format(value: FixedBigRational) = "$value rods"
    }
}

val FixedBigRational.rods get() = Rods.new(this)
val Long.rods get() = (this over 1).rods
val Int.rods get() = (this over 1).rods

class Chain private constructor(value: FixedBigRational) :
    Measure<English, Chains>(Chains, value) {

    companion object Chains : EnglishLengths<Chains>("chain", 9_504 over 1) {
        override fun new(value: FixedBigRational) = Chain(value)
        override fun format(value: FixedBigRational) = "$value ch"
    }
}

val FixedBigRational.chains get() = Chains.new(this)
val Long.chains get() = (this over 1).chains
val Int.chains get() = (this over 1).chains

class Furlong private constructor(value: FixedBigRational) :
    Measure<English, Furlongs>(Furlongs, value) {

    companion object Furlongs :
        EnglishLengths<Furlongs>("furlong", 95_040 over 1) {
        override fun new(value: FixedBigRational) = Furlong(value)
        override fun format(value: FixedBigRational) = "$value fur"
    }
}

val FixedBigRational.furlongs get() = Furlongs.new(this)
val Long.furlongs get() = (this over 1).furlongs
val Int.furlongs get() = (this over 1).furlongs

class Mile private constructor(value: FixedBigRational) :
    Measure<English, Miles>(Miles, value) {

    companion object Miles : EnglishLengths<Miles>("mile", 760_320 over 1) {
        override fun new(value: FixedBigRational) = Mile(value)
        override fun format(value: FixedBigRational) = "$value mi"
    }
}

val FixedBigRational.miles get() = Miles.new(this)
val Long.miles get() = (this over 1).miles
val Int.miles get() = (this over 1).miles

class League private constructor(value: FixedBigRational) :
    Measure<English, Leagues>(Leagues, value) {

    companion object Leagues :
        EnglishLengths<Leagues>("league", 2_280_960 over 1) {
        override fun new(value: FixedBigRational) = League(value)
        override fun format(value: FixedBigRational) = "$value lea"
    }
}

val FixedBigRational.leagues get() = Leagues.new(this)
val Long.leagues get() = (this over 1).leagues
val Int.leagues get() = (this over 1).leagues
