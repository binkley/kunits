package hm.binkley.kunit

import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UnitsTest {
    @Test
    fun `should be named`() {
        assertEquals("Bar", Bars.name)
        assertEquals("Bar", "$Bars")
        assertEquals("1 bars", "${1.bars}")
    }

    @Test
    fun `should posite`() {
        assertEquals((+1).bars, +(1.bars))
    }

    @Test
    fun `should negate`() {
        assertEquals((-1).bars, -(1.bars))
    }

    @Test
    fun `should add`() {
        assertEquals(3.bars, 1.bars + 2.bars)
        assertEquals((3 over 1).bars + 4.bars, 7.bars)
    }

    @Test
    fun `should subtract`() {
        assertEquals(1.bars, 3.bars - 2.bars)
        assertEquals((3 over 1).bars - 4.bars, (-1).bars)
    }

    @Test
    fun `should multiply`() {
        assertEquals(3.bars, 1.bars * 3)
        assertEquals(3.bars, 3 * 1.bars)
        assertEquals(3.bars, 1.bars * (3 over 1))
        assertEquals(3.bars, (3 over 1) * 1.bars)
    }

    @Test
    fun `should divide`() {
        assertEquals(1.bars, 3.bars / 3)
        assertEquals(1.bars, 3.bars / (3 over 1))
    }
}

internal sealed class Foos<U : Foos<U>>(
    name: String,
    bars: FiniteBigRational
) : Lengths<U>(name, bars)

internal object Bars : Foos<Bars>("Bar", ONE) {
    override fun new(value: FiniteBigRational) = Bar(value)
    override fun format(value: FiniteBigRational) = "$value bars"
}

internal class Bar(value: FiniteBigRational) : Measure<Bars>(Bars, value)

internal inline val Int.bars get() = (this over 1).bars
internal inline val FiniteBigRational.bars get() = Bar(this)
