package hm.binkley.kunits.system.fff.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Time
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of time. */
sealed class FFFTime<U : FFFTime<U>>(
    name: String,
    fortnights: FixedBigRational,
) : Time<FFF, U>(FFF, name, fortnights)

object Fortnights : FFFTime<Fortnights>("fortnight", ONE) {
    override fun new(value: FixedBigRational) = Fortnight(value)
    override fun format(value: FixedBigRational) = "$value ftn"
}

class Fortnight(value: FixedBigRational) :
    Measure<FFF, Fortnights>(Fortnights, value)

val Int.fortnights get() = (this over 1).fortnights
val Long.fortnights get() = (this over 1).fortnights
val FixedBigRational.fortnights get() = Fortnights.new(this)
