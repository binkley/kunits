package hm.binkley.kunit

import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.div
import hm.binkley.math.finite.minus
import hm.binkley.math.finite.plus
import hm.binkley.math.finite.times
import hm.binkley.math.finite.unaryMinus
import lombok.Generated
import java.util.Objects.hash

@Generated // Lie to JaCoCo
abstract class Units<U : Units<U>>(
    /** Must be unique for each unit. */
    val name: String,
    /** Used for conversations, not for equality, etc. */
    internal val base: FiniteBigRational
) {
    /** Creates a new unit from the given [value]. */
    abstract fun new(value: FiniteBigRational): Measure<U>

    /** Presents the calling measure suitable for humans. */
    abstract fun format(value: FiniteBigRational): String

    override fun equals(other: Any?) = this === other ||
            other is Units<*> &&
            name == other.name

    override fun hashCode() = hash(name)
    override fun toString() = name
}

@Generated // Lie to JaCoCo
abstract class Lengths<U : Lengths<U>>(
    name: String,
    base: FiniteBigRational
) : Units<U>(name, base)

@Generated // Lie to JaCoCo
abstract class Masses<U : Masses<U>>(
    name: String,
    base: FiniteBigRational
) : Units<U>(name, base)

@Generated // Lie to JaCoCo
abstract class Times<U : Times<U>>(
    name: String,
    base: FiniteBigRational
) : Units<U>(name, base)

@Generated // Lie to JaCoCo
abstract class Measure<U : Units<U>>(
    val unit: U,
    val value: FiniteBigRational
) {
    /** Converts this measure into [other] units. */
    fun <V : Units<V>> to(other: V) =
        other.new(value * unit.base / other.base)

    override fun equals(other: Any?) = this === other ||
            other is Measure<*> &&
            unit == other.unit &&
            value == other.value

    override fun hashCode() = hash(unit, value)
    override fun toString() = unit.format(value)
}

/** Returns this measure. */
operator fun <U : Units<U>> Measure<U>.unaryPlus() = this

/** Returns the additive inverse of this measure. */
operator fun <U : Units<U>> Measure<U>.unaryMinus() = unit.new(-value)

/** Adds the measures, with the _left_ returned as units. */
operator fun <U : Units<U>, V : Units<V>> Measure<U>.plus(
    other: Measure<V>
) = unit.new(value + other.to(unit).value)

/** Subtracts the measures, with the _left_ returned as units. */
operator fun <U : Units<U>, V : Units<V>> Measure<U>.minus(
    other: Measure<V>
) = unit.new(value - other.to(unit).value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.times(multiplicand: Int) =
    unit.new(value * multiplicand)

/** Scales up the measure, with the _right_ returned as units. */
operator fun <U : Units<U>> Int.times(multiplicand: Measure<U>) =
    multiplicand.unit.new(this * multiplicand.value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.times(multiplicand: FiniteBigRational) =
    unit.new(value * multiplicand)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> FiniteBigRational.times(multiplicand: Measure<U>) =
    multiplicand.unit.new(this * multiplicand.value)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.div(divisor: Int) =
    unit.new(value / divisor)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.div(divisor: FiniteBigRational) =
    unit.new(value / divisor)
