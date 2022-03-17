package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.Time
import hm.binkley.kunits.Weight
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.kunits.system.english.time.EnglishTimes
import hm.binkley.kunits.system.english.weight.EnglishWeights
import hm.binkley.math.fixed.over

private val LINES_PER_FURLONG = (95_040 over 1)
private val SECONDS_PER_FORTNIGHT = (1_209_600 over 1)
private val DRAMS_PER_FIRKIN = (23_040 over 1)

/** The system of furlong-firkin-fortnight units. */
object FFF : System<FFF>("Furlong-Firkin-Fortnight")

/** Converts lengths from FFF into English units. */
infix fun <V : EnglishLengths<V>>
Measure<FFF, Length, *>.intoEnglish(other: V) = into(other) {
    it * LINES_PER_FURLONG
}

/** Converts times from FFF into English units. */
infix fun <V : EnglishTimes<V>>
Measure<FFF, Time, *>.intoEnglish(other: V) = into(other) {
    it * SECONDS_PER_FORTNIGHT
}

/** Converts weights from FFF into English units. */
infix fun <V : EnglishWeights<V>>
Measure<FFF, Weight, *>.intoEnglish(other: V) = into(other) {
    it * DRAMS_PER_FIRKIN
}
