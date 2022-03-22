package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Time
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.time.Fortnight.Fortnights
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of time. */
sealed class FFFTimes<
    U : FFFTimes<U, M>,
    M : FFFTime<U, M>,
    >(
    name: String,
    fortnights: FixedBigRational,
) : Units<Time, FFF, U, M>(Time, FFF, name, fortnights)

sealed class FFFTime<
    U : FFFTimes<U, M>,
    M : FFFTime<U, M>,
    >(
    unit: U,
    quantity: FixedBigRational,
) : Measure<Time, FFF, U, M>(unit, quantity)

class Fortnight private constructor(quantity: FixedBigRational) :
    FFFTime<Fortnights, Fortnight>(Fortnights, quantity) {
    companion object Fortnights : FFFTimes<Fortnights, Fortnight>(
        "fortnight", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Fortnight(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity ftn"
    }
}

val FixedBigRational.fortnights get() = Fortnights.new(this)
val Long.fortnights get() = (this over 1).fortnights
val Int.fortnights get() = (this over 1).fortnights
