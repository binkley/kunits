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

package hm.binkley.kunits

import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.intoFFF
import hm.binkley.kunits.system.english.denomination.Crown.Crowns
import hm.binkley.kunits.system.english.denomination.Farthing.Farthings
import hm.binkley.kunits.system.english.denomination.Florin.Florins
import hm.binkley.kunits.system.english.denomination.Groat.Groats
import hm.binkley.kunits.system.english.denomination.Guinea.Guineas
import hm.binkley.kunits.system.english.denomination.HalfCrown.HalfCrowns
import hm.binkley.kunits.system.english.denomination.HalfGuinea.HalfGuineas
import hm.binkley.kunits.system.english.denomination.Halfpenny.Halfpence
import hm.binkley.kunits.system.english.denomination.Mark.Marks
import hm.binkley.kunits.system.english.denomination.Penny.Pence
import hm.binkley.kunits.system.english.denomination.Sixpenny.Sixpence
import hm.binkley.kunits.system.english.denomination.Threepenny.Threepence
import hm.binkley.kunits.system.english.denomination.Twopenny.Twopence
import hm.binkley.kunits.system.english.denomination.halfGroats
import hm.binkley.kunits.system.english.denomination.pounds
import hm.binkley.kunits.system.english.denomination.quid
import hm.binkley.kunits.system.english.denomination.tuppence
import hm.binkley.kunits.system.english.denomination.twopence
import hm.binkley.kunits.system.english.length.Barleycorn.Barleycorns
import hm.binkley.kunits.system.english.length.Foot.Feet
import hm.binkley.kunits.system.english.length.Hand.Hands
import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.Line.Lines
import hm.binkley.kunits.system.english.length.Stick.Sticks
import hm.binkley.kunits.system.english.length.Yard.Yards
import hm.binkley.kunits.system.english.length.lines
import hm.binkley.kunits.system.english.length.yards
import hm.binkley.kunits.system.english.time.Day.Days
import hm.binkley.kunits.system.english.time.Hour.Hours
import hm.binkley.kunits.system.english.time.Mileway.Mileways
import hm.binkley.kunits.system.english.time.Minute.Minutes
import hm.binkley.kunits.system.english.time.Quadrant.Quadrants
import hm.binkley.kunits.system.english.time.Quinzième.Quinzièmes
import hm.binkley.kunits.system.english.time.Second.Seconds
import hm.binkley.kunits.system.english.time.Week.Weeks
import hm.binkley.kunits.system.english.time.minutes
import hm.binkley.kunits.system.english.time.seconds
import hm.binkley.kunits.system.english.weight.Dram.Drams
import hm.binkley.kunits.system.english.weight.Ounce.Ounces
import hm.binkley.kunits.system.english.weight.Pound.Pounds
import hm.binkley.kunits.system.english.weight.StoneMeasure.Stone
import hm.binkley.kunits.system.english.weight.drams
import hm.binkley.kunits.system.english.weight.ounces
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.intoEnglish
import hm.binkley.kunits.system.fff.length.Furlong.Furlongs
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.kunits.system.mit.intoEnglish
import hm.binkley.kunits.system.mit.length.smoots
import hm.binkley.kunits.system.usd.denomination.Dime.Dimes
import hm.binkley.kunits.system.usd.denomination.DollarCoin.DollarCoins
import hm.binkley.kunits.system.usd.denomination.HalfDollar.HalfDollars
import hm.binkley.kunits.system.usd.denomination.Nickel.Nickels
import hm.binkley.kunits.system.usd.denomination.Penny.Pennies
import hm.binkley.kunits.system.usd.denomination.Quarter.Quarters
import hm.binkley.kunits.system.usd.denomination.cents
import hm.binkley.kunits.system.usd.denomination.dollars
import hm.binkley.kunits.system.usd.denomination.format
import hm.binkley.math.fixed.over
import hm.binkley.kunits.system.fff.length.furlongs as fffFurlongs

