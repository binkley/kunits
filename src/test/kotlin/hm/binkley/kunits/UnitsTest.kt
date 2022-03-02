package hm.binkley.kunits

import hm.binkley.kunits.system.english.length.Inches
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.english.intoFFF
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.kunits.system.fff.intoEnglish
import hm.binkley.kunits.system.mit.intoEnglish
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TWO
import hm.binkley.math.fixed.over
import hm.binkley.math.fixed.toBigRational
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import java.lang.System.identityHashCode
import hm.binkley.kunits.system.english.length.inches as englishInches
import hm.binkley.kunits.system.english.length.yards as englishYards
import hm.binkley.kunits.system.fff.length.furlongs as fffFurlongs
import hm.binkley.kunits.system.mit.length.smoots as mitSmoots

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
        220.englishYards shouldBe 1.fffFurlongs.intoEnglish(Yards)
        1.fffFurlongs shouldBe 220.englishYards.intoFFF(Furlongs)
        67.englishInches shouldBe 1.mitSmoots.intoEnglish(Inches)
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

sealed class MetasyntacticLength<U : MetasyntacticLength<U>>(
    name: String,
    foos: FixedBigRational,
) : Length<Metasyntactic, U>(Metasyntactic, name, foos)

object Foos : MetasyntacticLength<Foos>("foo", ONE) {
    override fun new(value: FixedBigRational) = Foo(value)
    override fun format(value: FixedBigRational) = "$value foos"
}

class Foo(value: FixedBigRational) :
    Measure<Metasyntactic, Foos>(Foos, value)

val Int.foos get() = toBigRational().foos
val Long.foos get() = toBigRational().foos
val FixedBigRational.foos get() = Foo(this)
val Measure<Metasyntactic, *>.foos get() = into(Foos)

object Bars : MetasyntacticLength<Bars>("bar", TWO) {
    override fun new(value: FixedBigRational) = Bar(value)
    override fun format(value: FixedBigRational) = "$value bars"
}

class Bar(value: FixedBigRational) :
    Measure<Metasyntactic, Bars>(Bars, value)

val Int.bars get() = toBigRational().bars
val Long.bars get() = toBigRational().bars
val FixedBigRational.bars get() = Bar(this)
val Measure<Metasyntactic, *>.bars get() = into(Bars)

// Alternate system, units, and measures for tests
object Martian : System<Martian>()

sealed class MartianLength<U : MartianLength<U>>(
    name: String,
    bars: FixedBigRational,
) : Length<Martian, U>(Martian, name, bars)

object Groks : MartianLength<Groks>("grok", ONE) {
    override fun new(value: FixedBigRational) = Grok(value)
    override fun format(value: FixedBigRational) = "$value groks"
}

class Grok(value: FixedBigRational) :
    Measure<Martian, Groks>(Groks, value)

val Int.groks get() = toBigRational().groks
val Long.groks get() = toBigRational().groks
val FixedBigRational.groks get() = Grok(this)
val Measure<Martian, *>.groks get() = into(Groks)
