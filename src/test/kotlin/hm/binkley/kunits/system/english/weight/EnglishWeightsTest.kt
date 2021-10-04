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
        1.drams.stone shouldBe (1 over 3584).stone

        16.drams shouldBe 1.ounces.drams
        1L.ounces shouldBe 1.ounces
        1.ounces.pounds shouldBe (1 over 16).pounds
        1.ounces.stone shouldBe (1 over 224).stone

        256.drams shouldBe 1.pounds.drams
        16.ounces shouldBe 1.pounds.ounces
        1L.pounds shouldBe 1.pounds
        1.pounds.stone shouldBe (1 over 14).stone

        3584.drams shouldBe 1.stone.drams
        224.ounces shouldBe 1.stone.ounces
        14.pounds shouldBe 1.stone.pounds
        1L.stone shouldBe 1.stone
    }

    @Test
    fun `should pretty print`() {
        "$Drams" shouldBe "English drams"
        "${1.drams}" shouldBe "1 dr"
        "$Ounces" shouldBe "English ounces"
        "${1.ounces}" shouldBe "1 oz"
        "$Pounds" shouldBe "English pounds"
        "${1.pounds}" shouldBe "1 lb"
        "$Stone" shouldBe "English stone"
        "${1.stone}" shouldBe "1 st"
    }
}
