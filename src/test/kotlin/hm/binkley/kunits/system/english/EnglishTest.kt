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

package hm.binkley.kunits.system.english

import hm.binkley.kunits.system.english.length.furlongs
import hm.binkley.kunits.system.english.time.fortnights
import hm.binkley.kunits.system.english.weight.pounds
import hm.binkley.kunits.system.fff.weight.Firkin.Firkins
import hm.binkley.kunits.system.fff.weight.firkins
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs as FFFFurlongs
import hm.binkley.kunits.system.fff.length.furlongs as fffFurlongs
import hm.binkley.kunits.system.fff.time.Fortnight.Fortnights as FFFFortnights
import hm.binkley.kunits.system.fff.time.fortnights as fffFortnights

internal class EnglishTest {
    @Test
    fun `should pretty print`() {
        "$English" shouldBe "English"
    }

    @Test
    fun `should convert into FFF`() {
        (1.furlongs intoFFF FFFFurlongs) shouldBe 1.fffFurlongs
        (1.fortnights intoFFF FFFFortnights) shouldBe 1.fffFortnights
        (1.pounds intoFFF Firkins) shouldBe (1 over 90).firkins
    }
}
