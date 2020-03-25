package hm.binkley.kunit.system.fff.time

import hm.binkley.kunit.div
import hm.binkley.kunit.minus
import hm.binkley.kunit.plus
import hm.binkley.kunit.times
import hm.binkley.kunit.unaryMinus
import hm.binkley.kunit.unaryPlus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffTimesTest {
    @Test
    fun `should convert`() {
        assertEquals(1.fortnights.to(Fortnights), 1.fortnights)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("1 ftn", "${1.fortnights}")
    }
}
