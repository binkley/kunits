/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package hm.binkley.kunits.system.fff

import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLength
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.kunits.system.english.time.EnglishTime
import hm.binkley.kunits.system.english.time.EnglishTimes
import hm.binkley.kunits.system.english.weight.EnglishWeight
import hm.binkley.kunits.system.english.weight.EnglishWeights
import hm.binkley.kunits.system.fff.length.FFFLength
import hm.binkley.kunits.system.fff.time.FFFTime
import hm.binkley.kunits.system.fff.weight.FFFWeight
import hm.binkley.math.fixed.over

private val linesPerFurlong = (95_040 over 1)
private val secondsPerFortnight = (1_209_600 over 1)
private val dramsPerFirkin = (23_040 over 1)

/** The system of furlong-firkin-fortnight units. */
object FFF : System<FFF>("Furlong-Firkin-Fortnight")

/** Converts lengths from FFF into English units. */
infix fun <
    V : EnglishLengths<V, N>,
    N : EnglishLength<V, N>
    >
FFFLength<*, *>.intoEnglish(other: V) = into(other) {
    it * linesPerFurlong
}

/** Converts times from FFF into English units. */
infix fun <
    V : EnglishTimes<V, N>,
    N : EnglishTime<V, N>
    >
FFFTime<*, *>.intoEnglish(other: V) = into(other) {
    it * secondsPerFortnight
}

/** Converts weights from FFF into English units. */
infix fun <
    V : EnglishWeights<V, N>,
    N : EnglishWeight<V, N>
    >
FFFWeight<*, *>.intoEnglish(other: V) = into(other) {
    it * dramsPerFirkin
}
