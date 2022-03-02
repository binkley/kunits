package hm.binkley.kunits.system.english

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.fixed.over

private val LINES_PER_FURLONG = 1 over 95_040

/** The system of English units. */
object English : System<English>("English")

/** Converts lengths from English to FFF units. */
infix fun <U : Length<English, U>, V : Length<FFF, V>>
Measure<English, U>.intoFFF(other: V) = into(other) { it * LINES_PER_FURLONG }
