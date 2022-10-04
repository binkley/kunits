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

package hm.binkley.kunits.system.english

import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLength
import hm.binkley.kunits.system.english.time.EnglishTime
import hm.binkley.kunits.system.english.weight.EnglishWeight
import hm.binkley.kunits.system.fff.length.FFFLength
import hm.binkley.kunits.system.fff.length.FFFLengths
import hm.binkley.kunits.system.fff.time.FFFTime
import hm.binkley.kunits.system.fff.time.FFFTimes
import hm.binkley.kunits.system.fff.weight.FFFWeight
import hm.binkley.kunits.system.fff.weight.FFFWeights
import hm.binkley.math.fixed.over

private val furlongsPerLine = 1 over 95_040
private val fortnightsPerSecond = 1 over 1_209_600
private val firkinsPerDram = 1 over 23_040

/** The system of English units. */
object English : System<English>("English")

/** Converts lengths from English into FFF units. */
infix fun <V : FFFLengths<V, N>, N : FFFLength<V, N>>
EnglishLength<*, *>.intoFFF(other: V) = into(other) {
    it * furlongsPerLine
}

/** Converts lengths from English into FFF units. */
infix fun <V : FFFTimes<V, N>, N : FFFTime<V, N>>
EnglishTime<*, *>.intoFFF(other: V) = into(other) {
    it * fortnightsPerSecond
}

/** Converts lengths from English into FFF units. */
infix fun <V : FFFWeights<V, N>, N : FFFWeight<V, N>>
EnglishWeight<*, *>.intoFFF(other: V) = into(other) {
    it * firkinsPerDram
}
