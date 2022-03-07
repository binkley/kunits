package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Times
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.time.Fortnight.Fortnights
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of time. */
sealed class FFFTimes<U : FFFTimes<U>>(
    name: String,
    fortnights: FixedBigRational,
) : Times<FFF, U>(FFF, name, fortnights)

class Fortnight private constructor(value: FixedBigRational) :
    Measure<FFF, Fortnights>(Fortnights, value) {

    object Fortnights : FFFTimes<Fortnights>("fortnight", ONE) {
        override fun new(value: FixedBigRational) = Fortnight(value)
        override fun format(value: FixedBigRational) = "$value ftn"
    }
}

val Int.fortnights get() = (this over 1).fortnights
val Long.fortnights get() = (this over 1).fortnights
val FixedBigRational.fortnights get() = Fortnights.new(this)
