package hm.binkley.kunits.system.english

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishTest {
    @Test
    fun `should pretty print`() {
        "$English" shouldBe "English"
    }
}
