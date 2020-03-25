package hm.binkley.kunit.system.fff.mass

import hm.binkley.kunit.div
import hm.binkley.kunit.minus
import hm.binkley.kunit.plus
import hm.binkley.kunit.times
import hm.binkley.kunit.unaryMinus
import hm.binkley.kunit.unaryPlus
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffMassesTest {
    @Test
    fun `should convert`() {
        assertEquals(1.firkins.to(Firkins), 1.firkins)
    }

    @Test
    fun `should posite`() {
        assertEquals((+1).firkins, +(1.firkins))
    }

    @Test
    fun `should negate`() {
        assertEquals((-1).firkins, -(1.firkins))
    }

    @Test
    fun `should add`() {
        assertEquals(3.firkins, 1.firkins + 2.firkins)
        assertEquals((3 over 1).firkins + 4.firkins, 7.firkins)
    }

    @Test
    fun `should subtract`() {
        assertEquals(1.firkins, 3.firkins - 2.firkins)
        assertEquals((3 over 1).firkins - 4.firkins, (-1).firkins)
    }

    @Test
    fun `should multiply`() {
        assertEquals(3.firkins, 1.firkins * 3)
        assertEquals(3.firkins, 3 * 1.firkins)
    }

    @Test
    fun `should divide`() {
        assertEquals(1.firkins, 3.firkins / 3)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("1 fir", "${1.firkins}")
    }
}
