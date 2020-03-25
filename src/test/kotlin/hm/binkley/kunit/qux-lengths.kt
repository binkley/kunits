package hm.binkley.kunit

import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.over
import hm.binkley.math.finite.times

object Qux : System<Qux>("Qux")

fun <U : Lengths<Qux, U>, V : Lengths<Fantasy, V>> Measure<Qux, U>.into(
    other: V
) = Smidges.new(this.to(Bars).value * 17).to(other)

sealed class QuxLengths<U : QuxLengths<U>>(
    name: String,
    bars: FiniteBigRational
) : Lengths<Qux, U>(Qux, name, bars)

object Bars : QuxLengths<Bars>("bar", ONE) {
    override fun new(value: FiniteBigRational) = Bar(value)
    override fun format(value: FiniteBigRational) = "$value bars"
}

class Bar(value: FiniteBigRational) : Measure<Qux, Bars>(Bars, value)

inline val Int.bars get() = (this over 1).bars
inline val FiniteBigRational.bars get() = Bar(this)
