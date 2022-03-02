package hm.binkley.kunits

import hm.binkley.kunits.Bar.Bars
import hm.binkley.kunits.Foo.Foos
import hm.binkley.kunits.Grok.Groks
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ExtensionsTest {
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

    @Nested
    inner class Reductions {
        @Test
        fun `should reduce to lowest terms all with values`() {
            val measure = 2.bars + (5 over 2).foos
            val reduction = measure.lowestTerms(Bars, Foos)

            reduction shouldBe listOf(3.bars, (1 over 2).foos)
        }

        @Test
        fun `should reduce to lowest terms with some zeroes`() {
            val measure = 2.bars
            val reduction = measure.lowestTerms(Bars, Foos)

            reduction shouldBe listOf(2.bars, 0.foos)
        }
    }
}
