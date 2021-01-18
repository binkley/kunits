package hm.binkley.kunits.system.mit

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MITTest {
    @Test
    fun `should pretty print`() {
        "$MIT" shouldBe "MIT"
    }
}
