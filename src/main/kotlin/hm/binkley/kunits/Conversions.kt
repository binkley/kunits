package hm.binkley.kunits

import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.truncateAndRemainder

/**
 * Converts this measure into units of [other] within the same system of
 * units.
 * Convenience for `measure.into(other) { it }` (no basis conversion
 * for the same systems of units).
 *
 * @param K the kind of units
 * @param S the source system of units
 * @param V the units of [N]
 * @param N the measurement type of [V]
 * @param other the target units
 */
infix fun <
    K : Kind,
    S : System<S>,
    V : Units<K, S, V, N>,
    N : Measure<K, S, V, N>,
    > Measure<K, S, *, *>.into(
    other: Units<K, S, V, N>
): N = into(other) { it }

/**
 * Converts this measure into units of [other] for a (possibly) different
 * system of units.
 *
 * Use [convert] when moving between systems of units.
 * It takes the value of this measure expressed in base units, and returns
 * a new measure value in base units for [other].
 *
 * @param K the kind of units
 * @param S the source system of units
 * @param T the target system of units
 * @param V the units of [N]
 * @param N the measurement type of [V]
 * @param other the target units
 * @param convert converts bases of the two units
 */
fun <
    K : Kind,
    S : System<S>,
    T : System<T>,
    V : Units<K, T, V, N>,
    N : Measure<K, T, V, N>,
    > Measure<K, S, *, *>.into(
    other: Units<K, T, V, N>,
    convert: (FixedBigRational) -> FixedBigRational,
): N = other.new(convertBases(other, convert))

/**
 * Converts this measure into lowest terms for [restOfUnits] from the most
 * significant unit to the least significant, returning the _same order_ as
 * [firstUnit] and [restOfUnits].
 * This is a _greedy_ algorithm, so is not always optimal but performs well
 * especially for smaller numbers, and follows the order of units provided.
 * For example, using units of 5, 10, 20, and 25, converting from 40 produces
 * one each of 25, 10, and 5, but an optimal minimization might be 20 twice.
 * See a _dynamic programming_ (DP) approach contrasted in
 * https://en.wikipedia.org/wiki/Change-making_problem.
 * Note that the DP optimal approach is not sensible with fractional units
 * (such as 1.25) and relies on the amounts for integer indexing.
 *
 * Examples
 * - `64.inches.into(Feet, Inches)` returns `5.feet` and `4.inches`.
 * - `64.inches.into(Inches, Feet)` returns `4.inches` and `5.feet`
 *
 * @param K the kind of units
 * @param S the system of units
 * @param firstUnit the first measure to reduce to
 * @param restOfUnits the rest of the units to reduce to
 *
 * @return the reduced measures in the same order as [firstUnit] then
 * [restOfUnits]
 */
fun <K : Kind, S : System<S>> Measure<K, S, *, *>.into(
    firstUnit: Units<K, S, *, *>,
    vararg restOfUnits: Units<K, S, *, *>,
): List<Measure<K, S, *, *>> = with(restOfUnits.toMutableList()) {
    add(0, firstUnit)
    into(this)
}

/**
 * Converts this measure into lowest terms for [units], from most significant
 * unit to least significant, returning the same order as [units].
 * This is a _greedy_ algorithm, so is not always optimal but performs well
 * especially for smaller numbers, and follows the order of units provided.
 * For example, using units of 5, 10, 20, and 25, converting from 40 produces
 * one each of 25, 10, and 5, but an optimal minimization might be 20 twice.
 * See a _dynamic programming_ (DP) approach contrasted in
 * https://en.wikipedia.org/wiki/Change-making_problem.
 * Note that the DP optimal approach is not sensible with fractional units
 * (such as 1.25) and relies on the amounts for integer indexing.
 *
 * Examples
 * - `64.inches.into(Feet, Inches)` returns `5.feet` and `4.inches`.
 * - `64.inches into listOf(Inches, Feet)` returns `4.inches` and `5.feet`
 *
 * This function raises an exception if there are no units.
 *
 * @param K the kind of units
 * @param S the system of units
 * @param units reduce this measure to these units
 *
 * @return the reduced measures in the same order as [units]
 */
infix fun <K : Kind, S : System<S>> Measure<K, S, *, *>.into(
    units: List<Units<K, S, *, *>>,
): List<Measure<K, S, *, *>> {
    require(units.isNotEmpty()) { "No units" }

    // Pre-populate with nulls so that we may write in any order
    val into = MutableList<Measure<*, *, *, *>?>(units.size) { null }

    val descendingIndexed = units.sortedDescendingIndexed()
    var current: Measure<*, *, *, *> = this
    descendingIndexed.forEach { (inputIndex, unit) ->
        val converted = current.convertBases(unit) { it }
        val (whole, remainder) = converted.truncateAndRemainder()
        into[inputIndex] = unit.new(whole)
        current = unit.new(remainder)
    }

    // Tack any left over into the least significant unit
    val leastIndex = descendingIndexed.last().first
    val least = into[leastIndex]!!
    // TODO: Reuse `+` operator
    into[leastIndex] = least.unit.new(least.quantity + current.quantity)

    @Suppress("UNCHECKED_CAST")
    return into.toNonNullableList() as List<Measure<K, S, *, *>>
}

private fun Measure<*, *, *, *>.convertBases(
    other: Units<*, *, *, *>,
    convert: (FixedBigRational) -> FixedBigRational,
) = convert(unit.basis * quantity) / other.basis

/**
 * Sorts the array element-wise descending, each entry with an attached index
 * of the ordering in the original list.
 */
private fun <T : Comparable<T>> List<T>.sortedDescendingIndexed() =
    mapIndexed { index, it -> index to it }.sortedByDescending { it.second }

private fun <T> Collection<T?>.toNonNullableList() = map { it!! }
