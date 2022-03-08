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

This project covers mostly silly units: Metric is uninteresting except that
being based on base 10, it is not representable by binary computers; the
French revolutionaries overlooked that.

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

Test coverage is 100% for lines and branches (and no ignored code).

### Systems of units

* English
* FFF
* MIT
* USD

### Kotlin rational

This library depends on
[`kotlin-rational`](https://github.com/binkley/kotlin-rational) for
representing big rationals.

Presently there is no published dependency for `kotlin-rational`. To build
KUnits, install locally from the `kotlin-rational-2.1.1` tag.

### Platform

This code targets JDK 17.

## Design

### API

- [`System`](src/main/kotlin/hm/binkley/kunits/Units.kt) representing a
  system of units
- `Units` representing units of measurement
- `Measure` representing concrete quantities
  ([`FixedBigRational`](#kotlin-rational)) of a unit

Included for `Measure` are the usual simple arithmetic operations.

Specializations of `Units` for units of the same kind:

- `Lengths`
- `Times`
- `Weights`
- `Denominations`


The exemplar of quirkiness is traditional
[_English units_](https://en.wikipedia.org/wiki/English_units):

- [English units of length](src/main/kotlin/hm/binkley/kunits/system/english/length/EnglishLengths.kt)
- [English units of weight](src/main/kotlin/hm/binkley/kunits/system/english/weight/EnglishWeights.kt)

A real but whimsical complete system of units is
[Furlong-Firkin-Fortnight](https://en.wikipedia.org/wiki/FFF_system):

- [FFF units of length](src/main/kotlin/hm/binkley/kunits/system/fff/length/FFFLengths.kt)
- [FFF units of time](src/main/kotlin/hm/binkley/kunits/system/fff/time/FFFTimes.kt)
- [FFF units of weight](src/main/kotlin/hm/binkley/kunits/system/fff/weight/FFFWeights.kt)

Unreal and whimsical systems of units for testing:

- [`Metasyntactic`](src/test/kotlin/hm/binkley/kunits/test-systems.kt)
- `Martian`

Below is the source of the `Martian` system of units showing the minimal 
code needed for setting up a system of units:

```kotlin
object Martian : System<Martian>("Martian")

sealed class MartianLengths<U : MartianLengths<U>>(
    name: String,
    bar: FixedBigRational,
) : Lengths<Martian, U>(Martian, name, bar)

class Grok private constructor(value: FixedBigRational) :
    Measure<Martian, Groks>(Groks, value) {

    companion object Groks : MartianLengths<Groks>("grok", ONE) {
        override fun new(value: FixedBigRational) = Grok(value)
        override fun format(value: FixedBigRational) = "$value groks"
    }
}

val FixedBigRational.groks get() = Groks.new(this)
val Long.groks get() = (this over 1).groks
val Int.groks get() = (this over 1).groks
```

For convenience, systems of units may provide conversions to other systems:

```kotlin
infix fun <U : MetasyntacticLengths<U>, V : MartianLengths<V>>
        Measure<Metasyntactic, U>.intoMartian(other: V) = into(other) {
        it * (3 over 1)
    }
```

### Problems

#### Syntactic sugar

There are too many options on what "nice" Kotlin syntactic sugar looks
like. The most "natural English" approach might be:

```kotlin
2.feet in Inches // *not* valid Kotlin
```

However, this is a compilation failure as the "in" needs to be "\`in\`" since
`in` is a keyword.

Another is:

```kotlin
2.feet to Inches
```

This works, but is confusing in context of the `to` function for creating
a `Pair` instance.

Note both of the above are also more verbose in some situations, as in:

```kotlin
(2.feet to Inches) shouldBe 24.inches
```

This needs parentheses so that `2.feet` does not bind more tightly to the
left-hand `shouldBe` infix function than to the right-hand `to` infix
function.

Another is to just skip syntactic sugar:

```kotlin
Feet(2).into(Inches)
```

This loses the pleasantness of Kotlin, and might as well be Java (with a
`new` keyword added for that language).

The chosen compromise is to use `into` instead of `in` or `to`, and accept 
the verbosity of chaining infix functions:

```kotlin
2.feet into Inches
(2.feet into Inches) shouldBe 24.inches
```

#### Inline

The trivial extension properties for converting `Int`, `Long`, and 
`FixedBigRational` into units could be `inline`. However, [_Kotlin inline
functions are not marked as
covered_](https://github.com/jacoco/jacoco/issues/654) lowers test coverage.

Following [_The Rules_](https://wiki.c2.com/?MakeItWorkMakeItRightMakeItFast),
`inline` is removed for now, until JaCoCo resolves this issue.

#### Mixing compile errors with runtime errors for the same problem

Incompatible unit conversions are inconsistent. The two cases are:

1. Converting between units of different kinds (say, lengths and weights) in
   the same system of units
2. Converting between units of the same kind (say, lengths) but in different
   systems of units

Behavior:

* Ideal &mdash; incompatible conversions do not compile
* Actual &mdash; conversions between systems with `into` do not compile (use
  a dedicated function such as
  [`intoEnglish`](src/main/kotlin/hm/binkley/kunits/system/fff/FFF.kt)), and
  conversions within a system for units of different kinds (_eg_, lengths
  to weights) raises a runtime exception

```kotlin
// Compiles but raises exception: both are English units but of different 
// kinds:
1.foot into Pounds
// Does not compile: both are lengths, but of different systems:
1.smoot into Inches
// This would both compile and run successfully:
1.smoot intoEnglish Inches
```

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
* [_Units &amp; Systems of Units_](https://www.sizes.com/units/)