/** Runs the demo. */
fun main() {
    println("== ENGLISH LENGTHS")
    val m1 = 120.lines
    println("Positive length -> (+m1) ${+m1}")
    println("Negative length -> (-m1) ${-m1}")
    println("Change of lengths -> (no change) ${m1 into Lines}")
    println(
        "Change of lengths -> (lines to barleycorns) ${
            m1 into Barleycorns
        }"
    )
    println("Adding like lengths -> (m1+m1) ${m1 + m1}")
    println(
        "Adding related lengths -> (lines+barleycorns) ${
            m1 + (m1 into Barleycorns)
        }"
    )
    println(
        "Subtracting related lengths -> (hands-lines) ${
            (m1 into Hands) - m1
        }"
    )
    println("Scaling length -> (tripling) ${m1 * 3}")
    println("Change of lengths -> (lines to barleycorns) ${m1 / Barleycorns}")
    println("Scaling length -> (thirding) ${m1 / 3}")
    println("Change of lengths -> (multiple) ${m1 into Inches into Sticks}")
    println(
        "Complex expression -> (yards+feet-barleycorns into hands) ${
            ((m1 into Yards) + (m1 into Feet) - (m1 into Barleycorns))
                into Hands
        }"
    )

    println()
    println("== PRE-1971 BRITISH COINAGE")
    val p1 = 1.pounds
    val p2 = 1.twopence
    println("$p1 (pounds) is ${1.quid} (quid)")
    println(
        "$p2 (pence) is ${1.tuppence} (tuppence) or ${1.halfGroats} (half-groat)"
    )
    println(
        """$p1 is
    ${p1 into Guineas}
    or ${p1 into Marks}
    or ${p1 into HalfGuineas}
    or ${p1 into Crowns}
    or ${p1 into HalfCrowns}
    or ${p1 into Florins}
    or ${p1 into Sixpence}
    or ${p1 into Groats}
    or ${p1 into Threepence}
    or ${p1 into Twopence}
    or ${p1 into Pence}
    or ${p1 into Halfpence}
    or ${p1 into Farthings}"""
    )

    println()
    println("== OUTDATED TIMES")
    val m2 = (12_345 over 4).seconds
    println("Positive time -> (+m2) ${+m2}")
    println("Negative time -> (+m2) ${-m2}")
    println("Change of times -> (no change) ${m2 into Seconds}")
    println("Change of times -> (seconds into hours) ${m2 into Hours}")
    println("Adding like times -> (m2+m2) ${m2 + m2}")
    println("Adding related times -> (seconds + minutes) ${m2 + 1.minutes}")
    println(
        "Subtracting related times -> (quadrants-seconds) ${
            (m2 into Quadrants) - m2
        }"
    )
    println("Scaling time -> (quadrupling) ${m2 * 4}")
    println("Change of times -> (seconds to minutes) ${m2 / Minutes}")
    println("Scaling time -> (quartering) ${m2 / 4}")
    println("Change of times -> (multiple) ${m2 into Mileways into Quinzièmes}")
    println(
        "Complex expression -> (minutes+days-weeks into seconds) ${
            ((m2 into Minutes) + (m2 into Days) - (m2 into Weeks)) into Seconds
        }"
    )

    println()
    println("== AVOIRDUPOIS WEIGHTS")
    val m3 = 300L.drams
    println("Positive weight -> (+m3) ${+m3}")
    println("Negative weight -> (+m3) ${-m3}")
    println("Change of weights -> (no change) ${m3 into Drams}")
    println("Change of weights -> (drams into ounces) ${m3 into Ounces}")
    println("Adding like weights -> (m3+m3) ${m3 + m3}")
    println("Adding like weights -> (m3+1) ${m3 + 1.ounces}")
    println(
        "Subtracting related weights -> (pounds-ounces) ${
            (m3 into Pounds) - m3
        })"
    )
    println("Scaling weight -> (quintupling) ${m3 * 5}")
    println("Change of weights -> (drams to ounces) ${m3 / Ounces}")
    println("Scaling weight -> (fifthing) ${m3 / 5}")
    println("Change of weights -> (multiple) ${m3 into Pounds into Stone}")
    println(
        "Complex expression -> (stone+pounds-ounces into drams) ${
            ((m3 into Stone) + (m3 into Pounds) - (m3 into Ounces)) into Drams
        }"
    )

    println()
    println("== USD DENOMINATIONS")
    val m4 = 4.dollars + 33.cents
    val coins = m4.into(
        DollarCoins,
        HalfDollars,
        Quarters,
        Dimes,
        Nickels,
        Pennies
    )
    val looseChange = listOf(
        DollarCoins,
        HalfDollars,
        Quarters,
        Dimes,
        Nickels,
        Pennies
    )
    val alsoCoins = m4 % looseChange

    val coinCount = coins.map { it.quantity }.sumOf { it.toInt() }
    println("${m4.format()} MAKES CHANGE IN $coinCount COINS AS:")
    coins.forEach { println("- $it (${it.format()})") }
    val recheckM4 = coins.fold(0.dollars) { sum, next -> sum + next }
    println("WHICH SUMS TO ${recheckM4.format()}")
    println("AND IS THE SAME AS $alsoCoins (${coins == alsoCoins})")

    println()
    println("== CONVERSIONS")
    // Use multiline string because of long line in the code
    println(
        """
${1.fffFurlongs} IN $FFF IS ${1.fffFurlongs intoEnglish Yards} IN $English
        """.trimIndent()
    )
    println("${220.yards} IN $English IS ${220.yards intoFFF Furlongs} IN $FFF")
    val smootInInches = 1.smoots intoEnglish Inches
    println("${1.smoots} IN $MIT IS $smootInInches IN $English")
    println("$smootInInches IS ${smootInInches.into(Feet, Inches)}")

    println()
    println("== EXAMPLE: CLOCK ARITHMETIC")
    val duration = 94.25.minutes // 94¼ minutes
    println(
        "$duration (94¼) IS ${
            duration.into(Seconds, Minutes, Hours)
        } (${duration into Hours})"
    )
}
