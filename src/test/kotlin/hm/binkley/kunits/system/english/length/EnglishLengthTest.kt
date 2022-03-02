package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.system.english.length.Barleycorn.Barleycorns
import hm.binkley.kunits.system.english.length.Chain.Chains
import hm.binkley.kunits.system.english.length.Ell.Ells
import hm.binkley.kunits.system.english.length.Foot.Feet
import hm.binkley.kunits.system.english.length.Furlong.Furlongs
import hm.binkley.kunits.system.english.length.Hand.Hands
import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.League.Leagues
import hm.binkley.kunits.system.english.length.Line.Lines
import hm.binkley.kunits.system.english.length.Link.Links
import hm.binkley.kunits.system.english.length.Mile.Miles
import hm.binkley.kunits.system.english.length.Rod.Rods
import hm.binkley.kunits.system.english.length.Shaftment.Shaftments
import hm.binkley.kunits.system.english.length.Stick.Sticks
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import hm.binkley.kunits.into

internal class EnglishLengthTest {
    @Test
    fun `should convert`() {
        1L.line shouldBe 1.lines
        (1 over 4).barleycorns shouldBe (1.lines into Barleycorns)
        (1 over 12).inches shouldBe (1.lines into Inches)
        (1 over 24).sticks shouldBe (1.lines into Sticks)
        (1 over 48).hands shouldBe (1.lines into Hands)
        (1 over 72).shaftments shouldBe (1.lines into Shaftments)
        (25 over 2_376).links shouldBe (1.lines into Links)
        (1 over 144).feet shouldBe (1.lines into Feet)
        (1 over 432).yards shouldBe (1.lines into Yards)
        (1 over 540).ells shouldBe (1.lines into Ells)
        (1 over 2_376).rods shouldBe (1.lines into Rods)
        (1 over 9_504).chains shouldBe (1.lines into Chains)
        (1 over 95_040).furlongs shouldBe (1.lines into Furlongs)
        (1 over 760_320).miles shouldBe (1.lines into Miles)
        (1 over 2_280_960).leagues shouldBe (1.lines into Leagues)

        4.lines shouldBe (1.barleycorns into Lines)
        1L.barleycorns shouldBe 1.barleycorns
        (1 over 3).inches shouldBe (1.barleycorns into Inches)
        (1 over 6).sticks shouldBe (1.barleycorns into Sticks)
        (1 over 12).hands shouldBe (1.barleycorns into Hands)
        (1 over 18).shaftments shouldBe (1.barleycorns into Shaftments)
        (25 over 594).links shouldBe (1.barleycorns into Links)
        (1 over 36).feet shouldBe (1.barleycorns into Feet)
        (1 over 108).yards shouldBe (1.barleycorns into Yards)
        (1 over 135).ells shouldBe (1.barleycorns into Ells)
        (1 over 594).rods shouldBe (1.barleycorns into Rods)
        (1 over 2_376).chains shouldBe (1.barleycorns into Chains)
        (1 over 23_760).furlongs shouldBe (1.barleycorns into Furlongs)
        (1 over 190_080).miles shouldBe (1.barleycorns into Miles)
        (1 over 570_240).leagues shouldBe (1.barleycorns into Leagues)

        12.lines shouldBe (1.inches into Lines)
        3.barleycorns shouldBe (1.inches into Barleycorns)
        1L.inches shouldBe 1.inches
        (1 over 2).sticks shouldBe (1.inches into Sticks)
        (1 over 4).hands shouldBe (1.inches into Hands)
        (1 over 6).shaftments shouldBe (1.inches into Shaftments)
        (25 over 198).links shouldBe (1.inches into Links)
        (1 over 12).feet shouldBe (1.inches into Feet)
        (1 over 36).yards shouldBe (1.inches into Yards)
        (1 over 45).ells shouldBe (1.inches into Ells)
        (1 over 198).rods shouldBe (1.inches into Rods)
        (1 over 792).chains shouldBe (1.inches into Chains)
        (1 over 7_920).furlongs shouldBe (1.inches into Furlongs)
        (1 over 63_360).miles shouldBe (1.inches into Miles)
        (1 over 190_080).leagues shouldBe (1.inches into Leagues)

        24.lines shouldBe (1.sticks into Lines)
        6.barleycorns shouldBe (1.sticks into Barleycorns)
        2.inches shouldBe (1.sticks into Inches)
        1L.sticks shouldBe 1.sticks
        (1 over 2).hands shouldBe (1.sticks into Hands)
        (1 over 3).shaftments shouldBe (1.sticks into Shaftments)
        (25 over 99).links shouldBe (1.sticks into Links)
        (1 over 6).feet shouldBe (1.sticks into Feet)
        (1 over 18).yards shouldBe (1.sticks into Yards)
        (2 over 45).ells shouldBe (1.sticks into Ells)
        (1 over 99).rods shouldBe (1.sticks into Rods)
        (1 over 396).chains shouldBe (1.sticks into Chains)
        (1 over 3_960).furlongs shouldBe (1.sticks into Furlongs)
        (1 over 31_680).miles shouldBe (1.sticks into Miles)
        (1 over 95_040).leagues shouldBe (1.sticks into Leagues)

        48.lines shouldBe (1.hands into Lines)
        12.barleycorns shouldBe (1.hands into Barleycorns)
        4.inches shouldBe (1.hands into Inches)
        2.sticks shouldBe (1.hands into Sticks)
        1L.hands shouldBe 1.hands
        (2 over 3).shaftments shouldBe (1.hands into Shaftments)
        (50 over 99).links shouldBe (1.hands into Links)
        (1 over 3).feet shouldBe (1.hands into Feet)
        (1 over 9).yards shouldBe (1.hands into Yards)
        (4 over 45).ells shouldBe (1.hands into Ells)
        (2 over 99).rods shouldBe (1.hands into Rods)
        (1 over 198).chains shouldBe (1.hands into Chains)
        (1 over 1_980).furlongs shouldBe (1.hands into Furlongs)
        (1 over 15_840).miles shouldBe (1.hands into Miles)
        (1 over 47_520).leagues shouldBe (1.hands into Leagues)

        72.lines shouldBe (1.shaftments into Lines)
        18.barleycorns shouldBe (1.shaftments into Barleycorns)
        6.inches shouldBe (1.shaftments into Inches)
        3.sticks shouldBe (1.shaftments into Sticks)
        (3 over 2).hands shouldBe (1.shaftments into Hands)
        1L.shaftments shouldBe 1.shaftments
        (25 over 33).links shouldBe (1.shaftments into Links)
        (1 over 2).feet shouldBe (1.shaftments into Feet)
        (1 over 6).yards shouldBe (1.shaftments into Yards)
        (2 over 15).ells shouldBe (1.shaftments into Ells)
        (1 over 33).rods shouldBe (1.shaftments into Rods)
        (1 over 132).chains shouldBe (1.shaftments into Chains)
        (1 over 1_320).furlongs shouldBe (1.shaftments into Furlongs)
        (1 over 10_560).miles shouldBe (1.shaftments into Miles)
        (1 over 31_680).leagues shouldBe (1.shaftments into Leagues)

        (2_376 over 25).lines shouldBe (1.links into Lines)
        (594 over 25).barleycorns shouldBe (1.links into Barleycorns)
        (198 over 25).inches shouldBe (1.links into Inches)
        (99 over 25).sticks shouldBe (1.links into Sticks)
        (99 over 50).hands shouldBe (1.links into Hands)
        (33 over 25).shaftments shouldBe (1.links into Shaftments)
        1L.links shouldBe 1.links
        (33 over 50).feet shouldBe (1.links into Feet)
        (11 over 50).yards shouldBe (1.links into Yards)
        (22 over 125).ells shouldBe (1.links into Ells)
        (1 over 25).rods shouldBe (1.links into Rods)
        (1 over 100).chains shouldBe (1.links into Chains)
        (1 over 1_000).furlongs shouldBe (1.links into Furlongs)
        (1 over 8_000).miles shouldBe (1.links into Miles)
        (1 over 24_000).leagues shouldBe (1.links into Leagues)

        144.lines shouldBe (1.feet into Lines)
        36.barleycorns shouldBe (1.feet into Barleycorns)
        12.inches shouldBe (1.feet into Inches)
        6.sticks shouldBe (1.feet into Sticks)
        3.hands shouldBe (1.feet into Hands)
        2.shaftments shouldBe (1.feet into Shaftments)
        (50 over 33).links shouldBe (1.feet into Links)
        1L.feet shouldBe 1.feet
        (1 over 3).yards shouldBe (1.feet into Yards)
        (4 over 15).ells shouldBe (1.feet into Ells)
        (2 over 33).rods shouldBe (1.feet into Rods)
        (1 over 66).chains shouldBe (1.feet into Chains)
        (1 over 660).furlongs shouldBe (1.feet into Furlongs)
        (1 over 5_280).miles shouldBe (1.feet into Miles)
        (1 over 15_840).leagues shouldBe (1.feet into Leagues)

        432.lines shouldBe (1.yards into Lines)
        108.barleycorns shouldBe (1.yards into Barleycorns)
        36.inches shouldBe (1.yards into Inches)
        18.sticks shouldBe (1.yards into Sticks)
        9.hands shouldBe (1.yards into Hands)
        6.shaftments shouldBe (1.yards into Shaftments)
        (50 over 11).links shouldBe (1.yards into Links)
        3.feet shouldBe (1.yards into Feet)
        1L.yards shouldBe 1.yards
        (4 over 5).ells shouldBe (1.yards into Ells)
        (2 over 11).rods shouldBe (1.yards into Rods)
        (1 over 220).furlongs shouldBe (1.yards into Furlongs)
        (1 over 22).chains shouldBe (1.yards into Chains)
        (1 over 1_760).miles shouldBe (1.yards into Miles)
        (1 over 5_280).leagues shouldBe (1.yards into Leagues)

        540.lines shouldBe (1.ells into Lines)
        135.barleycorns shouldBe (1.ells into Barleycorns)
        45.inches shouldBe (1.ells into Inches)
        (45 over 2).sticks shouldBe (1.ells into Sticks)
        (45 over 4).hands shouldBe (1.ells into Hands)
        (15 over 2).shaftments shouldBe (1.ells into Shaftments)
        (125 over 22).links shouldBe (1.ells into Links)
        (15 over 4).feet shouldBe (1.ells into Feet)
        (5 over 4).yards shouldBe (1.ells into Yards)
        1L.ells shouldBe 1.ells
        (5 over 22).rods shouldBe (1.ells into Rods)
        (1 over 176).furlongs shouldBe (1.ells into Furlongs)
        (5 over 88).chains shouldBe (1.ells into Chains)
        (1 over 1_408).miles shouldBe (1.ells into Miles)
        (1 over 4_224).leagues shouldBe (1.ells into Leagues)

        2_376.lines shouldBe (1.rods into Lines)
        594.barleycorns shouldBe (1.rods into Barleycorns)
        198.inches shouldBe (1.rods into Inches)
        99.sticks shouldBe (1.rods into Sticks)
        (99 over 2).hands shouldBe (1.rods into Hands)
        33.shaftments shouldBe (1.rods into Shaftments)
        25.links shouldBe (1.rods into Links)
        (33 over 2).feet shouldBe (1.rods into Feet)
        (11 over 2).yards shouldBe (1.rods into Yards)
        (22 over 5).ells shouldBe (1.rods into Ells)
        1L.rods shouldBe 1.rods
        (1 over 4).chains shouldBe (1.rods into Chains)
        (1 over 40).furlongs shouldBe (1.rods into Furlongs)
        (1 over 320).miles shouldBe (1.rods into Miles)
        (1 over 960).leagues shouldBe (1.rods into Leagues)

        9_504.lines shouldBe (1.chains into Lines)
        2_376.barleycorns shouldBe (1.chains into Barleycorns)
        792.inches shouldBe (1.chains into Inches)
        396.sticks shouldBe (1.chains into Sticks)
        198.hands shouldBe (1.chains into Hands)
        132.shaftments shouldBe (1.chains into Shaftments)
        100.links shouldBe (1.chains into Links)
        66.feet shouldBe (1.chains into Feet)
        22.yards shouldBe (1.chains into Yards)
        (88 over 5).ells shouldBe (1.chains into Ells)
        4.rods shouldBe (1.chains into Rods)
        1L.chains shouldBe 1.chains
        (1 over 10).furlongs shouldBe (1.chains into Furlongs)
        (1 over 80).miles shouldBe (1.chains into Miles)
        (1 over 240).leagues shouldBe (1.chains into Leagues)

        95_040.lines shouldBe (1.furlongs into Lines)
        23_760.barleycorns shouldBe (1.furlongs into Barleycorns)
        7_920.inches shouldBe (1.furlongs into Inches)
        3_960.sticks shouldBe (1.furlongs into Sticks)
        1_980.hands shouldBe (1.furlongs into Hands)
        1_320.shaftments shouldBe (1.furlongs into Shaftments)
        1_000.links shouldBe (1.furlongs into Links)
        660.feet shouldBe (1.furlongs into Feet)
        220.yards shouldBe (1.furlongs into Yards)
        176.ells shouldBe (1.furlongs into Ells)
        40.rods shouldBe (1.furlongs into Rods)
        10.chains shouldBe (1.furlongs into Chains)
        1L.furlongs shouldBe 1.furlongs
        (1 over 8).miles shouldBe (1.furlongs into Miles)
        (1 over 24).leagues shouldBe (1.furlongs into Leagues)

        760_320.lines shouldBe (1.miles into Lines)
        190_080.barleycorns shouldBe (1.miles into Barleycorns)
        63_360.inches shouldBe (1.miles into Inches)
        31_680.sticks shouldBe (1.miles into Sticks)
        15_840.hands shouldBe (1.miles into Hands)
        10_560.shaftments shouldBe (1.miles into Shaftments)
        8_000.links shouldBe (1.miles into Links)
        5_280.feet shouldBe (1.miles into Feet)
        1_760.yards shouldBe (1.miles into Yards)
        1_408.ells shouldBe (1.miles into Ells)
        320.rods shouldBe (1.miles into Rods)
        80.chains shouldBe (1.miles into Chains)
        8.furlongs shouldBe (1.miles into Furlongs)
        1L.miles shouldBe 1.miles
        (1 over 3).leagues shouldBe (1.miles into Leagues)

        2_280_960.lines shouldBe (1.leagues into Lines)
        570_240.barleycorns shouldBe (1.leagues into Barleycorns)
        190_080.inches shouldBe (1.leagues into Inches)
        95_040.sticks shouldBe (1.leagues into Sticks)
        47_520.hands shouldBe (1.leagues into Hands)
        31_680.shaftments shouldBe (1.leagues into Shaftments)
        24_000.links shouldBe (1.leagues into Links)
        15_840.feet shouldBe (1.leagues into Feet)
        5_280.yards shouldBe (1.leagues into Yards)
        4_224.ells shouldBe (1.leagues into Ells)
        960.rods shouldBe (1.leagues into Rods)
        240.chains shouldBe (1.leagues into Chains)
        24.furlongs shouldBe (1.leagues into Furlongs)
        3.miles shouldBe (1.leagues into Miles)
        1L.leagues shouldBe 1.leagues
    }

