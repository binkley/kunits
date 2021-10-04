<a href="LICENSE.md">
<img src="./images/public-domain.png" alt="Public Domain" align="right"/>
</a>

# KUnits

Units of measurement in Kotlin

<img src="./images/kunits.png" alt="KUnits" align="right" width="20%"/>

[![build](https://github.com/binkley/kunits/workflows/build/badge.svg)](https://github.com/binkley/kunits/actions)
[![issues](https://img.shields.io/github/issues/binkley/kunits.svg)](https://github.com/binkley/kunits/issues/)
[![vulnerabilities](https://snyk.io/test/github/binkley/kunits/badge.svg)](https://snyk.io/test/github/binkley/kunits)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

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

#### Syntactic sugar

There are too many options on what "nice" Kotlin syntactic sugar looks 
like.  The most "natural English" approach might be:
```
2.feet in Inches // *not* valid Kotlin
```
However, this is a compilation failure as the "in" needs to be "\`in\`" since 
`in` is a keyword.

Another is:
```
2.feet to Inches
```
This works, but is confusing in context of the `to` function for creating 
a `Pair` instance.

Note both of the above are also more verbose in some situations, as in:
```
24.inches shouldBe (2.feet to Inches)
```
This needs parentheses so that `2.feet` does not bind more tightly to the 
left-hand `shouldBe` infix function than to the right-hand `to` infix 
function.

Another is just skip syntactic sugar:
```
Feet(2).convertTo(Inches)
```
This loses the pleasantness of Kotlin, and might as well be Java (with a 
`new` keyword added for that language).

A compromise is to chain extension properties, which pleases no one:
```
2.feet.inches
```
And this violates what extension properties are for.

#### Inline

The trivial extension properties for converting `Int` (and other numeric 
types) to English Units could be `inline`. However [_Kotlin inline 
functions are not marked as
covered_](https://github.com/jacoco/jacoco/issues/654) causes code 
coverage to fail.

Following [the rules](https://wiki.c2.com/?MakeItWorkMakeItRightMakeItFast),
`inline` is removed for now, until JaCoCo resolves this issue. In hindsight,
one wishes `inline` were an annotation rather than a keyword: it should be a
compiler hint, not a command, and the compiler should inline automatically, as
it makes sense, without the programmer being explicit.

#### Gaps

The code has not yet explored conversions between systems of units, _eg_,
between metric and English units.

## Reading

* [_Avoirdupois system_](https://en.wikipedia.org/wiki/Avoirdupois_system)
* [_Chart showing the relationships of distance
  measures_](https://en.wikipedia.org/wiki/English_units#/media/File:English_Length_Units_Graph.svg)
* [_English units_](https://en.wikipedia.org/wiki/English_units)
* [_English Weights &amp;
  Measures_](http://home.clara.net/brianp/quickref.html)
* [_FFF system_](https://en.wikipedia.org/wiki/FFF_system)
* [_Imperial units_](https://en.wikipedia.org/wiki/Imperial_units)
* [_Physikal_](https://github.com/Tenkiv/Physikal)
* [_PostCSS Imperial_](https://github.com/sebdeckers/postcss-imperial)
* [_Smoot_](https://en.wikipedia.org/wiki/Smoot)
