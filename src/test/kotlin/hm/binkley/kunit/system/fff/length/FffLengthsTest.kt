package hm.binkley.kunit.system.fff.length

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffLengthsTest {
    @Test
    fun `should convert`() {
        assertEquals(1.furlongs.to(Furlongs), 1.furlongs)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("FFF furlong", "$Furlongs")
        assertEquals("1 fur", "${1.furlongs}")
    }
}
