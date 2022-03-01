package hm.binkley.kunits

import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.FffLengths
import hm.binkley.kunits.system.fff.length.Furlong
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.kunits.system.fff.time.FffTimes
import hm.binkley.kunits.system.fff.weight.FffWeights
import hm.binkley.math.div
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.times
import java.util.Objects.hash

/**
 * Represents a system of units.
 *
 * See [FFF] for an example.
 */
abstract class System<S : System<S>> {
    /** Should be unique globally: automatically the simple class name. */
    val name: String = this::class.simpleName!!

    // Systems are singleton objects, so no point to defining equals/hashCode

    override fun toString() = name
}

/**
 * Represents units within a [System].
 *
 * Do not use directly; rather, extend one of the groups of units such as
 * [Lengths], [Times], or [Weights].
 */
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

/**
 * Represents units of length within a [System].
 *
 * See [FffLengths] and [Furlongs] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * _measurement_ of that unit.
 */
abstract class Lengths<S : System<S>, U : Lengths<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational,
) : Units<S, U>(system, name, base)

/**
 * Represents units of time within a [System].
 *
 * See [FffTimes] for an example.
 */
abstract class Times<S : System<S>, U : Times<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational,
) : Units<S, U>(system, name, base)

/**
 * Represents units of weight within a [System].
 *
 * See [FffWeights] for an example.
 */
abstract class Weights<S : System<S>, U : Weights<S, U>>(
    system: S,
    name: String,
    base: FixedBigRational,
) : Units<S, U>(system, name, base)

/**
 * Represents measurements of a unit within a [System].
 *
 * See [Furlong] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * _measurement_ of that unit.
 */
abstract class Measure<S : System<S>, U : Units<S, U>>(
    val unit: U,
    val value: FixedBigRational,
) {
    /** Converts this measure into [other]'s units in the same [System]. */
    fun <V : Units<S, V>> convertTo(other: V) =
        other.new(value * unit.base / other.base)

    override fun equals(other: Any?) = this === other ||
        other is Measure<*, *> &&
        unit == other.unit &&
        value == other.value

    override fun hashCode() = hash(unit, value)
    override fun toString() = unit.format(value)
}
