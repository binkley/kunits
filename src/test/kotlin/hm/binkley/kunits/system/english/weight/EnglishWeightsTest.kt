package hm.binkley.kunits.system.english.weight

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWeightsTest {
    @Test
    fun `should convert`() {
        1L.scruples shouldBe 1.scruples
        1.scruples.drams shouldBe (1 over 3).drams
        1.scruples.ounces shouldBe (1 over 48).ounces
        1.scruples.pounds shouldBe (1 over 768).pounds

        3.scruples shouldBe 1.drams.scruples
        1L.drams shouldBe 1.drams
        1.drams.ounces shouldBe (1 over 16).ounces
        1.drams.pounds shouldBe (1 over 256).pounds

        48.scruples shouldBe 1.ounces.scruples
        16.drams shouldBe 1.ounces.drams
        1L.ounces shouldBe 1.ounces
        1.ounces.pounds shouldBe (1 over 16).pounds

        768.scruples shouldBe 1.pounds.scruples
        256.drams shouldBe 1.pounds.drams
        16.ounces shouldBe 1.pounds.ounces
        1L.pounds shouldBe 1.pounds
    }

    @Test
    fun `should pretty print`() {
        "$Scruples" shouldBe "English scruples"
        "${1.scruples}" shouldBe "1 scruples"
        "$Drams" shouldBe "English drams"
        "${1.drams}" shouldBe "1 dr"
        "$Ounces" shouldBe "English ounces"
        "${1.ounces}" shouldBe "1 oz"
        "$Pounds" shouldBe "English pounds"
        "${1.pounds}" shouldBe "1 lb"
    }
}
