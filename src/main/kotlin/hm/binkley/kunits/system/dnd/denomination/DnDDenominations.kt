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

package hm.binkley.kunits.system.dnd.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.dnd.DnD
import hm.binkley.kunits.system.dnd.denomination.Copper.CopperPieces
import hm.binkley.kunits.system.dnd.denomination.Electrum.ElectrumPieces
import hm.binkley.kunits.system.dnd.denomination.Gold.GoldPieces
import hm.binkley.kunits.system.dnd.denomination.Platinum.PlatinumPieces
import hm.binkley.kunits.system.dnd.denomination.Silver.SilverPieces
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TEN
import hm.binkley.math.fixed.over

/** A D&D coinage. */
abstract class DnDDenominations<
    U : Units<Denomination, DnD, U, M>,
    M : Measure<Denomination, DnD, U, M>,
    >(
    name: String,
    copperPieces: FixedBigRational,
) : Units<Denomination, DnD, U, M>(Denomination, DnD, name, copperPieces)

abstract class DnDDenomination<
    U : Units<Denomination, DnD, U, M>,
    M : Measure<Denomination, DnD, U, M>,
    >(
    unit: U,
    quantity: FixedBigRational,
) : Measure<Denomination, DnD, U, M>(unit, quantity)

class Copper private constructor(quantity: FixedBigRational) :
    DnDDenomination<CopperPieces, Copper>(CopperPieces, quantity) {
    companion object CopperPieces : DnDDenominations<CopperPieces, Copper>(
        "copper piece", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Copper(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity cp"
    }
}

val FixedBigRational.copper get() = CopperPieces.new(this)
val Long.copper get() = (this over 1).copper
val Int.copper get() = (this over 1).copper

class Silver private constructor(quantity: FixedBigRational) :
    DnDDenomination<SilverPieces, Silver>(SilverPieces, quantity) {
    companion object SilverPieces : DnDDenominations<SilverPieces, Silver>(
        "silver piece", TEN
    ) {
        override fun new(quantity: FixedBigRational) = Silver(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sp"
    }
}

val FixedBigRational.silver get() = SilverPieces.new(this)
val Long.silver get() = (this over 1).silver
val Int.silver get() = (this over 1).silver

class Electrum private constructor(quantity: FixedBigRational) :
    DnDDenomination<ElectrumPieces, Electrum>(ElectrumPieces, quantity) {
    companion object ElectrumPieces : DnDDenominations<ElectrumPieces, Electrum>(
        "electrum piece", 50 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Electrum(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ep"
    }
}

val FixedBigRational.electrum get() = ElectrumPieces.new(this)
val Long.electrum get() = (this over 1).electrum
val Int.electrum get() = (this over 1).electrum

class Gold private constructor(quantity: FixedBigRational) :
    DnDDenomination<GoldPieces, Gold>(GoldPieces, quantity) {
    companion object GoldPieces : DnDDenominations<GoldPieces, Gold>(
        "gold piece", 100 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Gold(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity gp"
    }
}

val FixedBigRational.gold get() = GoldPieces.new(this)
val Long.gold get() = (this over 1).gold
val Int.gold get() = (this over 1).gold

class Platinum private constructor(quantity: FixedBigRational) :
    DnDDenomination<PlatinumPieces, Platinum>(PlatinumPieces, quantity) {
    companion object PlatinumPieces : DnDDenominations<PlatinumPieces, Platinum>(
        "platinum piece", 1_000 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Platinum(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity pp"
    }
}

val FixedBigRational.platinum get() = PlatinumPieces.new(this)
val Long.platinum get() = (this over 1).platinum
val Int.platinum get() = (this over 1).platinum
