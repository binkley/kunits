package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.times

private const val LINES_PER_FURLONG = 95_040

/** Converts lengths from FFF to English units. */
fun <U : Length<FFF, U>, V : Length<English, V>>
Measure<FFF, U>.toEnglish(other: V) = into(other) { it * LINES_PER_FURLONG }
