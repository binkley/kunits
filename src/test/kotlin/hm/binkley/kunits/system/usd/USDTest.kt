package hm.binkley.kunits.system.usd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class USDTest {
    @Test
    fun `should pretty print`() {
        "$USD" shouldBe "USD"
    }
}
