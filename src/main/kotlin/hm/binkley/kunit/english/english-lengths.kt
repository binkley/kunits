package hm.binkley.kunit.english

import hm.binkley.kunit.Measure
import hm.binkley.kunit.Units
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.minus
import hm.binkley.math.finite.over
import hm.binkley.math.finite.plus
import hm.binkley.math.finite.times

sealed class EnglishLengths<U : EnglishLengths<U>>(name: String) :
    Units<U>(name)

object Poppyseeds : EnglishLengths<Poppyseeds>("Poppyseed") {
    override fun new(value: FiniteBigRational) = Poppyseed(value)
    override fun format(value: FiniteBigRational) = "$value poppyseeds"
}

class Poppyseed(value: FiniteBigRational) :
    Measure<Poppyseeds>(Poppyseeds, value)

inline val Int.poppyseeds
    get() = (this over 1).poppyseeds
inline val FiniteBigRational.poppyseeds
    get() = Poppyseed(this)

object Barleycorns : EnglishLengths<Barleycorns>("Barleycorn") {
    override fun new(value: FiniteBigRational) = Barleycorn(value)
    override fun format(value: FiniteBigRational) = "$value barleycorns"
}

class Barleycorn(value: FiniteBigRational) :
    Measure<Barleycorns>(Barleycorns, value)

inline val Int.barleycorns
    get() = (this over 1).barleycorns
inline val FiniteBigRational.barleycorns
    get() = Barleycorn(this)

object Inches : EnglishLengths<Inches>("Inch") {
    override fun new(value: FiniteBigRational) = Inch(value)
    override fun format(value: FiniteBigRational) = "$value\""
}

class Inch(value: FiniteBigRational) :
    Measure<Inches>(Inches, value)

inline val Int.inches
    get() = (this over 1).inches
inline val FiniteBigRational.inches
    get() = Inch(this)

object Sticks : EnglishLengths<Sticks>("Stick") {
    override fun new(value: FiniteBigRational) = Stick(value)
    override fun format(value: FiniteBigRational) = "$value sticks"
}

class Stick(value: FiniteBigRational) :
    Measure<Sticks>(Sticks, value)

inline val Int.sticks
    get() = (this over 1).sticks
inline val FiniteBigRational.sticks
    get() = Stick(this)

object Hands : EnglishLengths<Hands>("Hand") {
    override fun new(value: FiniteBigRational) = Hand(value)
    override fun format(value: FiniteBigRational) = "$value hh"
}

class Hand(value: FiniteBigRational) :
    Measure<Hands>(Hands, value)

inline val Int.hands
    get() = (this over 1).hands
inline val FiniteBigRational.hands
    get() = Hand(this)

object Feet : EnglishLengths<Feet>("Foot") {
    override fun new(value: FiniteBigRational) = Foot(value)
    override fun format(value: FiniteBigRational) = "$value'"
}

class Foot(value: FiniteBigRational) :
    Measure<Feet>(Feet, value)

inline val Int.feet
    get() = (this over 1).feet
inline val FiniteBigRational.feet
    get() = Foot(this)

object Yards : EnglishLengths<Yards>("Yard") {
    override fun new(value: FiniteBigRational) = Yard(value)
    override fun format(value: FiniteBigRational) = "$value yd"
}

class Yard(value: FiniteBigRational) :
    Measure<Yards>(Yards, value)

inline val Int.yards
    get() = (this over 1).yards
inline val FiniteBigRational.yards
    get() = Yard(this)

object Fathoms : EnglishLengths<Fathoms>("Fathom") {
    override fun new(value: FiniteBigRational) = Fathom(value)
    override fun format(value: FiniteBigRational) = "$value fm"
}

class Fathom(value: FiniteBigRational) :
    Measure<Fathoms>(Fathoms, value)

inline val Int.fathoms
    get() = (this over 1).fathoms
inline val FiniteBigRational.fathoms
    get() = Fathom(this)

