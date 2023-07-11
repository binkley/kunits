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

package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.system.dnd.denomination.DnDDenomination
import hm.binkley.kunits.system.dnd.denomination.DnDDenominations
import hm.binkley.kunits.system.dnd.denomination.other.Adamant.AdamantPieces
import hm.binkley.kunits.system.dnd.denomination.other.Bronze.BronzePieces
import hm.binkley.kunits.system.dnd.denomination.other.Mithril.MithrilPieces
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.over

/**
 * Examples of adding to existing units of measure.
 * See https://www.sageadvice.eu/prices-for-brass-steel-mithril-adamantine/.
 */

class Bronze private constructor(quantity: FixedBigRational) :
    DnDDenomination<BronzePieces, Bronze>(BronzePieces, quantity) {
    companion object BronzePieces : DnDDenominations<BronzePieces, Bronze>(
        "bronze piece",
        1 over 10
    ) {
        override fun new(quantity: FixedBigRational) = Bronze(quantity)

        /** @todo "bp" for bronze piece _vs "bp" for brass piece */
        override fun format(quantity: FixedBigRational) = "$quantity bp"
    }
}

val FixedBigRational.bronze get() = BronzePieces.new(this)
val Long.bronze get() = (this over 1).bronze
val Int.bronze get() = (this over 1).bronze

class Mithril private constructor(quantity: FixedBigRational) :
    DnDDenomination<MithrilPieces, Mithril>(MithrilPieces, quantity) {
    companion object MithrilPieces : DnDDenominations<MithrilPieces, Mithril>(
        "mithril piece",
        10_000 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Mithril(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity mp"
    }
}

val FixedBigRational.mithril get() = MithrilPieces.new(this)
val Long.mithril get() = (this over 1).mithril
val Int.mithril get() = (this over 1).mithril

class Adamant private constructor(quantity: FixedBigRational) :
    DnDDenomination<AdamantPieces, Adamant>(AdamantPieces, quantity) {
    companion object AdamantPieces : DnDDenominations<AdamantPieces, Adamant>(
        "adamant piece",
        100_000 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Adamant(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ap"
    }
}

val FixedBigRational.adamant get() = AdamantPieces.new(this)
val Long.adamant get() = (this over 1).adamant
val Int.adamant get() = (this over 1).adamant
