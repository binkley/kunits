package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.system.dnd.denomination.DnDDenomination
import hm.binkley.kunits.system.dnd.denomination.DnDDenominations
import hm.binkley.kunits.system.dnd.denomination.other.AdamantPiece.AdamantPieces
import hm.binkley.kunits.system.dnd.denomination.other.BronzePiece.BronzePieces
import hm.binkley.kunits.system.dnd.denomination.other.IronPiece.IronPieces
import hm.binkley.kunits.system.dnd.denomination.other.MithrilPiece.MithrilPieces
import hm.binkley.kunits.system.dnd.denomination.other.SteelPiece.SteelPieces
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.over

/**
 * Examples of adding to existing units of measure.
 * See https://www.sageadvice.eu/prices-for-brass-steel-mithril-adamantine/.
 */

class IronPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<IronPieces, IronPiece>(IronPieces, quantity) {
    companion object IronPieces : DnDDenominations<IronPieces, IronPiece>(
        "Iron Piece",
        1 over 100
    ) {
        override fun new(quantity: FixedBigRational) = IronPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity IP"
    }
}

val FixedBigRational.ironPieces get() = IronPieces.new(this)
val Long.ironPieces get() = (this over 1).ironPieces
val Int.ironPieces get() = (this over 1).ironPieces

class BronzePiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<BronzePieces, BronzePiece>(BronzePieces, quantity) {
    companion object BronzePieces : DnDDenominations<BronzePieces, BronzePiece>(
        "Bronze Piece",
        1 over 10
    ) {
        override fun new(quantity: FixedBigRational) = BronzePiece(quantity)

        /** @todo "bp" for bronze piece _vs "bp" for brass piece */
        override fun format(quantity: FixedBigRational) = "$quantity BP"
    }
}

val FixedBigRational.bronzePieces get() = BronzePieces.new(this)
val Long.bronzePieces get() = (this over 1).bronzePieces
val Int.bronzePieces get() = (this over 1).bronzePieces

class SteelPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<SteelPieces, SteelPiece>(SteelPieces, quantity) {
    companion object SteelPieces : DnDDenominations<SteelPieces, SteelPiece>(
        "Steel Piece",
        50 over 1
    ) {
        override fun new(quantity: FixedBigRational) = SteelPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity TP"
    }
}

val FixedBigRational.steelPieces get() = SteelPieces.new(this)
val Long.steelPieces get() = (this over 1).steelPieces
val Int.steelPieces get() = (this over 1).steelPieces

class MithrilPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<MithrilPieces, MithrilPiece>(MithrilPieces, quantity) {
    companion object MithrilPieces :
        DnDDenominations<MithrilPieces, MithrilPiece>(
            "Mithril Piece",
            10_000 over 1
        ) {
        override fun new(quantity: FixedBigRational) = MithrilPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity MP"
    }
}

val FixedBigRational.mithrilPieces get() = MithrilPieces.new(this)
val Long.mithrilPieces get() = (this over 1).mithrilPieces
val Int.mithrilPieces get() = (this over 1).mithrilPieces

class AdamantPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<AdamantPieces, AdamantPiece>(AdamantPieces, quantity) {
    companion object AdamantPieces :
        DnDDenominations<AdamantPieces, AdamantPiece>(
            "Adamant Piece",
            100_000 over 1
        ) {
        override fun new(quantity: FixedBigRational) = AdamantPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity AP"
    }
}

val FixedBigRational.adamantPieces get() = AdamantPieces.new(this)
val Long.adamantPieces get() = (this over 1).adamantPieces
val Int.adamantPieces get() = (this over 1).adamantPieces
