package hm.binkley.kunits.system.mit

import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.inches
import hm.binkley.kunits.system.mit.length.smoots
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MITTest {
    @Test
    fun `should pretty print`() {
        "$MIT" shouldBe "MIT"
    }

    @Test
    fun `should convert into English`() {
        (1.smoots intoEnglish Inches) shouldBe 67.inches
    }
}
