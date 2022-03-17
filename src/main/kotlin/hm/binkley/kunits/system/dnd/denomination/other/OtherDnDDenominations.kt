package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.system.dnd.denomination.DnDDenomination
import hm.binkley.kunits.system.dnd.denomination.DnDDenominations
import hm.binkley.kunits.system.dnd.denomination.other.Mithral.MithralPieces
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.over

/** Example of adding to existing units of measure. */
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
