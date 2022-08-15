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

package hm.binkley.kunits.system.dnd.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.Copper.CopperPieces
import hm.binkley.kunits.system.dnd.denomination.Electrum.ElectrumPieces
import hm.binkley.kunits.system.dnd.denomination.Gold.GoldPieces
import hm.binkley.kunits.system.dnd.denomination.Platinum.PlatinumPieces
import hm.binkley.kunits.system.dnd.denomination.Silver.SilverPieces
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DnDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.copper shouldBe (1.copper into CopperPieces)
        1L.silver shouldBe (10.copper into SilverPieces)
        1L.electrum shouldBe (5.silver into ElectrumPieces)
        1L.gold shouldBe (2.electrum into GoldPieces)
        1L.platinum shouldBe (10.gold into PlatinumPieces)
    }

    @Test
    fun `should pretty print`() {
        "$CopperPieces" shouldBe "D&D denomination: copper piece"
        "${1.copper}" shouldBe "1 cp"
        "$SilverPieces" shouldBe "D&D denomination: silver piece"
        "${1.silver}" shouldBe "1 sp"
        "$ElectrumPieces" shouldBe "D&D denomination: electrum piece"
        "${1.electrum}" shouldBe "1 ep"
        "$GoldPieces" shouldBe "D&D denomination: gold piece"
        "${1.gold}" shouldBe "1 gp"
        "$PlatinumPieces" shouldBe "D&D denomination: platinum piece"
        "${1.platinum}" shouldBe "1 pp"
    }
}
