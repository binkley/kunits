package hm.binkley.kunits

import hm.binkley.kunits.Alice.Alices
import hm.binkley.kunits.BarMeasure.Bar
import hm.binkley.kunits.BazMeasure.Baz
import hm.binkley.kunits.FooMeasure.Foo
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

infix fun <
    V : Units<Martian, Length, V, N>,
    N : Measure<Martian, Length, V, N>,
    >
MetasyntacticLength<*, *>.intoMartian(other: V) = into(other) {
    it * (3 over 1)
}

sealed class MetasyntacticLengths<
    U : MetasyntacticLengths<U, M>,
    M : MetasyntacticLength<U, M>,
    >(
    name: String,
    basis: FixedBigRational,
) : Units<Metasyntactic, Length, U, M>(Metasyntactic, Length, name, basis)

sealed class MetasyntacticLength<
    U : MetasyntacticLengths<U, M>,
    M : MetasyntacticLength<U, M>,
    >(
    units: U,
    quantity: FixedBigRational,
) : Measure<Metasyntactic, Length, U, M>(units, quantity)

class FooMeasure private constructor(value: FixedBigRational) :
    MetasyntacticLength<Foo, FooMeasure>(Foo, value) {
    companion object Foo : MetasyntacticLengths<Foo, FooMeasure>(
        "foo", ONE
    ) {
        override fun new(quantity: FixedBigRational) = FooMeasure(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity foo"
    }
}

val FixedBigRational.foo get() = FooMeasure.new(this)
val Long.foo get() = (this over 1).foo
val Int.foo get() = (this over 1).foo

class BarMeasure private constructor(value: FixedBigRational) :
    MetasyntacticLength<Bar, BarMeasure>(Bar, value) {
    companion object Bar : MetasyntacticLengths<Bar, BarMeasure>(
        "bar", TWO
    ) {
        override fun new(quantity: FixedBigRational) = BarMeasure(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity bar"
    }
}

val FixedBigRational.bar get() = Bar.new(this)
val Long.bar get() = (this over 1).bar
val Int.bar get() = (this over 1).bar

class BazMeasure private constructor(value: FixedBigRational) :
    MetasyntacticLength<Baz, BazMeasure>(Baz, value) {
    companion object Baz : MetasyntacticLengths<Baz, BazMeasure>(
        "baz", 4 over 1
    ) {
        override fun new(quantity: FixedBigRational) = BazMeasure(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity baz"
    }
}

val FixedBigRational.baz get() = Baz.new(this)
val Long.baz get() = (this over 1).baz
val Int.baz get() = (this over 1).baz

sealed class MetasyntacticTimes<
    U : MetasyntacticTimes<U, M>,
    M : MetasyntacticTime<U, M>,
    >(
    name: String,
    basis: FixedBigRational,
) : Units<Metasyntactic, Time, U, M>(Metasyntactic, Time, name, basis)

sealed class MetasyntacticTime<
    U : MetasyntacticTimes<U, M>,
    M : MetasyntacticTime<U, M>,
    >(
    units: U,
    quantity: FixedBigRational,
) : Measure<Metasyntactic, Time, U, M>(units, quantity)

class Spam private constructor(value: FixedBigRational) :
    MetasyntacticTime<Spams, Spam>(Spams, value) {
    companion object Spams : MetasyntacticTimes<Spams, Spam>(
        "spam", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Spam(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity spams"
    }
}

val FixedBigRational.spams get() = Spams.new(this)
val Long.spams get() = (this over 1).spams
val Int.spams get() = (this over 1).spams

sealed class MetasyntacticWeights<
    U : MetasyntacticWeights<U, M>,
    M : MetasyntacticWeight<U, M>,
    >(
    name: String,
    basis: FixedBigRational,
) : Units<Metasyntactic, Weight, U, M>(Metasyntactic, Weight, name, basis)

sealed class MetasyntacticWeight<
    U : MetasyntacticWeights<U, M>,
    M : MetasyntacticWeight<U, M>,
    >(
    units: U,
    quantity: FixedBigRational,
) : Measure<Metasyntactic, Weight, U, M>(units, quantity)

class Fred private constructor(value: FixedBigRational) :
    MetasyntacticWeight<Freds, Fred>(Freds, value) {
    companion object Freds : MetasyntacticWeights<Freds, Fred>(
        "fred", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Fred(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity freds"
    }
}

val FixedBigRational.freds get() = Freds.new(this)
val Long.freds get() = (this over 1).freds
val Int.freds get() = (this over 1).freds

sealed class MetasyntacticDenominations<
    U : MetasyntacticDenominations<U, M>,
    M : MetasyntacticDenomination<U, M>,
    >(
    name: String,
    basis: FixedBigRational,
) : Units<Metasyntactic, Denomination, U, M>(Metasyntactic, Denomination, name, basis)

sealed class MetasyntacticDenomination<
    U : MetasyntacticDenominations<U, M>,
    M : MetasyntacticDenomination<U, M>,
    >(
    units: U,
    quantity: FixedBigRational,
) : Measure<Metasyntactic, Denomination, U, M>(units, quantity)

class Alice private constructor(value: FixedBigRational) :
    MetasyntacticDenomination<Alices, Alice>(Alices, value) {
    companion object Alices : MetasyntacticDenominations<Alices, Alice>(
        "alice", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Alice(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity alices"
    }
}

val FixedBigRational.alices get() = Alices.new(this)
val Long.alices get() = (this over 1).alices
val Int.alices get() = (this over 1).alices

object ShoeSize : Kind("shoe size")

sealed class MetasyntacticShoeSizes<
    U : MetasyntacticShoeSizes<U, M>,
    M : MetasyntacticShoeSize<U, M>,
    >(
    name: String,
    basis: FixedBigRational,
) : Units<Metasyntactic, ShoeSize, U, M>(Metasyntactic, ShoeSize, name, basis)

sealed class MetasyntacticShoeSize<
    U : MetasyntacticShoeSizes<U, M>,
    M : MetasyntacticShoeSize<U, M>,
    >(
    units: U,
    quantity: FixedBigRational,
) : Measure<Metasyntactic, ShoeSize, U, M>(units, quantity)

class Toto private constructor(value: FixedBigRational) :
    MetasyntacticShoeSize<Totos, Toto>(Totos, value) {
    companion object Totos : MetasyntacticShoeSizes<Totos, Toto>(
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

infix fun <
    V : Units<Metasyntactic, Length, V, N>,
    N : Measure<Metasyntactic, Length, V, N>,
    >
Measure<Martian, Length, *, *>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}

class Grok private constructor(value: FixedBigRational) :
    Measure<Martian, Length, Groks, Grok>(Groks, value) {
    companion object Groks : Units<Martian, Length, Groks, Grok>(
        Martian, Length, "grok", ONE
    ) {
        override fun new(quantity: FixedBigRational) = Grok(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity groks"
    }
}

val FixedBigRational.groks get() = Groks.new(this)
val Long.groks get() = (this over 1).groks
val Int.groks get() = (this over 1).groks
