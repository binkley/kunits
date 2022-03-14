package hm.binkley.kunits.system.english

import hm.binkley.kunits.system.english.length.furlongs
import hm.binkley.kunits.system.english.weight.pounds
import hm.binkley.kunits.system.fff.weight.Firkin.Firkins
import hm.binkley.kunits.system.fff.weight.firkins
import hm.binkley.math.fixed.over
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
        (1.pounds intoFFF Firkins) shouldBe (1 over 90).firkins
    }
}
