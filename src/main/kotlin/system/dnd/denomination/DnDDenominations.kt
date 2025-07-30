package hm.binkley.kunits.system.dnd.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.dnd.DnD
import hm.binkley.kunits.system.dnd.denomination.CopperPiece.CopperPieces
import hm.binkley.kunits.system.dnd.denomination.ElectrumPiece.ElectrumPieces
import hm.binkley.kunits.system.dnd.denomination.GoldPiece.GoldPieces
import hm.binkley.kunits.system.dnd.denomination.PlatinumPiece.PlatinumPieces
import hm.binkley.kunits.system.dnd.denomination.SilverPiece.SilverPieces
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TEN
import hm.binkley.math.fixed.over

/** A D&D coinage. */
abstract class DnDDenominations<
    U : Units<Denomination, DnD, U, M>,
    M : Measure<Denomination, DnD, U, M>
    >(
    name: String,
    copperPieces: FixedBigRational
) : Units<Denomination, DnD, U, M>(Denomination, DnD, name, copperPieces)

abstract class DnDDenomination<
    U : Units<Denomination, DnD, U, M>,
    M : Measure<Denomination, DnD, U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Denomination, DnD, U, M>(unit, quantity)

class CopperPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<CopperPieces, CopperPiece>(CopperPieces, quantity) {
    companion object CopperPieces : DnDDenominations<CopperPieces, CopperPiece>(
        "Copper Piece",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = CopperPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity CP"
    }
}

val FixedBigRational.copperPieces get() = CopperPieces.new(this)
val Long.copperPieces get() = (this over 1).copperPieces
val Int.copperPieces get() = (this over 1).copperPieces

class SilverPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<SilverPieces, SilverPiece>(SilverPieces, quantity) {
    companion object SilverPieces : DnDDenominations<SilverPieces, SilverPiece>(
        "Silver Piece",
        TEN
    ) {
        override fun new(quantity: FixedBigRational) = SilverPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity SP"
    }
}

val FixedBigRational.silverPieces get() = SilverPieces.new(this)
val Long.silverPieces get() = (this over 1).silverPieces
val Int.silverPieces get() = (this over 1).silverPieces

class ElectrumPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<ElectrumPieces, ElectrumPiece>(ElectrumPieces, quantity) {
    companion object ElectrumPieces :
        DnDDenominations<ElectrumPieces, ElectrumPiece>(
            "Electrum Piece",
            50 over 1
        ) {
        override fun new(quantity: FixedBigRational) = ElectrumPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity EP"
    }
}

val FixedBigRational.electrumPieces get() = ElectrumPieces.new(this)
val Long.electrumPieces get() = (this over 1).electrumPieces
val Int.electrumPieces get() = (this over 1).electrumPieces

class GoldPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<GoldPieces, GoldPiece>(GoldPieces, quantity) {
    companion object GoldPieces : DnDDenominations<GoldPieces, GoldPiece>(
        "Gold Piece",
        100 over 1
    ) {
        override fun new(quantity: FixedBigRational) = GoldPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity GP"
    }
}

val FixedBigRational.goldPieces get() = GoldPieces.new(this)
val Long.goldPieces get() = (this over 1).goldPieces
val Int.goldPieces get() = (this over 1).goldPieces

class PlatinumPiece private constructor(quantity: FixedBigRational) :
    DnDDenomination<PlatinumPieces, PlatinumPiece>(PlatinumPieces, quantity) {
    companion object PlatinumPieces :
        DnDDenominations<PlatinumPieces, PlatinumPiece>(
            "Platinum Piece",
            1_000 over 1
        ) {
        override fun new(quantity: FixedBigRational) = PlatinumPiece(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity PP"
    }
}

val FixedBigRational.platinumPieces get() = PlatinumPieces.new(this)
val Long.platinumPieces get() = (this over 1).platinumPieces
val Int.platinumPieces get() = (this over 1).platinumPieces
