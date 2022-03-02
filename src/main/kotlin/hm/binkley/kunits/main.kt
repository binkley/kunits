package hm.binkley.kunits

import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.length.Inches
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.english.length.barleycorns
import hm.binkley.kunits.system.english.length.feet
import hm.binkley.kunits.system.english.length.hands
import hm.binkley.kunits.system.english.length.inches
import hm.binkley.kunits.system.english.length.lines
import hm.binkley.kunits.system.english.length.sticks
import hm.binkley.kunits.system.english.length.yards
import hm.binkley.kunits.system.english.intoFFF
import hm.binkley.kunits.system.english.weight.drams
import hm.binkley.kunits.system.english.weight.ounces
import hm.binkley.kunits.system.english.weight.pounds
import hm.binkley.kunits.system.english.weight.stone
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.kunits.system.fff.intoEnglish
import hm.binkley.kunits.system.mit.MIT
import hm.binkley.kunits.system.mit.intoEnglish
import hm.binkley.kunits.system.fff.length.furlongs as fffFurlongs
import hm.binkley.kunits.system.mit.length.smoots as mitSmoots

/** Runs the demo. */
fun main() {
    println("== ENGLISH LENGTHS")
    val m1 = 120.lines

    println(+m1)
    println(-m1)
    println(m1.lines)
    println(m1.barleycorns)
    println(m1 + m1)
    println(m1 + m1.barleycorns)
    println(m1.hands - m1)
    println(m1 * 3)
    println(m1 / 3)
    println(m1.inches.sticks)
    println((m1.yards + m1.feet - m1.barleycorns).hands)

    println()
    println("== AVOIRDUPOIS WEIGHTS")
    val m2 = 300.drams

    println(+m2)
    println(-m2)
    println(m2.drams)
    println(m2.ounces)
    println(m2 + m2)
    println(m2 + 1.ounces)
    println(m2.pounds - m2)
    println(m2 * 4)
    println(m2 / 4)
    println(m2.pounds.stone)
    println((m2.stone + m2.pounds - m2.ounces).drams)

    println()
    println("== CONVERSIONS")
    println("${1.fffFurlongs} IN $FFF IS ${1.fffFurlongs.intoEnglish(Yards)} IN $English")
    println("${220.yards} IN $English IS ${220.yards.intoFFF(Furlongs)} IN $FFF")
    println("${1.mitSmoots} IN $MIT IS ${1.mitSmoots.intoEnglish(Inches)} IN $English")
}
