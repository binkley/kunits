package hm.binkley.kunits.system.fff

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FFFTest {
    @Test
    fun `should pretty print`() {
        "$FFF" shouldBe "FFF"
    }
}
