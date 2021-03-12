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
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over
import hm.binkley.math.fixed.toBigRational
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.lang.System.identityHashCode

internal class UnitsTest {
    @Test
    fun `should posite`() {
        +(1L.bars) shouldBe (+1).bars
    }

    @Test
    fun `should negate`() {
        -(1.bars) shouldBe (-1L).bars
    }

    @Test
    fun `should add`() {
        1.bars + 2.bars shouldBe 3.bars
        7.bars shouldBe ((3 over 1).bars + 4.bars)
    }

    @Test
    fun `should subtract`() {
        3.bars - 2.bars shouldBe 1.bars
        (-1).bars shouldBe ((3 over 1).bars - 4.bars)
    }

    @Test
    fun `should multiply`() {
        1.bars * 3 shouldBe 3.bars
        3 * 1.bars shouldBe 3.bars
        1.bars * 3L shouldBe 3.bars
        3L * 1.bars shouldBe 3.bars
        1.bars * (3 over 1) shouldBe 3.bars
        (3 over 1) * 1.bars shouldBe 3.bars
    }

    @Test
    fun `should divide`() {
        3.bars / 3 shouldBe 1.bars
        3.bars / 3L shouldBe 1.bars
        3.bars / (3 over 1) shouldBe 1.bars
    }

    @Test
    fun `should convert between units`() {
        1.quxen.bars shouldBe 2.bars
        2L.bars.quxen shouldBe 1L.quxen
    }

    @Test
    fun `should convert between systems`() {
        220.yards shouldBe 1.furlongs.into(Yards)
        1.furlongs shouldBe 220.yards.into(Furlongs)
        67.inches shouldBe 1.smoots.into(Inches)
    }

    @Test
    fun `should pretty print`() {
        "$Foo" shouldBe "Foo"
        "$Bars" shouldBe "Foo bar"
        "${1.bars}" shouldBe "1 bars"
    }

    @Test
    fun `should be named`() {
        Foo.name shouldBe "Foo"
        Bars.name shouldBe "bar"
    }

    @Test
    fun `should be part of a system`() {
        Bars.system shouldBe Foo
    }

    @Test
    fun `should hash`() {
        assertNotEquals(identityHashCode(Foo), Foo.hashCode())
        assertNotEquals(identityHashCode(Bars), Bars.hashCode())
        val measure = 1.bars
        assertNotEquals(identityHashCode(measure), measure.hashCode())
    }
}

private object Foo : System<Foo>()

private sealed class FooLengths<U : FooLengths<U>>(
    name: String,
    bars: FixedBigRational,
) : Lengths<Foo, U>(Foo, name, bars)

private object Bars : FooLengths<Bars>("bar", ONE) {
    override fun new(value: FixedBigRational) = Bar(value)
    override fun format(value: FixedBigRational) = "$value bars"
}

private class Bar(value: FixedBigRational) : Measure<Foo, Bars>(Bars, value)

private inline val Int.bars get() = toBigRational().bars
private inline val Long.bars get() = toBigRational().bars
private inline val FixedBigRational.bars get() = Bar(this)
private val Measure<Foo, *>.bars get() = to(Bars)

private object Quxen : FooLengths<Quxen>("qux", 2 over 1) {
    override fun new(value: FixedBigRational) = Qux(value)
    override fun format(value: FixedBigRational) = "$value quxen"
}

private class Qux(value: FixedBigRational) : Measure<Foo, Quxen>(Quxen, value)

private inline val Int.quxen get() = toBigRational().quxen
private inline val Long.quxen get() = toBigRational().quxen
private inline val FixedBigRational.quxen get() = Qux(this)
private val Measure<Foo, *>.quxen get() = to(Quxen)
