package hm.binkley.kunits

import hm.binkley.kunits.Bar.Bars
import hm.binkley.kunits.Foo.Foos
import hm.binkley.kunits.Grok.Groks
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.over

// Main system, units, and measures for tests
object Metasyntactic : System<Metasyntactic>("Metasyntactic")

infix fun <U : Length<Metasyntactic, U>, V : Length<Martian, V>>
Measure<Metasyntactic, U>.intoMartian(other: V) = into(other) {
    it * (3 over 1)
}

sealed class MetasyntacticLength<U : MetasyntacticLength<U>>(
    name: String,
    foos: FixedBigRational,
) : Length<Metasyntactic, U>(Metasyntactic, name, foos)

class Foo private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Foos>(Foos, value) {

    companion object Foos : MetasyntacticLength<Foos>(
        "foo",
        FixedBigRational.ONE
    ) {
        override fun new(value: FixedBigRational) = Foo(value)
        override fun format(value: FixedBigRational) = "$value foos"
    }
}

val Int.foos get() = (this over 1).foos
val Long.foos get() = (this over 1).foos
val FixedBigRational.foos get() = Foos.new(this)

class Bar private constructor(value: FixedBigRational) :
    Measure<Metasyntactic, Bars>(Bars, value) {

    companion object Bars : MetasyntacticLength<Bars>(
        "bar",
        FixedBigRational.TWO
    ) {
        override fun new(value: FixedBigRational) = Bar(value)
        override fun format(value: FixedBigRational) = "$value bars"
    }
}

val Int.bars get() = (this over 1).bars
val Long.bars get() = (this over 1).bars
val FixedBigRational.bars get() = Bars.new(this)

// Alternate system, units, and measures for tests
object Martian : System<Martian>("Martian")

infix fun <U : Length<Martian, U>, V : Length<Metasyntactic, V>>
Measure<Martian, U>.intoMetasyntactic(other: V) = into(other) {
    it * (1 over 3)
}

sealed class MartianLength<U : MartianLength<U>>(
    name: String,
    bars: FixedBigRational,
) : Length<Martian, U>(Martian, name, bars)

class Grok private constructor(value: FixedBigRational) :
    Measure<Martian, Groks>(Groks, value) {

    companion object Groks : MartianLength<Groks>(
        "grok",
        FixedBigRational.ONE
    ) {
        override fun new(value: FixedBigRational) = Grok(value)
        override fun format(value: FixedBigRational) = "$value groks"
    }
}

val Int.groks get() = (this over 1).groks
val FixedBigRational.groks get() = Groks.new(this)
