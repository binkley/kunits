package hm.binkley.kunits.system.fff

import hm.binkley.kunits.system.fff.length.furlongs
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import hm.binkley.kunits.system.english.length.Furlong.Furlongs as EnglishFurlongs
import hm.binkley.kunits.system.english.length.furlongs as englishFurlongs

internal class FFFTest {
    @Test
    fun `should pretty print`() {
        "$FFF" shouldBe "FFF"
    }

    @Test
    fun `should convert into English`() {
        (1.furlongs intoEnglish EnglishFurlongs) shouldBe 1.englishFurlongs
    }
}
