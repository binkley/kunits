package hm.binkley.kunits.system.english

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.math.div

fun <U : Lengths<English, U>, V : Lengths<FFF, V>> Measure<English, U>.into(
    other: V,
) = Furlongs.new(this.convertTo(Yards).value / 220).convertTo(other)
