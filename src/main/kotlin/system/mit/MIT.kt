package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.SMOOTS_PER_LINE
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLength
import hm.binkley.kunits.system.english.length.EnglishLengths

/** Tbe system of MIT units. */
object MIT : System<MIT>("MIT")

/** Converts lengths from MIT into English units. */
infix fun <
    V : EnglishLengths<V, N>,
    N : EnglishLength<V, N>,
    > Measure<Length, MIT, *, *>.intoEnglish(
    other: V
) = into(other) {
    it / SMOOTS_PER_LINE
}
