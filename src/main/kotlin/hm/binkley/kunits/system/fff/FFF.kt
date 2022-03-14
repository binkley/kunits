package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.kunits.system.english.weight.EnglishWeights
import hm.binkley.kunits.system.fff.length.FFFLengths
import hm.binkley.kunits.system.fff.weight.FFFWeights
import hm.binkley.math.fixed.over

private val LINES_PER_FURLONG = (95_040 over 1)
private val DRAMS_PER_FIRKIN = (23_040 over 1)

/** The system of furlong-firkin-fortnight units. */
object FFF : System<FFF>("Furlong-Firkin-Fortnight")

/** Converts lengths from FFF into English units. */
infix fun <U : FFFLengths<U>, V : EnglishLengths<V>>
Measure<FFF, U>.intoEnglish(other: V) = into(other) { it * LINES_PER_FURLONG }

/** Converts weights from FFF into English units. */
infix fun <U : FFFWeights<U>, V : EnglishWeights<V>>
Measure<FFF, U>.intoEnglish(other: V) = into(other) { it * DRAMS_PER_FIRKIN }
