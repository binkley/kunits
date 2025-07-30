package hm.binkley.kunits.system.discworld.lancre

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LancreTest {
    @Test
    fun `should pretty print`() {
        "$Lancre" shouldBe "Lancre"
    }
}
