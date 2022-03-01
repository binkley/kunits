package hm.binkley.kunits.system.english.length

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishLengthsTest {
    @Test
    fun `should convert`() {
        1L.line shouldBe 1.lines
        (1 over 4).barleycorns shouldBe 1.lines.barleycorns
        (1 over 12).inches shouldBe 1.lines.inches
        (1 over 24).sticks shouldBe 1.lines.sticks
        (1 over 48).hands shouldBe 1.lines.hands
        (1 over 72).shaftments shouldBe 1.lines.shaftments
        (25 over 2_376).links shouldBe 1.lines.links
        (1 over 144).feet shouldBe 1.lines.feet
        (1 over 432).yards shouldBe 1.lines.yards
        (1 over 540).ells shouldBe 1.lines.ells
        (1 over 2_376).rods shouldBe 1.lines.rods
        (1 over 9_504).chains shouldBe 1.lines.chains
        (1 over 95_040).furlongs shouldBe 1.lines.furlongs
        (1 over 760_320).miles shouldBe 1.lines.miles
        (1 over 2_280_960).leagues shouldBe 1.lines.leagues

        4.lines shouldBe 1.barleycorns.lines
        1L.barleycorns shouldBe 1.barleycorns
        (1 over 3).inches shouldBe 1.barleycorns.inches
        (1 over 6).sticks shouldBe 1.barleycorns.sticks
        (1 over 12).hands shouldBe 1.barleycorns.hands
        (1 over 18).shaftments shouldBe 1.barleycorns.shaftments
        (25 over 594).links shouldBe 1.barleycorns.links
        (1 over 36).feet shouldBe 1.barleycorns.feet
        (1 over 108).yards shouldBe 1.barleycorns.yards
        (1 over 135).ells shouldBe 1.barleycorns.ells
        (1 over 594).rods shouldBe 1.barleycorns.rods
        (1 over 2_376).chains shouldBe 1.barleycorns.chains
        (1 over 23_760).furlongs shouldBe 1.barleycorns.furlongs
        (1 over 190_080).miles shouldBe 1.barleycorns.miles
        (1 over 570_240).leagues shouldBe 1.barleycorns.leagues

        12.lines shouldBe 1.inches.lines
        3.barleycorns shouldBe 1.inches.barleycorns
        1L.inches shouldBe 1.inches
        (1 over 2).sticks shouldBe 1.inches.sticks
        (1 over 4).hands shouldBe 1.inches.hands
        (1 over 6).shaftments shouldBe 1.inches.shaftments
        (25 over 198).links shouldBe 1.inches.links
        (1 over 12).feet shouldBe 1.inches.feet
        (1 over 36).yards shouldBe 1.inches.yards
        (1 over 45).ells shouldBe 1.inches.ells
        (1 over 198).rods shouldBe 1.inches.rods
        (1 over 792).chains shouldBe 1.inches.chains
        (1 over 7_920).furlongs shouldBe 1.inches.furlongs
        (1 over 63_360).miles shouldBe 1.inches.miles
        (1 over 190_080).leagues shouldBe 1.inches.leagues

        24.lines shouldBe 1.sticks.lines
        6.barleycorns shouldBe 1.sticks.barleycorns
        2.inches shouldBe 1.sticks.inches
        1L.sticks shouldBe 1.sticks
        (1 over 2).hands shouldBe 1.sticks.hands
        (1 over 3).shaftments shouldBe 1.sticks.shaftments
        (25 over 99).links shouldBe 1.sticks.links
        (1 over 6).feet shouldBe 1.sticks.feet
        (1 over 18).yards shouldBe 1.sticks.yards
        (2 over 45).ells shouldBe 1.sticks.ells
        (1 over 99).rods shouldBe 1.sticks.rods
        (1 over 396).chains shouldBe 1.sticks.chains
        (1 over 3_960).furlongs shouldBe 1.sticks.furlongs
        (1 over 31_680).miles shouldBe 1.sticks.miles
        (1 over 95_040).leagues shouldBe 1.sticks.leagues

        48.lines shouldBe 1.hands.lines
        12.barleycorns shouldBe 1.hands.barleycorns
        4.inches shouldBe 1.hands.inches
        2.sticks shouldBe 1.hands.sticks
        1L.hands shouldBe 1.hands
        (2 over 3).shaftments shouldBe 1.hands.shaftments
        (50 over 99).links shouldBe 1.hands.links
        (1 over 3).feet shouldBe 1.hands.feet
        (1 over 9).yards shouldBe 1.hands.yards
        (4 over 45).ells shouldBe 1.hands.ells
        (2 over 99).rods shouldBe 1.hands.rods
        (1 over 198).chains shouldBe 1.hands.chains
        (1 over 1_980).furlongs shouldBe 1.hands.furlongs
        (1 over 15_840).miles shouldBe 1.hands.miles
        (1 over 47_520).leagues shouldBe 1.hands.leagues

        72.lines shouldBe 1.shaftments.lines
        18.barleycorns shouldBe 1.shaftments.barleycorns
        6.inches shouldBe 1.shaftments.inches
        3.sticks shouldBe 1.shaftments.sticks
        (3 over 2).hands shouldBe 1.shaftments.hands
        1L.shaftments shouldBe 1.shaftments
        (25 over 33).links shouldBe 1.shaftments.links
        (1 over 2).feet shouldBe 1.shaftments.feet
        (1 over 6).yards shouldBe 1.shaftments.yards
        (2 over 15).ells shouldBe 1.shaftments.ells
        (1 over 33).rods shouldBe 1.shaftments.rods
        (1 over 132).chains shouldBe 1.shaftments.chains
        (1 over 1_320).furlongs shouldBe 1.shaftments.furlongs
        (1 over 10_560).miles shouldBe 1.shaftments.miles
        (1 over 31_680).leagues shouldBe 1.shaftments.leagues

        (2_376 over 25).lines shouldBe 1.links.lines
        (594 over 25).barleycorns shouldBe 1.links.barleycorns
        (198 over 25).inches shouldBe 1.links.inches
        (99 over 25).sticks shouldBe 1.links.sticks
        (99 over 50).hands shouldBe 1.links.hands
        (33 over 25).shaftments shouldBe 1.links.shaftments
        1L.links shouldBe 1.links
        (33 over 50).feet shouldBe 1.links.feet
        (11 over 50).yards shouldBe 1.links.yards
        (22 over 125).ells shouldBe 1.links.ells
        (1 over 25).rods shouldBe 1.links.rods
        (1 over 100).chains shouldBe 1.links.chains
        (1 over 1_000).furlongs shouldBe 1.links.furlongs
        (1 over 8_000).miles shouldBe 1.links.miles
        (1 over 24_000).leagues shouldBe 1.links.leagues

        144.lines shouldBe 1.feet.lines
        36.barleycorns shouldBe 1.feet.barleycorns
        12.inches shouldBe 1.feet.inches
        6.sticks shouldBe 1.feet.sticks
        3.hands shouldBe 1.feet.hands
        2.shaftments shouldBe 1.feet.shaftments
        (50 over 33).links shouldBe 1.feet.links
        1L.feet shouldBe 1.feet
        (1 over 3).yards shouldBe 1.feet.yards
        (4 over 15).ells shouldBe 1.feet.ells
        (2 over 33).rods shouldBe 1.feet.rods
        (1 over 66).chains shouldBe 1.feet.chains
        (1 over 660).furlongs shouldBe 1.feet.furlongs
        (1 over 5_280).miles shouldBe 1.feet.miles
        (1 over 15_840).leagues shouldBe 1.feet.leagues

        432.lines shouldBe 1.yards.lines
        108.barleycorns shouldBe 1.yards.barleycorns
        36.inches shouldBe 1.yards.inches
        18.sticks shouldBe 1.yards.sticks
        9.hands shouldBe 1.yards.hands
        6.shaftments shouldBe 1.yards.shaftments
        (50 over 11).links shouldBe 1.yards.links
        3.feet shouldBe 1.yards.feet
        1L.yards shouldBe 1.yards
        (4 over 5).ells shouldBe 1.yards.ells
        (2 over 11).rods shouldBe 1.yards.rods
        (1 over 220).furlongs shouldBe 1.yards.furlongs
        (1 over 22).chains shouldBe 1.yards.chains
        (1 over 1_760).miles shouldBe 1.yards.miles
        (1 over 5_280).leagues shouldBe 1.yards.leagues

        540.lines shouldBe 1.ells.lines
        135.barleycorns shouldBe 1.ells.barleycorns
        45.inches shouldBe 1.ells.inches
        (45 over 2).sticks shouldBe 1.ells.sticks
        (45 over 4).hands shouldBe 1.ells.hands
        (15 over 2).shaftments shouldBe 1.ells.shaftments
        (125 over 22).links shouldBe 1.ells.links
        (15 over 4).feet shouldBe 1.ells.feet
        (5 over 4).yards shouldBe 1.ells.yards
        1L.ells shouldBe 1.ells
        (5 over 22).rods shouldBe 1.ells.rods
        (1 over 176).furlongs shouldBe 1.ells.furlongs
        (5 over 88).chains shouldBe 1.ells.chains
        (1 over 1_408).miles shouldBe 1.ells.miles
        (1 over 4_224).leagues shouldBe 1.ells.leagues

        2_376.lines shouldBe 1.rods.lines
        594.barleycorns shouldBe 1.rods.barleycorns
        198.inches shouldBe 1.rods.inches
        99.sticks shouldBe 1.rods.sticks
        (99 over 2).hands shouldBe 1.rods.hands
        33.shaftments shouldBe 1.rods.shaftments
        25.links shouldBe 1.rods.links
        (33 over 2).feet shouldBe 1.rods.feet
        (11 over 2).yards shouldBe 1.rods.yards
        (22 over 5).ells shouldBe 1.rods.ells
        1L.rods shouldBe 1.rods
        (1 over 4).chains shouldBe 1.rods.chains
        (1 over 40).furlongs shouldBe 1.rods.furlongs
        (1 over 320).miles shouldBe 1.rods.miles
        (1 over 960).leagues shouldBe 1.rods.leagues

        9_504.lines shouldBe 1.chains.lines
        2_376.barleycorns shouldBe 1.chains.barleycorns
        792.inches shouldBe 1.chains.inches
        396.sticks shouldBe 1.chains.sticks
        198.hands shouldBe 1.chains.hands
        132.shaftments shouldBe 1.chains.shaftments
        100.links shouldBe 1.chains.links
        66.feet shouldBe 1.chains.feet
        22.yards shouldBe 1.chains.yards
        (88 over 5).ells shouldBe 1.chains.ells
        4.rods shouldBe 1.chains.rods
        1L.chains shouldBe 1.chains
        (1 over 10).furlongs shouldBe 1.chains.furlongs
        (1 over 80).miles shouldBe 1.chains.miles
        (1 over 240).leagues shouldBe 1.chains.leagues

        95_040.lines shouldBe 1.furlongs.lines
        23_760.barleycorns shouldBe 1.furlongs.barleycorns
        7_920.inches shouldBe 1.furlongs.inches
        3_960.sticks shouldBe 1.furlongs.sticks
        1_980.hands shouldBe 1.furlongs.hands
        1_320.shaftments shouldBe 1.furlongs.shaftments
        1_000.links shouldBe 1.furlongs.links
        660.feet shouldBe 1.furlongs.feet
        220.yards shouldBe 1.furlongs.yards
        176.ells shouldBe 1.furlongs.ells
        40.rods shouldBe 1.furlongs.rods
        10.chains shouldBe 1.furlongs.chains
        1L.furlongs shouldBe 1.furlongs
        (1 over 8).miles shouldBe 1.furlongs.miles
        (1 over 24).leagues shouldBe 1.furlongs.leagues

        760_320.lines shouldBe 1.miles.lines
        190_080.barleycorns shouldBe 1.miles.barleycorns
        63_360.inches shouldBe 1.miles.inches
        31_680.sticks shouldBe 1.miles.sticks
        15_840.hands shouldBe 1.miles.hands
        10_560.shaftments shouldBe 1.miles.shaftments
        8_000.links shouldBe 1.miles.links
        5_280.feet shouldBe 1.miles.feet
        1_760.yards shouldBe 1.miles.yards
        1_408.ells shouldBe 1.miles.ells
        320.rods shouldBe 1.miles.rods
        80.chains shouldBe 1.miles.chains
        8.furlongs shouldBe 1.miles.furlongs
        1L.miles shouldBe 1.miles
        (1 over 3).leagues shouldBe 1.miles.leagues

        2_280_960.lines shouldBe 1.leagues.lines
        570_240.barleycorns shouldBe 1.leagues.barleycorns
        190_080.inches shouldBe 1.leagues.inches
        95_040.sticks shouldBe 1.leagues.sticks
        47_520.hands shouldBe 1.leagues.hands
        31_680.shaftments shouldBe 1.leagues.shaftments
        24_000.links shouldBe 1.leagues.links
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
        // TODO: How to cope with multi-language for singular vs plural?
        "$Lines" shouldBe "English line"
        "${1.lines}" shouldBe "1 lines"
        "$Barleycorns" shouldBe "English barleycorn"
        "${1.barleycorns}" shouldBe "1 Bc"
        "$Inches" shouldBe "English inch"
        "${1.inches}" shouldBe "1\""
        "$Sticks" shouldBe "English stick"
        "${1.sticks}" shouldBe "1 stick"
        "${2.sticks}" shouldBe "2 sticks"
        "$Hands" shouldBe "English hand"
        "${1.hands}" shouldBe "1 hh"
        "$Shaftments" shouldBe "English shaftment"
        "${1.shaftments}" shouldBe "1 shaftments"
        "$Links" shouldBe "English link"
        "${1.links}" shouldBe "1 links"
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
