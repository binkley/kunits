package hm.binkley.kunits.system.english.length

import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.length.Barleycorn.Barleycorns
import hm.binkley.kunits.system.english.length.Chain.Chains
import hm.binkley.kunits.system.english.length.Ell.Ells
import hm.binkley.kunits.system.english.length.Foot.Feet
import hm.binkley.kunits.system.english.length.Furlong.Furlongs
import hm.binkley.kunits.system.english.length.Hand.Hands
import hm.binkley.kunits.system.english.length.Inch.Inches
import hm.binkley.kunits.system.english.length.League.Leagues
import hm.binkley.kunits.system.english.length.Link.Links
import hm.binkley.kunits.system.english.length.Mile.Miles
import hm.binkley.kunits.system.english.length.Rod.Rods
import hm.binkley.kunits.system.english.length.Shaftment.Shaftments
import hm.binkley.kunits.system.english.length.Stick.Sticks
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishLengthsTest {
    @Test
    fun `should convert`() {
        1L.lines shouldBe 1.lines
        1L.barleycorns shouldBe (4.lines into Barleycorns)
        1L.inches shouldBe (3.barleycorns into Inches)
        1L.sticks shouldBe (2.inches into Sticks)
        1L.hands shouldBe (2.sticks into Hands)
        1L.shaftments shouldBe ((3 over 2).hands into Shaftments)
        1L.links shouldBe ((33 over 25).shaftments into Links)
        1L.feet shouldBe ((50 over 33).links into Feet)
        1L.yards shouldBe (3.feet into Yard)
        1L.ells shouldBe ((5 over 4).yards into Ells)
        1L.rods shouldBe ((22 over 5).ells into Rods)
        1L.chains shouldBe (4.rods into Chains)
        1L.furlongs shouldBe (10.chains into Furlongs)
        1L.miles shouldBe (8.furlongs into Miles)
        1L.leagues shouldBe (3.miles into Leagues)
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
        "$Link" shouldBe "English link"
        "${1.links}" shouldBe "1 links"
        "$Foot" shouldBe "English foot"
        "${1.feet}" shouldBe "1'"
        "$Yard" shouldBe "English yard"
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
