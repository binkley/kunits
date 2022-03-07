package hm.binkley.kunits

import hm.binkley.kunits.Bar.Bar
import hm.binkley.kunits.Baz.Baz
import hm.binkley.kunits.Foo.Foo
import hm.binkley.kunits.Grok.Groks
import hm.binkley.kunits.Spam.Spams
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TWO
import hm.binkley.math.fixed.over

// Main system, units, and measures for tests
object Metasyntactic : System<Metasyntactic>("Metasyntactic")

infix fun <U : MetasyntacticLengths<U>, V : MartianLengths<V>>
Measure<Metasyntactic, U>.intoMartian(other: V) = into(other) {
    it * (3 over 1)
}

sealed class MetasyntacticLengths<U : MetasyntacticLengths<U>>(
    name: String,
    foo: FixedBigRational,
) : Lengths<Metasyntactic, U>(Metasyntactic, name, foo)

class Foo private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Foo>(Foo, value) {

    companion object Foo : MetasyntacticLengths<Foo>("foo", ONE) {
        override fun new(value: FixedBigRational) = Foo(value)
        override fun format(value: FixedBigRational) = "$value foo"
    }
}

val FixedBigRational.foo get() = Foo.new(this)
val Long.foo get() = (this over 1).foo
val Int.foo get() = (this over 1).foo

class Bar private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Bar>(Bar, value) {

    companion object Bar : MetasyntacticLengths<Bar>("bar", TWO) {
        override fun new(value: FixedBigRational) = Bar(value)
        override fun format(value: FixedBigRational) = "$value bar"
    }
}

val FixedBigRational.bar get() = Bar.new(this)
val Long.bar get() = (this over 1).bar
val Int.bar get() = (this over 1).bar

class Baz private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Baz>(Baz, value) {

    companion object Baz : MetasyntacticLengths<Baz>("baz", (4 over 1)) {
        override fun new(value: FixedBigRational) = Baz(value)
        override fun format(value: FixedBigRational) = "$value baz"
    }
}

val FixedBigRational.baz get() = Baz.new(this)
val Long.baz get() = (this over 1).baz
val Int.baz get() = (this over 1).baz

sealed class MetasyntacticWeights<U : MetasyntacticWeights<U>>(
    name: String,
    bar: FixedBigRational,
) : Weights<Metasyntactic, U>(Metasyntactic, name, bar)

class Spam private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Spams>(Spams, value) {

    companion object Spams : MetasyntacticWeights<Spams>("spam", ONE) {
        override fun new(value: FixedBigRational) = Spam(value)
        override fun format(value: FixedBigRational) = "$value spams"
    }
}

val FixedBigRational.spams get() = Spams.new(this)
val Long.spams get() = (this over 1).spams
val Int.spams get() = (this over 1).spams

// Alternate system, units, and measures for tests
object Martian : System<Martian>("Martian")

infix fun <U : MartianLengths<U>, V : MetasyntacticLengths<V>>
Measure<Martian, U>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}

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
