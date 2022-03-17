package hm.binkley.kunits

import hm.binkley.kunits.Alice.Alices
import hm.binkley.kunits.Bar.Bar
import hm.binkley.kunits.Baz.Baz
import hm.binkley.kunits.Foo.Foo
import hm.binkley.kunits.Fred.Freds
import hm.binkley.kunits.Grok.Groks
import hm.binkley.kunits.Spam.Spams
import hm.binkley.kunits.Toto.Totos
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TWO
import hm.binkley.math.fixed.over

/**
 * System of units for testing named after metasyntactic variables:
 * - [MetasyntacticLengths]: foo, bar, baz ("C")
 * - [MetasyntacticTimes]: spam, ham, eggs (Python)
 * - [MetasyntacticWeights]: fred, barney (British)
 * - [MetasyntacticDenominations]: alice, bob (Security)
 * - [MetasyntacticShoeSizes]: toto, titi, tata (French)
 *
 * See https://foldoc.org/metasyntactic+variable and
 * https://en.wikipedia.org/wiki/Metasyntactic_variable
 */
object Metasyntactic : System<Metasyntactic>("Metasyntactic")

infix fun <U : MetasyntacticLengths<U>, V : MartianLengths<V>>
Measure<Metasyntactic, U>.intoMartian(other: V) = into(other) {
    it * (3 over 1)
}

sealed class MetasyntacticLengths<U : MetasyntacticLengths<U>>(
    name: String,
    foo: FixedBigRational,
) : Units<Metasyntactic, U>(Metasyntactic, name, foo)

class Foo private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Foo>(Foo, value) {
    companion object Foo : MetasyntacticLengths<Foo>(
        "foo", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Foo(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity foo"
    }
}

val FixedBigRational.foo get() = Foo.new(this)
val Long.foo get() = (this over 1).foo
val Int.foo get() = (this over 1).foo

class Bar private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Bar>(Bar, value) {
    companion object Bar : MetasyntacticLengths<Bar>(
        "bar", TWO
    ) {
        override fun new(quantity: FixedBigRational) = Bar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity bar"
    }
}

val FixedBigRational.bar get() = Bar.new(this)
val Long.bar get() = (this over 1).bar
val Int.bar get() = (this over 1).bar

class Baz private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Baz>(Baz, value) {
    companion object Baz : MetasyntacticLengths<Baz>(
        "baz", 4 over 1
    ) {
        override fun new(quantity: FixedBigRational) = Baz(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity baz"
    }
}

val FixedBigRational.baz get() = Baz.new(this)
val Long.baz get() = (this over 1).baz
val Int.baz get() = (this over 1).baz

sealed class MetasyntacticTimes<U : MetasyntacticTimes<U>>(
    name: String,
    spams: FixedBigRational,
) : Units<Metasyntactic, U>(Metasyntactic, name, spams)

class Spam private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Spams>(Spams, value) {
    companion object Spams : MetasyntacticTimes<Spams>(
        "spam", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Spam(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity spams"
    }
}

val FixedBigRational.spams get() = Spams.new(this)
val Long.spams get() = (this over 1).spams
val Int.spams get() = (this over 1).spams

sealed class MetasyntacticWeights<U : MetasyntacticWeights<U>>(
    name: String,
    freds: FixedBigRational,
) : Units<Metasyntactic, U>(Metasyntactic, name, freds)

class Fred private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Freds>(Freds, value) {
    companion object Freds : MetasyntacticWeights<Freds>(
        "fred", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Fred(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity freds"
    }
}

val FixedBigRational.freds get() = Freds.new(this)
val Long.freds get() = (this over 1).freds
val Int.freds get() = (this over 1).freds

sealed class MetasyntacticDenominations<U : MetasyntacticDenominations<U>>(
    name: String,
    alices: FixedBigRational,
) : Units<Metasyntactic, U>(Metasyntactic, name, alices)

class Alice private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Alices>(Alices, value) {
    companion object Alices : MetasyntacticDenominations<Alices>(
        "alice", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Alice(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity bobs"
    }
}

val FixedBigRational.alices get() = Alices.new(this)
val Long.alices get() = (this over 1).alices
val Int.alices get() = (this over 1).alices

sealed class MetasyntacticShoeSizes<U : MetasyntacticShoeSizes<U>>(
    name: String,
    totos: FixedBigRational,
) : Units<Metasyntactic, U>(Metasyntactic, name, totos)

class Toto private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Totos>(Totos, value) {
    companion object Totos : MetasyntacticShoeSizes<Totos>(
        "toto", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Toto(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity totos"
    }
}

val FixedBigRational.totos get() = Totos.new(this)
val Long.totos get() = (this over 1).totos
val Int.totos get() = (this over 1).totos

/** Alternate system, units, and measures for tests. */
object Martian : System<Martian>("Martian")

infix fun <U : MartianLengths<U>, V : MetasyntacticLengths<V>>
Measure<Martian, U>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}

sealed class MartianLengths<U : MartianLengths<U>>(
    name: String,
    bar: FixedBigRational,
) : Units<Martian, U>(Martian, name, bar)

class Grok private constructor(value: FixedBigRational) :
    Measure<Martian, Groks>(Groks, value) {
    companion object Groks : MartianLengths<Groks>(
        "grok", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Grok(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity groks"
    }
}

val FixedBigRational.groks get() = Groks.new(this)
val Long.groks get() = (this over 1).groks
val Int.groks get() = (this over 1).groks
