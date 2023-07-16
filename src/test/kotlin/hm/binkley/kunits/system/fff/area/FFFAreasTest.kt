package hm.binkley.kunits.system.fff.area

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFAreasTest {
    @Test
    fun `should convert`() {
        1L.footFathom shouldBe 1.footFathom
    }

    @Test
    fun `should pretty print`() {
        "$FootFathomMeasure" shouldBe
            "Furlong-Firkin-Fortnight area: foot-fathom"
        "${1.footFathom}" shouldBe "1 ft-fath"
    }
}