    @Test
    fun `should pretty print`() {
        // TODO: How to cope with multi-language for singular vs plural?
        "$Line" shouldBe "English line"
        "${1.lines}" shouldBe "1 lines"
        "$Barleycorn" shouldBe "English barleycorn"
        "${1.barleycorns}" shouldBe "1 Bc"
        "$Inch" shouldBe "English inch"
        "${1.inches}" shouldBe "1\""
        "$Stick" shouldBe "English stick"
        "${1.sticks}" shouldBe "1 stick"
        "${2.sticks}" shouldBe "2 sticks"
        "$Hand" shouldBe "English hand"
        "${1.hands}" shouldBe "1 hh"
        "$Shaftment" shouldBe "English shaftment"
        "${1.shaftments}" shouldBe "1 shaftments"
        "$Links" shouldBe "English link"
        "${1.links}" shouldBe "1 links"
        "$Foot" shouldBe "English foot"
        "${1.feet}" shouldBe "1'"
        "$Yards" shouldBe "English yard"
        "${1.yards}" shouldBe "1 yd"
        "$Ell" shouldBe "English ells"
        "${1.ells}" shouldBe "1 ells"
        "$Rod" shouldBe "English rod"
        "${1.rods}" shouldBe "1 rods"
        "$Chain" shouldBe "English chain"
        "${1.chains}" shouldBe "1 ch"
        "$Furlong" shouldBe "English furlong"
        "${1.furlongs}" shouldBe "1 fur"
        "$Mile" shouldBe "English mile"
        "${1.miles}" shouldBe "1 mi"
        "$League" shouldBe "English league"
        "${1.leagues}" shouldBe "1 lea"
    }
}
