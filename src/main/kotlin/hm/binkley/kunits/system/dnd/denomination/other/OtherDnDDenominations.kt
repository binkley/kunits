package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.system.dnd.denomination.DnDDenomination
import hm.binkley.kunits.system.dnd.denomination.DnDDenominations
import hm.binkley.kunits.system.dnd.denomination.other.Adamant.AdamantPieces
import hm.binkley.kunits.system.dnd.denomination.other.Bronze.BronzePieces
import hm.binkley.kunits.system.dnd.denomination.other.Mithral.MithralPieces
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.over

/** Examples of adding to existing units of measure. */

class Bronze private constructor(quantity: FixedBigRational) :
    DnDDenomination<BronzePieces, Bronze>(BronzePieces, quantity) {
    companion object BronzePieces : DnDDenominations<BronzePieces, Bronze>(
        "bronze piece", 1 over 10
    ) {
        override fun new(quantity: FixedBigRational) = Bronze(quantity)

        /** @todo "bp" for bronze piece _vs "bp" for brass piece */
        override fun format(quantity: FixedBigRational) = "$quantity bp"
    }
}

val FixedBigRational.bronze get() = BronzePieces.new(this)
val Long.bronze get() = (this over 1).bronze
val Int.bronze get() = (this over 1).bronze

class Mithral private constructor(quantity: FixedBigRational) :
    DnDDenomination<MithralPieces, Mithral>(MithralPieces, quantity) {
    companion object MithralPieces : DnDDenominations<MithralPieces, Mithral>(
        "mithral piece", 10_000 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Mithral(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity mp"
    }
}

val FixedBigRational.mithral get() = MithralPieces.new(this)
val Long.mithral get() = (this over 1).mithral
val Int.mithral get() = (this over 1).mithral

class Adamant private constructor(quantity: FixedBigRational) :
    DnDDenomination<AdamantPieces, Adamant>(AdamantPieces, quantity) {
    companion object AdamantPieces : DnDDenominations<AdamantPieces, Adamant>(
        "adamant piece", 100_000 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Adamant(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ap"
    }
}

val FixedBigRational.adamant get() = AdamantPieces.new(this)
val Long.adamant get() = (this over 1).adamant
val Int.adamant get() = (this over 1).adamant