/** There is a clever way to do this, but this is simple if tedious. */
private val ratios = mapOf(
    (Poppyseeds to Poppyseeds) to ONE,
    (Poppyseeds to Barleycorns) to (4 over 1),
    (Poppyseeds to Inches) to (12 over 1),
    (Poppyseeds to Sticks) to (24 over 1),
    (Poppyseeds to Hands) to (48 over 1),
    (Poppyseeds to Feet) to (144 over 1),
    (Poppyseeds to Yards) to (432 over 1),
    (Poppyseeds to Fathoms) to (864 over 1),
    (Barleycorns to Poppyseeds) to (1 over 4),
    (Barleycorns to Barleycorns) to ONE,
    (Barleycorns to Inches) to (3 over 1),
    (Barleycorns to Sticks) to (6 over 1),
    (Barleycorns to Hands) to (12 over 1),
    (Barleycorns to Feet) to (36 over 1),
    (Barleycorns to Yards) to (108 over 1),
    (Barleycorns to Fathoms) to (216 over 1),
    (Inches to Poppyseeds) to (1 over 12),
    (Inches to Barleycorns) to (1 over 3),
    (Inches to Inches) to ONE,
    (Inches to Sticks) to (2 over 1),
    (Inches to Hands) to (4 over 1),
    (Inches to Feet) to (12 over 1),
    (Inches to Yards) to (36 over 1),
    (Inches to Fathoms) to (72 over 1),
    (Sticks to Poppyseeds) to (1 over 24),
    (Sticks to Barleycorns) to (1 over 6),
    (Sticks to Inches) to (1 over 2),
    (Sticks to Sticks) to ONE,
    (Sticks to Hands) to (2 over 1),
    (Sticks to Feet) to (6 over 1),
    (Sticks to Yards) to (18 over 1),
    (Sticks to Fathoms) to (36 over 1),
    (Hands to Poppyseeds) to (1 over 48),
    (Hands to Barleycorns) to (1 over 12),
    (Hands to Inches) to (1 over 4),
    (Hands to Sticks) to (1 over 2),
    (Hands to Hands) to ONE,
    (Hands to Feet) to (3 over 1),
    (Hands to Yards) to (9 over 1),
    (Hands to Fathoms) to (18 over 1),
    (Feet to Poppyseeds) to (1 over 144),
    (Feet to Barleycorns) to (1 over 36),
    (Feet to Inches) to (1 over 12),
    (Feet to Sticks) to (1 over 6),
    (Feet to Hands) to (1 over 3),
    (Feet to Feet) to ONE,
    (Feet to Yards) to (3 over 1),
    (Feet to Fathoms) to (6 over 1),
    (Yards to Poppyseeds) to (1 over 432),
    (Yards to Barleycorns) to (1 over 108),
    (Yards to Inches) to (1 over 36),
    (Yards to Sticks) to (1 over 18),
    (Yards to Hands) to (1 over 9),
    (Yards to Feet) to (1 over 3),
    (Yards to Yards) to ONE,
    (Yards to Fathoms) to (2 over 1),
    (Fathoms to Poppyseeds) to (1 over 864),
    (Fathoms to Barleycorns) to (1 over 216),
    (Fathoms to Inches) to (1 over 72),
    (Fathoms to Sticks) to (1 over 36),
    (Fathoms to Hands) to (1 over 18),
    (Fathoms to Feet) to (1 over 6),
    (Fathoms to Yards) to (1 over 2),
    (Fathoms to Fathoms) to ONE
)

fun <U : EnglishLengths<U>, V : EnglishLengths<V>> Measure<U>.to(other: V) =
    other.new(value * (ratios.getValue(other to unit)))

// With automatic unit conversion -- for explicit conversion, remove these
// definitions, and rely on Unit<*>'s definitions

operator fun <U : EnglishLengths<U>, V : EnglishLengths<V>> Measure<U>.plus(
    other: Measure<V>
) = unit.new(value + other.to(unit).value)

operator fun <U : EnglishLengths<U>, V : EnglishLengths<V>> Measure<U>.minus(
    other: Measure<V>
) = unit.new(value - other.to(unit).value)
