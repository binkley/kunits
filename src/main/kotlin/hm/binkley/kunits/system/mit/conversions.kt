package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Length
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.mit.length.Smoots
import hm.binkley.math.times
import hm.binkley.kunits.system.english.length.Inches as EnglishInches

/** Converts lengths from MIT to English units. */
fun <U : Length<MIT, U>, V : Length<English, V>>
Measure<MIT, U>.toEnglish(other: V) =
    EnglishInches.new(convertTo(Smoots).value * 67).convertTo(other)
