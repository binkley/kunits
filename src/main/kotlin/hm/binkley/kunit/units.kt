package hm.binkley.kunit

import java.util.Objects.hash

abstract class Units<U : Units<U>>(
    val name: String
) {
    abstract fun new(value: FiniteBigRational): Measure<U>
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
    override fun toString() = unit.format(value)
}

operator fun <U : Units<U>> Measure<U>.unaryPlus() = this
operator fun <U : Units<U>> Measure<U>.unaryMinus() = unit.new(-value)

operator fun <U : Units<U>> Measure<U>.plus(other: Measure<U>) =
    unit.new(value + other.value)

operator fun <U : Units<U>> Measure<U>.minus(other: Measure<U>) =
    unit.new(value - other.value)

operator fun <U : Units<U>> Measure<U>.times(factor: Int) =
    unit.new(value * factor)

operator fun <U : Units<U>> Measure<U>.div(factor: Int) =
    unit.new(value / factor)
