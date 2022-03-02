package hm.binkley.kunits.system.mit.length

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MITLengthTest {
    @Test
    fun `should convert`() {
        1.smoots.into(Ears) shouldBe (67 over 3).ears
        1L.smoots.into(Smoots) shouldBe 1.smoots

        1.ears.into(Ears) shouldBe 1.ears
        1L.ears.into(Smoots) shouldBe (3 over 67).smoots
    }

    @Test
    fun `should pretty print`() {
        "$Smoots" shouldBe "MIT smoot"
        "${1.smoots}" shouldBe "1 sm"
        "$Ears" shouldBe "MIT ear"
        "${1.ears}" shouldBe "1 ears"
    }
}
