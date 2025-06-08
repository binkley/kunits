package hm.binkley.kunits.system.fff.area

import hm.binkley.kunits.Area
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.system.fff.FFF
import hm.binkley.kunits.system.fff.area.FootFathomMeasure.FootFathom
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

/** The furlong-firkin-fortnight units of area. */
sealed class FFFAreas<
    U : FFFAreas<U, M>,
    M : FFFArea<U, M>
    >(
    name: String,
    footFathoms: FixedBigRational
) : Units<Area, FFF, U, M>(Area, FFF, name, footFathoms)

sealed class FFFArea<
    U : FFFAreas<U, M>,
    M : FFFArea<U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Area, FFF, U, M>(unit, quantity)

class FootFathomMeasure(quantity: FixedBigRational) :
    FFFArea<FootFathom, FootFathomMeasure>(FootFathom, quantity) {
    companion object FootFathom : FFFAreas<FootFathom, FootFathomMeasure>(
        "foot-fathom",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) =
            FootFathomMeasure(quantity)

        override fun format(quantity: FixedBigRational) = "$quantity ft-fath"
    }
}

val FixedBigRational.footFathom get() = FootFathom.new(this)
val Long.footFathom get() = (this over 1).footFathom
val Int.footFathom get() = (this over 1).footFathom
