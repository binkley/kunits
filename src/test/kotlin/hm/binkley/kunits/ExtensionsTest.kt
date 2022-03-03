package hm.binkley.kunits

import hm.binkley.kunits.Bar.Bar
import hm.binkley.kunits.Baz.Baz
import hm.binkley.kunits.Foo.Foo
import hm.binkley.kunits.Grok.Groks
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ExtensionsTest {
    @Test
    fun `should convert between units`() {
        (1.bar into Foo) shouldBe 2.foo
        (2L.foo into Bar) shouldBe 1L.bar
    }

    @Test
    fun `should convert between systems`() {
        (1.foo intoMartian Groks) shouldBe 3.groks
        (1.groks intoMetasyntactic Foo) shouldBe (1 over 3).foo
    }

    @Nested
    inner class Reductions {
        @Test
        fun `should reduce to lowest terms all with values`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            val reduction = measure.reduceTo(Baz, Bar, Foo)

            reduction shouldBe listOf(8.baz, 1.bar, (1 over 2).foo)
        }

        @Test
        fun `should reduce to lowest terms with some zeroes`() {
            val measure = 1.bar
            val reduction = measure.reduceTo(Baz, Bar, Foo)

            reduction shouldBe listOf(0.baz, 1.bar, 0.foo)
        }

        @Test
        fun `should reduce and preserve unit input ordering`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            val reduction = measure.reduceTo(Foo, Baz, Bar)

            reduction shouldBe listOf((1 over 2).foo, 8.baz, 1.bar)
        }
    }
}
