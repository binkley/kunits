package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times

/** Returns this measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.unaryPlus() = this

/** Returns the additive inverse of this measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.unaryMinus() = unit.new(-value)

/** Adds the two measures using _left_ measure for units. */
operator fun <S : System<S>, U : Units<S, U>, V : Units<S, V>>
Measure<S, U>.plus(other: Measure<S, V>) =
    unit.new(value + other.into(unit).value)

/** Subtracts the two measures using _left_ measure for units. */
operator fun <S : System<S>, U : Units<S, U>, V : Units<S, V>>
Measure<S, U>.minus(other: Measure<S, V>) =
    unit.new(value - other.into(unit).value)

/** Scales up the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.times(factor: FixedBigRational) = unit.new(value * factor)

/** Scales up the measure. */
operator fun <S : System<S>, U : Units<S, U>>
FixedBigRational.times(factor: Measure<S, U>) =
    factor.unit.new(this * factor.value)

/** Scales up the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.times(factor: Long) = unit.new(value * factor)

/** Scales up the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Long.times(factor: Measure<S, U>) = factor.unit.new(this * factor.value)

/** Scales up the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.times(factor: Int) = unit.new(value * factor)

/** Scales up the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Int.times(factor: Measure<S, U>) = factor.unit.new(this * factor.value)

/** Scales down the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.div(factor: FixedBigRational) = unit.new(value / factor)

/** Scales down the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.div(factor: Long) = unit.new(value / factor)

/** Scales down the measure. */
operator fun <S : System<S>, U : Units<S, U>>
Measure<S, U>.div(factor: Int) = unit.new(value / factor)
