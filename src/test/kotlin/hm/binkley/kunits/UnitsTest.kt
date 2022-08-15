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

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import java.lang.System.identityHashCode

/** @todo How much of this is testing test code _vs_ production code? */
internal class UnitsTest {
    @Test
    fun `should pretty print`() {
        "$Metasyntactic" shouldBe "Metasyntactic"
        "$FooMeasure" shouldBe "Metasyntactic length: foo"
        "${1.foo}" shouldBe "1 foo"
    }

    @Test
    fun `should be named`() {
        Length.name shouldBe "length"
        Time.name shouldBe "time"
        Weight.name shouldBe "weight"
        Denomination.name shouldBe "denomination"
        Metasyntactic.name shouldBe "Metasyntactic"
        FooMeasure.name shouldBe "foo"
    }

    @Test
    fun `should have a kind of units`() {
        FooMeasure.kind shouldBe Length
    }

    @Test
    fun `should be part of a system`() {
        FooMeasure.system shouldBe Metasyntactic
    }

    @Test
    fun `should have an ordering`() {
        FooMeasure shouldBeLessThan BarMeasure
        1.foo shouldBeLessThan 1.bar
    }

    @Suppress("ReplaceCallWithBinaryOperator")
    @Test
    fun `should equate`() {
        val measure = 1.foo
        measure.equals(measure).shouldBeTrue()
        measure.equals(1.foo).shouldBeTrue()
        measure.equals(null).shouldBeFalse()
        measure.equals(this).shouldBeFalse()
        measure.equals(1.groks).shouldBeFalse()
        measure.equals(1.bar).shouldBeFalse()
        measure.equals(2.foo).shouldBeFalse()
    }

    @Test
    fun `should hash`() {
        val measure = 1.foo
        val hash = measure.hashCode()
        hash shouldBe 1.foo.hashCode()
        hash shouldNotBe identityHashCode(measure)
        hash shouldNotBe 1.bar.hashCode()
        hash shouldNotBe 2.foo.hashCode()
    }
}
