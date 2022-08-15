/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

// Quinzième and ilk
@file:Suppress(
    "ClassName",
    "NonAsciiCharacters",
    "ObjectPropertyName",
)

package hm.binkley.kunits.system.english.time

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Time
import hm.binkley.kunits.Units
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

sealed class EnglishTimes<
    U : EnglishTimes<U, M>,
    M : EnglishTime<U, M>,
    >(
    name: String,
    seconds: FixedBigRational,
) : Units<Time, English, U, M>(Time, English, name, seconds)

sealed class EnglishTime<
    U : EnglishTimes<U, M>,
    M : EnglishTime<U, M>,
    >(
    unit: U,
    quantity: FixedBigRational,
) : Measure<Time, English, U, M>(unit, quantity)

class Atom private constructor(quantity: FixedBigRational) :
    EnglishTime<Atoms, Atom>(Atoms, quantity) {
    companion object Atoms : EnglishTimes<Atoms, Atom>(
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
    EnglishTime<Seconds, Second>(Seconds, quantity) {
    companion object Seconds : EnglishTimes<Seconds, Second>(
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
    EnglishTime<Minutes, Minute>(Minutes, quantity) {
    companion object Minutes : EnglishTimes<Minutes, Minute>(
        "minute", (60 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Minute(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity min"
    }
}

val FixedBigRational.minutes get() = Minutes.new(this)
val Double.minutes get() = (this over 1).minutes
val Long.minutes get() = (this over 1).minutes
val Int.minutes get() = (this over 1).minutes

class Moment private constructor(quantity: FixedBigRational) :
    EnglishTime<Moments, Moment>(Moments, quantity) {
    companion object Moments : EnglishTimes<Moments, Moment>(
        "moment", (90 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Moment(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity moments"
    }
}

val FixedBigRational.moments get() = Moments.new(this)
val Long.moments get() = (this over 1).moments
val Int.moments get() = (this over 1).moments

class Point private constructor(quantity: FixedBigRational) :
    EnglishTime<Points, Point>(Points, quantity) {
    companion object Points : EnglishTimes<Points, Point>(
        "point", (900 over 1)
    ) {
        override fun new(quantity: FixedBigRational) = Point(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity points"
    }
}

val FixedBigRational.points get() = Points.new(this)
val Long.points get() = (this over 1).points
val Int.points get() = (this over 1).points
val FixedBigRational.pricks get() = points
val Long.pricks get() = points
val Int.pricks get() = points

class Mileway private constructor(quantity: FixedBigRational) :
    EnglishTime<Mileways, Mileway>(Mileways, quantity) {
    companion object Mileways : EnglishTimes<Mileways, Mileway>(
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
    EnglishTime<Hours, Hour>(Hours, quantity) {
    companion object Hours : EnglishTimes<Hours, Hour>(
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
    EnglishTime<Quadrants, Quadrant>(Quadrants, quantity) {
    companion object Quadrants : EnglishTimes<Quadrants, Quadrant>(
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
    EnglishTime<Days, Day>(Days, quantity) {
    companion object Days : EnglishTimes<Days, Day>(
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
    EnglishTime<Weeks, Week>(Weeks, quantity) {
    companion object Weeks : EnglishTimes<Weeks, Week>(
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
    EnglishTime<Fortnights, Fortnight>(Fortnights, quantity) {
    companion object Fortnights : EnglishTimes<Fortnights, Fortnight>(
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
    EnglishTime<Quinzièmes, Quinzième>(Quinzièmes, quantity) {
    companion object Quinzièmes : EnglishTimes<Quinzièmes, Quinzième>(
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
