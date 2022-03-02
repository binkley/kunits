package hm.binkley.kunits.system.fff.time

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFTimeTest {
    @Test
    fun `should convert`() {
        1.fortnights.into(Fortnights) shouldBe 1L.fortnights
    }

    @Test
    fun `should pretty print`() {
        "$Fortnights" shouldBe "FFF fortnight"
        "${1.fortnights}" shouldBe "1 ftn"
    }
}
