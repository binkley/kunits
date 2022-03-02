package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.math.times

private const val LINES_PER_SMOOT = 804

/** Converts lengths from MIT to English units. */
fun <U : Length<MIT, U>, V : Length<English, V>>
Measure<MIT, U>.toEnglish(other: V) = into(other) { it * LINES_PER_SMOOT }
