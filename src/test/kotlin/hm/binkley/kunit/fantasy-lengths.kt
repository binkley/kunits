package hm.binkley.kunit

import hm.binkley.math.finite.FiniteBigRational
import hm.binkley.math.finite.FiniteBigRational.Companion.ONE
import hm.binkley.math.finite.div
import hm.binkley.math.finite.over

object Fantasy : System<Fantasy>("Fantasy")

fun <U : Lengths<Fantasy, U>, V : Lengths<Qux, V>> Measure<Fantasy, U>.into(
    other: V
) = Bars.new(this.to(Smidges).value / 17).to(other)

sealed class FantasyLengths<U : FantasyLengths<U>>(
    name: String,
    bars: FiniteBigRational
) : Lengths<Fantasy, U>(Fantasy, name, bars)

object Smidges : FantasyLengths<Smidges>("smidge", ONE) {
    override fun new(value: FiniteBigRational) = Smidge(value)
    override fun format(value: FiniteBigRational) = "$value sm"
}

class Smidge(value: FiniteBigRational) :
    Measure<Fantasy, Smidges>(Smidges, value)

inline val Int.smidges get() = (this over 1).smidges
inline val FiniteBigRational.smidges get() = Smidge(this)
