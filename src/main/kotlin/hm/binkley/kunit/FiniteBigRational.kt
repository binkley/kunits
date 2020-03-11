package hm.binkley.kunit

import hm.binkley.kunit.FiniteBigRational.Companion.ONE
import hm.binkley.kunit.FiniteBigRational.Companion.TEN
import hm.binkley.kunit.FiniteBigRational.Companion.ZERO
import hm.binkley.kunit.FiniteBigRational.Companion.valueOf
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Objects.hash

private typealias BInt = BigInteger
private typealias BDecimal = BigDecimal

class FiniteBigRational private constructor(
    val numerator: BInt,
    val denominator: BInt
) : Comparable<FiniteBigRational> {
    override fun compareTo(other: FiniteBigRational) = when {
        this === other -> 0 // Sort stability for constants
        else -> {
            val a = numerator * other.denominator
            val b = other.numerator * denominator
            a.compareTo(b)
        }
    }

    override fun equals(other: Any?) = this === other ||
            other is FiniteBigRational &&
            numerator == other.numerator &&
            denominator == other.denominator

    override fun hashCode() = hash(numerator, denominator)

    override fun toString() = when {
        denominator.isOne() -> numerator.toString()
        else -> "$numerator⁄$denominator" // UNICODE fraction slash
    }

    companion object {
        val ZERO = FiniteBigRational(BInt.ZERO, BInt.ONE)
        val ONE = FiniteBigRational(BInt.ONE, BInt.ONE)
        val TWO = FiniteBigRational(BInt.TWO, BInt.ONE)
        val TEN = FiniteBigRational(BInt.TEN, BInt.ONE)

        fun valueOf(numerator: BInt, denominator: BInt): FiniteBigRational {
            if (denominator.isZero()) throw ArithmeticException("Division by zero")
            if (numerator.isZero()) return ZERO

            var n = numerator
            var d = denominator
            if (-1 == d.signum()) {
                n = n.negate()
                d = d.negate()
            }

            if (d.isOne()) return when {
                n.isOne() -> ONE
                n.isTwo() -> TWO
                n.isTen() -> TEN
                else -> FiniteBigRational(n, d)
            }

            val gcd = n.gcd(d)
            if (!gcd.isOne()) {
                n /= gcd
                d /= gcd
            }

            return FiniteBigRational(n, d)
        }
    }
}

val FiniteBigRational.sign: FiniteBigRational
    get() = numerator.signum().toFiniteBigRational()

val FiniteBigRational.absoluteValue: FiniteBigRational
    get() = valueOf(numerator.abs(), denominator)

val FiniteBigRational.reciprocal: FiniteBigRational
    get() = valueOf(denominator, numerator)

infix fun BDecimal.over(denominator: BDecimal) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun BDecimal.over(denominator: BInt) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun BDecimal.over(denominator: Long) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun BDecimal.over(denominator: Int) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun BInt.over(denominator: BDecimal) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun BInt.over(denominator: BInt) = valueOf(this, denominator)

infix fun BInt.over(denominator: Long) =
    valueOf(this, denominator.toBigInteger())

infix fun BInt.over(denominator: Int) =
    valueOf(this, denominator.toBigInteger())

infix fun Long.over(denominator: BDecimal) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun Long.over(denominator: BInt) = valueOf(toBigInteger(), denominator)

infix fun Long.over(denominator: Long) =
    valueOf(toBigInteger(), denominator.toBigInteger())

infix fun Long.over(denominator: Int) =
    valueOf(toBigInteger(), denominator.toBigInteger())

infix fun Int.over(denominator: BDecimal) =
    toFiniteBigRational() / denominator.toFiniteBigRational()

infix fun Int.over(denominator: BInt) = valueOf(toBigInteger(), denominator)

infix fun Int.over(denominator: Long) =
    valueOf(toBigInteger(), denominator.toBigInteger())

