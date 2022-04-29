package hm.binkley.kunits

import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.intoFFF
import hm.binkley.kunits.system.english.length.Barleycorn.Barleycorns
import hm.binkley.kunits.system.english.length.Foot.Feet
import hm.binkley.kunits.system.english.length.Hand.Hands
import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.Line
import hm.binkley.kunits.system.english.length.Line.Lines
import hm.binkley.kunits.system.english.length.Stick.Sticks
import hm.binkley.kunits.system.english.length.Yard.Yards
import hm.binkley.kunits.system.english.length.lines
import hm.binkley.kunits.system.english.length.yards
import hm.binkley.kunits.system.english.time.Atom.Atoms
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
    val m1: Line = 120.lines
    println(+m1)
    println(-m1)
    println(m1 into Lines)
    println(m1 into Barleycorns)
    println(m1 + m1)
    println(m1 + (m1 into Barleycorns))
    println((m1 into Hands) - m1)
    println(m1 * 3)
    println(m1 / Barleycorns)
    println(m1 / 3)
    println(m1 into Inches into Sticks)
    println(
        ((m1 into Yards) + (m1 into Feet) - (m1 into Barleycorns)) into Hands
    )

    println()
    println("== MEDIEVAL TIMES")
    val m2 = (12_345 over 4).seconds
    println(+m2)
    println(-m2)
    println(m2 into Atoms)
    println(m2 into Hours)
    println(m2 + m2)
    println(m2 + 1.minutes)
    println((m2 into Quadrants) - m2)
    println(m2 * 4)
    println(m2 / Minutes)
    println(m2 / 4)
    println(m2 into Mileways into Quinzièmes)
    println(
        ((m2 into Minutes) + (m2 into Days) - (m2 into Weeks)) into Seconds
    )

    println()
    println("== AVOIRDUPOIS WEIGHTS")
    val m3 = 300L.drams
    println(+m3)
    println(-m3)
    println(m3 into Drams)
    println(m3 into Ounces)
    println(m3 + m3)
    println(m3 + 1.ounces)
    println((m3 into Pounds) - m3)
    println(m3 * 5)
    println(m3 / Ounces)
    println(m3 / 5)
    println(m3 into Pounds into Stone)
    println(
        ((m3 into Stone) + (m3 into Pounds) - (m3 into Ounces)) into Drams
    )

    println()
    println("== USD DENOMINATIONS")
    val m4 = 4.dollars + 33.cents
    val coins = m4.into(
        DollarCoins, HalfDollars, Quarters, Dimes, Nickels, Pennies
    )
    val looseChange = listOf(
        DollarCoins, HalfDollars, Quarters, Dimes, Nickels, Pennies
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
    println("${1.fffFurlongs} IN $FFF IS ${1.fffFurlongs intoEnglish Yards} IN $English")
    println("${220.yards} IN $English IS ${220.yards intoFFF Furlongs} IN $FFF")
    val smootInInches = 1.smoots intoEnglish Inches
    println("${1.smoots} IN $MIT IS $smootInInches IN $English")
    println("$smootInInches IS ${smootInInches.into(Feet, Inches)}")
}
