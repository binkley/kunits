package hm.binkley.kunits.system.mit.length

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MitLengthsTest {
    @Test
    fun `should convert`() {
        1.smoots.convertTo(Ears) shouldBe (67 over 3).ears
        1L.smoots.convertTo(Smoots) shouldBe 1.smoots

        1.ears.convertTo(Ears) shouldBe 1.ears
        1L.ears.convertTo(Smoots) shouldBe (3 over 67).smoots
    }

    @Test
    fun `should pretty print`() {
        "$Smoots" shouldBe "MIT smoot"
        "${1.smoots}" shouldBe "1 sm"
        "${1.ears}" shouldBe "1 ear"
    }
}
