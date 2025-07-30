package hm.binkley.kunits.system.discworld

import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Penny.Pence
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.pence
import hm.binkley.kunits.system.discworld.lancre.denomination.Penny.Pennies
import hm.binkley.kunits.system.discworld.lancre.denomination.pennies
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DiscworldTest {
    @Test
    fun `should pretty print`() {
        "$Discworld" shouldBe "Discworld"
    }

    @Test
    fun `should convert Ankh-Morpork money into Lancre money`() {
        (240.pence intoLancre Pennies) shouldBe 100.pennies
    }

    @Test
    fun `should convert Lancre money into Ankh-Morpork money`() {
        (100.pennies intoAnkhMorpork Pence) shouldBe 240.pence
    }
}
