package hm.binkley.kunit.system.fff.length

import hm.binkley.kunit.div
import hm.binkley.kunit.minus
import hm.binkley.kunit.plus
import hm.binkley.kunit.times
import hm.binkley.kunit.unaryMinus
import hm.binkley.kunit.unaryPlus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FffLengthsTest {
    @Test
    fun `should convert`() {
        assertEquals(1.furlongs.to(Furlongs), 1.furlongs)
    }

    @Test
    fun `should pretty print`() {
        assertEquals("1 fur", "${1.furlongs}")
    }
}
