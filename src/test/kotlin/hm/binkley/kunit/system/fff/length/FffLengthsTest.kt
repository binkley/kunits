package hm.binkley.kunit.system.fff.length

import hm.binkley.kunit.div
import hm.binkley.kunit.minus
import hm.binkley.kunit.plus
import hm.binkley.kunit.times
import hm.binkley.kunit.unaryMinus
import hm.binkley.kunit.unaryPlus
import hm.binkley.math.finite.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffLengthsTest {
    @Test
    fun `should convert`() {
        assertEquals(1.furlongs.to(Furlongs), 1.furlongs)
    }

    @Test
    fun `should posite`() {
        assertEquals((+1).furlongs, +(1.furlongs))
    }

    @Test
    fun `should negate`() {
        assertEquals((-1).furlongs, -(1.furlongs))
    }

    @Test
    fun `should add`() {
        assertEquals(3.furlongs, 1.furlongs + 2.furlongs)
        assertEquals((3 over 1).furlongs + 4.furlongs, 7.furlongs)
    }

    @Test
    fun `should subtract`() {
        assertEquals(1.furlongs, 3.furlongs - 2.furlongs)
        assertEquals((3 over 1).furlongs - 4.furlongs, (-1).furlongs)
    }

    @Test
    fun `should multiply`() {
        assertEquals(3.furlongs, 1.furlongs * 3)
        assertEquals(3.furlongs, 3 * 1.furlongs)
    }

    @Test
    fun `should divide`() {
        assertEquals(1.furlongs, 3.furlongs / 3)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("1 fur", "${1.furlongs}")
    }
}
