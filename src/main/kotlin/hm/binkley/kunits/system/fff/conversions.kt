package hm.binkley.kunits.system.fff

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.fff.length.Furlongs
import hm.binkley.math.times
import hm.binkley.kunits.system.english.length.Yards as EnglishYards

/** Converts lengths from FFF to English units. */
fun <U : Length<FFF, U>, V : Length<English, V>>
Measure<FFF, U>.toEnglish(other: V) =
    EnglishYards.new(convertTo(Furlongs).value * 220).convertTo(other)
