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

package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.weight.Clove.Cloves
import hm.binkley.kunits.system.english.weight.Dram.Drams
import hm.binkley.kunits.system.english.weight.HundredweightMeasure.Hundredweight
import hm.binkley.kunits.system.english.weight.Ounce.Ounces
import hm.binkley.kunits.system.english.weight.Pound.Pounds
import hm.binkley.kunits.system.english.weight.StoneMeasure.Stone
import hm.binkley.kunits.system.english.weight.Tod.Tods
import hm.binkley.kunits.system.english.weight.Tun.Tuns
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWeightsTest {
    @Test
    fun `should convert`() {
        1L.grains shouldBe 1.grains
        1L.drams shouldBe ((875 over 32).grains into Drams)
        1L.ounces shouldBe (16.drams into Ounces)
        1L.pounds shouldBe (16.ounces into Pounds)
        1L.cloves shouldBe (7.pounds into Cloves)
        1L.stone shouldBe (2.cloves into Stone)
        1L.tods shouldBe (2.stone into Tods)
        1L.hundredweight shouldBe (4.tods into Hundredweight)
        1L.tuns shouldBe (20.hundredweight into Tuns)
        1L.tuns shouldBe 1.tuns
    }

    @Test
    fun `should pretty print`() {
        "$Grain" shouldBe "English weight: grain"
        "${1.grains}" shouldBe "1 gr"
        "$Dram" shouldBe "English weight: dram"
        "${1.drams}" shouldBe "1 dr"
        "$Ounce" shouldBe "English weight: ounce"
        "${1.ounces}" shouldBe "1 oz"
        "$Pound" shouldBe "English weight: pound"
        "${1.pounds}" shouldBe "1 lb"
        "$Clove" shouldBe "English weight: clove"
        "${1.cloves}" shouldBe "1 cloves"
        "$Stone" shouldBe "English weight: stone"
        "${1.stone}" shouldBe "1 st"
        "$Tod" shouldBe "English weight: tod"
        "${1.tods}" shouldBe "1 tods"
        "$Hundredweight" shouldBe "English weight: hundredweight"
        "${1.hundredweight}" shouldBe "1 cwt"
        "$Tun" shouldBe "English weight: tun"
        "${1.tuns}" shouldBe "1 tuns"
    }
}
