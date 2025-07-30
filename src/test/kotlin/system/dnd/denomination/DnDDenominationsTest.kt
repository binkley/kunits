package hm.binkley.kunits.system.dnd.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.CopperPiece.CopperPieces
import hm.binkley.kunits.system.dnd.denomination.ElectrumPiece.ElectrumPieces
import hm.binkley.kunits.system.dnd.denomination.GoldPiece.GoldPieces
import hm.binkley.kunits.system.dnd.denomination.PlatinumPiece.PlatinumPieces
import hm.binkley.kunits.system.dnd.denomination.SilverPiece.SilverPieces
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DnDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.copperPieces shouldBe (1.copperPieces into CopperPieces)
        1L.silverPieces shouldBe (10.copperPieces into SilverPieces)
        1L.electrumPieces shouldBe (5.silverPieces into ElectrumPieces)
        1L.goldPieces shouldBe (2.electrumPieces into GoldPieces)
        1L.platinumPieces shouldBe (10.goldPieces into PlatinumPieces)
    }

    @Test
    fun `should pretty print`() {
        "$CopperPieces" shouldBe "D&D denomination: Copper Piece"
        "${1.copperPieces}" shouldBe "1 CP"
        "$SilverPieces" shouldBe "D&D denomination: Silver Piece"
        "${1.silverPieces}" shouldBe "1 SP"
        "$ElectrumPieces" shouldBe "D&D denomination: Electrum Piece"
        "${1.electrumPieces}" shouldBe "1 EP"
        "$GoldPieces" shouldBe "D&D denomination: Gold Piece"
        "${1.goldPieces}" shouldBe "1 GP"
        "$PlatinumPieces" shouldBe "D&D denomination: Platinum Piece"
        "${1.platinumPieces}" shouldBe "1 PP"
    }
}
