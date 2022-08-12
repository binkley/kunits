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
Positive length -> (+m1) 120 lines
Negative length -> (-m1) -120 lines
Change of lengths -> (no change) 120 lines
Change of lengths -> (lines to barleycorns) 30 Bc
Adding like lengths -> (m1+m1) 240 lines
Adding related lengths -> (lines+barleycorns) 240 lines
Subtracting related lengths -> (hands-lines) 0 hh
Scaling length -> (tripling) 360 lines
Change of lengths -> (lines to barleycorns) 30 Bc
Scaling length -> (thirding) 40 lines
Change of lengths -> (multiple) 5 sticks
Complex expression -> (yards+feet-barleycorns into hands) 5⁄2 hh

== OUTDATED TIMES
Positive time -> (+m2) 12345⁄4 sec
Negative time -> (+m2) -12345⁄4 sec
Change of times -> (no change) 12345⁄4 sec
Change of times -> (seconds into hours) 823⁄960 hr
Adding like times -> (m2+m2) 12345⁄2 sec
Adding related times -> (seconds + minutes) 12585⁄4 sec
Subtracting related times -> (quadrants-seconds) 0 quadrants
Scaling time -> (quadrupling) 12345 sec
Change of times -> (seconds to minutes) 823⁄16 min
Scaling time -> (quartering) 12345⁄16 sec
Change of times -> (multiple) 823⁄345600 quinzièmes
Complex expression -> (minutes+days-weeks into seconds) 12345⁄4 sec

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

== EXAMPLE: CLOCK ARITHMETIC
377⁄4 min (94¼) IS [15 sec, 34 min, 1 hr] (377⁄240 hr)
            """
    }
}

private infix fun String.shouldBeAfterTrimming(expected: String) =
    trimIndent().trim() shouldBe expected.trimIndent().trim()
