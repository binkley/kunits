package hm.binkley.kunits

import hm.binkley.math.div
import hm.binkley.math.finite.FixedBigRational
import hm.binkley.math.minus
import hm.binkley.math.plus
import hm.binkley.math.times
import hm.binkley.math.unaryMinus
import lombok.Generated
import java.util.Objects.hash

private val systemNames = mutableSetOf<String>()

@Generated // Lie to JaCoCo
abstract class System<S : System<S>>(
    /** Must be unique for each system. */
    val name: String
) {
    init {
        println("*** I AM A ${this.javaClass} with name, $name")
        @Suppress("LeakingThis")
        if (!systemNames.add(name)) error(
            "Whoops!  Two different systems of units with the  same name?  $name"
        )
    }

    override fun equals(other: Any?) = this === other ||
        other is System<*> &&
        name == other.name

    override fun hashCode() = hash(name)
    override fun toString() = name
}

@Generated // Lie to JaCoCo
abstract class Units<S : System<S>, U : Units<S, U>>(
    /** Must be unique for each system. */
    val system: S,
    /** Must be unique for each unit within [system]. */
    val name: String,
    /** Used for conversions, not for equality, etc. */
    internal val base: FixedBigRational
) {
    /** Creates a new unit from the given [value]. */
    abstract fun new(value: FixedBigRational): Measure<S, U>

    /** Presents the calling measure suitable for humans. */
    abstract fun format(value: FixedBigRational): String

    override fun equals(other: Any?) = this === other ||
        other is Units<*, *> &&
        system == other.system &&
        name == other.name

    override fun hashCode() = hash(system, name)
    override fun toString() = "$system $name" // TODO: Ugh -- I18N, etc.
}

@Generated // Lie to JaCoCo
abstract class Lengths<S : System<S>, U : Lengths<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational
) : Units<S, U>(system, name, base)

@Generated // Lie to JaCoCo
abstract class Masses<S : System<S>, U : Masses<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational
) : Units<S, U>(system, name, base)

@Generated // Lie to JaCoCo
abstract class Times<S : System<S>, U : Times<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational
) : Units<S, U>(system, name, base)

@Generated // Lie to JaCoCo
abstract class Measure<S : System<S>, U : Units<S, U>>(
    val unit: U,
    val value: FixedBigRational
) {
    /** Converts this measure into [other]'s units. */
    fun <V : Units<S, V>> to(other: V) =
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
    other: Measure<S, V>
): Measure<S, U> = unit.new(value + other.to(unit).value)

/** Subtracts the measures, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>, V : Units<S, V>> Measure<S, U>.minus(
    other: Measure<S, V>
): Measure<S, U> = unit.new(value - other.to(unit).value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.times(
    multiplicand: Int
) =
    unit.new(value * multiplicand)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.times(
    multiplicand: Long
) =
    unit.new(value * multiplicand)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.times(
    multiplicand: FixedBigRational
) =
    unit.new(value * multiplicand)

/** Scales up the measure, with the _right_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Int.times(
    multiplicand: Measure<S, U>
) =
    multiplicand.unit.new(this * multiplicand.value)

/** Scales up the measure, with the _right_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Long.times(
    multiplicand: Measure<S, U>
) =
    multiplicand.unit.new(this * multiplicand.value)

/** Scales up the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> FixedBigRational.times(
    multiplicand: Measure<S, U>
) = multiplicand.unit.new(this * multiplicand.value)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.div(
    divisor: Int
) =
    unit.new(value / divisor)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.div(
    divisor: Long
) =
    unit.new(value / divisor)

/** Scales down the measure, with the _left_ returned as units. */
operator fun <S : System<S>, U : Units<S, U>> Measure<S, U>.div(
    divisor: FixedBigRational
) =
    unit.new(value / divisor)
