package hm.binkley.kunits.system.mit

import hm.binkley.kunits.Lengths
import hm.binkley.kunits.Measure
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.mit.length.Smoots
import hm.binkley.math.times
import hm.binkley.kunits.system.english.length.Inches as EnglishInches

fun <U : Lengths<MIT, U>, V : Lengths<English, V>>
Measure<MIT, U>.toEnglish(other: V) =
    EnglishInches.new(convertTo(Smoots).value * 67).convertTo(other)
