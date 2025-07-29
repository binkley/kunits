package hm.binkley.kunits

import hm.binkley.math.fixed.over

/** Conversion from FFF to English for standard units of length. */
val FURLONGS_PER_LINE = 1 over 95_040

/** Conversion from FFF to English for standard units of time. */
val FORTNIGHTS_PER_SECOND = 1 over 1_209_600

/** Conversion from FFF to English for standard units of weight. */
val FIRKINS_PER_DRAM = 1 over 23_040

/**
 * Conversion from Lancre pennies to Ankh-Morpork dollars in the Disword.
 * Note that:
 * - 240 pence to the dollar in Ankh-Morpork
 * - 100 Lancre pennies to the Ankh-Morpork dollar
 */
val ANKH_MORPORK_PENCE_PER_LANCRE_PENNY = 100 over 240

/** Conversion from English to MIT for standard units of length. */
val SMOOTS_PER_LINE = 1 over 804
