package hm.binkley.kunits

import hm.binkley.kunits.Alice.Alices
import hm.binkley.kunits.Bar.Bar
import hm.binkley.kunits.Baz.Baz
import hm.binkley.kunits.Foo.Foo
import hm.binkley.kunits.Fred.Freds
import hm.binkley.kunits.Grok.Groks
import hm.binkley.kunits.Spam.Spams
import hm.binkley.math.fixed.over
import io.kotest.assertions.throwables.shouldThrow
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

    @Test
    fun `should not convert between different systems of units`() {
        // Uncomment to see that these do not compile
        // 1.groks into Spams
        // 1.groks.into(Bar, Foo)
    }

    /** @todo Nothing syntactically prevents converting feet into pounds */
    @Test
    fun `should not convert between different types of unit is suboptimal`() {
        shouldThrow<IllegalArgumentException> {
            1.foo into Spams
        }
        shouldThrow<IllegalArgumentException> {
            1.spams into Freds
        }
        shouldThrow<IllegalArgumentException> {
            1.freds into Alices
        }
        shouldThrow<IllegalArgumentException> {
            1.alices into Foo
        }
    }

    @Test
    fun `should catch missing branch when checking conversion kinds`() {
        shouldThrow<NotImplementedError> {
            1.totos into Foo
        }
    }

    @Nested
    inner class Reductions {
        @Test
        fun `should convert into lowest terms all with values`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            val lowestTerms = measure.into(Baz, Bar, Foo)

            lowestTerms shouldBe listOf(8.baz, 1.bar, (1 over 2).foo)
        }

        @Test
        fun `should convert into lowest terms with some zeroes`() {
            val measure = 1.bar
            val lowestTerms = measure.into(Baz, Bar, Foo)

            lowestTerms shouldBe listOf(0.baz, 1.bar, 0.foo)
        }

        @Test
        fun `should convert into and preserve unit input ordering`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            val lowestTerms = measure.into(Foo, Baz, Bar)

            lowestTerms shouldBe listOf((1 over 2).foo, 8.baz, 1.bar)
        }
    }
}
