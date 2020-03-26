package hm.binkley.kunits.system.fff.time

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffTimesTest {
    @Test
    fun `should convert`() {
        assertEquals(1.fortnights.to(Fortnights), 1.fortnights)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("FFF fortnight", "$Fortnights")
        assertEquals("1 ftn", "${1.fortnights}")
    }
}
