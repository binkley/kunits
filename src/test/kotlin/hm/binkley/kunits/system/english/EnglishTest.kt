package hm.binkley.kunits.system.english

import hm.binkley.kunits.system.english.length.furlongs
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs as FFFFurlongs
import hm.binkley.kunits.system.fff.length.furlongs as fffFurlongs

internal class EnglishTest {
    @Test
    fun `should pretty print`() {
        "$English" shouldBe "English"
    }

    @Test
    fun `should convert into FFF`() {
        (1.furlongs intoFFF FFFFurlongs) shouldBe 1.fffFurlongs
    }
}
