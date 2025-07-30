package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.copperPieces
import hm.binkley.kunits.system.dnd.denomination.other.AdamantPiece.AdamantPieces
import hm.binkley.kunits.system.dnd.denomination.other.BronzePiece.BronzePieces
import hm.binkley.kunits.system.dnd.denomination.other.MithrilPiece.MithrilPieces
import hm.binkley.kunits.system.dnd.denomination.platinumPieces
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OtherDnDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.bronzePieces shouldBe ((1 over 10).copperPieces into BronzePieces)
        1L.mithrilPieces shouldBe (10.platinumPieces into MithrilPieces)
        1L.adamantPieces shouldBe (10.mithrilPieces into AdamantPieces)
    }

    @Test
    fun `should pretty print`() {
        "$BronzePieces" shouldBe "D&D denomination: Bronze Piece"
        "${1.bronzePieces}" shouldBe "1 BP"
        "$MithrilPieces" shouldBe "D&D denomination: Mithril Piece"
        "${1.mithrilPieces}" shouldBe "1 MP"
        "$AdamantPieces" shouldBe "D&D denomination: Adamant Piece"
        "${1.adamantPieces}" shouldBe "1 AP"
    }
}