infix fun Int.over(denominator: Int) =
    valueOf(toBigInteger(), denominator.toBigInteger())

fun BDecimal.toFiniteBigRational() = convert(this)

fun BInt.toFiniteBigRational() = valueOf(this, BInt.ONE)

fun Long.toFiniteBigRational() = toBigInteger().toFiniteBigRational()

fun Int.toFiniteBigRational() = toBigInteger().toFiniteBigRational()

operator fun FiniteBigRational.unaryPlus() = this

operator fun FiniteBigRational.unaryMinus() =
    valueOf(numerator.negate(), denominator)

operator fun FiniteBigRational.inc() =
    valueOf(numerator + denominator, denominator)

operator fun FiniteBigRational.dec() =
    valueOf(numerator - denominator, denominator)

operator fun FiniteBigRational.plus(other: FiniteBigRational) =
    if (denominator == other.denominator)
        valueOf(numerator + other.numerator, denominator)
    else valueOf(
        numerator * other.denominator + other.numerator * denominator,
        denominator * other.denominator
    )

operator fun FiniteBigRational.plus(addend: BDecimal) =
    this + addend.toFiniteBigRational()

operator fun FiniteBigRational.plus(addend: BInt) =
    this + addend.toFiniteBigRational()

operator fun FiniteBigRational.plus(addend: Long) =
    this + addend.toFiniteBigRational()

operator fun FiniteBigRational.plus(addend: Int) =
    this + addend.toFiniteBigRational()

operator fun FiniteBigRational.minus(subtrahend: FiniteBigRational) =
    this + -subtrahend

operator fun FiniteBigRational.minus(subtrahend: BDecimal) =
    this - subtrahend.toFiniteBigRational()

operator fun FiniteBigRational.minus(subtrahend: BInt) =
    this - subtrahend.toFiniteBigRational()

operator fun FiniteBigRational.minus(subtrahend: Long) =
    this - subtrahend.toFiniteBigRational()

operator fun FiniteBigRational.minus(subtrahend: Int) =
    this - subtrahend.toFiniteBigRational()

operator fun FiniteBigRational.times(other: FiniteBigRational) = valueOf(
    numerator * other.numerator,
    denominator * other.denominator
)

operator fun FiniteBigRational.times(multiplicand: BDecimal) =
    this * multiplicand.toFiniteBigRational()

operator fun FiniteBigRational.times(multiplicand: BInt) =
    this * multiplicand.toFiniteBigRational()

operator fun FiniteBigRational.times(multiplicand: Long) =
    this * multiplicand.toFiniteBigRational()

operator fun FiniteBigRational.times(multiplicand: Int) =
    this * multiplicand.toFiniteBigRational()

operator fun FiniteBigRational.div(divisor: FiniteBigRational) =
    this * divisor.reciprocal

operator fun FiniteBigRational.div(divisor: BDecimal) =
    this / divisor.toFiniteBigRational()

operator fun FiniteBigRational.div(divisor: BInt) =
    this / divisor.toFiniteBigRational()

operator fun FiniteBigRational.div(divisor: Long) =
    this / divisor.toFiniteBigRational()

operator fun FiniteBigRational.div(divisor: Int) =
    this / divisor.toFiniteBigRational()

@Suppress("UNUSED_PARAMETER")
operator fun FiniteBigRational.rem(divisor: FiniteBigRational) = ZERO

operator fun FiniteBigRational.rem(divisor: BDecimal) =
    this % divisor.toFiniteBigRational()

operator fun FiniteBigRational.rem(divisor: BInt) =
    this % divisor.toFiniteBigRational()

operator fun FiniteBigRational.rem(divisor: Long) =
    this % divisor.toFiniteBigRational()

operator fun FiniteBigRational.rem(divisor: Int) =
    this % divisor.toFiniteBigRational()

operator fun FiniteBigRational.rangeTo(other: FiniteBigRational) =
    FiniteBigRationalProgression(this, other)

