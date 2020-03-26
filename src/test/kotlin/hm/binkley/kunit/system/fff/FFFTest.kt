package hm.binkley.kunit.system.fff

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FFFTest {
    @Test
    fun `should pretty print`() {
        assertEquals("FFF", "$FFF")
    }
}
