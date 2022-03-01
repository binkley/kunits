package hm.binkley.kunits.system.english.weight

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWeightsTest {
    @Test
    fun `should convert`() {
        1L.grains shouldBe 1.grains
        1.grains.drams shouldBe (32 over 875).drams
        1.grains.ounces shouldBe (2 over 875).ounces
        1.grains.pounds shouldBe (1 over 7000).pounds
        1.grains.cloves shouldBe (1 over 49_000).cloves
        1.grains.stone shouldBe (1 over 98_000).stone
        1.grains.tods shouldBe (1 over 196_000).tods
        1.grains.hundredweight shouldBe (1 over 784_000).hundredweight
        1.grains.tons shouldBe (1 over 15_680_000).tons

        (875 over 32).grains shouldBe 1.drams.grains
        1L.drams shouldBe 1.drams
        1.drams.ounces shouldBe (1 over 16).ounces
        1.drams.pounds shouldBe (1 over 256).pounds
        1.drams.cloves shouldBe (1 over 1_792).cloves
        1.drams.stone shouldBe (1 over 3_584).stone
        1.drams.tods shouldBe (1 over 7_168).tods
        1.drams.hundredweight shouldBe (1 over 28_672).hundredweight
        1.drams.tons shouldBe (1 over 573_440).tons

        (875 over 2).grains shouldBe 1.ounces.grains
        16.drams shouldBe 1.ounces.drams
        1L.ounces shouldBe 1.ounces
        1.ounces.pounds shouldBe (1 over 16).pounds
        1.ounces.cloves shouldBe (1 over 112).cloves
        1.ounces.stone shouldBe (1 over 224).stone
        1.ounces.tods shouldBe (1 over 448).tods
        1.ounces.hundredweight shouldBe (1 over 1_792).hundredweight
        1.ounces.tons shouldBe (1 over 35_840).tons

        7000.grains shouldBe 1.pounds.grains
        256.drams shouldBe 1.pounds.drams
        16.ounces shouldBe 1.pounds.ounces
        1L.pounds shouldBe 1.pounds
        1.pounds.cloves shouldBe (1 over 7).cloves
        1.pounds.stone shouldBe (1 over 14).stone
        1.pounds.tods shouldBe (1 over 28).tods
        1.pounds.hundredweight shouldBe (1 over 112).hundredweight
        1.pounds.tons shouldBe (1 over 2_240).tons

        49_000.grains shouldBe 1.cloves.grains
        1_792.drams shouldBe 1.cloves.drams
        112.ounces shouldBe 1.cloves.ounces
        7.pounds shouldBe 1.cloves.pounds
        1L.cloves shouldBe 1.cloves
        1.cloves.stone shouldBe (1 over 2).stone
        1.cloves.tods shouldBe (1 over 4).tods
        1.cloves.hundredweight shouldBe (1 over 16).hundredweight
        1.cloves.tons shouldBe (1 over 320).tons

        98_000.grains shouldBe 1.stone.grains
        3_584.drams shouldBe 1.stone.drams
        224.ounces shouldBe 1.stone.ounces
        14.pounds shouldBe 1.stone.pounds
        2.cloves shouldBe 1.stone.cloves
        1L.stone shouldBe 1.stone
        1.stone.tods shouldBe (1 over 2).tods
        1.stone.hundredweight shouldBe (1 over 8).hundredweight
        1.stone.tons shouldBe (1 over 160).tons

        196_000.grains shouldBe 1.tods.grains
        7_168.drams shouldBe 1.tods.drams
        448.ounces shouldBe 1.tods.ounces
        28.pounds shouldBe 1.tods.pounds
        4.cloves shouldBe 1.tods.cloves
        2.stone shouldBe 1.tods.stone
        1L.tods shouldBe 1.tods
        1.tods.hundredweight shouldBe (1 over 4).hundredweight
        1.tods.tons shouldBe (1 over 80).tons

        784_000.grains shouldBe 1.hundredweight.grains
        28_672.drams shouldBe 1.hundredweight.drams
        1_792.ounces shouldBe 1.hundredweight.ounces
        112.pounds shouldBe 1.hundredweight.pounds
        16.cloves shouldBe 1.hundredweight.cloves
        8.stone shouldBe 1.hundredweight.stone
        4.tods shouldBe 1.hundredweight.tods
        1L.hundredweight shouldBe 1.hundredweight
        1.hundredweight.tons shouldBe (1 over 20).tons

        15_680_000.grains shouldBe 1.tons.grains
        573_440.drams shouldBe 1.tons.drams
        35_840.ounces shouldBe 1.tons.ounces
        2_240.pounds shouldBe 1.tons.pounds
        320.cloves shouldBe 1.tons.cloves
        160.stone shouldBe 1.tons.stone
        80.tods shouldBe 1.tons.tods
        20.hundredweight shouldBe 1.tons.hundredweight
        1L.tons shouldBe 1.tons
    }

    @Test
    fun `should pretty print`() {
        "$Grains" shouldBe "English grains"
        "${1.grains}" shouldBe "1 gr"
        "$Drams" shouldBe "English drams"
        "${1.drams}" shouldBe "1 dr"
        "$Ounces" shouldBe "English ounces"
        "${1.ounces}" shouldBe "1 oz"
        "$Pounds" shouldBe "English pounds"
        "${1.pounds}" shouldBe "1 lb"
        "$Cloves" shouldBe "English cloves"
        "${1.cloves}" shouldBe "1 cloves"
        "$Stone" shouldBe "English stone"
        "${1.stone}" shouldBe "1 st"
        "$Tods" shouldBe "English tods"
        "${1.tods}" shouldBe "1 tods"
        "$Hundredweight" shouldBe "English hundredweight"
        "${1.hundredweight}" shouldBe "1 cwt"
        "$Tons" shouldBe "English tons"
        "${1.tons}" shouldBe "1 tons"
    }
}
