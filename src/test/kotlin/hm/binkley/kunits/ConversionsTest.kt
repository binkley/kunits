/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package hm.binkley.kunits

import hm.binkley.kunits.BarMeasure.Bar
import hm.binkley.kunits.BazMeasure.Baz
import hm.binkley.kunits.Grok.Groks
import hm.binkley.math.fixed.over
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ConversionsTest {
    @Test
    fun `should convert between units`() {
        (1.bar into FooMeasure) shouldBe 2.foo
        (2L.foo into Bar) shouldBe 1L.bar
    }

    @Test
    fun `should convert between systems`() {
        (1.foo intoMartian Groks) shouldBe 3.groks
        (1.groks intoMetasyntactic FooMeasure) shouldBe (1 over 3).foo
    }

    @Test
    fun `should not convert between different systems of units`() {
        // Uncomment to see that these do not compile
        // 1.groks into Spams
        // 1.groks.into(Bar, Foo)
    }

    @Test
    fun `should not convert between different kinds of unit is suboptimal`() {
        // Uncomment to see that these do not compile
        // 1.foo into Spams
        // 1.spams into Freds
        // 1.freds into Alices
        // 1.alices into Foo
    }

    @Nested
    inner class Reductions {
        @Test
        fun `should convert into lowest terms all with values`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            val lowestTerms = measure.into(Baz, Bar, FooMeasure)

            lowestTerms shouldBe listOf(8.baz, 1.bar, (1 over 2).foo)
        }

        @Test
        fun `should convert into lowest terms with some zeroes`() {
            val measure = 1.bar
            val lowestTerms = measure.into(Baz, Bar, FooMeasure)

            lowestTerms shouldBe listOf(0.baz, 1.bar, 0.foo)
        }

        @Test
        fun `should convert into and preserve unit input ordering`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            val lowestTerms = measure.into(FooMeasure, Baz, Bar)

            lowestTerms shouldBe listOf((1 over 2).foo, 8.baz, 1.bar)
        }

        @Test
        fun `should not convert into no units`() {
            val measure = 7.baz + 2.bar + (5 over 2).foo
            // Uncomment to see that this does not compile
            // measure.into()
            shouldThrow<IllegalArgumentException> {
                measure.into(emptyList())
            }
        }
    }
}
