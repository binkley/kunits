<a href="LICENSE.md">
<img src="./images/public-domain.png" alt="Public Domain" align="right"/>
</a>

# KUnits

Units of measurement in Kotlin

<img src="./images/kunits.png" alt="KUnits" align="right" width="20%"/>

[![build](https://github.com/binkley/kunits/workflows/build/badge.svg)](https://github.com/binkley/kunits/actions)
[![issues](https://img.shields.io/github/issues/binkley/kunits.svg)](https://github.com/binkley/kunits/issues/)
[![Public Domain](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

(This project covers mostly silly units: Metric is uninteresting except that
being based on base-10, it is not representable by binary computers; the
French revolutionaries overlooked that.)

* [Build](#build)
* [Design](#design)
* [Problems](#problems)
* [Kotlin rational](#kotlin-rational)
* [Reading](#reading)

## Build

Try [`./run`](./run) for a demonstration.

The build is vanilla [Maven](pom.xml), with [Batect](https://batect.dev)
offered as a means to reproduce locally what CI does.

```
# With Maven
$ ./mvnw clean verify
$ ./run
# With Batect
$ ./batect build
$ ./batect run
```

### Systems of units

* English
* FFF
* MIT

### Kotlin rational

This library depends on
[`kotlin-rational`](https://github.com/binkley/kotlin-rational) for
representing finite big rationals.

Presently there is no published dependency for `kotlin-rational`. To build
KUnits, install locally from the `finite-rational-1.0.0` tag.

### Platform

The code passed tests on JDK 11, and 13-15 (12 was not tested).

## Design

KUnits provides abstractions for representing systems of units in Kotlin, and
one quirky example,
[_English units_](https://en.wikipedia.org/wiki/English_units).  (Contrast
traditional English units with
[_Imperial units_](https://www.britannica.com/topic/Imperial-unit).)

This abstraction provides the usual arithmetic operations amongst units, _eg_,
additions, subtraction, multiplication, and division.

The top-level API represents:

- [`Units`](src/main/kotlin/hm/binkley/kunits/units.kt) representing units of
  measurement in the abstract with no quantities
- [`Measure`](src/main/kotlin/hm/binkley/kunits/units.kt) representing
  measurements in the concrete of a given unit with a quantity expressed as a
  [`FixedBigRational`](#kotlin-rational)

The code shows a generic pattern for implementing a Unit System with
[English units of length](src/main/kotlin/hm/binkley/kunits/system/english/length/english-lengths.kt)
as the real world exemplar, and
[FFF units of length](src/main/kotlin/hm/binkley/kunits/system/fff/length/fff-lengths.kt)
,
[FFF units of mass](src/main/kotlin/hm/binkley/kunits/system/fff/mass/fff-masses.kt)
, and
[FFF units of time](src/main/kotlin/hm/binkley/kunits/system/fff/time/fff-times.kt)
, as a whimsical full system. The pattern can also be seen in
[a test](src/test/kotlin/hm/binkley/kunit/UnitsTest.kt) based on
[_metasyntactic
variables_](https://en.wikipedia.org/wiki/Metasyntactic_variable) (`foo`,
`bar`, and ilk):

```kotlin
object Metasyntactic : System<Metasyntactic>()

sealed class MetasyntacticLengths<U : MetasyntacticLengths<U>>(
    name: String,
    bars: FixedBigRational,
) : Lengths<Metasyntactic, U>(Metasyntactic, name, bars)

object Foos : MetasyntacticLengths<Foos>("foo", ONE) {
    override fun new(value: FixedBigRational) = Foo(value)
    override fun format(value: FixedBigRational) = "$value foos"
}

class Foo(value: FixedBigRational) : Measure<Metasyntactic, Foos>(Foos, value)

inline val Int.foos get() = toBigRational().foos
inline val Long.foos get() = toBigRational().foos
inline val FixedBigRational.foos get() = Foo(this)
val Measure<Metasyntactic, *>.foos get() = to(Foos)
```

The code relies heavily on `Int` and [`FixedBigRational`](#kotlin-rational)
for representing measurements, and conversion ratios between units.

### Problems

#### Inline

The trivial properties for converting `Int` to English Units could be
`inline`. However
[_Kotlin inline functions are not marked as
covered_](https://github.com/jacoco/jacoco/issues/654)
causes code coverage to fail.

Following [the rules](https://wiki.c2.com/?MakeItWorkMakeItRightMakeItFast),
`inline` is removed for now, until JaCoCo resolves this issue. In hindsight,
one wishes `inline` were an annotation rather than a keyword: it should be a
compiler hint, not a command, and the compiler should inline automatically, as
it makes sense, without the programmer being explicit.

#### Gaps

The code has not yet explored conversions between systems of units, _eg_,
between metric and English units.

## Reading

* [_Physikal_](https://github.com/Tenkiv/Physikal)
* [_English units_](https://en.wikipedia.org/wiki/English_units)
* [_Imperial units_](https://en.wikipedia.org/wiki/Imperial_units)
* [_PostCSS Imperial_](https://github.com/sebdeckers/postcss-imperial)
* [_FFF system_](https://en.wikipedia.org/wiki/FFF_system)
* [_Smoot_](https://en.wikipedia.org/wiki/Smoot)
