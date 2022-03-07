package hm.binkley.kunits

import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.intoFFF
import hm.binkley.kunits.system.english.length.Barleycorn.Barleycorns
import hm.binkley.kunits.system.english.length.Foot.Feet
import hm.binkley.kunits.system.english.length.Hand.Hands
import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.Line.Lines
import hm.binkley.kunits.system.english.length.Stick.Sticks
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.english.length.lines
import hm.binkley.kunits.system.english.length.yards
import hm.binkley.kunits.system.english.weight.Dram.Drams
import hm.binkley.kunits.system.english.weight.Ounce.Ounces
import hm.binkley.kunits.system.english.weight.Pound.Pounds
import hm.binkley.kunits.system.english.weight.Stone
import hm.binkley.kunits.system.english.weight.drams
import hm.binkley.kunits.system.english.weight.ounces
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.intoEnglish
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.kunits.system.mit.intoEnglish
import hm.binkley.kunits.system.usd.denomination.Dime.Dimes
import hm.binkley.kunits.system.usd.denomination.DollarCoin.DollarCoins
import hm.binkley.kunits.system.usd.denomination.HalfDollar.HalfDollars
import hm.binkley.kunits.system.usd.denomination.Nickel.Nickels
import hm.binkley.kunits.system.usd.denomination.Penny.Pennies
import hm.binkley.kunits.system.usd.denomination.Quarter.Quarters
import hm.binkley.kunits.system.usd.denomination.dollars
import hm.binkley.kunits.system.usd.denomination.format
import hm.binkley.kunits.system.usd.denomination.pennies
import hm.binkley.kunits.system.fff.length.furlongs as fffFurlongs
import hm.binkley.kunits.system.mit.length.smoots as mitSmoots

/** Runs the demo. */
fun main() {
    println("== ENGLISH LENGTHS")
    val m1 = 120.lines
    println(+m1)
    println(-m1)
    println(m1 into Lines)
    println(m1 into Barleycorns)
    println(m1 + m1)
    println(m1 + (m1 into Barleycorns))
    println((m1 into Hands) - m1)
    println(m1 * 3)
    println(m1 / 3)
    println(m1 into Inches into Sticks)
    println(
        ((m1 into Yards) + (m1 into Feet) - (m1 into Barleycorns)) into Hands
    )

    println()
    println("== AVOIRDUPOIS WEIGHTS")
    val m2 = 300.drams

    println(+m2)
    println(-m2)
    println(m2 into Drams)
    println(m2 into Ounces)
    println(m2 + m2)
    println(m2 + 1.ounces)
    println((m2 into Pounds) - m2)
    println(m2 * 4)
    println(m2 / 4)
    println(m2 into Pounds into Stone)
    println(
        ((m2 into Stone) + (m2 into Pounds) - (m2 into Ounces)) into Drams
    )

    println()
    println("== CONVERSIONS")
    println("${1.fffFurlongs} IN $FFF IS ${1.fffFurlongs.intoEnglish(Yards)} IN $English")
    println("${220.yards} IN $English IS ${220.yards.intoFFF(Furlongs)} IN $FFF")
    val smootInInches = 1.mitSmoots.intoEnglish(Inches)
    println("${1.mitSmoots} IN $MIT IS $smootInInches IN $English")
    println("$smootInInches IS ${smootInInches.into(Feet, Inches)}")

    println()
    println("== MONEY")
    val m4 = 4.dollars + 33.pennies
    val coins = m4.into(
        DollarCoins, HalfDollars, Quarters, Dimes, Nickels, Pennies
    )
    val coinCount = coins.map { it.quantity }.sumOf { it.toInt() }
    println("${m4.format()} MAKES CHANGE IN $coinCount COINS AS:")
    coins.forEach { println("- $it (${it.format()})") }
    val recheckM4 = coins.fold(0.dollars) { sum, next -> sum + next }
    println("WHICH SUMS TO ${recheckM4.format()}")
}
