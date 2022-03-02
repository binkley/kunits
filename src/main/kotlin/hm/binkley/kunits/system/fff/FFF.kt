package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.over

private val FURLONGS_PER_LINE = (95_040 over 1)

object FFF : System<FFF>()

/** Converts lengths from FFF to English units. */
infix fun <U : Length<FFF, U>, V : Length<English, V>>
Measure<FFF, U>.intoEnglish(other: V) = into(other) { it * FURLONGS_PER_LINE }
