package hm.binkley.kunits.system.english

import hm.binkley.kunits.FIRKINS_PER_DRAM
import hm.binkley.kunits.FORTNIGHTS_PER_SECOND
import hm.binkley.kunits.FURLONGS_PER_LINE
import hm.binkley.kunits.System
import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.EnglishLength
import hm.binkley.kunits.system.english.time.EnglishTime
import hm.binkley.kunits.system.english.weight.EnglishWeight
import hm.binkley.kunits.system.fff.length.FFFLength
import hm.binkley.kunits.system.fff.length.FFFLengths
import hm.binkley.kunits.system.fff.time.FFFTime
import hm.binkley.kunits.system.fff.time.FFFTimes
import hm.binkley.kunits.system.fff.weight.FFFWeight
import hm.binkley.kunits.system.fff.weight.FFFWeights

/** The system of English units. */
object English : System<English>("English")

/** Converts lengths from English into FFF units. */
infix fun <
    V : FFFLengths<V, N>,
    N : FFFLength<V, N>
    > EnglishLength<*, *>.intoFFF(
    other: V
) = into(other) {
    it * FURLONGS_PER_LINE
}

/** Converts lengths from English into FFF units. */
infix fun <V : FFFTimes<V, N>, N : FFFTime<V, N>> EnglishTime<*, *>.intoFFF(
    other: V
) = into(
    other
) {
    it * FORTNIGHTS_PER_SECOND
}

/** Converts lengths from English into FFF units. */
infix fun <
    V : FFFWeights<V, N>,
    N : FFFWeight<V, N>
    > EnglishWeight<*, *>.intoFFF(
    other: V
) = into(other) {
    it * FIRKINS_PER_DRAM
}
