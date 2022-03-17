package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.math.fixed.over

private val LINES_PER_SMOOT = (804 over 1)

/** Tbe system of MIT units. */
object MIT : System<MIT>("MIT")

/** Converts lengths from MIT into English units. */
infix fun <V : EnglishLengths<V>>
Measure<MIT, Length, *>.intoEnglish(other: V) = into(other) {
    it * LINES_PER_SMOOT
}
