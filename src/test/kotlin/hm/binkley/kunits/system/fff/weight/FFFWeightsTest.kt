package hm.binkley.kunits.system.fff.weight

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFWeightsTest {
    @Test
    fun `should convert`() {
        1L.firkins shouldBe 1.firkins
    }

    @Test
    fun `should pretty print`() {
        "$Firkin" shouldBe "Furlong-Firkin-Fortnight weight: firkin"
        "${1.firkins}" shouldBe "1 fir"
    }
}
