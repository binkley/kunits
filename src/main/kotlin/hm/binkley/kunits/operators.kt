@file:Suppress("UNCHECKED_CAST")

package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times

/** Returns this measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.unaryPlus(): M = this

/** Returns the additive inverse of this measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.unaryMinus(): M = unit.new(-quantity) as M

/** Adds the two measures using _left_ measure for units. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.plus(other: Measure<S, K, *>): M =
    unit.new(quantity + (other into unit).quantity) as M

/** Subtracts the two measures using _left_ measure for units. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.minus(other: Measure<S, K, *>): M =
    unit.new(quantity - (other into unit).quantity) as M

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.times(factor: FixedBigRational): M = unit.new(quantity * factor) as M

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
FixedBigRational.times(factor: M): M =
    factor.unit.new(this * factor.quantity) as M

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.times(factor: Long): M = unit.new(quantity * factor) as M

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
Long.times(factor: M): M = factor.unit.new(this * factor.quantity) as M

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.times(factor: Int): M = unit.new(quantity * factor) as M

/** Scales up the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
Int.times(factor: M): M = factor.unit.new(this * factor.quantity) as M

/** Takes the ratio of two measures in the same system of units. */
operator fun <S : System<S>, K : Kind, V : Units<S, K, V>>
Measure<S, K, *>.div(denominator: Measure<S, K, V>): FixedBigRational =
    (this into denominator.unit).quantity / denominator.quantity

/** Scales down the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.div(factor: FixedBigRational): M = unit.new(quantity / factor) as M

/** Scales down the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.div(factor: Long): M = unit.new(quantity / factor) as M

/** Scales down the measure. */
operator fun <
    S : System<S>,
    K : Kind,
    U : Units<S, K, U>,
    M : Measure<S, K, U>
    >
M.div(factor: Int): M = unit.new(quantity / factor) as M
