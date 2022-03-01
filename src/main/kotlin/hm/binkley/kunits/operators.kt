package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times

/** Returns this measure. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.unaryPlus() = this

/** Returns the additive inverse of this measure. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.unaryMinus() =
    unit.new(-value)

/** Adds the measures, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>, V : Units<S, V>> Measure<S, U>.plus(
    other: Measure<S, V>,
): Measure<S, U> = unit.new(value + other.convertTo(unit).value)

/** Subtracts the measures, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>, V : Units<S, V>> Measure<S, U>.minus(
    other: Measure<S, V>,
): Measure<S, U> = unit.new(value - other.convertTo(unit).value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.times(
    multiplicand: FixedBigRational,
) = unit.new(value * multiplicand)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> FixedBigRational.times(
    multiplicand: Measure<S, U>,
) = multiplicand.unit.new(this * multiplicand.value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.times(
    multiplicand: Long,
) = unit.new(value * multiplicand)

/** Scales up the measure, with the _right_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Long.times(
    multiplicand: Measure<S, U>,
) = multiplicand.unit.new(this * multiplicand.value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.times(
    multiplicand: Int,
) = unit.new(value * multiplicand)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.div(
    divisor: FixedBigRational,
) = unit.new(value / divisor)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.div(
    divisor: Long,
) = unit.new(value / divisor)

/** Scales up the measure, with the _right_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Int.times(
    multiplicand: Measure<S, U>,
) = multiplicand.unit.new(this * multiplicand.value)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.div(
    divisor: Int,
) = unit.new(value / divisor)
