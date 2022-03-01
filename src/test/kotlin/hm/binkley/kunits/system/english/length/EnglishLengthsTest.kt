package hm.binkley.kunits.system.english.length

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishLengthsTest {
    @Test
    fun `should convert`() {
        1L.poppyseeds shouldBe 1.poppyseeds
        1.poppyseeds.barleycorns shouldBe (1 over 4).barleycorns
        1.poppyseeds.inches shouldBe (1 over 12).inches
        1.poppyseeds.sticks shouldBe (1 over 24).sticks
        1.poppyseeds.hands shouldBe (1 over 48).hands
        1.poppyseeds.feet shouldBe (1 over 144).feet
        1.poppyseeds.yards shouldBe (1 over 432).yards
        1.poppyseeds.ells shouldBe (1 over 540).ells
        1.poppyseeds.rods shouldBe (1 over 2_376).rods
        1.poppyseeds.chains shouldBe (1 over 9_504).chains
        1.poppyseeds.furlongs shouldBe (1 over 95_040).furlongs
        1.poppyseeds.miles shouldBe (1 over 760_320).miles
        1.poppyseeds.leagues shouldBe (1 over 2_280_960).leagues

        4.poppyseeds shouldBe 1.barleycorns.poppyseeds
        1L.barleycorns shouldBe 1.barleycorns
        1.barleycorns.inches shouldBe (1 over 3).inches
        1.barleycorns.sticks shouldBe (1 over 6).sticks
        1.barleycorns.hands shouldBe (1 over 12).hands
        1.barleycorns.feet shouldBe (1 over 36).feet
        1.barleycorns.yards shouldBe (1 over 108).yards
        1.barleycorns.ells shouldBe (1 over 135).ells
        1.barleycorns.rods shouldBe (1 over 594).rods
        1.barleycorns.chains shouldBe (1 over 2_376).chains
        1.barleycorns.furlongs shouldBe (1 over 23_760).furlongs
        1.barleycorns.miles shouldBe (1 over 190_080).miles
        1.barleycorns.leagues shouldBe (1 over 570_240).leagues

        12.poppyseeds shouldBe 1.inches.poppyseeds
        3.barleycorns shouldBe 1.inches.barleycorns
        1L.inches shouldBe 1.inches
        1.inches.sticks shouldBe (1 over 2).sticks
        1.inches.hands shouldBe (1 over 4).hands
        1.inches.feet shouldBe (1 over 12).feet
        1.inches.yards shouldBe (1 over 36).yards
        1.inches.ells shouldBe (1 over 45).ells
        1.inches.rods shouldBe (1 over 198).rods
        1.inches.chains shouldBe (1 over 792).chains
        1.inches.furlongs shouldBe (1 over 7_920).furlongs
        1.inches.miles shouldBe (1 over 63_360).miles
        1.inches.leagues shouldBe (1 over 190_080).leagues

        24.poppyseeds shouldBe 1.sticks.poppyseeds
        6.barleycorns shouldBe 1.sticks.barleycorns
        2.inches shouldBe 1.sticks.inches
        1L.sticks shouldBe 1.sticks
        1.sticks.hands shouldBe (1 over 2).hands
        1.sticks.feet shouldBe (1 over 6).feet
        1.sticks.yards shouldBe (1 over 18).yards
        1.sticks.ells shouldBe (2 over 45).ells
        1.sticks.rods shouldBe (1 over 99).rods
        1.sticks.chains shouldBe (1 over 396).chains
        1.sticks.furlongs shouldBe (1 over 3_960).furlongs
        1.sticks.miles shouldBe (1 over 31_680).miles
        1.sticks.leagues shouldBe (1 over 95_040).leagues

        48.poppyseeds shouldBe 1.hands.poppyseeds
        12.barleycorns shouldBe 1.hands.barleycorns
        4.inches shouldBe 1.hands.inches
        2.sticks shouldBe 1.hands.sticks
        1L.hands shouldBe 1.hands
        1.hands.feet shouldBe (1 over 3).feet
        1.hands.yards shouldBe (1 over 9).yards
        1.hands.ells shouldBe (4 over 45).ells
        1.hands.rods shouldBe (2 over 99).rods
        1.hands.chains shouldBe (1 over 198).chains
        1.hands.furlongs shouldBe (1 over 1_980).furlongs
        1.hands.miles shouldBe (1 over 15_840).miles
        1.hands.leagues shouldBe (1 over 47_520).leagues

        144.poppyseeds shouldBe 1.feet.poppyseeds
        36.barleycorns shouldBe 1.feet.barleycorns
        12.inches shouldBe 1.feet.inches
        6.sticks shouldBe 1.feet.sticks
        3.hands shouldBe 1.feet.hands
        1L.feet shouldBe 1.feet
        1.feet.yards shouldBe (1 over 3).yards
        1.feet.ells shouldBe (4 over 15).ells
        1.feet.rods shouldBe (2 over 33).rods
        1.feet.chains shouldBe (1 over 66).chains
        1.feet.furlongs shouldBe (1 over 660).furlongs
        1.feet.miles shouldBe (1 over 5_280).miles
        1.feet.leagues shouldBe (1 over 15_840).leagues

        432.poppyseeds shouldBe 1.yards.poppyseeds
        108.barleycorns shouldBe 1.yards.barleycorns
        36.inches shouldBe 1.yards.inches
        18.sticks shouldBe 1.yards.sticks
        9.hands shouldBe 1.yards.hands
        3.feet shouldBe 1.yards.feet
        1L.yards shouldBe 1.yards
        1.yards.ells shouldBe (4 over 5).ells
        1.yards.rods shouldBe (2 over 11).rods
        1.yards.furlongs shouldBe (1 over 220).furlongs
        1.yards.chains shouldBe (1 over 22).chains
        1.yards.miles shouldBe (1 over 1_760).miles
        1.yards.leagues shouldBe (1 over 5_280).leagues

        540.poppyseeds shouldBe 1.ells.poppyseeds
        135.barleycorns shouldBe 1.ells.barleycorns
        45.inches shouldBe 1.ells.inches
        (45 over 2).sticks shouldBe 1.ells.sticks
        (45 over 4).hands shouldBe 1.ells.hands
        (15 over 4).feet shouldBe 1.ells.feet
        (5 over 4).yards shouldBe 1.ells.yards
        1L.ells shouldBe 1.ells
        1.ells.rods shouldBe (5 over 22).rods
        1.ells.furlongs shouldBe (1 over 176).furlongs
        1.ells.chains shouldBe (5 over 88).chains
        1.ells.miles shouldBe (1 over 1_408).miles
        1.ells.leagues shouldBe (1 over 4_224).leagues

        2_376.poppyseeds shouldBe 1.rods.poppyseeds
        594.barleycorns shouldBe 1.rods.barleycorns
        198.inches shouldBe 1.rods.inches
        99.sticks shouldBe 1.rods.sticks
        (99 over 2).hands shouldBe 1.rods.hands
        (33 over 2).feet shouldBe 1.rods.feet
        (11 over 2).yards shouldBe 1.rods.yards
        (22 over 5).ells shouldBe 1.rods.ells
        1L.rods shouldBe 1.rods
        1.rods.chains shouldBe (1 over 4).chains
        1.rods.furlongs shouldBe (1 over 40).furlongs
        1.rods.miles shouldBe (1 over 320).miles
        1.rods.leagues shouldBe (1 over 960).leagues

        9_504.poppyseeds shouldBe 1.chains.poppyseeds
        2_376.barleycorns shouldBe 1.chains.barleycorns
        792.inches shouldBe 1.chains.inches
        396.sticks shouldBe 1.chains.sticks
        198.hands shouldBe 1.chains.hands
        66.feet shouldBe 1.chains.feet
        22.yards shouldBe 1.chains.yards
        (88 over 5).ells shouldBe 1.chains.ells
        4.rods shouldBe 1.chains.rods
        1L.chains shouldBe 1.chains
        1.chains.furlongs shouldBe (1 over 10).furlongs
        1.chains.miles shouldBe (1 over 80).miles
        1.chains.leagues shouldBe (1 over 240).leagues

        95_040.poppyseeds shouldBe 1.furlongs.poppyseeds
        23_760.barleycorns shouldBe 1.furlongs.barleycorns
        7_920.inches shouldBe 1.furlongs.inches
        3_960.sticks shouldBe 1.furlongs.sticks
        1_980.hands shouldBe 1.furlongs.hands
        660.feet shouldBe 1.furlongs.feet
        220.yards shouldBe 1.furlongs.yards
        176.ells shouldBe 1.furlongs.ells
        40.rods shouldBe 1.furlongs.rods
        10.chains shouldBe 1.furlongs.chains
        1L.furlongs shouldBe 1.furlongs
        1.furlongs.miles shouldBe (1 over 8).miles
        1.furlongs.leagues shouldBe (1 over 24).leagues

        760_320.poppyseeds shouldBe 1.miles.poppyseeds
        190_080.barleycorns shouldBe 1.miles.barleycorns
        63_360.inches shouldBe 1.miles.inches
        31_680.sticks shouldBe 1.miles.sticks
        15_840.hands shouldBe 1.miles.hands
        5_280.feet shouldBe 1.miles.feet
        1_760.yards shouldBe 1.miles.yards
        1_408.ells shouldBe 1.miles.ells
        320.rods shouldBe 1.miles.rods
        80.chains shouldBe 1.miles.chains
        8.furlongs shouldBe 1.miles.furlongs
        1L.miles shouldBe 1.miles
        1.miles.leagues shouldBe (1 over 3).leagues

        2_280_960.poppyseeds shouldBe 1.leagues.poppyseeds
        570_240.barleycorns shouldBe 1.leagues.barleycorns
        190_080.inches shouldBe 1.leagues.inches
        95_040.sticks shouldBe 1.leagues.sticks
        47_520.hands shouldBe 1.leagues.hands
        15_840.feet shouldBe 1.leagues.feet
        5_280.yards shouldBe 1.leagues.yards
        4_224.ells shouldBe 1.leagues.ells
        960.rods shouldBe 1.leagues.rods
        240.chains shouldBe 1.leagues.chains
        24.furlongs shouldBe 1.leagues.furlongs
        3.miles shouldBe 1.leagues.miles
        1L.leagues shouldBe 1.leagues
    }

    @Test
    fun `should pretty print`() {
        "$Poppyseeds" shouldBe "English poppyseed"
        // TODO: How to cope with multi-language for singular vs plural?
        "${1.poppyseeds}" shouldBe "1 poppyseeds"
        "$Barleycorns" shouldBe "English barleycorn"
        "${1.barleycorns}" shouldBe "1 Bc"
        "$Inches" shouldBe "English inch"
        "${1.inches}" shouldBe "1\""
        "$Sticks" shouldBe "English stick"
        "${1.sticks}" shouldBe "1 stick"
        "${2.sticks}" shouldBe "2 sticks"
        "$Hands" shouldBe "English hand"
        "${1.hands}" shouldBe "1 hh"
        "$Feet" shouldBe "English foot"
        "${1.feet}" shouldBe "1'"
        "$Yards" shouldBe "English yard"
        "${1.yards}" shouldBe "1 yd"
        "$Ells" shouldBe "English ells"
        "${1.ells}" shouldBe "1 ells"
        "$Rods" shouldBe "English rod"
        "${1.rods}" shouldBe "1 rods"
        "$Chains" shouldBe "English chain"
        "${1.chains}" shouldBe "1 ch"
        "$Furlongs" shouldBe "English furlong"
        "${1.furlongs}" shouldBe "1 fur"
        "$Miles" shouldBe "English mile"
        "${1.miles}" shouldBe "1 mi"
        "$Leagues" shouldBe "English league"
        "${1.leagues}" shouldBe "1 lea"
    }
}
