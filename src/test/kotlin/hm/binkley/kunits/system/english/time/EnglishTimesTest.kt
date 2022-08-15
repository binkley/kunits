/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package hm.binkley.kunits.system.english.time

import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.time.Day.Days
import hm.binkley.kunits.system.english.time.Fortnight.Fortnights
import hm.binkley.kunits.system.english.time.Hour.Hours
import hm.binkley.kunits.system.english.time.Mileway.Mileways
import hm.binkley.kunits.system.english.time.Minute.Minutes
import hm.binkley.kunits.system.english.time.Moment.Moments
import hm.binkley.kunits.system.english.time.Point.Points
import hm.binkley.kunits.system.english.time.Quadrant.Quadrants
import hm.binkley.kunits.system.english.time.Second.Seconds
import hm.binkley.kunits.system.english.time.Week.Weeks
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishTimesTest {
    @Test
    fun `should convert`() {
        1L.atoms shouldBe 1.atoms
        1L.seconds shouldBe ((94 over 15).atoms into Seconds)
        1L.minutes shouldBe (60.seconds into Minutes)
        1L.moments shouldBe ((3 over 2).minutes into Moments)
        1L.points shouldBe (10.moments into Points)
        1L.pricks shouldBe 1.points
        (3 over 1).pricks shouldBe 3.points
        1L.mileways shouldBe ((4 over 3).points into Mileways)
        1L.hours shouldBe (3.mileways into Hours)
        1L.quadrants shouldBe (6.hours into Quadrants)
        1L.days shouldBe (4.quadrants into Days)
        1L.weeks shouldBe (7.days into Weeks)
        1L.fortnights shouldBe (2.weeks into Fortnights)
        1L.quinzièmes shouldBe ((15 over 14).fortnights into Quinzième)
    }

    @Test
    fun `should pretty print`() {
        "$Atom" shouldBe "English time: atom"
        "${1.atoms}" shouldBe "1 atoms"
        "$Second" shouldBe "English time: second"
        "${1.seconds}" shouldBe "1 sec"
        "$Minute" shouldBe "English time: minute"
        "${1.minutes}" shouldBe "1 min"
        "$Moment" shouldBe "English time: moment"
        "${1.moments}" shouldBe "1 moments"
        "$Point" shouldBe "English time: point"
        "${1.points}" shouldBe "1 points"
        "${1.pricks}" shouldBe "1 points"
        "$Mileway" shouldBe "English time: mileway"
        "${1.mileways}" shouldBe "1 mileways"
        "$Hour" shouldBe "English time: hour"
        "${1.hours}" shouldBe "1 hr"
        "$Quadrant" shouldBe "English time: quadrant"
        "${1.quadrants}" shouldBe "1 quadrants"
        "$Day" shouldBe "English time: day"
        "${1.days}" shouldBe "1 days"
        "$Week" shouldBe "English time: week"
        "${1.weeks}" shouldBe "1 weeks"
        "$Fortnight" shouldBe "English time: fortnight"
        "${1.fortnights}" shouldBe "1 fortnights"
        "$Quinzième" shouldBe "English time: quinzième"
        "${1.quinzièmes}" shouldBe "1 quinzièmes"
    }
}
