package hm.binkley.kunits

import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.FFFLengths
import hm.binkley.kunits.system.fff.length.Furlong
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs
import hm.binkley.kunits.system.fff.time.FFFTimes
import hm.binkley.kunits.system.fff.weight.FFFWeights
import hm.binkley.kunits.system.usd.denomination.USDDenominations
import hm.binkley.math.fixed.FixedBigRational
import java.util.Objects.hash

/**
 * Represents a system of units.
 *
 * See [FFF] for an example.
 *
 * @param S the system of units
 */
abstract class System<S : System<S>>(
    /** The name for this system of units. */
    val name: String,
) {
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
 * [Lengths], [Times], [Weights] or [Denominations].
 *
 * @param S the system of units
 * @param U the units of measure
 */
abstract class Units<S : System<S>, U : Units<S, U>>(
    /** The system of units for this unit. */
    val system: S,
    /** Must be unique for each unit within [system]. */
    val name: String,
    /** Amount of 1 unit expressed in base units. */
    internal val basis: FixedBigRational,
) : Comparable<Units<S, *>> {
    /**
     * Creates a new measure from the given [quantity].
     *
     * @param quantity the amount of this unit
     *
     * @todo Avoid casting: teach new to return specific M measure type
     */
    abstract fun new(quantity: FixedBigRational): Measure<S, U>

    /**
     * Presents the calling measure suitable for humans.
     *
     * @param quantity the amount of this unit
     */
    abstract fun format(quantity: FixedBigRational): String

    /** Orders units by their [basis]. */
    override fun compareTo(other: Units<S, *>) = basis.compareTo(other.basis)

    // Units are singleton objects, so no point to defining equals/hashCode

    /** Presents this unit as "[system] [name]". */
    override fun toString() = "$system $name"
}

/**
 * Represents units of length within a [System].
 *
 * See [FFFLengths] and [Furlongs] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * _measure_ of that unit.
 *
 * @param S the system of units
 * @param U the units of measure
 */
abstract class Lengths<S : System<S>, U : Lengths<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents units of time within a [System].
 *
 * See [FFFTimes] for an example.
 *
 * @param S the system of units
 * @param U the units of measure
 */
abstract class Times<S : System<S>, U : Times<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents units of weight within a [System].
 *
 * See [FFFWeights] for an example.
 *
 * @param S the system of units
 * @param U the units of measure
 */
abstract class Weights<S : System<S>, U : Weights<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents units of coinage or currency within a [System].
 *
 * See [USDDenominations] for an example.
 *
 * @param S the system of units
 * @param U the units of measure
 */
abstract class Denominations<S : System<S>, U : Denominations<S, U>>(
    system: S,
    name: String,
    basis: FixedBigRational,
) : Units<S, U>(system, name, basis)

/**
 * Represents a [quantity] of a [unit] within a [System].
 *
 * See [Furlong] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * quantity of that unit.
 *
 * @param S the system of units
 * @param U the units of measure
 */
abstract class Measure<S : System<S>, U : Units<S, U>>(
    /** Unit of measure. */
    val unit: U,
    /** Number of [unit]s. */
    val quantity: FixedBigRational,
) : Comparable<Measure<S, *>> {
    /** Compares to [other] in the [U] units of measure. */
    override fun compareTo(other: Measure<S, *>) =
        quantity.compareTo((other into unit).quantity)

    /** Presents this measure as [Units.format] of [quantity]. */
    override fun toString() = unit.format(quantity)

    /**
     * To use `==`, convert the sides of the comparison to a common unit of
     * measure.
     * Example: `1.foo == (1.bar in Foo)`.
     *
     * *NB* &mdash; in Kotlin you cannot say `1.foo == 1.bar` as the left and
     * right sides are different types, and will not compile.
     * (You can, however, say `!(1.foo < 1.bar) && !(1.foo > 1.bar)` which
     * is mathematically equivalent though in convenient.)
     */
    override fun equals(other: Any?) = this === other ||
        other is Measure<*, *> &&
        unit == other.unit &&
        quantity == other.quantity

    override fun hashCode() = hash(unit, quantity)
}
