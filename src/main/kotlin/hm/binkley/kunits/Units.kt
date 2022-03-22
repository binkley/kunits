package hm.binkley.kunits

import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.Furlong
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs
import hm.binkley.math.fixed.FixedBigRational
import java.util.Objects.hash

/** Represents kinds of [Units]. */
abstract class Kind(
    val name: String
) {
    override fun toString() = name
}

/** Type token for units of length. */
object Length : Kind("length")

/** Type token for units of time. */
object Time : Kind("time")

/** Type token for units of weight. */
object Weight : Kind("weight")

/** Type token for units of denomination. */
object Denomination : Kind("denomination")

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
 * For each kind of system of units, there is a base unit with a [basis] of 1.
 * Conversion between units uses the basis in calculations.
 * Example: the meter is the base unit of length in a Metric system of units,
 * and kilometers have a basis of 1,000.
 *
 * @param K the kind of units
 * @param S the system of units
 * @param U the units of [M]
 * @param M the measurement type of [U]
 */
abstract class Units<
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>
    >(
    /** The kind of units. */
    val kind: K,
    /** The system of units for this unit. */
    val system: S,
    /** Must be unique for each unit within [system]. */
    val name: String,
    /** Amount of 1 unit expressed in base units. */
    internal val basis: FixedBigRational,
) : Comparable<Units<K, S, *, *>> {
    /**
     * Creates a new measure of this unit with the given [quantity].
     *
     * @param quantity the amount of this unit
     */
    abstract fun new(quantity: FixedBigRational): M

    /**
     * Presents the calling measure suitable for humans.
     *
     * @param quantity the amount of this unit
     */
    abstract fun format(quantity: FixedBigRational): String

    /** Compares to [other] in this kind of system of units. */
    override fun compareTo(other: Units<K, S, *, *>) =
        basis.compareTo(other.basis)

    // Units are singleton objects, so no point to defining equals/hashCode

    /** Presents this unit as "[system] [name]". */
    override fun toString() = "$system $kind: $name"
}

/**
 * Represents a [quantity] of a [unit] within a [System].
 *
 * See [Furlong] for an example.
 * Note the pairing: [Furlongs] defines the _unit_; [Furlong] defines a
 * quantity of that unit.
 *
 * @param K the kind of units
 * @param S the system of units
 * @param U the units of [M]
 * @param M the measurement type of [U]
 */
abstract class Measure<
    K : Kind,
    S : System<S>,
    U : Units<K, S, U, M>,
    M : Measure<K, S, U, M>,
    >(
    /** Unit of measure. */
    val unit: U,
    /** Quantity of [unit]s. */
    val quantity: FixedBigRational,
) : Comparable<Measure<K, S, *, *>> {
    /** Compares to [other] in the [U] units of measure. */
    override fun compareTo(other: Measure<K, S, *, *>) =
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
     * is mathematically equivalent though inconvenient.)
     */
    override fun equals(other: Any?) = this === other ||
        other is Measure<*, *, *, *> &&
        unit == other.unit &&
        quantity == other.quantity

    override fun hashCode() = hash(unit, quantity)
}
