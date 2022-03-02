package hm.binkley.kunits.system.english

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.math.div
import hm.binkley.kunits.system.fff.length.Furlongs as FffFurlongs

/** Converts lengths from English to FFF units. */
fun <U : Length<English, U>, V : Length<FFF, V>>
Measure<English, U>.toFFF(other: V) =
    FffFurlongs.new(convertTo(Yards).value / 220).convertTo(other)
