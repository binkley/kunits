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
import hm.binkley.math.finite.FixedBigRational
import hm.binkley.math.finite.FixedBigRational.Companion.ONE
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class UnitsTest {
    @Test
    fun `should posite`() {
        assertEquals((+1).bars, +(1L.bars))
    }

    @Test
    fun `should negate`() {
        assertEquals((-1L).bars, -(1.bars))
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
        assertEquals(3.bars, 1.bars * 3L)
        assertEquals(3.bars, 3L * 1.bars)
        assertEquals(3.bars, 1.bars * (3 over 1))
        assertEquals(3.bars, (3 over 1) * 1.bars)
    }

    @Test
    fun `should divide`() {
        assertEquals(1.bars, 3.bars / 3)
        assertEquals(1.bars, 3.bars / 3L)
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

    @Test
    fun `should complain about duplicate system names`() {
        val error = assertThrows<ExceptionInInitializerError> {
            Foo
            DuplicateFoo
        }

        assertTrue(error.cause!!.message!!.contains(Foo.name))
    }
}

private object Foo : System<Foo>("Foo")

private sealed class FooLengths<U : FooLengths<U>>(
    name: String,
    bars: FixedBigRational
) : Lengths<Foo, U>(Foo, name, bars)

private object Bars : FooLengths<Bars>("bar", ONE) {
    override fun new(value: FixedBigRational) = Bar(value)
    override fun format(value: FixedBigRational) = "$value bars"
}

private class Bar(value: FixedBigRational) : Measure<Foo, Bars>(Bars, value)

private inline val Int.bars get() = (this over 1).bars
private inline val Long.bars get() = (this over 1).bars
private inline val FixedBigRational.bars get() = Bar(this)

private object DuplicateFoo : System<DuplicateFoo>("Foo")
