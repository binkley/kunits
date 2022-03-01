package hm.binkley.kunits

import hm.binkley.kunits.system.english.length.barleycorns
import hm.binkley.kunits.system.english.length.feet
import hm.binkley.kunits.system.english.length.hands
import hm.binkley.kunits.system.english.length.inches
import hm.binkley.kunits.system.english.length.lines
import hm.binkley.kunits.system.english.length.sticks
import hm.binkley.kunits.system.english.length.yards
import hm.binkley.kunits.system.english.weight.drams
import hm.binkley.kunits.system.english.weight.ounces
import hm.binkley.kunits.system.english.weight.pounds
import hm.binkley.kunits.system.english.weight.stone

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
}
