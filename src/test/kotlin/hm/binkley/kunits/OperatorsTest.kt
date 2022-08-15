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
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OperatorsTest {
    @Test
    fun `should posite`() {
        +(1L.foo) shouldBe (+1).foo
    }

    @Test
    fun `should negate`() {
        -(1.foo) shouldBe (-1L).foo
    }

    @Test
    fun `should add`() {
        1.foo + 2.foo shouldBe 3.foo
    }

    @Test
    fun `should subtract`() {
        3.foo - 2.foo shouldBe 1.foo
    }

    @Test
    fun `should multiply`() {
        1.foo * 3 shouldBe 3.foo
        3 * 1.foo shouldBe 3.foo
        1.foo * 3L shouldBe 3.foo
        3L * 1.foo shouldBe 3.foo
        1.foo * (3 over 1) shouldBe 3.foo
        (3 over 1) * 1.foo shouldBe 3.foo
    }

    @Test
    fun `should divide`() {
        3.foo / Bar shouldBe (3 over 2).bar
        3.foo / 4.bar shouldBe (3 over 8)
        3.foo / 3 shouldBe 1.foo
        3.foo / 3L shouldBe 1.foo
        3.foo / (3 over 1) shouldBe 1.foo
    }
}
