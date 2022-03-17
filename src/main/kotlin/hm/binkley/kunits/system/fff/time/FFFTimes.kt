package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.time.Fortnight.Fortnights
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of time. */
sealed class FFFTimes<U : FFFTimes<U>>(
    name: String,
    fortnights: FixedBigRational,
) : Units<FFF, U>(FFF, name, fortnights)

class Fortnight private constructor(quantity: FixedBigRational) :
    Measure<FFF, Fortnights>(Fortnights, quantity) {
    companion object Fortnights : FFFTimes<Fortnights>(
        "fortnight", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Fortnight(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ftn"
    }
}

val FixedBigRational.fortnights get() = Fortnights.new(this)
val Long.fortnights get() = (this over 1).fortnights
val Int.fortnights get() = (this over 1).fortnights
