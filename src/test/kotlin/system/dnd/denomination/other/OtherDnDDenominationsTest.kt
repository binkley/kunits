package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.copper
import hm.binkley.kunits.system.dnd.denomination.other.Adamant.AdamantPieces
import hm.binkley.kunits.system.dnd.denomination.other.Bronze.BronzePieces
import hm.binkley.kunits.system.dnd.denomination.other.Mithril.MithrilPieces
import hm.binkley.kunits.system.dnd.denomination.platinum
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OtherDnDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.bronze shouldBe ((1 over 10).copper into BronzePieces)
        1L.mithril shouldBe (10.platinum into MithrilPieces)
        1L.adamant shouldBe (10.mithril into AdamantPieces)
    }

    @Test
    fun `should pretty print`() {
        "$BronzePieces" shouldBe "D&D denomination: bronze piece"
        "${1.bronze}" shouldBe "1 bp"
        "$MithrilPieces" shouldBe "D&D denomination: mithril piece"
        "${1.mithril}" shouldBe "1 mp"
        "$AdamantPieces" shouldBe "D&D denomination: adamant piece"
        "${1.adamant}" shouldBe "1 ap"
    }
}
