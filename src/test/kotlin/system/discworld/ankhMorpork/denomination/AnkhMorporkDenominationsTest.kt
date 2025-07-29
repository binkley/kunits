package hm.binkley.kunits.system.discworld.ankhMorpork.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Dollar.Dollars
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AnkhMorporkDenominationsTest {
    @Test
    fun `should convert`() {
        1L.pennies shouldBe 1.pennies
        1L.dollars shouldBe (240.pennies into Dollars)
    }

    @Test
    fun `should pretty print`() {
        "$Penny" shouldBe "Ankh-Morpork denomination: penny"
        "${1.pennies}" shouldBe "1p"
        "$Dollar" shouldBe "Ankh-Morpork denomination: dollar"
        "${1.dollars}" shouldBe "$1"
    }
}
