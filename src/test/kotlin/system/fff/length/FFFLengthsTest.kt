package hm.binkley.kunits.system.fff.length

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFLengthsTest {
    @Test
    fun `should convert`() {
        1L.furlongs shouldBe 1.furlongs
    }

    @Test
    fun `should pretty print`() {
        "$Furlong" shouldBe "Furlong-Firkin-Fortnight length: furlong"
        "${1.furlongs}" shouldBe "1 fur"
    }
}
