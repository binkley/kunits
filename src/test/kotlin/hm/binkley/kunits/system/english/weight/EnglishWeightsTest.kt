package hm.binkley.kunits.system.english.weight

import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.weight.Clove.Cloves
import hm.binkley.kunits.system.english.weight.Dram.Drams
import hm.binkley.kunits.system.english.weight.Grain.Grains
import hm.binkley.kunits.system.english.weight.Ounce.Ounces
import hm.binkley.kunits.system.english.weight.Pound.Pounds
import hm.binkley.kunits.system.english.weight.Tod.Tods
import hm.binkley.kunits.system.english.weight.Tun.Tuns
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWeightsTest {
    @Test
    fun `should convert`() {
        1L.grains shouldBe 1.grains
        1L.drams shouldBe ((875 over 32).grains into Drams)
        1L.ounces shouldBe (16.drams into Ounces)
        1L.pounds shouldBe (16.ounces into Pounds)
        1L.cloves shouldBe (7.pounds into Cloves)
        1L.stone shouldBe (2.cloves into Stone)
        1L.tods shouldBe (2.stone into Tods)
        1L.hundredweight shouldBe (4.tods into Hundredweight)
        1L.tuns shouldBe (20.hundredweight into Tuns)
        1L.tuns shouldBe 1.tuns
    }

    @Test
    fun `should pretty print`() {
        "$Grains" shouldBe "English grain"
        "${1.grains}" shouldBe "1 gr"
        "$Drams" shouldBe "English dram"
        "${1.drams}" shouldBe "1 dr"
        "$Ounces" shouldBe "English ounce"
        "${1.ounces}" shouldBe "1 oz"
        "$Pounds" shouldBe "English pound"
        "${1.pounds}" shouldBe "1 lb"
        "$Cloves" shouldBe "English clove"
        "${1.cloves}" shouldBe "1 cloves"
        "$Stone" shouldBe "English stone"
        "${1.stone}" shouldBe "1 st"
        "$Tods" shouldBe "English tod"
        "${1.tods}" shouldBe "1 tods"
        "$Hundredweight" shouldBe "English hundredweight"
        "${1.hundredweight}" shouldBe "1 cwt"
        "$Tuns" shouldBe "English tun"
        "${1.tuns}" shouldBe "1 tuns"
    }
}
