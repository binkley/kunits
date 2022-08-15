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

package hm.binkley.kunits.system.fff.weight

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.Weight
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.weight.Firkin.Firkins
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of weight. */
sealed class FFFWeights<
    U : FFFWeights<U, M>,
    M : FFFWeight<U, M>,
    >(
    name: String,
    furlongs: FixedBigRational,
) : Units<Weight, FFF, U, M>(Weight, FFF, name, furlongs)

sealed class FFFWeight<
    U : FFFWeights<U, M>,
    M : FFFWeight<U, M>,
    >(
    unit: U,
    quantity: FixedBigRational,
) : Measure<Weight, FFF, U, M>(unit, quantity)

/** One firkin (weight) is the weight of one firkin (volume) of water. */
class Firkin private constructor(quantity: FixedBigRational) :
    FFFWeight<Firkins, Firkin>(Firkins, quantity) {
    companion object Firkins : FFFWeights<Firkins, Firkin>(
        "firkin", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Firkin(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity fir"
    }
}

val FixedBigRational.firkins get() = Firkins.new(this)
val Long.firkins get() = (this over 1).firkins
val Int.firkins get() = (this over 1).firkins
