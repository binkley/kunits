package hm.binkley.kunits.system.english

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.div
import hm.binkley.kunits.system.fff.length.Furlongs as FffFurlongs

fun <U : Lengths<English, U>, V : Lengths<FFF, V>>
Measure<English, U>.into(other: V) =
    FffFurlongs.new(convertTo(Yards).value / 220).convertTo(other)