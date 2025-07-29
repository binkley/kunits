package hm.binkley.kunits.system.discworld.lancre

import hm.binkley.kunits.ANKH_MORPORK_PENCE_PER_LANCRE_PENNY
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.AnkhMorporkDenomination
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.AnkhMorporkDenominations
import hm.binkley.kunits.system.discworld.lancre.denomination.LancreDenomination

object Lancre : System<Lancre>("Lancre")

/** Converts money from Lancre into Ankh-Morpork units. */
infix fun <
    V : AnkhMorporkDenominations<V, N>,
    N : AnkhMorporkDenomination<V, N>,
    > LancreDenomination<*, *>.intoAnkhMorpork(
    other: V
) = into(other) {
    it / ANKH_MORPORK_PENCE_PER_LANCRE_PENNY
}
