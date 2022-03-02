package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.system.english.English
import hm.binkley.math.fixed.over

private val LINES_PER_SMOOT = (804 over 1)

object MIT : System<MIT>()

/** Converts lengths from MIT to English units. */
infix fun <U : Length<MIT, U>, V : Length<English, V>>
Measure<MIT, U>.intoEnglish(other: V) = into(other) { it * LINES_PER_SMOOT }
