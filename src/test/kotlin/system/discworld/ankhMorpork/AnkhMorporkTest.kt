package hm.binkley.kunits.system.discworld.ankhMorpork

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AnkhMorporkTest {
    @Test
    fun `should pretty print`() {
        "$AnkhMorpork" shouldBe "Ankh-Morpork"
    }
}
