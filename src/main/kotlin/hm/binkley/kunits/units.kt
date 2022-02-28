package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times
import java.util.Objects.hash

abstract class System<S : System<S>> {
    /** Should be unique globally: automatically the simple class name. */
    val name: String = this::class.simpleName!!

    // Systems are singleton objects, so no point to defining equals/hashCode

    override fun toString() = name
}

abstract class Units<S : System<S>, U : Units<S, U>>(
    /** Must be unique for each system. */
    val system: S,
    /** Must be unique for each unit within [system]. */
    val name: String,
    /** Used for conversions, not for equality, etc. */
    internal val base: FixedBigRational,
) {
    /** Creates a new unit from the given [value]. */
    abstract fun new(value: FixedBigRational): Measure<S, U>

    /** Presents the calling measure suitable for humans. */
    abstract fun format(value: FixedBigRational): String

    // Units are singleton objects, so no point to defining equals/hashCode

    override fun toString() = "$system $name" // TODO: Ugh -- I18N, etc.
}

abstract class Lengths<S : System<S>, U : Lengths<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational,
) : Units<S, U>(system, name, base)

abstract class Masses<S : System<S>, U : Masses<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational,
) : Units<S, U>(system, name, base)

abstract class Times<S : System<S>, U : Times<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational,
) : Units<S, U>(system, name, base)

abstract class Measure<S : System<S>, U : Units<S, U>>(
    val unit: U,
    val value: FixedBigRational,
) {
    /** Converts this measure into [other]'s units. */
    fun <V : Units<S, V>> convertTo(other: V) =
        other.new(value * unit.base / other.base)

    override fun equals(other: Any?) = this === other ||
        other is Measure<*, *> &&
        unit == other.unit &&
        value == other.value

    override fun hashCode() = hash(unit, value)
    override fun toString() = unit.format(value)
}

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
