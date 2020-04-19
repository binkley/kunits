package hm.binkley.kunits.system.mit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MITTest {
    @Test
    fun `should pretty print`() {
        assertEquals("MIT", "$MIT")
    }
}
