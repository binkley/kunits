<a href="LICENSE.md">
<img src="./images/public-domain.png" alt="Public Domain" align="right"/>
</a>

# KUnits

Units of measure in Kotlin

<img src="./images/kunits.png" alt="KUnits" align="right" width="20%"/>

[![build](https://github.com/binkley/kunits/workflows/build/badge.svg)](https://github.com/binkley/kunits/actions)
[![issues](https://img.shields.io/github/issues/binkley/kunits.svg)](https://github.com/binkley/kunits/issues/)
[![vulnerabilities](https://snyk.io/test/github/binkley/kunits/badge.svg)](https://snyk.io/test/github/binkley/kunits)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

This project covers historical, fantasy, or whimsical units: Metric is
uninteresting except that being based on base 10, it is not representable
by binary computers; the French revolutionaries overlooked that.
USD is provided as a practical example.

The project is a demonstration of the power (and limits) of generics in
Kotlin, and writing a clean DSL: see
[`main.kt`](src/main/kotlin/hm/binkley/kunits/main.kt).
It is also fun.

* [Build](#build)
* [Design](#design)
* [Considerations](#considerations)
* [Kotlin rational](#kotlin-rational)
* [Reading](#reading)

## Build

Try [`./run`](./run) for a demonstration.

The build is vanilla [Maven](pom.xml), with [Batect](https://batect.dev)
offered as a means to reproduce locally what CI does.

```
$ ./mvnw clean verify
$ ./run
# Or:
$ ./batect build
$ ./batect demo
```

Test coverage is 100% for lines, branches, and instructions.

### Systems of units

* [English](src/main/kotlin/hm/binkley/kunits/system/english/)
* [FFF](src/main/kotlin/hm/binkley/kunits/system/fff/)
* [MIT](src/main/kotlin/hm/binkley/kunits/system/mit/)
* [USD](src/main/kotlin/hm/binkley/kunits/system/usd/)
* [D&amp;D](src/main/kotlin/hm/binkley/kunits/system/dnd/)

### Kotlin rational

This library depends on
[`kotlin-rational`](https://github.com/binkley/kotlin-rational) for
representing big rationals.

Presently there is no published dependency for `kotlin-rational`.
To build KUnits, install locally from the `kotlin-rational-2.2.0` tag.

### Platform

This code targets JDK 17.

## Design

<!---
TODO: Unclear it is a good idea to use line numbers in links: means keeping
this file and code source in sync more than already the case.
-->
### DSL

#### Creating measures of units

- From `Int`s:
  [`120.lines`](src/main/kotlin/hm/binkley/kunits/main.kt#L53)
- From `Long`s:
  [`300L.drams`](src/main/kotlin/hm/binkley/kunits/main.kt#L89)
- From `FixedBigRational`s:
  [`(12_345 over 4).seconds`](src/main/kotlin/hm/binkley/kunits/main.kt#L71)

#### Arithmetic

- Idempotency:
  [`+m1`](src/main/kotlin/hm/binkley/kunits/main.kt#L54)
- Negation:
  [`-m1`](src/main/kotlin/hm/binkley/kunits/main.kt#L55)
- Addition:
  [`4.dollars + 33.cents`](src/main/kotlin/hm/binkley/kunits/main.kt#L107)
- Subtraction:
  [`(m1 into Hands) - m1`](src/main/kotlin/hm/binkley/kunits/main.kt#L60)
- Multiplication:
  [`m2 * 4`](src/main/kotlin/hm/binkley/kunits/main.kt#L79)
- Division:
  [`m2 / 4`](src/main/kotlin/hm/binkley/kunits/main.kt#L81)

#### Converting measures into other units

- Between units of the same kind within a system:
  [`m3 into Ounces`](src/main/kotlin/hm/binkley/kunits/main.kt#L93), or as
  shorthand, [`m1 /
  Barleycorns`](src/main/kotlin/hm/binkley/kunits/main.kt#L62) 
- Into multiple other units of the same kind within a system:
  [`m4.into(DollarCoins, HalfDollars, Quarters, Dimes, Nickels, 
  Pennies)`](src/main/kotlin/hm/binkley/kunits/main.kt#L108), or as shorthand,
  [`m4 % looseChange`](src/main/kotlin/hm/binkley/kunits/main.kt#L114)
- Between units of the same kind between different systems:
  [`1.smoots intoEnglish
  Inches`](src/main/kotlin/hm/binkley/kunits/main.kt#L127)

#### Pretty printing

- Default formatting:
  [`"${220.yards} IN $English IS ${220.yards intoFFF Furlongs} IN
  $FFF"`](src/main/kotlin/hm/binkley/kunits/main.kt#L126)
- Custom formatting:
  [`"- $it (${it.format()})"`](src/main/kotlin/hm/binkley/kunits/main.kt#L118)

### API

- [`Kind`](src/main/kotlin/hm/binkley/kunits/Units.kt#L9) represents a
  kind of units (_eg_,
  [`Length`](src/main/kotlin/hm/binkley/kunits/Units.kt#L18))
- [`System`](src/main/kotlin/hm/binkley/kunits/Units.kt#L29) represents a
  system of units (_eg_,
  [`English`](src/main/kotlin/hm/binkley/kunits/system/english/English.kt))
- [`Units`](src/main/kotlin/hm/binkley/kunits/Units.kt#L46) represents 
  units of measure (_eg_,
  [`MetasyntacticLengths`](src/test/kotlin/hm/binkley/kunits/test-systems.kt#37))
- [`Measure`](src/main/kotlin/hm/binkley/kunits/Units.kt#L98) represents 
  quantities of units (_eg_,
  [`m1`](src/main/kotlin/hm/binkley/kunits/main.kt#53))

Included for `Measure` are the usual simple arithmetic operations.

The exemplar of quirkiness is traditional
[_English units_](https://en.wikipedia.org/wiki/English_units):

- [English units of length](src/main/kotlin/hm/binkley/kunits/system/english/length/EnglishLengths.kt)
- [English units of time](src/main/kotlin/hm/binkley/kunits/system/english/time/EnglishTimes.kt)
- [English units of weight](src/main/kotlin/hm/binkley/kunits/system/english/weight/EnglishWeights.kt)

Unreal systems of units for testing:

- [`Metasyntactic`](src/test/kotlin/hm/binkley/kunits/test-systems.kt#L16)
- [`Martian`](src/test/kotlin/hm/binkley/kunits/test-systems.kt#L217)

Below is the source for the Martian system of units showing the minimal 
code needed for setting up a system of units:

```kotlin
// Define the Martian system of units, a singleton
object Martian : System<Martian>("Martian")

class Grok private constructor(value: FixedBigRational) :
  // Grok is a measure of length in the Martian system
  Measure<Length, Martian, Groks, Grok>(Groks, value) {
  // Groks are units measured as multiples of one grok
  companion object Groks : Units<Length, Martian, Groks, Grok>(
    Length, Martian, "grok", ONE
  ) {
    override fun new(quantity: FixedBigRational) = Grok(quantity)
    override fun format(quantity: FixedBigRational) = "$quantity groks"
  }
}

// Factory extension properties for creating some quantity of groks
val FixedBigRational.groks get() = Groks.new(this)
val Long.groks get() = (this over 1).groks
val Int.groks get() = (this over 1).groks
```

For convenience, systems of units may provide [conversions into other
systems](src/test/kotlin/hm/binkley/kunits/test-systems.kt#L28):

```kotlin
infix fun <
    V : Units<Length, Metasyntactic, V, N>,
    N : Measure<Length, Metasyntactic, V, N>,
    >
// Specialize converting Martian units of length to Metasyntactic ones
// Elsewhere, define the reflexive `intoMartian` to reverse the conversion
Measure<Length, Martian, *, *>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}
```

Typically, the base type for units of measure (`MartialLengths`, above) is
`sealed` as there is a known, fixed number of units.
However,
[`OtherDnDDenominations`](src/main/kotlin/hm/binkley/kunits/system/dnd/denomination/other/OtherDnDDenominations.kt)
is an example of extending a kind of units.

Also, see
[`ShoeSizes`](src/test/kotlin/hm/binkley/kunits/test-systems.kt#L185) for an 
example of creating new kinds of units.

#### Use of generics

Generic signatures pervade types and function signatures. The standard 
ordering is:

- `K` "kind" &mdash; is this length, weight, etc.
- `S` "system" &dash; is this English units, etc.
- `U` "unit" &dash; what unit is this?
- `M` "measure" &dash; how many units?

### Considerations

#### Syntactic sugar

> _Syntactic sugar causes cancer of the semicolon._<br/>
> &mdash; Alan J. Perlis

There are too many options for "nice" Kotlin syntactic sugar.
The most "natural English" approach might be:

```kotlin
2.feet in Inches // *not* valid Kotlin
```

However, this is a compilation failure as the "in" needs to be "\`in\`" since
`in` is a keyword in Kotlin.

Another might be:

```kotlin
2.feet to Inches
```

However, this overloads the universal `to` function for creating `Pair`s.

Or consider:

```kotlin
2.feet as Inches
```

Unfortunately, `as` is an existing keyword for type casting.

The chosen compromise is an infix
[`into`](src/main/kotlin/hm/binkley/kunits/conversions.kt#L8) function, 
and a more general version for [conversions into unit units of the same 
kind in another system](src/main/kotlin/hm/binkley/kunits/conversions.kt#L26).

```kotlin
2.feet into Inches
```

Though infix functions do not chain nicely:

```kotlin
2.feet into Inches shouldBe 24.inches // what you expect
2.feet shouldBe 24.inches into Feet // does not compile
```

More readable is:

```kotlin
(2.feet into Inches) shouldBe 24.inches // parentheses for readability
2.feet shouldBe (24.inches into Feet) // parentheses needed to compile
2.feet / Inches shouldBe 24.inches // operator binds more tightly than infix
2.feet shouldBe 24.inches / Feet // compiles, but harder to read
```

And parentheses are required for correct binding order in some cases:

```kotlin
24.inches shouldBe (2.feet into Inches)
```

One may skip syntactic sugar altogether:

```kotlin
Feet(2).into(Inches)
```

At the cost of losing some pleasantness of Kotlin.

#### Inline

The trivial extension properties for converting `Int`, `Long`, and 
`FixedBigRational` into units could be `inline` (as well as several others). 
However, JaCoCo's [_Kotlin inline functions are not marked as
covered_](https://github.com/jacoco/jacoco/issues/654) lowers test coverage,
and Kover's [_Feature request: Equivalent Maven
plugin_](https://github.com/Kotlin/kotlinx-kover/issues/51) does not support 
Maven.

Following [_The Rules_](https://wiki.c2.com/?MakeItWorkMakeItRightMakeItFast),
`inline` is removed for now, until JaCoCo resolves this issue.

#### Mixing compile errors with runtime errors for the same problem

Incompatible unit conversions are inconsistent. The two cases are:

1. Converting between units of different kinds (say, lengths and weights) in
   the same system of units
2. Converting between units of the same kind (say, lengths) but in different
   systems of units

Behavior:

* Operations between incompatible units do not compile.
  For example, you cannot convert feet into pounds

```kotlin
// Does not compile: feet and pounds are different kinds of units
1.feet into Pounds
// Does not compile: both are lengths, but of different systems:
1.smoots into Inches
// This would both compile and run successfully:
1.smoots intoEnglish Inches
```

## Reading

* [_10 Little-Known Units of
  Time_](https://www.mentalfloss.com/article/60080/10-little-known-units-time)
* [_Avoirdupois system_](https://en.wikipedia.org/wiki/Avoirdupois_system)
* [_Chart showing the relationships of distance
  measures_](https://en.wikipedia.org/wiki/English_units#/media/File:English_Length_Units_Graph.svg)
* [_English units_](https://en.wikipedia.org/wiki/English_units)
* [_English Weights &amp;
  Measures_](http://home.clara.net/brianp/quickref.html)
* [_FFF system_](https://en.wikipedia.org/wiki/FFF_system)
* [_Imperial units_](https://en.wikipedia.org/wiki/Imperial_units)
* [_metasyntactic variable_](https://foldoc.org/metasyntactic+variable)
* [_Physikal_](https://github.com/Tenkiv/Physikal)
* [_Smoot_](https://en.wikipedia.org/wiki/Smoot)
* [_Units of Measurement -
  API_](https://unitsofmeasurement.github.io/unit-api/)
* [_Units &amp; Systems of Units_](https://www.sizes.com/units/)
