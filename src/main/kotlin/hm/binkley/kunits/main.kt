package hm.binkley.kunits

import hm.binkley.kunits.system.english.length.barleycorns
import hm.binkley.kunits.system.english.length.feet
import hm.binkley.kunits.system.english.length.hands
import hm.binkley.kunits.system.english.length.inches
import hm.binkley.kunits.system.english.length.poppyseeds
import hm.binkley.kunits.system.english.length.sticks
import hm.binkley.kunits.system.english.length.yards

fun main() {
    val m1 = 120.poppyseeds

    println(+m1)
    println(-m1)
    println(m1.poppyseeds)
    println(m1.barleycorns)
    println(m1 + m1)
    println(m1 + m1.barleycorns)
    println(m1.hands - m1)
    println(m1 * 3)
    println(m1 / 3)
    println(m1.inches.sticks)
    println((m1.yards + m1.feet - m1.barleycorns).hands)
}
