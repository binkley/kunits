package hm.binkley.kunits.system.english.weight

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWeightsTest {
    @Test
    fun `should convert`() {
        1L.grains shouldBe 1.grains
        (32 over 875).drams shouldBe 1.grains.drams
        (2 over 875).ounces shouldBe 1.grains.ounces
        (1 over 7000).pounds shouldBe 1.grains.pounds
        (1 over 49_000).cloves shouldBe 1.grains.cloves
        (1 over 98_000).stone shouldBe 1.grains.stone
        (1 over 196_000).tods shouldBe 1.grains.tods
        (1 over 784_000).hundredweight shouldBe 1.grains.hundredweight
        (1 over 15_680_000).tuns shouldBe 1.grains.tuns

        (875 over 32).grains shouldBe 1.drams.grains
        1L.drams shouldBe 1.drams
        (1 over 16).ounces shouldBe 1.drams.ounces
        (1 over 256).pounds shouldBe 1.drams.pounds
        (1 over 1_792).cloves shouldBe 1.drams.cloves
        (1 over 3_584).stone shouldBe 1.drams.stone
        (1 over 7_168).tods shouldBe 1.drams.tods
        (1 over 28_672).hundredweight shouldBe 1.drams.hundredweight
        (1 over 573_440).tuns shouldBe 1.drams.tuns

        (875 over 2).grains shouldBe 1.ounces.grains
        16.drams shouldBe 1.ounces.drams
        1L.ounces shouldBe 1.ounces
        (1 over 16).pounds shouldBe 1.ounces.pounds
        (1 over 112).cloves shouldBe 1.ounces.cloves
        (1 over 224).stone shouldBe 1.ounces.stone
        (1 over 448).tods shouldBe 1.ounces.tods
        (1 over 1_792).hundredweight shouldBe 1.ounces.hundredweight
        (1 over 35_840).tuns shouldBe 1.ounces.tuns

        7000.grains shouldBe 1.pounds.grains
        256.drams shouldBe 1.pounds.drams
        16.ounces shouldBe 1.pounds.ounces
        1L.pounds shouldBe 1.pounds
        (1 over 7).cloves shouldBe 1.pounds.cloves
        (1 over 14).stone shouldBe 1.pounds.stone
        (1 over 28).tods shouldBe 1.pounds.tods
        (1 over 112).hundredweight shouldBe 1.pounds.hundredweight
        (1 over 2_240).tuns shouldBe 1.pounds.tuns

        49_000.grains shouldBe 1.cloves.grains
        1_792.drams shouldBe 1.cloves.drams
        112.ounces shouldBe 1.cloves.ounces
        7.pounds shouldBe 1.cloves.pounds
        1L.cloves shouldBe 1.cloves
        (1 over 2).stone shouldBe 1.cloves.stone
        (1 over 4).tods shouldBe 1.cloves.tods
        (1 over 16).hundredweight shouldBe 1.cloves.hundredweight
        (1 over 320).tuns shouldBe 1.cloves.tuns

        98_000.grains shouldBe 1.stone.grains
        3_584.drams shouldBe 1.stone.drams
        224.ounces shouldBe 1.stone.ounces
        14.pounds shouldBe 1.stone.pounds
        2.cloves shouldBe 1.stone.cloves
        1L.stone shouldBe 1.stone
        (1 over 2).tods shouldBe 1.stone.tods
        (1 over 8).hundredweight shouldBe 1.stone.hundredweight
        (1 over 160).tuns shouldBe 1.stone.tuns

        196_000.grains shouldBe 1.tods.grains
        7_168.drams shouldBe 1.tods.drams
        448.ounces shouldBe 1.tods.ounces
        28.pounds shouldBe 1.tods.pounds
        4.cloves shouldBe 1.tods.cloves
        2.stone shouldBe 1.tods.stone
        1L.tods shouldBe 1.tods
        (1 over 4).hundredweight shouldBe 1.tods.hundredweight
        (1 over 80).tuns shouldBe 1.tods.tuns

        784_000.grains shouldBe 1.hundredweight.grains
        28_672.drams shouldBe 1.hundredweight.drams
        1_792.ounces shouldBe 1.hundredweight.ounces
        112.pounds shouldBe 1.hundredweight.pounds
        16.cloves shouldBe 1.hundredweight.cloves
        8.stone shouldBe 1.hundredweight.stone
        4.tods shouldBe 1.hundredweight.tods
        1L.hundredweight shouldBe 1.hundredweight
        (1 over 20).tuns shouldBe 1.hundredweight.tuns

        15_680_000.grains shouldBe 1.tuns.grains
        573_440.drams shouldBe 1.tuns.drams
        35_840.ounces shouldBe 1.tuns.ounces
        2_240.pounds shouldBe 1.tuns.pounds
        320.cloves shouldBe 1.tuns.cloves
        160.stone shouldBe 1.tuns.stone
        80.tods shouldBe 1.tuns.tods
        20.hundredweight shouldBe 1.tuns.hundredweight
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
