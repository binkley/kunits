package hm.binkley.kunits.system.dnd.denomination.other

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.other.Mithral.MithralPieces
import hm.binkley.kunits.system.dnd.denomination.platinum
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OtherDnDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.mithral shouldBe (10.platinum into Mithral)
    }

    @Test
    fun `should pretty print`() {
        "$MithralPieces" shouldBe "D&D denomination: mithral piece"
        "${1.mithral}" shouldBe "1 mp"
    }
}
