package hm.binkley.kunits.system.english

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.System
import hm.binkley.kunits.system.english.length.Yards
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.math.div

object English : System<English>()

fun <U : Lengths<English, U>, V : Lengths<FFF, V>> Measure<English, U>.into(
    other: V
) = Furlongs.new(this.convertTo(Yards).value / 220).convertTo(other)

// TODO: Conversion from English weights to Firkin
// fun <U : Masses<English, U>, V : Masses<FFF, V>> Measure<English, U>.into(
//    other: V
// ): Nothing = TODO("CONVERT ENGLISH TO FFF")
