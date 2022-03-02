package hm.binkley.kunits

import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.FFFLength
import hm.binkley.kunits.system.fff.length.Furlong
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.kunits.system.fff.time.FFFTime
import hm.binkley.kunits.system.fff.weight.FFFWeight
import hm.binkley.math.fixed.FixedBigRational
import java.util.Objects.hash

/**
 * Represents a system of units.
 *
 * See [FFF] for an example.
 *
 * @param S the system of units
 */
abstract class System<S : System<S>> {
    /** The name for this system of units: the simple class name. */
    val name: String = this::class.simpleName!!

    // Systems are singleton objects, so no point to defining equals/hashCode

    /** Presents this system as [name]. */
    override fun toString() = name
}

/**
 * Represents units within a [System].
 *
 * For each kind of system of units (length, weight, time), there is one unit
 * called the "base" with a [basis] of 1.
 * Conversion between units uses the basis in calculations.
 * Example: the meter is the base unit of length in a Metric system of units,
 * and kilometers have a basis of 1,000.
 *
 * Do not use directly; rather, extend one of the groups of units such as
 * [Length], [Time], or [Weight].
 *
 * @param S the system of units
 * @param U the units of measurement
 */
abstract class Units<S : System<S>, U : Units<S, U>>(
    /** The system of units for this unit. */
    val system: S,
    /** Must be unique for each unit within [system]. */
    val name: String,
    /** Amount of 1 unit expressed in base units. */
    internal val basis: FixedBigRational,
) {
    /**
     * Creates a new measure from the given [value].
     *
     * @param value the amount of this unit
     */
    abstract fun new(value: FixedBigRational): Measure<S, U>

    /**
     * Presents the calling measure suitable for humans.
     *
     * @param value the amount of this unit
     */
    abstract fun format(value: FixedBigRational): String

    // Units are singleton objects, so no point to defining equals/hashCode

    /** Presents this unit as "[system] [name]". */
    override fun toString() = "$system $name"
}

/**
 * Represents units of length within a [System].
 *
 * See [FFFLength] and [Furlongs] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * _measurement_ of that unit.
 *
 * @param S the system of units
 * @param U the units of measurement
 */
abstract class Length<S : System<S>, U : Length<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents units of time within a [System].
 *
 * See [FFFTime] for an example.
 *
 * @param S the system of units
 * @param U the units of measurement
 */
abstract class Time<S : System<S>, U : Time<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents units of weight within a [System].
 *
 * See [FFFWeight] for an example.
 *
 * @param S the system of units
 * @param U the units of measurement
 */
abstract class Weight<S : System<S>, U : Weight<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents measurements of a unit within a [System].
 *
 * See [Furlong] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * _measurement_ of that unit.
 *
 * @param S the system of units
 * @param U the units of measurement
 */
abstract class Measure<S : System<S>, U : Units<S, U>>(
    /** Unit for [value]. */
    val unit: U,
    /** Amount of [unit]. */
    val value: FixedBigRational,
) {
    /**
     * Converts this measure into units of [other] within this system of
     * units.
     *
     * @param V the units for [other]
     * @param other the target units
     *
     * @todo Nothing syntactically prevents converting feet into pounds
     */
    infix fun <V : Units<S, V>> into(other: V) = into(other) { it }

    /**
     * Converts this measure into units of [other] in a different [System].
     *
     * Use [conversion] when moving between systems of units.
     * It takes the [value] of this measurement expressed in base units for
     * [U], and returns a new measurement value in base units for [V].
     *
     * @param T the system of units for [other]
     * @param V the units for [other]
     * @param other the target units
     * @param conversion the conversion basis between [unit] and [other]
     */
    fun <T : System<T>, V : Units<T, V>> into(
        other: V,
        conversion: (FixedBigRational) -> FixedBigRational,
    ) = other.new(conversion(value * unit.basis) / other.basis)

    /** Presents this measure as [Units.format] of [value]. */
    override fun toString() = unit.format(value)

    override fun equals(other: Any?) = this === other ||
        other is Measure<*, *> &&
        unit == other.unit &&
        value == other.value

    override fun hashCode() = hash(unit, value)
}
