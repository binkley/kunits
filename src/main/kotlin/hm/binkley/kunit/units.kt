package hm.binkley.kunit

import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.div
import hm.binkley.math.finite.minus
import hm.binkley.math.finite.plus
import hm.binkley.math.finite.times
import hm.binkley.math.finite.unaryMinus
import java.util.Objects.hash

abstract class Units<U : Units<U>>(
    val name: String
) {
    /** Creates a new unit from the given _value_. */
    abstract fun new(value: FiniteBigRational): Measure<U>

    /** Presents the measure suitable for human output. */
    abstract fun format(value: FiniteBigRational): String

    override fun equals(other: Any?) = this === other ||
            other is Units<*> &&
            name == other.name

    override fun hashCode() = hash(name)
    override fun toString() = name
}

abstract class Measure<U : Units<U>>(
    val unit: U,
    val value: FiniteBigRational
) {
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

/** Adds the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.plus(other: Measure<U>) =
    unit.new(value + other.value)

/** Adds the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.plus(addend: Int) =
    unit.new(value + addend)

/** Subtracts the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.minus(other: Measure<U>) =
    unit.new(value - other.value)

/** Subtracts the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.minus(subtrahend: Int) =
    unit.new(value - subtrahend)

/** Multiplies the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.times(multiplicand: Int) =
    unit.new(value * multiplicand)

/** Divides the measure, with the _left_ returned as units. */
operator fun <U : Units<U>> Measure<U>.div(divisor: Int) =
    unit.new(value / divisor)