operator fun FiniteBigRational.rangeTo(other: BDecimal) =
    rangeTo(other.toFiniteBigRational())

operator fun FiniteBigRational.rangeTo(other: BInt) =
    rangeTo(other.toFiniteBigRational())

operator fun FiniteBigRational.rangeTo(other: Long) =
    rangeTo(other.toFiniteBigRational())

operator fun FiniteBigRational.rangeTo(other: Int) =
    rangeTo(other.toFiniteBigRational())

sealed class FiniteBigRationalIterator(
    first: FiniteBigRational,
    protected val last: FiniteBigRational,
    private val step: FiniteBigRational
) : Iterator<FiniteBigRational> {
    init {
        if (step == ZERO) error("Step must be non-zero.")
    }

    protected var current = first

    override fun next(): FiniteBigRational {
        val next = current
        current += step
        return next
    }
}

class IncrementingFiniteBigRationalIterator(
    first: FiniteBigRational,
    last: FiniteBigRational,
    step: FiniteBigRational
) : FiniteBigRationalIterator(first, last, step) {
    init {
        if (first > last)
            error("Step must be advance range to avoid overflow.")
    }

    override fun hasNext() = current <= last
}

class DecrementingFiniteBigRationalIterator(
    first: FiniteBigRational,
    last: FiniteBigRational,
    step: FiniteBigRational
) : FiniteBigRationalIterator(first, last, step) {
    init {
        if (first < last)
            error("Step must be advance range to avoid overflow.")
    }

    override fun hasNext() = current >= last
}

class FiniteBigRationalProgression(
    override val start: FiniteBigRational,
    override val endInclusive: FiniteBigRational,
    step: FiniteBigRational = ONE
) : SteppedFiniteBigRationalProgression(start, endInclusive, step) {
    infix fun step(step: FiniteBigRational) =
        SteppedFiniteBigRationalProgression(start, endInclusive, step)

    infix fun step(step: BInt) =
        SteppedFiniteBigRationalProgression(start, endInclusive, step over 1)

    infix fun step(step: Long) =
        SteppedFiniteBigRationalProgression(start, endInclusive, step over 1)

    infix fun step(step: Int) =
        SteppedFiniteBigRationalProgression(start, endInclusive, step over 1)
}

open class SteppedFiniteBigRationalProgression(
    override val start: FiniteBigRational,
    override val endInclusive: FiniteBigRational,
    private val step: FiniteBigRational
) : Iterable<FiniteBigRational>, ClosedRange<FiniteBigRational> {
    override fun iterator() =
        if (step < ZERO)
            DecrementingFiniteBigRationalIterator(start, endInclusive, step)
        else
            IncrementingFiniteBigRationalIterator(start, endInclusive, step)

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is SteppedFiniteBigRationalProgression -> false
        else -> start == other.start &&
                endInclusive == other.endInclusive &&
                step == other.step
    }

    override fun hashCode() = hash(start, endInclusive, step)

    override fun toString() =
        if (step < ZERO) "$start downTo $endInclusive step $step"
        else "$start..$endInclusive step $step"
}

infix fun FiniteBigRational.downTo(other: FiniteBigRational) =
    FiniteBigRationalProgression(this, other, -ONE)

operator fun BDecimal.plus(other: FiniteBigRational) =
    toFiniteBigRational() + other

operator fun BInt.plus(other: FiniteBigRational) =
    toFiniteBigRational() + other

operator fun Long.plus(other: FiniteBigRational) =
    toFiniteBigRational() + other

operator fun Int.plus(other: FiniteBigRational) =
    toFiniteBigRational() + other

operator fun BDecimal.minus(other: FiniteBigRational) =
    toFiniteBigRational() - other

operator fun BInt.minus(other: FiniteBigRational) =
    toFiniteBigRational() - other

