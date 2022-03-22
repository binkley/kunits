package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.copper
import hm.binkley.kunits.system.dnd.denomination.other.Adamant.AdamantPieces
import hm.binkley.kunits.system.dnd.denomination.other.Bronze.BronzePieces
import hm.binkley.kunits.system.dnd.denomination.other.Mithral.MithralPieces
import hm.binkley.kunits.system.dnd.denomination.platinum
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OtherDnDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.bronze shouldBe ((1 over 10).copper into Bronze)
        1L.mithral shouldBe (10.platinum into Mithral)
        1L.adamant shouldBe (10.mithral into Adamant)
    }

    @Test
    fun `should pretty print`() {
        "$BronzePieces" shouldBe "D&D denomination: bronze piece"
        "${1.bronze}" shouldBe "1 bp"
        "$MithralPieces" shouldBe "D&D denomination: mithral piece"
        "${1.mithral}" shouldBe "1 mp"
        "$AdamantPieces" shouldBe "D&D denomination: adamant piece"
        "${1.adamant}" shouldBe "1 ap"
    }
}
