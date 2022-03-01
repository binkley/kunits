package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.math.times

fun <U : Lengths<FFF, U>, V : Lengths<English, V>> Measure<FFF, U>.into(
    other: V,
) = Yards.new(convertTo(Furlongs).value * 220).convertTo(other)
