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

package hm.binkley.kunits.system.english.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.denomination.Crown.Crowns
import hm.binkley.kunits.system.english.denomination.Farthing.Farthings
import hm.binkley.kunits.system.english.denomination.Halfpenny.Halfpence
import hm.binkley.kunits.system.english.denomination.Penny.Pence
import hm.binkley.kunits.system.english.denomination.Shilling.Shillings
import hm.binkley.kunits.system.english.denomination.Sixpenny.Sixpence
import hm.binkley.kunits.system.english.denomination.Threepenny.Threepence
import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over
import hm.binkley.math.times

/** The English units of denomination. */
sealed class EnglishDenominations<
    U : EnglishDenominations<U, M>,
    M : EnglishDenomination<U, M>
    >(
    name: String,
    pence: FixedBigRational
) : Units<Denomination, English, U, M>(Denomination, English, name, pence)

sealed class EnglishDenomination<
    U : EnglishDenominations<U, M>,
    M : EnglishDenomination<U, M>
    >(
    units: U,
    quantity: FixedBigRational
) : Measure<Denomination, English, U, M>(units, quantity)

class Farthing private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Farthings, Farthing>(Farthings, quantity) {
    companion object Farthings : EnglishDenominations<Farthings, Farthing>(
        "farthing",
        (1 over 4)
    ) {
        override fun new(quantity: FixedBigRational) = Farthing(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity / 4}d"
    }
}

val FixedBigRational.farthings get() = Farthings.new(this)
val Long.farthings get() = (this over 1).farthings
val Int.farthings get() = (this over 1).farthings

class Halfpenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Halfpence, Halfpenny>(Halfpence, quantity) {
    companion object Halfpence : EnglishDenominations<Halfpence, Halfpenny>(
        "halfpenny",
        (1 over 2)
    ) {
        override fun new(quantity: FixedBigRational) = Halfpenny(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity / 2}d"
    }
}

val FixedBigRational.halfpence get() = Halfpence.new(this)
val Long.halfpence get() = (this over 1).halfpence
val Int.halfpence get() = (this over 1).halfpence

class Penny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Pence, Penny>(Pence, quantity) {
    companion object Pence : EnglishDenominations<Pence, Penny>(
        "penny",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Penny(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}d"
    }
}

val FixedBigRational.pence get() = Pence.new(this)
val Long.pence get() = (this over 1).pence
val Int.pence get() = (this over 1).pence

class Threepenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Threepence, Threepenny>(Threepenny, quantity) {
    companion object Threepence :
        EnglishDenominations<Threepence, Threepenny>(
            "threepenny",
            (3 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Threepenny(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity * 3}d"
    }
}

val FixedBigRational.threepenny get() = Threepenny.new(this)
val Long.threepence get() = (this over 1).threepenny
val Int.threepence get() = (this over 1).threepenny

class Sixpenny private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Sixpence, Sixpenny>(Sixpenny, quantity) {
    companion object Sixpence :
        EnglishDenominations<Sixpence, Sixpenny>(
            "sixpenny",
            (6 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Sixpenny(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity * 6}d"
    }
}

val FixedBigRational.sixpenny get() = Sixpenny.new(this)
val Long.sixpence get() = (this over 1).sixpenny
val Int.sixpence get() = (this over 1).sixpenny

class Shilling private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Shillings, Shilling>(Shilling, quantity) {
    companion object Shillings :
        EnglishDenominations<Shillings, Shilling>(
            "shilling",
            (12 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Shilling(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity}s"
    }
}

val FixedBigRational.shilling get() = Shilling.new(this)
val Long.shillings get() = (this over 1).shilling
val Int.shillings get() = (this over 1).shilling

class Crown private constructor(quantity: FixedBigRational) :
    EnglishDenomination<Crowns, Crown>(Crown, quantity) {
    companion object Crowns :
        EnglishDenominations<Crowns, Crown>(
            "crown",
            (60 over 1)
        ) {
        override fun new(quantity: FixedBigRational) = Crown(quantity)
        override fun format(quantity: FixedBigRational) = "${quantity * 5}s"
    }
}

val FixedBigRational.crown get() = Crown.new(this)
val Long.crowns get() = (this over 1).crown
val Int.crowns get() = (this over 1).crown
