package hm.binkley.kunits.system.mit.length

import hm.binkley.kunits.into
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MITLengthsTest {
    @Test
    fun `should convert`() {
        1L.ears shouldBe 1.ears
        1L.smoots shouldBe ((67 over 3).ears into Smoot)
    }

    @Test
    fun `should pretty print`() {
        "$Smoot" shouldBe "MIT length: smoot"
        "${1.smoots}" shouldBe "1 sm"
        "$Ear" shouldBe "MIT length: ear"
        "${1.ears}" shouldBe "1 ears"
    }
}
