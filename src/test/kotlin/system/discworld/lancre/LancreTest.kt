package hm.binkley.kunits.system.discworld.lancre

import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Dollar.Dollars
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.dollars
import hm.binkley.kunits.system.discworld.lancre.denomination.pennies
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LancreTest {
    @Test
    fun `should pretty print`() {
        "$Lancre" shouldBe "Lancre"
    }

    @Test
    fun `should convert into Ankh-Morpork`() {
        (100.pennies intoAnkhMorpork Dollars) shouldBe 1.dollars
    }
}
