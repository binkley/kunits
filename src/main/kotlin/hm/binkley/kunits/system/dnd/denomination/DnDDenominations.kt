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

/** The D&D coinage. */
abstract class DnDDenominations<U : DnDDenominations<U>>(
    name: String,
    copperPieces: FixedBigRational,
) : Units<DnD, Denomination, U>(DnD, Denomination, name, copperPieces)

abstract class DnDDenomination<U : DnDDenominations<U>>(
    unit: U,
    quantity: FixedBigRational,
) : Measure<DnD, Denomination, U>(unit, quantity)

class Copper private constructor(quantity: FixedBigRational) :
    DnDDenomination<CopperPieces>(CopperPieces, quantity) {
    companion object CopperPieces : DnDDenominations<CopperPieces>(
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
    DnDDenomination<SilverPieces>(SilverPieces, quantity) {
    companion object SilverPieces : DnDDenominations<SilverPieces>(
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
    DnDDenomination<ElectrumPieces>(ElectrumPieces, quantity) {
    companion object ElectrumPieces : DnDDenominations<ElectrumPieces>(
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
    DnDDenomination<GoldPieces>(GoldPieces, quantity) {
    companion object GoldPieces : DnDDenominations<GoldPieces>(
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
    DnDDenomination<PlatinumPieces>(PlatinumPieces, quantity) {
    companion object PlatinumPieces : DnDDenominations<PlatinumPieces>(
        "platinum piece", 1_000 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Platinum(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity pp"
    }
}

val FixedBigRational.platinum get() = PlatinumPieces.new(this)
val Long.platinum get() = (this over 1).platinum
val Int.platinum get() = (this over 1).platinum
