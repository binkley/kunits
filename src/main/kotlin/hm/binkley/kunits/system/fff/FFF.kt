package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.math.fixed.over

private val FURLONGS_PER_LINE = (95_040 over 1)

/** The system of furlong-firkin-fortnight units. */
object FFF : System<FFF>("Furlong-Firkin-Fortnight")

/** Converts lengths from FFF into English units. */
infix fun <V : EnglishLengths<V>>
Measure<FFF, *>.intoEnglish(other: V) = into(other) { it * FURLONGS_PER_LINE }
