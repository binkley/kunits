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

package hm.binkley.kunits.system.english.volume.wine

import hm.binkley.kunits.into
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWineVolumesTest {
    @Test
    fun `should convert`() {
        1L.tuns shouldBe 1.tuns
        1L.pipes shouldBe ((1 over 2).tuns into Pipe)
        1L.puncheons shouldBe ((1 over 3).tuns into Puncheon)
        1L.hogsheads shouldBe ((1 over 4).tuns into Hogshead)
        1L.tierces shouldBe ((1 over 6).tuns into Tierce)
        1L.wineBarrels shouldBe ((1 over 8).tuns into WineBarrel)
        1L.rundlets shouldBe ((1 over 14).tuns into Rundlet)
    }

    @Test
    fun `should pretty print`() {
        "$Tun" shouldBe "English volume: tun"
        "${1.tuns}" shouldBe "1 tuns"
        "$Pipe" shouldBe "English volume: pipe"
        "${1.pipes}" shouldBe "1 pipes"
        "$Puncheon" shouldBe "English volume: puncheon"
        "${1.puncheons}" shouldBe "1 puncheons"
        "$Hogshead" shouldBe "English volume: hogshead"
        "${1.hogsheads}" shouldBe "1 hhd"
        "${2.hogsheads}" shouldBe "2 hhds"
        "$Tierce" shouldBe "English volume: tierce"
        "${1.tierces}" shouldBe "1 tierces"
        "$WineBarrel" shouldBe "English volume: wine barrel"
        "${1.wineBarrels}" shouldBe "1 wine barrels"
        "$Rundlet" shouldBe "English volume: rundlet"
        "${1.rundlets}" shouldBe "1 rundlets"
    }
}
