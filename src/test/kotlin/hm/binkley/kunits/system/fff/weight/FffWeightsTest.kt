package hm.binkley.kunits.system.fff.weight

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FffWeightsTest {
    @Test
    fun `should convert`() {
        1.firkins.convertTo(Firkins) shouldBe 1L.firkins
    }

    @Test
    fun `should pretty print`() {
        "$Firkins" shouldBe "FFF firkin"
        "${1.firkins}" shouldBe "1 fir"
    }
}
