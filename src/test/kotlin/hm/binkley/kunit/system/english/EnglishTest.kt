package hm.binkley.kunit.system.english

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class EnglishTest {
    @Test
    fun `should pretty print`() {
        assertEquals("English", "$English")
    }
}
