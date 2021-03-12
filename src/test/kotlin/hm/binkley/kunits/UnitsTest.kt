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
        +(1L.foos) shouldBe (+1).foos
    }

    @Test
    fun `should negate`() {
        -(1.foos) shouldBe (-1L).foos
    }

    @Test
    fun `should add`() {
        1.foos + 2.foos shouldBe 3.foos
    }

    @Test
    fun `should subtract`() {
        3.foos - 2.foos shouldBe 1.foos
    }

    @Test
    fun `should multiply`() {
        1.foos * 3 shouldBe 3.foos
        3 * 1.foos shouldBe 3.foos
        1.foos * 3L shouldBe 3.foos
        3L * 1.foos shouldBe 3.foos
        1.foos * (3 over 1) shouldBe 3.foos
        (3 over 1) * 1.foos shouldBe 3.foos
    }

    @Test
    fun `should divide`() {
        3.foos / 3 shouldBe 1.foos
        3.foos / 3L shouldBe 1.foos
        3.foos / (3 over 1) shouldBe 1.foos
    }

    @Test
    fun `should convert between units`() {
        1.bars.foos shouldBe 2.foos
        2L.foos.bars shouldBe 1L.bars
    }

    @Test
    fun `should convert between systems`() {
        220.yards shouldBe 1.furlongs.into(Yards)
        1.furlongs shouldBe 220.yards.into(Furlongs)
        67.inches shouldBe 1.smoots.into(Inches)
    }

    @Test
    fun `should pretty print`() {
        "$Metasyntactic" shouldBe "Metasyntactic"
        "$Foos" shouldBe "Metasyntactic foo"
        "${1.foos}" shouldBe "1 foos"
    }

    @Test
    fun `should be named`() {
        Metasyntactic.name shouldBe "Metasyntactic"
        Foos.name shouldBe "foo"
    }

    @Test
    fun `should be part of a system`() {
        Foos.system shouldBe Metasyntactic
    }

    @Test
    fun `should hash`() {
        assertNotEquals(identityHashCode(Metasyntactic), Metasyntactic.hashCode())
        assertNotEquals(identityHashCode(Foos), Foos.hashCode())
        val measure = 1.foos
        assertNotEquals(identityHashCode(measure), measure.hashCode())
    }
}

private object Metasyntactic : System<Metasyntactic>()

private sealed class MetasyntacticLengths<U : MetasyntacticLengths<U>>(
    name: String,
    bars: FixedBigRational,
) : Lengths<Metasyntactic, U>(Metasyntactic, name, bars)

private object Foos : MetasyntacticLengths<Foos>("foo", ONE) {
    override fun new(value: FixedBigRational) = Foo(value)
    override fun format(value: FixedBigRational) = "$value foos"
}

private class Foo(value: FixedBigRational) :
    Measure<Metasyntactic, Foos>(Foos, value)

private inline val Int.foos get() = toBigRational().foos
private inline val Long.foos get() = toBigRational().foos
private inline val FixedBigRational.foos get() = Foo(this)
private val Measure<Metasyntactic, *>.foos get() = to(Foos)

private object Bars : MetasyntacticLengths<Bars>("bar", 2 over 1) {
    override fun new(value: FixedBigRational) = Bar(value)
    override fun format(value: FixedBigRational) = "$value bars"
}

private class Bar(value: FixedBigRational) :
    Measure<Metasyntactic, Bars>(Bars, value)

private inline val Int.bars get() = toBigRational().bars
private inline val Long.bars get() = toBigRational().bars
private inline val FixedBigRational.bars get() = Bar(this)
private val Measure<Metasyntactic, *>.bars get() = to(Bars)
