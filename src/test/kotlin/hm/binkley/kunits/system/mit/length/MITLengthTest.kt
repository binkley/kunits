package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.system.mit.length.Smoot.Smoots
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import hm.binkley.kunits.into

internal class MITLengthTest {
    @Test
    fun `should convert`() {
        1L.ears shouldBe 1.ears
        1.ears shouldBe ((3 over 67).smoots into Ears)

        1.smoots shouldBe ((67 over 3).ears into Smoot)
        1L.smoots shouldBe 1.smoots
    }

    @Test
    fun `should pretty print`() {
        "$Smoots" shouldBe "MIT smoot"
        "${1.smoots}" shouldBe "1 sm"
        "$Ears" shouldBe "MIT ear"
        "${1.ears}" shouldBe "1 ears"
    }
}
