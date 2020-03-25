package hm.binkley.kunit

import hm.binkley.kunit.system.english.into
import hm.binkley.kunit.system.english.length.Yards
import hm.binkley.kunit.system.english.length.yards
import hm.binkley.kunit.system.fff.into
import hm.binkley.kunit.system.fff.length.Furlongs
import hm.binkley.kunit.system.fff.length.furlongs
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UnitsTest {
    @Test
    fun `should be named`() {
        assertEquals("bar", Bars.name)
        assertEquals("Qux bar", "$Bars")
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

    @Test
    fun `should convert between systems`() {
        assertEquals(1.furlongs.into(Yards), 220.yards)
        assertEquals(220.yards.into(Furlongs), 1.furlongs)
    }
}

internal object Qux : System<Qux>("Qux")

internal sealed class Foos<U : Foos<U>>(
    name: String,
    bars: FiniteBigRational
) : Lengths<Qux, U>(Qux, name, bars)

internal object Bars : Foos<Bars>("bar", ONE) {
    override fun new(value: FiniteBigRational) = Bar(value)
    override fun format(value: FiniteBigRational) = "$value bars"
}

internal class Bar(value: FiniteBigRational) : Measure<Qux, Bars>(Bars, value)

internal inline val Int.bars get() = (this over 1).bars
internal inline val FiniteBigRational.bars get() = Bar(this)