operator fun Long.minus(other: FiniteBigRational) =
    toFiniteBigRational() - other

operator fun Int.minus(other: FiniteBigRational) =
    toFiniteBigRational() - other

operator fun BDecimal.times(other: FiniteBigRational) =
    toFiniteBigRational() * other

operator fun BInt.times(other: FiniteBigRational) =
    toFiniteBigRational() * other

operator fun Long.times(other: FiniteBigRational) =
    toFiniteBigRational() * other

operator fun Int.times(other: FiniteBigRational) =
    toFiniteBigRational() * other

operator fun BDecimal.div(other: FiniteBigRational) =
    toFiniteBigRational() / other

operator fun BInt.div(other: FiniteBigRational) =
    toFiniteBigRational() / other

operator fun Long.div(other: FiniteBigRational) =
    toFiniteBigRational() / other

operator fun Int.div(other: FiniteBigRational) = toFiniteBigRational() / other

@Suppress("UNUSED_PARAMETER")
operator fun BDecimal.rem(other: FiniteBigRational) = ZERO

@Suppress("UNUSED_PARAMETER")
operator fun BInt.rem(other: FiniteBigRational) = ZERO

@Suppress("UNUSED_PARAMETER")
operator fun Long.rem(other: FiniteBigRational) = ZERO

@Suppress("UNUSED_PARAMETER")
operator fun Int.rem(other: FiniteBigRational) = ZERO

operator fun BDecimal.rangeTo(other: FiniteBigRational) =
    toFiniteBigRational()..other

operator fun BInt.rangeTo(other: FiniteBigRational) =
    toFiniteBigRational()..other

operator fun Long.rangeTo(other: FiniteBigRational) =
    toFiniteBigRational()..other

operator fun Int.rangeTo(other: FiniteBigRational) =
    toFiniteBigRational()..other

private fun convert(other: BDecimal) = when (other) {
    BDecimal.ZERO -> ZERO
    BDecimal.ONE -> ONE
    BDecimal.TEN -> TEN
    else -> {
        val bd = other.stripTrailingZeros()
        val scale = bd.scale()
        val unscaledValue = bd.unscaledValue()
        when {
            0 == scale -> unscaledValue over 1
            0 > scale -> (unscaledValue * BInt.TEN.pow(-scale)) over 1
            else -> unscaledValue over BInt.TEN.pow(scale)
        }
    }
}

private fun BInt.isZero() = this == BInt.ZERO
private fun BInt.isOne() = this == BInt.ONE
private fun BInt.isTwo() = this == BInt.TWO
private fun BInt.isTen() = this == BInt.TEN

fun FiniteBigRational.divideAndRemainder(other: FiniteBigRational):
        Pair<FiniteBigRational, FiniteBigRational> {
    val quotient = (this / other).round()
    val remainder = this - other * quotient
    return quotient to remainder
}

fun FiniteBigRational.pow(exponent: Int): FiniteBigRational /* type check issue */ =
    when {
        0 <= exponent ->
            valueOf(numerator.pow(exponent), denominator.pow(exponent))
        else -> reciprocal.pow(-exponent)
    }

fun FiniteBigRational.floor() = when {
    roundsToSelf() -> this
    ZERO <= this -> round()
    else -> round() - ONE
}

fun FiniteBigRational.ceil() = when {
    roundsToSelf() -> this
    ZERO <= this -> round() + ONE
    else -> round()
}

fun FiniteBigRational.round() = when {
    roundsToSelf() -> this
    else -> (numerator / denominator).toFiniteBigRational()
}

private fun FiniteBigRational.roundsToSelf() = isInteger()

fun FiniteBigRational.between(other: FiniteBigRational) = when {
    equals(other) -> throw ArithmeticException("Nothing between itself")
    else -> valueOf(
        numerator + other.numerator,
        denominator + other.denominator
    )
}

fun FiniteBigRational.isInteger() = BInt.ONE == denominator
