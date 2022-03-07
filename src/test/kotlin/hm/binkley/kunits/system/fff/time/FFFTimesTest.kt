package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.system.fff.time.Fortnight.Fortnights
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFTimesTest {
    @Test
    fun `should convert`() {
        1L.fortnights shouldBe 1.fortnights
    }

    @Test
    fun `should pretty print`() {
        "$Fortnights" shouldBe "Furlong-Firkin-Fortnight fortnight"
        "${1.fortnights}" shouldBe "1 ftn"
    }
}
