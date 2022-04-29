package hm.binkley.kunits

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErrAndOutNormalized
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MainTest {
    @Test
    fun `should run`() {
        tapSystemErrAndOutNormalized { main() } shouldBeAfterTrimming
            """
== ENGLISH LENGTHS
120 lines
-120 lines
120 lines
30 Bc
240 lines
240 lines
0 hh
360 lines
30 Bc
40 lines
5 sticks
5⁄2 hh

== MEDIEVAL TIMES
12345⁄4 sec
-12345⁄4 sec
38681⁄2 atoms
823⁄960 hr
12345⁄2 sec
12585⁄4 sec
0 quadrants
12345 sec
823⁄16 min
12345⁄16 sec
823⁄345600 quinzièmes
12345⁄4 sec

== AVOIRDUPOIS WEIGHTS
300 dr
-300 dr
300 dr
75⁄4 oz
600 dr
316 dr
0 lb
1500 dr
75⁄4 oz
60 dr
75⁄896 st
300 dr

== USD DENOMINATIONS
$4.33 MAKES CHANGE IN 9 COINS AS:
- 4 100¢ ($4.00)
- 0 50¢ ($0.00)
- 1 25¢ ($0.25)
- 0 10¢ ($0.00)
- 1 5¢ ($0.05)
- 3 1¢ ($0.03)
WHICH SUMS TO $4.33
AND IS THE SAME AS [4 100¢, 0 50¢, 1 25¢, 0 10¢, 1 5¢, 3 1¢] (true)

== CONVERSIONS
1 fur IN Furlong-Firkin-Fortnight IS 220 yd IN English
220 yd IN English IS 1 fur IN Furlong-Firkin-Fortnight
1 sm IN MIT IS 67" IN English
67" IS [5', 7"]
            """
    }
}

private infix fun String.shouldBeAfterTrimming(expected: String) =
    trimIndent().trim() shouldBe expected.trimIndent().trim()
