package hm.binkley.kunits.system.english

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.div

private const val FURLONGS_PER_LINE = 95_040

/** Converts lengths from English to FFF units. */
fun <U : Length<English, U>, V : Length<FFF, V>>
Measure<English, U>.intoFFF(other: V) = into(other) { it / FURLONGS_PER_LINE }
