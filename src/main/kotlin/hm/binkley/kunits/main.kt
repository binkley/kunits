package hm.binkley.kunits

import hm.binkley.kunits.system.english.length.Barleycorns
import hm.binkley.kunits.system.english.length.Feet
import hm.binkley.kunits.system.english.length.Hands
import hm.binkley.kunits.system.english.length.Inches
import hm.binkley.kunits.system.english.length.Poppyseeds
import hm.binkley.kunits.system.english.length.Sticks
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.english.length.poppyseeds
import lombok.Generated

@Generated // Lie to JaCoCo
fun main() {
    val m1 = 120.poppyseeds

    println(+m1)
    println(-m1)
    println(m1.to(Poppyseeds))
    println(m1.to(Barleycorns))
    println(m1 + m1)
    println(m1 + m1.to(Barleycorns))
    println(m1.to(Hands) - m1)
    println(m1 * 3)
    println(m1 / 3)
    println(
        m1.to(Inches).to(
            Sticks
        )
    )
    println(
        (m1.to(Yards) + m1.to(
            Feet
        ) - m1.to(Barleycorns)).to(
            Hands
        )
    )
}
