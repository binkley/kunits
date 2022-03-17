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
 * @param S the source system of units
 * @param K the kind of units
 * @param other the target units
 */
infix fun <
    S : System<S>,
    K : Kind,
    V : Units<S, K, V, N>,
    N : Measure<S, K, V, N>,
    >
Measure<S, K, *, *>.into(other: Units<S, K, V, N>): N = into(other) { it }

/**
 * Converts this measure into units of [other] for a (possibly) different
 * system of units.
 *
 * Use [conversion] when moving between systems of units.
 * It takes the value of this measure expressed in base units, and returns
 * a new measure value in base units for [other].
 *
 * @param S the source system of units
 * @param K the kind of units
 * @param T the target system of units
 * @param other the target units
 * @param conversion convert bases of the two units
 */
fun <
    S : System<S>,
    K : Kind,
    T : System<T>,
    V : Units<T, K, V, N>,
    N : Measure<T, K, V, N>,
    >
Measure<S, K, *, *>.into(
    other: Units<T, K, V, N>,
    conversion: (FixedBigRational) -> FixedBigRational,
): N = other.new(convertByBases(other, conversion))

/**
 * Converts this measure into lowest terms for [units], from most significant
 * unit to least significant, returning the same order as [units].
 * Example: `64.inches.into(Feet, Inches)` is the list of `5.feet` and
 * `4.inches`.
 * Note: `64.inches.into(Inches, Feet)` is the list of `4.inches` and
 * `5.feet following the order of units provided.
 *
 * @param S the system of units
 * @param K the kind of units
 * @param units reduce this measure to these units
 *
 * @return the reduced measures in the same order as [units]
 *
 * @todo Tighten generics bounds within the function body
 */
fun <S : System<S>, K : Kind>
Measure<S, K, *, *>.into(
    vararg units: Units<S, K, *, *>
): List<Measure<S, K, *, *>> {
    // Pre-populate with nulls so that we may write in any order
    val into = MutableList<Measure<*, *, *, *>?>(units.size) { null }

    val descendingIndexed = units.sortedDescendingIndexed()
    var current: Measure<*, *, *, *> = this
    descendingIndexed.forEach { (inputIndex, unit) ->
        val valueToReduce = current.convertByBases(unit) { it }
        val (whole, remainder) = valueToReduce.wholeNumberAndRemainder()
        into[inputIndex] = unit.new(whole)
        current = unit.new(remainder)
    }

    // Tack any left over into the least significant unit
    val leastIndex = descendingIndexed.last().first
    val least = into[leastIndex]!!
    // TODO: Reuse `+` operator
    into[leastIndex] = least.unit.new(least.quantity + current.quantity)

    @Suppress("UNCHECKED_CAST")
    return into.toNonNullableList() as List<Measure<S, K, *, *>>
}

private fun Measure<*, *, *, *>.convertByBases(
    other: Units<*, *, *, *>,
    conversion: (FixedBigRational) -> FixedBigRational,
) = conversion(quantity * unit.basis) / other.basis

/**
 * Sorts the array element-wise descending, each entry with an attached
 * index of the ordering in the original array.
 */
private fun <T : Comparable<T>> Array<T>.sortedDescendingIndexed() =
    mapIndexed { index, it -> index to it }.sortedByDescending { it.second }

private fun <T> Collection<T?>.toNonNullableList() = map { it!! }

private fun FixedBigRational.wholeNumberAndRemainder():
    Pair<FixedBigRational, FixedBigRational> =
    divideAndRemainder(ONE)
