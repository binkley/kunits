package hm.binkley.kunits

import hm.binkley.math.divideAndRemainder
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE

/**
 * Reduces this measure to the lowest terms for [units].
 * Example: `64.inches.lowestTerms(Feet, Inches)` is the list of `5.feet`
 * and `4.inches`.
 *
 * @param S the system of units
 * @param bigToSmall are the units in descending order
 */
fun <S : System<S>>
Measure<S, *>.lowestTerms(vararg bigToSmall: Units<S, *>):
    List<Measure<S, *>> {
    val lowestTerms = ArrayList<Measure<S, *>>(bigToSmall.size)
    var current: Measure<S, *> = this
    for (unit in bigToSmall) {
        val currentInUnit = current.value * current.unit.basis / unit.basis
        val (wholeRatio, remainder) = currentInUnit.divideAndRemainder(ONE)
        lowestTerms += unit.new(wholeRatio)
        current = unit.new(remainder)
    }
    // Tack any left over into the last (smallest) unit
    lowestTerms[lowestTerms.lastIndex] = lowestTerms.last() + current
    return lowestTerms
}
