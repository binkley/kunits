package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
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
) : Units<English, U>(English, name, lines)

class Line private constructor(quantity: FixedBigRational) :
    Measure<English, Lines>(Lines, quantity) {
    companion object Lines : EnglishLengths<Lines>(
        "line", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Line(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity lines"
    }
}

val FixedBigRational.lines get() = Lines.new(this)
val Long.lines get() = (this over 1).lines
val Int.lines get() = (this over 1).lines

class Barleycorn private constructor(quantity: FixedBigRational) :
    Measure<English, Barleycorns>(Barleycorns, quantity) {
    companion object Barleycorns : EnglishLengths<Barleycorns>(
        "barleycorn", 4 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Barleycorn(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity Bc"
    }
}

val FixedBigRational.barleycorns get() = Barleycorns.new(this)
val Long.barleycorns get() = (this over 1).barleycorns
val Int.barleycorns get() = (this over 1).barleycorns

class Inch private constructor(quantity: FixedBigRational) :
    Measure<English, Inches>(Inches, quantity) {
    companion object Inches : EnglishLengths<Inches>(
        "inch", 12 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Inch(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity\""
    }
}

val FixedBigRational.inches get() = Inches.new(this)
val Long.inches get() = (this over 1).inches
val Int.inches get() = (this over 1).inches

class Stick private constructor(quantity: FixedBigRational) :
    Measure<English, Sticks>(Sticks, quantity) {
    companion object Sticks : EnglishLengths<Sticks>(
        "stick", 24 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Stick(quantity)
        override fun format(quantity: FixedBigRational) = when (quantity) {
            ONE -> "1 stick"
            else -> "$quantity sticks"
        }
    }
}

val FixedBigRational.sticks get() = Sticks.new(this)
val Long.sticks get() = (this over 1).sticks
val Int.sticks get() = (this over 1).sticks

class Hand private constructor(quantity: FixedBigRational) :
    Measure<English, Hands>(Hands, quantity) {
    companion object Hands : EnglishLengths<Hands>(
        "hand", 48 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Hand(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity hh"
    }
}

val FixedBigRational.hands get() = Hands.new(this)
val Long.hands get() = (this over 1).hands
val Int.hands get() = (this over 1).hands

class Shaftment private constructor(quantity: FixedBigRational) :
    Measure<English, Shaftments>(Shaftments, quantity) {
    companion object Shaftments : EnglishLengths<Shaftments>(
        "shaftment", 72 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Shaftment(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity shaftments"
    }
}

val FixedBigRational.shaftments get() = Shaftments.new(this)
val Long.shaftments get() = (this over 1).shaftments
val Int.shaftments get() = (this over 1).shaftments

class Link private constructor(quantity: FixedBigRational) :
    Measure<English, Links>(Links, quantity) {
    companion object Links : EnglishLengths<Links>(
        "link", 2_376 over 25
    ) {
        override fun new(quantity: FixedBigRational) = Link(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity links"
    }
}

val FixedBigRational.links get() = Links.new(this)
val Long.links get() = (this over 1).links
val Int.links get() = (this over 1).links

class Foot private constructor(quantity: FixedBigRational) :
    Measure<English, Feet>(Feet, quantity) {
    companion object Feet : EnglishLengths<Feet>(
        "foot", 144 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Foot(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity'"
    }
}

val FixedBigRational.feet get() = Feet.new(this)
val Long.feet get() = (this over 1).feet
val Int.feet get() = (this over 1).feet

class Yard(quantity: FixedBigRational) :
    Measure<English, Yards>(Yards, quantity) {
    companion object Yards : EnglishLengths<Yards>(
        "yard", 432 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Yard(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity yd"
    }
}

val FixedBigRational.yards get() = Yards.new(this)
val Long.yards get() = (this over 1).yards
val Int.yards get() = (this over 1).yards

class Ell private constructor(quantity: FixedBigRational) :
    Measure<English, Ells>(Ells, quantity) {
    companion object Ells : EnglishLengths<Ells>(
        "ells", 540 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Ell(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ells"
    }
}

val FixedBigRational.ells get() = Ells.new(this)
val Long.ells get() = (this over 1).ells
val Int.ells get() = (this over 1).ells

class Rod private constructor(quantity: FixedBigRational) :
    Measure<English, Rods>(Rods, quantity) {
    companion object Rods : EnglishLengths<Rods>(
        "rod", 2_376 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Rod(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity rods"
    }
}

val FixedBigRational.rods get() = Rods.new(this)
val Long.rods get() = (this over 1).rods
val Int.rods get() = (this over 1).rods

class Chain private constructor(quantity: FixedBigRational) :
    Measure<English, Chains>(Chains, quantity) {
    companion object Chains : EnglishLengths<Chains>(
        "chain", 9_504 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Chain(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ch"
    }
}

val FixedBigRational.chains get() = Chains.new(this)
val Long.chains get() = (this over 1).chains
val Int.chains get() = (this over 1).chains

class Furlong private constructor(quantity: FixedBigRational) :
    Measure<English, Furlongs>(Furlongs, quantity) {
    companion object Furlongs : EnglishLengths<Furlongs>(
        "furlong", 95_040 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Furlong(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity fur"
    }
}

val FixedBigRational.furlongs get() = Furlongs.new(this)
val Long.furlongs get() = (this over 1).furlongs
val Int.furlongs get() = (this over 1).furlongs

class Mile private constructor(quantity: FixedBigRational) :
    Measure<English, Miles>(Miles, quantity) {
    companion object Miles : EnglishLengths<Miles>(
        "mile", 760_320 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Mile(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity mi"
    }
}

val FixedBigRational.miles get() = Miles.new(this)
val Long.miles get() = (this over 1).miles
val Int.miles get() = (this over 1).miles

class League private constructor(quantity: FixedBigRational) :
    Measure<English, Leagues>(Leagues, quantity) {
    companion object Leagues : EnglishLengths<Leagues>(
        "league", 2_280_960 over 1
    ) {
        override fun new(quantity: FixedBigRational) = League(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity lea"
    }
}

val FixedBigRational.leagues get() = Leagues.new(this)
val Long.leagues get() = (this over 1).leagues
val Int.leagues get() = (this over 1).leagues
