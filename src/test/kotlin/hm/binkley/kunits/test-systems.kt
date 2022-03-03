package hm.binkley.kunits

import hm.binkley.kunits.Bar.Bar
import hm.binkley.kunits.Baz.Baz
import hm.binkley.kunits.Foo.Foo
import hm.binkley.kunits.Grok.Groks
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TWO
import hm.binkley.math.fixed.over

// Main system, units, and measures for tests
object Metasyntactic : System<Metasyntactic>("Metasyntactic")

infix fun <U : Length<Metasyntactic, U>, V : Length<Martian, V>>
Measure<Metasyntactic, U>.intoMartian(other: V) = into(other) {
    it * (3 over 1)
}

sealed class MetasyntacticLength<U : MetasyntacticLength<U>>(
    name: String,
    foo: FixedBigRational,
) : Length<Metasyntactic, U>(Metasyntactic, name, foo)

class Foo private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Foo>(Foo, value) {

    companion object Foo : MetasyntacticLength<Foo>("foo", ONE) {
        override fun new(value: FixedBigRational) = Foo(value)
        override fun format(value: FixedBigRational) = "$value foo"
    }
}

val Int.foo get() = (this over 1).foo
val Long.foo get() = (this over 1).foo
val FixedBigRational.foo get() = Foo.new(this)

class Bar private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Bar>(Bar, value) {

    companion object Bar : MetasyntacticLength<Bar>("bar", TWO) {
        override fun new(value: FixedBigRational) = Bar(value)
        override fun format(value: FixedBigRational) = "$value bar"
    }
}

val Int.bar get() = (this over 1).bar
val Long.bar get() = (this over 1).bar
val FixedBigRational.bar get() = Bar.new(this)

class Baz private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Baz>(Baz, value) {

    companion object Baz : MetasyntacticLength<Baz>("baz", (4 over 1)) {
        override fun new(value: FixedBigRational) = Baz(value)
        override fun format(value: FixedBigRational) = "$value baz"
    }
}

val Int.baz get() = (this over 1).baz
val Long.baz get() = (this over 1).baz
val FixedBigRational.baz get() = Baz.new(this)

// Alternate system, units, and measures for tests
object Martian : System<Martian>("Martian")

infix fun <U : Length<Martian, U>, V : Length<Metasyntactic, V>>
Measure<Martian, U>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}

sealed class MartianLength<U : MartianLength<U>>(
    name: String,
    bar: FixedBigRational,
) : Length<Martian, U>(Martian, name, bar)

class Grok private constructor(value: FixedBigRational) :
    Measure<Martian, Groks>(Groks, value) {

    companion object Groks : MartianLength<Groks>("grok", ONE) {
        override fun new(value: FixedBigRational) = Grok(value)
        override fun format(value: FixedBigRational) = "$value groks"
    }
}

val Int.groks get() = (this over 1).groks
val FixedBigRational.groks get() = Groks.new(this)
