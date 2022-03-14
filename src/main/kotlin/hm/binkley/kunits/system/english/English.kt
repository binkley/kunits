package hm.binkley.kunits.system.english

import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.kunits.system.english.weight.EnglishWeights
import hm.binkley.kunits.system.fff.length.FFFLengths
import hm.binkley.kunits.system.fff.weight.FFFWeights
import hm.binkley.math.fixed.over

private val FURLONGS_PER_LINE = 1 over 95_040
private val FIRKINS_PER_FRAM = 1 over 23_040

/** The system of English units. */
object English : System<English>("English")

/** Converts lengths from English into FFF units. */
infix fun <U : EnglishLengths<U>, V : FFFLengths<V>>
Measure<English, U>.intoFFF(other: V) = into(other) { it * FURLONGS_PER_LINE }

/** Converts lengths from English into FFF units. */
infix fun <U : EnglishWeights<U>, V : FFFWeights<V>>
Measure<English, U>.intoFFF(other: V) = into(other) { it * FIRKINS_PER_FRAM }
