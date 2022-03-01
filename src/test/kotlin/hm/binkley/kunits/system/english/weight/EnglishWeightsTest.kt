package hm.binkley.kunits.system.english.weight

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWeightsTest {
    @Test
    fun `should convert`() {
        1L.drams shouldBe 1.drams
        1.drams.ounces shouldBe (1 over 16).ounces
        1.drams.pounds shouldBe (1 over 256).pounds
        1.drams.cloves shouldBe (1 over 1_792).cloves
        1.drams.stone shouldBe (1 over 3_584).stone
        1.drams.tods shouldBe (1 over 7_168).tods

        16.drams shouldBe 1.ounces.drams
        1L.ounces shouldBe 1.ounces
        1.ounces.pounds shouldBe (1 over 16).pounds
        1.ounces.cloves shouldBe (1 over 112).cloves
        1.ounces.stone shouldBe (1 over 224).stone
        1.ounces.tods shouldBe (1 over 448).tods

        256.drams shouldBe 1.pounds.drams
        16.ounces shouldBe 1.pounds.ounces
        1L.pounds shouldBe 1.pounds
        1.pounds.cloves shouldBe (1 over 7).cloves
        1.pounds.stone shouldBe (1 over 14).stone
        1.pounds.tods shouldBe (1 over 28).tods

        1_792.drams shouldBe 1.cloves.drams
        112.ounces shouldBe 1.cloves.ounces
        7.pounds shouldBe 1.cloves.pounds
        1L.cloves shouldBe 1.cloves
        1.cloves.stone shouldBe (1 over 2).stone
        1.cloves.tods shouldBe (1 over 4).tods

        3_584.drams shouldBe 1.stone.drams
        224.ounces shouldBe 1.stone.ounces
        14.pounds shouldBe 1.stone.pounds
        2.cloves shouldBe 1.stone.cloves
        1L.stone shouldBe 1.stone
        1.stone.tods shouldBe (1 over 2).tods

        7_168.drams shouldBe 1.tods.drams
        448.ounces shouldBe 1.tods.ounces
        28.pounds shouldBe 1.tods.pounds
        4.cloves shouldBe 1.tods.cloves
        2.stone shouldBe 1.tods.stone
        1L.tods shouldBe 1.tods
    }

    @Test
    fun `should pretty print`() {
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
    }
}
