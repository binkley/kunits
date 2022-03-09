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
        "$CopperPieces" shouldBe "D&D copper piece"
        "${1.copper}" shouldBe "1 cp"
        "$SilverPieces" shouldBe "D&D silver piece"
        "${1.silver}" shouldBe "1 sp"
        "$ElectrumPieces" shouldBe "D&D electrum piece"
        "${1.electrum}" shouldBe "1 ep"
        "$GoldPieces" shouldBe "D&D gold piece"
        "${1.gold}" shouldBe "1 gp"
        "$PlatinumPieces" shouldBe "D&D platinum piece"
        "${1.platinum}" shouldBe "1 pp"
    }
}
