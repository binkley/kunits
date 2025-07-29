package hm.binkley.kunits.system.discworld.lancre.denomination

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LancreDenominationsTest {
    @Test
    fun `should convert`() {
        1L.pennies shouldBe 1.pennies
    }

    @Test
    fun `should pretty print`() {
        "$Penny" shouldBe "Lancre denomination: penny"
        "${1.pennies}" shouldBe "1 1¢"
    }
}
