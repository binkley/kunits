package hm.binkley.kunits.system.fff

import hm.binkley.kunits.FIRKINS_PER_DRAM
import hm.binkley.kunits.FORTNIGHTS_PER_SECOND
import hm.binkley.kunits.FURLONGS_PER_LINE
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLength
import hm.binkley.kunits.system.english.length.EnglishLengths
import hm.binkley.kunits.system.english.time.EnglishTime
import hm.binkley.kunits.system.english.time.EnglishTimes
import hm.binkley.kunits.system.english.weight.EnglishWeight
import hm.binkley.kunits.system.english.weight.EnglishWeights
import hm.binkley.kunits.system.fff.length.FFFLength
import hm.binkley.kunits.system.fff.time.FFFTime
import hm.binkley.kunits.system.fff.weight.FFFWeight

/** The system of furlong-firkin-fortnight units. */
object FFF : System<FFF>("Furlong-Firkin-Fortnight")

/** Converts lengths from FFF into English units. */
infix fun <
    V : EnglishLengths<V, N>,
    N : EnglishLength<V, N>,
    > FFFLength<*, *>.intoEnglish(
    other: V
) = into(other) {
    it / FURLONGS_PER_LINE
}

/** Converts times from FFF into English units. */
infix fun <
    V : EnglishTimes<V, N>,
    N : EnglishTime<V, N>,
    > FFFTime<*, *>.intoEnglish(
    other: V
) = into(other) {
    it / FORTNIGHTS_PER_SECOND
}

/** Converts weights from FFF into English units. */
infix fun <
    V : EnglishWeights<V, N>,
    N : EnglishWeight<V, N>,
    > FFFWeight<*, *>.intoEnglish(
    other: V
) = into(other) {
    it / FIRKINS_PER_DRAM
}
