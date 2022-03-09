package hm.binkley.kunits.system.dnd.denomination

import hm.binkley.kunits.Denominations
import hm.binkley.kunits.Measure
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
sealed class DnDDenominations<U : DnDDenominations<U>>(
    name: String,
    copperPieces: FixedBigRational,
) : Denominations<DnD, U>(DnD, name, copperPieces)

class Copper private constructor(value: FixedBigRational) :
    Measure<DnD, CopperPieces>(CopperPieces, value) {

    companion object CopperPieces :
        DnDDenominations<CopperPieces>("copper piece", ONE) {
        override fun new(value: FixedBigRational) = Copper(value)
        override fun format(value: FixedBigRational) = "$value cp"
    }
}

val FixedBigRational.copper get() = CopperPieces.new(this)
val Long.copper get() = (this over 1).copper
val Int.copper get() = (this over 1).copper

class Silver private constructor(value: FixedBigRational) :
    Measure<DnD, SilverPieces>(SilverPieces, value) {

    companion object SilverPieces :
        DnDDenominations<SilverPieces>("silver piece", TEN) {
        override fun new(value: FixedBigRational) = Silver(value)
        override fun format(value: FixedBigRational) = "$value sp"
    }
}

val FixedBigRational.silver get() = SilverPieces.new(this)
val Long.silver get() = (this over 1).silver
val Int.silver get() = (this over 1).silver

class Electrum private constructor(value: FixedBigRational) :
    Measure<DnD, ElectrumPieces>(ElectrumPieces, value) {

    companion object ElectrumPieces :
        DnDDenominations<ElectrumPieces>("electrum piece", (50 over 1)) {
        override fun new(value: FixedBigRational) = Electrum(value)
        override fun format(value: FixedBigRational) = "$value ep"
    }
}

val FixedBigRational.electrum get() = ElectrumPieces.new(this)
val Long.electrum get() = (this over 1).electrum
val Int.electrum get() = (this over 1).electrum

class Gold private constructor(value: FixedBigRational) :
    Measure<DnD, GoldPieces>(GoldPieces, value) {

    companion object GoldPieces :
        DnDDenominations<GoldPieces>("gold piece", (100 over 1)) {
        override fun new(value: FixedBigRational) = Gold(value)
        override fun format(value: FixedBigRational) = "$value gp"
    }
}

val FixedBigRational.gold get() = GoldPieces.new(this)
val Long.gold get() = (this over 1).gold
val Int.gold get() = (this over 1).gold

class Platinum private constructor(value: FixedBigRational) :
    Measure<DnD, PlatinumPieces>(PlatinumPieces, value) {

    companion object PlatinumPieces :
        DnDDenominations<PlatinumPieces>("platinum piece", (1_000 over 1)) {
        override fun new(value: FixedBigRational) = Platinum(value)
        override fun format(value: FixedBigRational) = "$value pp"
    }
}

val FixedBigRational.platinum get() = PlatinumPieces.new(this)
val Long.platinum get() = (this over 1).platinum
val Int.platinum get() = (this over 1).platinum
