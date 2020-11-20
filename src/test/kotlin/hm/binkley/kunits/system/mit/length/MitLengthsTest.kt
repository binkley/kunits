package hm.binkley.kunits.system.mit.length

import hm.binkley.math.fixed.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MitLengthsTest {
    @Test
    fun `should convert`() {
        assertEquals(1.smoots.to(Ears), (67 over 3).ears)
        assertEquals(1L.smoots.to(Smoots), 1.smoots)

        assertEquals(1.ears.to(Ears), 1.ears)
        assertEquals(1L.ears.to(Smoots), (3 over 67).smoots)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("MIT smoot", "$Smoots")
        assertEquals("1 sm", "${1.smoots}")
        assertEquals("1 ear", "${1.ears}")
    }
}
