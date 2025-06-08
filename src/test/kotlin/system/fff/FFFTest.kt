package hm.binkley.kunits.system.fff

import hm.binkley.kunits.system.english.weight.Pound.Pounds
import hm.binkley.kunits.system.english.weight.pounds
import hm.binkley.kunits.system.fff.length.furlongs
import hm.binkley.kunits.system.fff.time.fortnights
import hm.binkley.kunits.system.fff.weight.firkins
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import hm.binkley.kunits.system.english.length.Furlong.Furlongs as EnglishFurlongs
import hm.binkley.kunits.system.english.length.furlongs as englishFurlongs
import hm.binkley.kunits.system.english.time.Fortnight.Fortnights as EnglishFortnights
import hm.binkley.kunits.system.english.time.fortnights as englishFortnights

internal class FFFTest {
    @Test
    fun `should pretty print`() {
        "$FFF" shouldBe "Furlong-Firkin-Fortnight"
    }

    @Test
    fun `should convert into English`() {
        (1.furlongs intoEnglish EnglishFurlongs) shouldBe 1.englishFurlongs
        (1.fortnights intoEnglish EnglishFortnights) shouldBe
            1.englishFortnights
        (1.firkins intoEnglish Pounds) shouldBe 90.pounds
    }
}
