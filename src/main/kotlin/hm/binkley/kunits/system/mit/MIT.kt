package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.length.Inches
import hm.binkley.kunits.system.mit.length.Smoots
import hm.binkley.math.times

object MIT : System<MIT>()

fun <U : Lengths<MIT, U>, V : Lengths<English, V>> Measure<MIT, U>.into(
    other: V,
) = Inches.new(convertTo(Smoots).value * 67).convertTo(other)
