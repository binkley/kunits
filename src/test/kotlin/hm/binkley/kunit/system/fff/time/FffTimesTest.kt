package hm.binkley.kunit.system.fff.time

import hm.binkley.kunit.div
import hm.binkley.kunit.minus
import hm.binkley.kunit.plus
import hm.binkley.kunit.times
import hm.binkley.kunit.unaryMinus
import hm.binkley.kunit.unaryPlus
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffTimesTest {
    @Test
    fun `should convert`() {
        assertEquals(1.fortnights.to(Fortnights), 1.fortnights)
    }

    @Test
    fun `should posite`() {
        assertEquals((+1).fortnights, +(1.fortnights))
    }

    @Test
    fun `should negate`() {
        assertEquals((-1).fortnights, -(1.fortnights))
    }

    @Test
    fun `should add`() {
        assertEquals(3.fortnights, 1.fortnights + 2.fortnights)
        assertEquals((3 over 1).fortnights + 4.fortnights, 7.fortnights)
    }

    @Test
    fun `should subtract`() {
        assertEquals(1.fortnights, 3.fortnights - 2.fortnights)
        assertEquals((3 over 1).fortnights - 4.fortnights, (-1).fortnights)
    }

    @Test
    fun `should multiply`() {
        assertEquals(3.fortnights, 1.fortnights * 3)
        assertEquals(3.fortnights, 3 * 1.fortnights)
    }

    @Test
    fun `should divide`() {
        assertEquals(1.fortnights, 3.fortnights / 3)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("1 ftn", "${1.fortnights}")
    }
}
