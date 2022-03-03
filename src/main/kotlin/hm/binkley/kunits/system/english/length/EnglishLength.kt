package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.Length
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
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The English units of length. */
sealed class EnglishLength<U : EnglishLength<U>>(
    name: String,
    lines: FixedBigRational,
) : Length<English, U>(English, name, lines)

class Line private constructor(value: FixedBigRational) :
    Measure<English, Lines>(Lines, value) {

    companion object Lines : EnglishLength<Lines>("line", ONE) {
        override fun new(value: FixedBigRational) = Line(value)
        override fun format(value: FixedBigRational) = "$value lines"
    }
}

val Int.lines get() = (this over 1).lines
val Long.lines get() = (this over 1).lines
val FixedBigRational.lines get() = Lines.new(this)

class Barleycorn private constructor(value: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, value) {

    companion object Barleycorns :
        EnglishLength<Barleycorns>("barleycorn", 4 over 1) {
        override fun new(value: FixedBigRational) = Barleycorn(value)
        override fun format(value: FixedBigRational) = "$value Bc"
    }
}

val Int.barleycorns get() = (this over 1).barleycorns
val Long.barleycorns get() = (this over 1).barleycorns
val FixedBigRational.barleycorns get() = Barleycorns.new(this)

class Inch private constructor(value: FixedBigRational) :
    Measure<English, Inches>(Inches, value) {

    companion object Inches : EnglishLength<Inches>("inch", (12 over 1)) {
        override fun new(value: FixedBigRational) = Inch(value)
        override fun format(value: FixedBigRational) = "$value\""
    }
}

val Int.inches get() = (this over 1).inches
val Long.inches get() = (this over 1).inches
val FixedBigRational.inches get() = Inches.new(this)

class Stick private constructor(value: FixedBigRational) :
    Measure<English, Sticks>(Sticks, value) {

    companion object Sticks : EnglishLength<Sticks>("stick", 24 over 1) {
        override fun new(value: FixedBigRational) = Stick(value)
        override fun format(value: FixedBigRational) = when (value) {
            ONE -> "1 stick"
            else -> "$value sticks"
        }
    }
}

val Int.sticks get() = (this over 1).sticks
val Long.sticks get() = (this over 1).sticks
val FixedBigRational.sticks get() = Sticks.new(this)

class Hand private constructor(value: FixedBigRational) :
    Measure<English, Hands>(Hands, value) {

    companion object Hands : EnglishLength<Hands>("hand", 48 over 1) {
        override fun new(value: FixedBigRational) = Hand(value)
        override fun format(value: FixedBigRational) = "$value hh"
    }
}

val Int.hands get() = (this over 1).hands
val Long.hands get() = (this over 1).hands
val FixedBigRational.hands get() = Hands.new(this)

class Shaftment private constructor(value: FixedBigRational) :
    Measure<English, Shaftments>(Shaftments, value) {

    companion object Shaftments :
        EnglishLength<Shaftments>("shaftment", 72 over 1) {
        override fun new(value: FixedBigRational) = Shaftment(value)
        override fun format(value: FixedBigRational) = "$value shaftments"
    }
}

val Int.shaftments get() = (this over 1).shaftments
val Long.shaftments get() = (this over 1).shaftments
val FixedBigRational.shaftments get() = Shaftments.new(this)

class Link private constructor(value: FixedBigRational) :
    Measure<English, Links>(Links, value) {

    companion object Links : EnglishLength<Links>("link", 2_376 over 25) {
        override fun new(value: FixedBigRational) = Link(value)
        override fun format(value: FixedBigRational) = "$value links"
    }
}

val Int.links get() = (this over 1).links
val Long.links get() = (this over 1).links
val FixedBigRational.links get() = Links.new(this)

class Foot private constructor(value: FixedBigRational) :
    Measure<English, Feet>(Feet, value) {

    companion object Feet : EnglishLength<Feet>("foot", 144 over 1) {
        override fun new(value: FixedBigRational) = Foot(value)
        override fun format(value: FixedBigRational) = "$value'"
    }
}

val Int.feet get() = (this over 1).feet
val Long.feet get() = (this over 1).feet
val FixedBigRational.feet get() = Feet.new(this)

object Yards : EnglishLength<Yards>("yard", 432 over 1) {
    override fun new(value: FixedBigRational) = Yard(value)
    override fun format(value: FixedBigRational) = "$value yd"
}

class Yard(value: FixedBigRational) :
    Measure<English, Yards>(Yards, value)

val Int.yards get() = (this over 1).yards
val Long.yards get() = (this over 1).yards
val FixedBigRational.yards get() = Yards.new(this)

class Ell private constructor(value: FixedBigRational) :
    Measure<English, Ells>(Ells, value) {

    companion object Ells : EnglishLength<Ells>("ells", 540 over 1) {
        override fun new(value: FixedBigRational) = Ell(value)
        override fun format(value: FixedBigRational) = "$value ells"
    }
}

val Int.ells get() = (this over 1).ells
val Long.ells get() = (this over 1).ells
val FixedBigRational.ells get() = Ells.new(this)

class Rod private constructor(value: FixedBigRational) :
    Measure<English, Rods>(Rods, value) {

    companion object Rods : EnglishLength<Rods>("rod", 2_376 over 1) {
        override fun new(value: FixedBigRational) = Rod(value)
        override fun format(value: FixedBigRational) = "$value rods"
    }
}

val Int.rods get() = (this over 1).rods
val Long.rods get() = (this over 1).rods
val FixedBigRational.rods get() = Rods.new(this)

class Chain private constructor(value: FixedBigRational) :
    Measure<English, Chains>(Chains, value) {

    companion object Chains : EnglishLength<Chains>("chain", 9_504 over 1) {
        override fun new(value: FixedBigRational) = Chain(value)
        override fun format(value: FixedBigRational) = "$value ch"
    }
}

val Int.chains get() = (this over 1).chains
val Long.chains get() = (this over 1).chains
val FixedBigRational.chains get() = Chains.new(this)

class Furlong private constructor(value: FixedBigRational) :
    Measure<English, Furlongs>(Furlongs, value) {

    companion object Furlongs :
        EnglishLength<Furlongs>("furlong", 95_040 over 1) {
        override fun new(value: FixedBigRational) = Furlong(value)
        override fun format(value: FixedBigRational) = "$value fur"
    }
}

val Int.furlongs get() = (this over 1).furlongs
val Long.furlongs get() = (this over 1).furlongs
val FixedBigRational.furlongs get() = Furlongs.new(this)

class Mile private constructor(value: FixedBigRational) :
    Measure<English, Miles>(Miles, value) {

    companion object Miles : EnglishLength<Miles>("mile", 760_320 over 1) {
        override fun new(value: FixedBigRational) = Mile(value)
        override fun format(value: FixedBigRational) = "$value mi"
    }
}

val Int.miles get() = (this over 1).miles
val Long.miles get() = (this over 1).miles
val FixedBigRational.miles get() = Miles.new(this)

class League private constructor(value: FixedBigRational) :
    Measure<English, Leagues>(Leagues, value) {

    companion object Leagues :
        EnglishLength<Leagues>("league", 2_280_960 over 1) {
        override fun new(value: FixedBigRational) = League(value)
        override fun format(value: FixedBigRational) = "$value lea"
    }
}

val Int.leagues get() = (this over 1).leagues
val Long.leagues get() = (this over 1).leagues
val FixedBigRational.leagues get() = Leagues.new(this)
