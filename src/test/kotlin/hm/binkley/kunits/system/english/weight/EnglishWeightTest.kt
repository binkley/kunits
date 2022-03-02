package hm.binkley.kunits.system.english.weight

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
import hm.binkley.kunits.into

internal class EnglishWeightTest {
    @Test
    fun `should convert`() {
        1L.grains shouldBe 1.grains
        (32 over 875).drams shouldBe (1.grains into Drams)
        (2 over 875).ounces shouldBe (1.grains into Ounces)
        (1 over 7000).pounds shouldBe (1.grains into Pounds)
        (1 over 49_000).cloves shouldBe (1.grains into Cloves)
        (1 over 98_000).stone shouldBe (1.grains into Stone)
        (1 over 196_000).tods shouldBe (1.grains into Tods)
        (1 over 784_000).hundredweight shouldBe (1.grains into Hundredweight)
        (1 over 15_680_000).tuns shouldBe (1.grains into Tuns)

        (875 over 32).grains shouldBe (1.drams into Grains)
        1L.drams shouldBe 1.drams
        (1 over 16).ounces shouldBe (1.drams into Ounces)
        (1 over 256).pounds shouldBe (1.drams into Pounds)
        (1 over 1_792).cloves shouldBe (1.drams into Cloves)
        (1 over 3_584).stone shouldBe (1.drams into Stone)
        (1 over 7_168).tods shouldBe (1.drams into Tods)
        (1 over 28_672).hundredweight shouldBe (1.drams into Hundredweight)
        (1 over 573_440).tuns shouldBe (1.drams into Tuns)

        (875 over 2).grains shouldBe (1.ounces into Grains)
        16.drams shouldBe (1.ounces into Drams)
        1L.ounces shouldBe 1.ounces
        (1 over 16).pounds shouldBe (1.ounces into Pounds)
        (1 over 112).cloves shouldBe (1.ounces into Cloves)
        (1 over 224).stone shouldBe (1.ounces into Stone)
        (1 over 448).tods shouldBe (1.ounces into Tods)
        (1 over 1_792).hundredweight shouldBe (1.ounces into Hundredweight)
        (1 over 35_840).tuns shouldBe (1.ounces into Tuns)

        7000.grains shouldBe (1.pounds into Grains)
        256.drams shouldBe (1.pounds into Drams)
        16.ounces shouldBe (1.pounds into Ounces)
        1L.pounds shouldBe 1.pounds
        (1 over 7).cloves shouldBe (1.pounds into Cloves)
        (1 over 14).stone shouldBe (1.pounds into Stone)
        (1 over 28).tods shouldBe (1.pounds into Tods)
        (1 over 112).hundredweight shouldBe (1.pounds into Hundredweight)
        (1 over 2_240).tuns shouldBe (1.pounds into Tuns)

        49_000.grains shouldBe (1.cloves into Grains)
        1_792.drams shouldBe (1.cloves into Drams)
        112.ounces shouldBe (1.cloves into Ounces)
        7.pounds shouldBe (1.cloves into Pounds)
        1L.cloves shouldBe 1.cloves
        (1 over 2).stone shouldBe (1.cloves into Stone)
        (1 over 4).tods shouldBe (1.cloves into Tods)
        (1 over 16).hundredweight shouldBe (1.cloves into Hundredweight)
        (1 over 320).tuns shouldBe (1.cloves into Tuns)

        98_000.grains shouldBe (1.stone into Grains)
        3_584.drams shouldBe (1.stone into Drams)
        224.ounces shouldBe (1.stone into Ounces)
        14.pounds shouldBe (1.stone into Pounds)
        2.cloves shouldBe (1.stone into Cloves)
        1L.stone shouldBe 1.stone
        (1 over 2).tods shouldBe (1.stone into Tods)
        (1 over 8).hundredweight shouldBe (1.stone into Hundredweight)
        (1 over 160).tuns shouldBe (1.stone into Tuns)

        196_000.grains shouldBe (1.tods into Grains)
        7_168.drams shouldBe (1.tods into Drams)
        448.ounces shouldBe (1.tods into Ounces)
        28.pounds shouldBe (1.tods into Pounds)
        4.cloves shouldBe (1.tods into Cloves)
        2.stone shouldBe (1.tods into Stone)
        1L.tods shouldBe 1.tods
        (1 over 4).hundredweight shouldBe (1.tods into Hundredweight)
        (1 over 80).tuns shouldBe (1.tods into Tuns)

        784_000.grains shouldBe (1.hundredweight into Grains)
        28_672.drams shouldBe (1.hundredweight into Drams)
        1_792.ounces shouldBe (1.hundredweight into Ounces)
        112.pounds shouldBe (1.hundredweight into Pounds)
        16.cloves shouldBe (1.hundredweight into Cloves)
        8.stone shouldBe (1.hundredweight into Stone)
        4.tods shouldBe (1.hundredweight into Tods)
        1L.hundredweight shouldBe 1.hundredweight
        (1 over 20).tuns shouldBe (1.hundredweight into Tuns)

        15_680_000.grains shouldBe (1.tuns into Grains)
        573_440.drams shouldBe (1.tuns into Drams)
        35_840.ounces shouldBe (1.tuns into Ounces)
        2_240.pounds shouldBe (1.tuns into Pounds)
        320.cloves shouldBe (1.tuns into Cloves)
        160.stone shouldBe (1.tuns into Stone)
        80.tods shouldBe (1.tuns into Tods)
        20.hundredweight shouldBe (1.tuns into Hundredweight)
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
