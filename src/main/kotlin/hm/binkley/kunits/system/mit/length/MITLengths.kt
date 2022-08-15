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

package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.kunits.system.mit.length.Ear.Ears
import hm.binkley.kunits.system.mit.length.Smoot.Smoots
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

class Smoot private constructor(quantity: FixedBigRational) :
    Measure<Length, MIT, Smoots, Smoot>(Smoots, quantity) {
    companion object Smoots : Units<Length, MIT, Smoots, Smoot>(
        Length, MIT, "smoot", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Smoot(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sm"
    }
}

val FixedBigRational.smoots get() = Smoots.new(this)
val Long.smoots get() = (this over 1).smoots
val Int.smoots get() = (this over 1).smoots

class Ear(quantity: FixedBigRational) :
    Measure<Length, MIT, Ears, Ear>(Ears, quantity) {
    companion object Ears : Units<Length, MIT, Ears, Ear>(
        Length, MIT, "ear", 3 over 67
    ) {
        override fun new(quantity: FixedBigRational) = Ear(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ears"
    }
}

val FixedBigRational.ears get() = Ears.new(this)
val Long.ears get() = (this over 1).ears
val Int.ears get() = (this over 1).ears
