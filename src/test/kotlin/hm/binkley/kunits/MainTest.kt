package hm.binkley.kunits

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErrAndOutNormalized
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MainTest {
    @Test
    fun `should run`() {
        tapSystemErrAndOutNormalized { main() } shouldBeAfterTrimming """
== ENGLISH LENGTHS
120 lines
-120 lines
120 lines
30 Bc
240 lines
240 lines
0 hh
360 lines
40 lines
5 sticks
5⁄2 hh

== AVOIRDUPOIS WEIGHTS
300 dr
-300 dr
300 dr
75⁄4 oz
600 dr
316 dr
0 lb
1200 dr
75 dr
75⁄896 st
300 dr

== CONVERSIONS
1 fur IN FFF IS 220 yd IN English
220 yd IN English IS 1 fur IN FFF
1 sm IN MIT IS 67" IN English            
        """
    }
}

private infix fun String.shouldBeAfterTrimming(expected: String) =
    trimIndent().trim() shouldBe expected.trimIndent().trim()
