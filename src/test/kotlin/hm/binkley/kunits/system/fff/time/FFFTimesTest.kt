package hm.binkley.kunits.system.fff.time

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFTimesTest {
    @Test
    fun `should convert`() {
        1L.fortnights shouldBe 1.fortnights
    }

    @Test
    fun `should pretty print`() {
        "$Fortnight" shouldBe "Furlong-Firkin-Fortnight time: fortnight"
        "${1.fortnights}" shouldBe "1 ftn"
    }
}
