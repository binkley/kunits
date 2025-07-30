package hm.binkley.kunits.system.fff.area

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFAreasTest {
    @Test
    fun `should convert`() {
        1L.footFathoms shouldBe 1.footFathoms
    }

    @Test
    fun `should pretty print`() {
        "$FootFathom" shouldBe
            "Furlong-Firkin-Fortnight area: foot-fathom"
        "${1.footFathoms}" shouldBe "1 ft-fath"
    }
}
