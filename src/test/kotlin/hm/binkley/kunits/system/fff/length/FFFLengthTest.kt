package hm.binkley.kunits.system.fff.length

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFLengthTest {
    @Test
    fun `should convert`() {
        1L.furlongs shouldBe 1.furlongs
    }

    @Test
    fun `should pretty print`() {
        "$Furlongs" shouldBe "Furlong-Firkin-Fortnight furlong"
        "${1.furlongs}" shouldBe "1 fur"
    }
}
