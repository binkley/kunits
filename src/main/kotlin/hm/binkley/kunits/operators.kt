package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times

/** Returns this measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>
    >
M.unaryPlus(): M = this

/** Returns the additive inverse of this measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.unaryMinus(): M = unit.new(-quantity)

/** Adds the two measures using _left_ measure for units. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.plus(other: Measure<S, K, *, *>): M =
    unit.new(quantity + (other into unit).quantity)

/** Subtracts the two measures using _left_ measure for units. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.minus(other: Measure<S, K, *, *>): M =
    unit.new(quantity - (other into unit).quantity)

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.times(factor: FixedBigRational): M = unit.new(quantity * factor)

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
FixedBigRational.times(factor: M): M =
    factor.unit.new(this * factor.quantity)

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.times(factor: Long): M = unit.new(quantity * factor)

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
Long.times(factor: M): M = factor.unit.new(this * factor.quantity)

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.times(factor: Int): M = unit.new(quantity * factor)

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
Int.times(factor: M): M = factor.unit.new(this * factor.quantity)

/** Takes the ratio of two measures in the same system of units. */
operator fun <
    S : System<S>,
    K : Kind,
    V : Units<S, K, V, N>,
    N : Measure<S, K, V, N>,
    >
Measure<S, K, *, *>.div(denominator: Measure<S, K, V, N>): FixedBigRational =
    (this into denominator.unit).quantity / denominator.quantity

/**
 * Expresses this measure into units of [denominator].
 *
 * @see [into]
 */
operator fun <
    S : System<S>,
    K : Kind,
    V : Units<S, K, V, N>,
    N : Measure<S, K, V, N>,
    >
Measure<S, K, *, *>.div(denominator: V): N = into(denominator)

/** Scales down the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.div(factor: FixedBigRational): M = unit.new(quantity / factor)

/** Scales down the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.div(factor: Long): M = unit.new(quantity / factor)

/** Scales down the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U, M>,
    M : Measure<S, K, U, M>,
    >
M.div(factor: Int): M = unit.new(quantity / factor)
