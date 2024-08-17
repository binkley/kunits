package hm.binkley.kunits.system.dnd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DnDTest {
    @Test
    fun `should pretty print`() {
        "$DnD" shouldBe "D&D"
    }
}
