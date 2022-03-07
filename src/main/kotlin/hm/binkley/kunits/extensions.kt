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
 */
infix fun <S : System<S>, V : Units<S, V>>
Measure<S, *>.into(other: V) = into(other) { it }

/**
 * Converts this measure into units of [other] for a (possibly) different
 * system of units.
 *
 * Use [conversion] when moving between systems of units.
 * It takes the value of this measurement expressed in base units, and
 * returns a new measurement value in base units for [V].
 *
 * @param T the system of units for [other]
 * @param V the units for [other]
 * @param other the target units
 * @param conversion convert bases of the two units
 */
fun <T : System<T>, V : Units<T, V>> Measure<*, *>.into(
    other: V,
    conversion: (FixedBigRational) -> FixedBigRational,
) = other.new(convertByBases(other, conversion))

/**
 * Converts this measure into lowest terms for [units], from most significant
 * unit to least significant, returning the same order as [units].
 * Example: `64.inches.into(Feet, Inches)` is the list of `5.feet` and
 * `4.inches`.
 * Note: `64.inches.into(Inches, Feet)` is the list of `4.inches` and
 * `5.feet following the order of units provided.
 *
 * @param S the system of units
 * @param units reduce this measure to these units
 *
 * @return the reduced measures in the same order as [units]
 */
fun <S : System<S>>
Measure<S, *>.into(vararg units: Units<S, *>): List<Measure<S, *>> {
    // Pre-populate with nulls so that we may write in any order
    val into = MutableList<Measure<S, *>?>(units.size) { null }

    val descendingIndexed = units.sortedDescendingIndexed()
    var current = this
    descendingIndexed.forEach { (inputIndex, unit) ->
        val valueToReduce = current.convertByBases(unit) { it }
        val (reduced, remainder) = valueToReduce.divideAndRemainder(ONE)
        into[inputIndex] = unit.new(reduced)
        current = unit.new(remainder)
    }

    // Tack any left over into the least significant unit
    val leastIndex = descendingIndexed.last().first
    into[leastIndex] = into[leastIndex]!! + current

    return into.toNonNullableList()
}

private fun Measure<*, *>.convertByBases(
    other: Units<*, *>,
    conversion: (FixedBigRational) -> FixedBigRational,
) = conversion(quantity * unit.basis) / other.basis

/**
 * Sorts the array element-wise descending, each entry with an attached
 * index of the ordering in the original array.
 */
private fun <T : Comparable<T>> Array<T>.sortedDescendingIndexed() =
    mapIndexed { index, it -> index to it }.sortedByDescending { it.second }

private fun <T> Collection<T?>.toNonNullableList() = map { it!! }
