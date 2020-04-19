package hm.binkley.kunits

import hm.binkley.kunits.system.english.into
import hm.binkley.kunits.system.english.length.Inches
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.english.length.inches
import hm.binkley.kunits.system.english.length.yards
import hm.binkley.kunits.system.fff.into
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.kunits.system.fff.length.furlongs
import hm.binkley.kunits.system.mit.into
import hm.binkley.kunits.system.mit.length.smoots
import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UnitsTest {
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
        assertEquals(1.smoots.into(Inches), 67.inches)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("Foo", "$Foo")
        assertEquals("Foo bar", "$Bars")
        assertEquals("1 bars", "${1.bars}")
    }
}

internal object Foo : System<Foo>("Foo")

internal sealed class FooLengths<U : FooLengths<U>>(
    name: String,
    bars: FiniteBigRational
) : Lengths<Foo, U>(Foo, name, bars)

internal object Bars : FooLengths<Bars>("bar", ONE) {
    override fun new(value: FiniteBigRational) = Bar(value)
    override fun format(value: FiniteBigRational) = "$value bars"
}

internal class Bar(value: FiniteBigRational) : Measure<Foo, Bars>(Bars, value)

internal inline val Int.bars get() = (this over 1).bars
internal inline val FiniteBigRational.bars get() = Bar(this)
