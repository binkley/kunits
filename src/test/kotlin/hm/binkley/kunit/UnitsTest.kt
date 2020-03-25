package hm.binkley.kunit

import hm.binkley.math.finite.FiniteBigRational
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
    fun `should add`() {
        assertEquals(3.bars, 1.bars + 2.bars)
    }

    @Test
    fun `should subtract`() {
        assertEquals(1.bars, 3.bars - 2.bars)
    }
}

internal sealed class Foos<L : Foos<L>>(name: String) : Lengths<L>(name)

internal object Bars : Foos<Bars>("Bar") {
    override fun new(value: FiniteBigRational) = Bar(value)
    override fun format(value: FiniteBigRational) = "$value bars"
}

internal class Bar(value: FiniteBigRational) : Measure<Bars>(Bars, value)

internal inline val Int.bars
    get() = (this over 1).bars
internal inline val FiniteBigRational.bars
    get() = Bar(this)
