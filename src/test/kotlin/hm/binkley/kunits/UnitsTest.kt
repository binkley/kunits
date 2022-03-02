package hm.binkley.kunits

import hm.binkley.kunits.Foo.Foos
import hm.binkley.kunits.Grok.Groks
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TWO
import hm.binkley.math.fixed.over
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
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
        (1.bars into Foos) shouldBe 2.foos
        (2L.foos into Bars) shouldBe 1L.bars
    }

    @Test
    fun `should convert between systems`() {
        (1.foos intoMartian Groks) shouldBe 3.groks
        (1.groks intoMetasyntactic Foos) shouldBe (1 over 3).foos
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

    @Suppress("ReplaceCallWithBinaryOperator")
    @Test
    fun `should equate`() {
        val measure = 1.foos
        measure.equals(measure).shouldBeTrue()
        measure.equals(this).shouldBeFalse()
        measure.equals(1.groks).shouldBeFalse()
        measure.equals(1.bars).shouldBeFalse()
        measure.equals(2.foos).shouldBeFalse()
    }

    @Test
    fun `should hash`() {
        val measure = 1.foos
        identityHashCode(measure) shouldNotBe measure.hashCode()
    }
}

// Main system, units, and measures for tests
object Metasyntactic : System<Metasyntactic>()

infix fun <U : Length<Metasyntactic, U>, V : Length<Martian, V>>
Measure<Metasyntactic, U>.intoMartian(other: V) = into(other) {
    it * (3 over 1)
}

sealed class MetasyntacticLength<U : MetasyntacticLength<U>>(
    name: String,
    foos: FixedBigRational,
) : Length<Metasyntactic, U>(Metasyntactic, name, foos)

class Foo private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Foos>(Foos, value) {

    companion object Foos : MetasyntacticLength<Foos>("foo", ONE) {
        override fun new(value: FixedBigRational) = Foo(value)
        override fun format(value: FixedBigRational) = "$value foos"
    }
}

val Int.foos get() = (this over 1).foos
val Long.foos get() = (this over 1).foos
val FixedBigRational.foos get() = Foos.new(this)

object Bars : MetasyntacticLength<Bars>("bar", TWO) {
    override fun new(value: FixedBigRational) = Bar(value)
    override fun format(value: FixedBigRational) = "$value bars"
}

class Bar(value: FixedBigRational) :
    Measure<Metasyntactic, Bars>(Bars, value)

val Int.bars get() = (this over 1).bars
val Long.bars get() = (this over 1).bars
val FixedBigRational.bars get() = Bars.new(this)

// Alternate system, units, and measures for tests
object Martian : System<Martian>()

infix fun <U : Length<Martian, U>, V : Length<Metasyntactic, V>>
Measure<Martian, U>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}

sealed class MartianLength<U : MartianLength<U>>(
    name: String,
    bars: FixedBigRational,
) : Length<Martian, U>(Martian, name, bars)

class Grok private constructor(value: FixedBigRational) :
    Measure<Martian, Groks>(Groks, value) {

    companion object Groks : MartianLength<Groks>("grok", ONE) {
        override fun new(value: FixedBigRational) = Grok(value)
        override fun format(value: FixedBigRational) = "$value groks"
    }
}

val Int.groks get() = (this over 1).groks
val FixedBigRational.groks get() = Groks.new(this)
