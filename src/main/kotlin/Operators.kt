package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times

/** Syntactic sugar for returning the measure unchanged. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.unaryPlus(): M =
    this

/**
 * Syntactic sugar to turn a positive measure into a negative measure of the
 * same kind (and vice versa).
 */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.unaryMinus(): M =
    unit.new(-quantity)

/**
 * Syntactic sugar to add the _right_ measure to the _left_, and convert the
 * right side if needed, preserving the unit of the left side.
 */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.plus(
    other: Measure<K, S, *, *>
): M = unit.new(quantity + (other into unit).quantity)

/**
 * Syntactic sugar to subtract the _right_ measure from the _left_, and convert
 * the right side if needed, preserving the unit of the left side.
 */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.minus(
    other: Measure<K, S, *, *>
): M = unit.new(quantity - (other into unit).quantity)

/** Scales the measure by multiplication. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.times(
    factor: FixedBigRational
): M = unit.new(quantity * factor)

/** Scales the measure by multiplication. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > FixedBigRational.times(
    factor: M
): M = factor.unit.new(this * factor.quantity)

/** Scales the measure by multiplication. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.times(
    factor: Long
): M = unit.new(quantity * factor)

/** Scales the measure by multiplication. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > Long.times(
    factor: M
): M = factor.unit.new(this * factor.quantity)

/** Scales the measure by multiplication. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.times(
    factor: Int
): M = unit.new(quantity * factor)

/** Scales the measure by multiplication. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > Int.times(
    factor: M
): M = factor.unit.new(this * factor.quantity)

/** Takes the ratio of two measures from the same system of units. */
operator fun <
    K : Kind,
    S : System<S>,
    V : Units<K, S, V, N>,
    N : Measure<K, S, V, N>
    > Measure<K, S, *, *>.div(
    denominator: Measure<K, S, V, N>
): FixedBigRational =
    (this into denominator.unit).quantity / denominator.quantity

/**
 * Syntactic sugar for `this into denominator`
 * Expresses this measure in the units of [denominator].
 *
 * @see [into]
 */
operator fun <
    K : Kind,
    S : System<S>,
    V : Units<K, S, V, N>,
    N : Measure<K, S, V, N>
    > Measure<K, S, *, *>.div(
    denominator: V
): N = into(denominator)

/** Scales the measure by division. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.div(
    factor: FixedBigRational
): M = unit.new(quantity / factor)

/** Scales the measure by division. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.div(
    factor: Long
): M = unit.new(quantity / factor)

/** Scales the measure by division. */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.div(
    factor: Int
): M = unit.new(quantity / factor)

/**
 * Syntactic sugar for `this into units`.
 * Divides up the measure by [units].
 *
 * @see into
 */
operator fun <
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    > M.rem(
    units: List<Units<K, S, *, *>>
): List<Measure<K, S, *, *>> = this into units
