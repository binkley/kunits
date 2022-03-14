package hm.binkley.kunits.system.english.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Times
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.time.Atom.Atoms
import hm.binkley.kunits.system.english.time.Day.Days
import hm.binkley.kunits.system.english.time.Fortnight.Fortnights
import hm.binkley.kunits.system.english.time.Hour.Hours
import hm.binkley.kunits.system.english.time.Mileway.Mileways
import hm.binkley.kunits.system.english.time.Minute.Minutes
import hm.binkley.kunits.system.english.time.Moment.Moments
import hm.binkley.kunits.system.english.time.Point.Points
import hm.binkley.kunits.system.english.time.Quadrant.Quadrants
import hm.binkley.kunits.system.english.time.Quinzième.Quinzièmes
import hm.binkley.kunits.system.english.time.Second.Seconds
import hm.binkley.kunits.system.english.time.Week.Weeks
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

sealed class EnglishTimes<U : EnglishTimes<U>>(
    name: String,
    seconds: FixedBigRational,
) : Times<English, U>(English, name, seconds)

class Atom private constructor(quantity: FixedBigRational) :
    Measure<English, Atoms>(Atoms, quantity) {
    companion object Atoms : EnglishTimes<Atoms>(
        "atom", (15 over 94)
    ) {
        override fun new(quantity: FixedBigRational) = Atom(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity atoms"
    }
}

val FixedBigRational.atoms get() = Atoms.new(this)
val Long.atoms get() = (this over 1).atoms
val Int.atoms get() = (this over 1).atoms

class Second private constructor(quantity: FixedBigRational) :
    Measure<English, Seconds>(Seconds, quantity) {
    companion object Seconds : EnglishTimes<Seconds>(
        "second", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Second(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity sec"
    }
}

val FixedBigRational.seconds get() = Seconds.new(this)
val Long.seconds get() = (this over 1).seconds
val Int.seconds get() = (this over 1).seconds

class Minute private constructor(quantity: FixedBigRational) :
    Measure<English, Minutes>(Minutes, quantity) {
    companion object Minutes : EnglishTimes<Minutes>(
        "minute", (60 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Minute(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity min"
    }
}

val FixedBigRational.minutes get() = Minutes.new(this)
val Long.minutes get() = (this over 1).minutes
val Int.minutes get() = (this over 1).minutes

class Moment private constructor(quantity: FixedBigRational) :
    Measure<English, Moments>(Moments, quantity) {
    companion object Moments : EnglishTimes<Moments>(
        "moment", (90 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Moment(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity moments"
    }
}

val FixedBigRational.moments get() = Moments.new(this)
val Long.moments get() = (this over 1).moments
val Int.moments get() = (this over 1).moments

/** Also known as a "prick". */
class Point private constructor(quantity: FixedBigRational) :
    Measure<English, Points>(Points, quantity) {
    companion object Points : EnglishTimes<Points>(
        "point", (900 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Point(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity points"
    }
}

val FixedBigRational.points get() = Points.new(this)
val Long.points get() = (this over 1).points
val Int.points get() = (this over 1).points

class Mileway private constructor(quantity: FixedBigRational) :
    Measure<English, Mileways>(Mileways, quantity) {
    companion object Mileways : EnglishTimes<Mileways>(
        "mileway", (1_200 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Mileway(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity mileways"
    }
}

val FixedBigRational.mileways get() = Mileways.new(this)
val Long.mileways get() = (this over 1).mileways
val Int.mileways get() = (this over 1).mileways

class Hour private constructor(quantity: FixedBigRational) :
    Measure<English, Hours>(Hours, quantity) {
    companion object Hours : EnglishTimes<Hours>(
        "hour", (3_600 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Hour(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity hr"
    }
}

val FixedBigRational.hours get() = Hours.new(this)
val Long.hours get() = (this over 1).hours
val Int.hours get() = (this over 1).hours

class Quadrant private constructor(quantity: FixedBigRational) :
    Measure<English, Quadrants>(Quadrants, quantity) {
    companion object Quadrants : EnglishTimes<Quadrants>(
        "quadrant", (21_600 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Quadrant(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity quadrants"
    }
}

val FixedBigRational.quadrants get() = Quadrants.new(this)
val Long.quadrants get() = (this over 1).quadrants
val Int.quadrants get() = (this over 1).quadrants

class Day private constructor(quantity: FixedBigRational) :
    Measure<English, Days>(Days, quantity) {
    companion object Days : EnglishTimes<Days>(
        "day", (86_400 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Day(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity days"
    }
}

val FixedBigRational.days get() = Days.new(this)
val Long.days get() = (this over 1).days
val Int.days get() = (this over 1).days

class Week private constructor(quantity: FixedBigRational) :
    Measure<English, Weeks>(Weeks, quantity) {
    companion object Weeks : EnglishTimes<Weeks>(
        "week", (604_800 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Week(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity weeks"
    }
}

val FixedBigRational.weeks get() = Weeks.new(this)
val Long.weeks get() = (this over 1).weeks
val Int.weeks get() = (this over 1).weeks

class Fortnight private constructor(quantity: FixedBigRational) :
    Measure<English, Fortnights>(Fortnights, quantity) {
    companion object Fortnights : EnglishTimes<Fortnights>(
        "fortnight", (1_209_600 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Fortnight(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity fortnights"
    }
}

val FixedBigRational.fortnights get() = Fortnights.new(this)
val Long.fortnights get() = (this over 1).fortnights
val Int.fortnights get() = (this over 1).fortnights

class Quinzième private constructor(quantity: FixedBigRational) :
    Measure<English, Quinzièmes>(Quinzièmes, quantity) {
    companion object Quinzièmes : EnglishTimes<Quinzièmes>(
        "quinzième", (1_296_000 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Quinzième(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity quinzièmes"
    }
}

val FixedBigRational.quinzièmes get() = Quinzièmes.new(this)
val Long.quinzièmes get() = (this over 1).quinzièmes
val Int.quinzièmes get() = (this over 1).quinzièmes
