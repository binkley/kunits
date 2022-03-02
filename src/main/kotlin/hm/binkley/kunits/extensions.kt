package hm.binkley.kunits

import hm.binkley.math.divideAndRemainder
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE

/**
 * Converts this measure into units of [other] within the same system of
 * units.
 * Convenience for `measure.into(other) { it }` (no basis conversion
 * for the same systems of units).
 *
 * @param S the system of units
 * @param V the units for [other]
 * @param other the target units
 *
 * @todo Nothing syntactically prevents converting feet into pounds
 */
infix fun <S : System<S>, V : Units<S, V>>
Measure<S, *>.into(other: V) = into(other) { it }

/**
 * Converts this measure into units of [other] for a (possibly) different
 * system of units.
 *
 * Use [conversion] when moving between systems of units.
 * It takes the [value] of this measurement expressed in base units for
 * [U], and returns a new measurement value in base units for [V].
 *
 * @param T the system of units for [other]
 * @param V the units for [other]
 * @param other the target units
 * @param conversion the conversion basis between [unit] and [other]
 */
fun <T : System<T>, V : Units<T, V>> Measure<*, *>.into(
    other: V,
    conversion: (FixedBigRational) -> FixedBigRational,
) = other.new(conversion(value * unit.basis) / other.basis)

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
