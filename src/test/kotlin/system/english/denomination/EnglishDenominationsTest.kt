package hm.binkley.kunits.system.english.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.plus
import hm.binkley.kunits.system.english.denomination.Angel.Angels
import hm.binkley.kunits.system.english.denomination.Crown.Crowns
import hm.binkley.kunits.system.english.denomination.DoubleSovereign.DoubleSovereigns
import hm.binkley.kunits.system.english.denomination.Farthing.Farthings
import hm.binkley.kunits.system.english.denomination.Florin.Florins
import hm.binkley.kunits.system.english.denomination.Groat.Groats
import hm.binkley.kunits.system.english.denomination.Guinea.Guineas
import hm.binkley.kunits.system.english.denomination.HalfAngel.HalfAngels
import hm.binkley.kunits.system.english.denomination.HalfCrown.HalfCrowns
import hm.binkley.kunits.system.english.denomination.Halffarthing.Halffarthings
import hm.binkley.kunits.system.english.denomination.HalfGuinea.HalfGuineas
import hm.binkley.kunits.system.english.denomination.HalfNoble.HalfNobles
import hm.binkley.kunits.system.english.denomination.HalfSovereign.HalfSovereigns
import hm.binkley.kunits.system.english.denomination.Halfpenny.Halfpence
import hm.binkley.kunits.system.english.denomination.Leopard.Leopards
import hm.binkley.kunits.system.english.denomination.Mark.Marks
import hm.binkley.kunits.system.english.denomination.Mite.Mites
import hm.binkley.kunits.system.english.denomination.Noble.Nobles
import hm.binkley.kunits.system.english.denomination.Pound.Pounds
import hm.binkley.kunits.system.english.denomination.QuarterAngel.QuarterAngels
import hm.binkley.kunits.system.english.denomination.Quarterfarthing.Quarterfarthings
import hm.binkley.kunits.system.english.denomination.QuarterNoble.QuarterNobles
import hm.binkley.kunits.system.english.denomination.QuintupleSovereign.QuintupleSovereigns
import hm.binkley.kunits.system.english.denomination.Shilling.Shillings
import hm.binkley.kunits.system.english.denomination.Sixpenny.Sixpence
import hm.binkley.kunits.system.english.denomination.Sovereign.Sovereigns
import hm.binkley.kunits.system.english.denomination.Thirdfarthing.Thirdfarthings
import hm.binkley.kunits.system.english.denomination.ThreeFarthing.ThreeFarthings
import hm.binkley.kunits.system.english.denomination.Threepenny.Threepence
import hm.binkley.kunits.system.english.denomination.Twopenny.Twopence
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class EnglishDenominationsTest {
    @ParameterizedTest(name = "{0} lbs, {1} d, {2} p → {3}")
    @CsvSource(
        // pounds, shillings, pence, expected
        "0, 0, 0, 0d",
        "0, 0, 1, -/1",
        "0, 1, 0, 1/-",
        "1, 0, 0, 1/-/-",
        "0, 2, 4, 2/4",
        "2, 42, 4, 4/2/4"
    )
    fun `should format traditionally`(
        pounds: Int,
        shillings: Int,
        pence: Int,
        expected: String
    ) {
        val amount = pounds.pounds + shillings.shillings + pence.pence

        amount.formatTraditional() shouldBe expected
    }

    @Test
    fun `should convert`() {
        1L.mites shouldBe ((1 over 24).pence into Mites)
        1L.quarterfarthings shouldBe ((1 over 16).pence into Quarterfarthings)
        1L.thirdfarthings shouldBe ((1 over 12).pence into Thirdfarthings)
        1L.halffarthings shouldBe ((1 over 8).pence into Halffarthings)
        1L.farthings shouldBe ((1 over 4).pence into Farthings)
        1L.threeFarthings shouldBe ((3 over 4).pence into ThreeFarthings)
        1L.halfpence shouldBe ((1 over 2).pence into Halfpence)
        (1 over 1).`ha'penny` shouldBe 1.halfpence
        1L.`ha'penny` shouldBe 1.halfpence
        1.`ha'penny` shouldBe 1.halfpence
        1L.pence shouldBe 1.pence
        1L.twopence shouldBe (2.pence into Twopence)
        (1 over 1).`tu'penny` shouldBe 1.twopence
        1L.`tu'penny` shouldBe 1.twopence
        1.`tu'penny` shouldBe 1.twopence
        (1 over 1).halfGroats shouldBe 1.twopence
        1L.halfGroats shouldBe 1.twopence
        1L.threepence shouldBe (3.pence into Threepence)
        (1 over 1).thruppence shouldBe 1.threepence
        1L.thruppence shouldBe 1.threepence
        1L.groats shouldBe (4.pence into Groats)
        1L.sixpence shouldBe (6.pence into Sixpence)
        (1 over 1).tanners shouldBe 1.sixpence
        1L.tanners shouldBe 1.sixpence
        1L.shillings shouldBe (12.pence into Shillings)
        (1 over 1).bob shouldBe 1.shillings
        1L.bob shouldBe 1.shillings
        1L.quarterNobles shouldBe (20.pence into QuarterNobles)
        1L.florins shouldBe (24.pence into Florins)
        1L.quarterAngels shouldBe (24.pence into QuarterAngels)
        1L.halfCrowns shouldBe (30.pence into HalfCrowns)
        1L.halfNobles shouldBe (50.pence into HalfNobles)
        1L.crowns shouldBe (60.pence into Crowns)
        1L.halfAngels shouldBe (66.pence into HalfAngels)
        1L.leopards shouldBe (72.pence into Leopards)
        1L.angels shouldBe (80.pence into Angels)
        1L.nobles shouldBe (100.pence into Nobles)
        1L.halfSovereigns shouldBe (120.pence into HalfSovereigns)
        1L.halfGuineas shouldBe (126.pence into HalfGuineas)
        1L.marks shouldBe (160.pence into Marks)
        1L.pounds shouldBe (240.pence into Pounds)
        (1 over 1).quid shouldBe 1.pounds
        1L.quid shouldBe 1.pounds
        1L.sovereigns shouldBe (240.pence into Sovereigns)
        1L.guineas shouldBe (252.pence into Guineas)
        1L.doubleSovereigns shouldBe (480.pence into DoubleSovereigns)
        1L.quintupleSovereigns shouldBe (1200.pence into QuintupleSovereigns)
    }

    @Test
    fun `should pretty print`() {
        "$Mites" shouldBe "English denomination: mite"
        "${1.mites}" shouldBe "1 mites"
        "$Quarterfarthings" shouldBe "English denomination: quarterfarthing"
        "${1.quarterfarthings}" shouldBe "1 quarterfarthings"
        "$Thirdfarthings" shouldBe "English denomination: thirdfarthing"
        "${1.thirdfarthings}" shouldBe "1 thirdfarthings"
        "$Halffarthings" shouldBe "English denomination: halffarthing"
        "${1.halffarthings}" shouldBe "1 halffarthings"
        "$Farthing" shouldBe "English denomination: farthing"
        "${1.farthings}" shouldBe "1 farthings"
        "$Halfpenny" shouldBe "English denomination: halfpenny"
        "${1.halfpence}" shouldBe "1 ha'pence"
        "$ThreeFarthings" shouldBe "English denomination: three farthing"
        "${1.threeFarthings}" shouldBe "1 three farthings"
        "$Penny" shouldBe "English denomination: penny"
        "${1.pence}" shouldBe "1d"
        "$Twopenny" shouldBe "English denomination: twopenny"
        "${1.twopence}" shouldBe "1 tuppence"
        "${1.`tu'penny`}" shouldBe "1 tuppence"
        "${1.halfGroats}" shouldBe "1 tuppence"
        "$Threepenny" shouldBe "English denomination: threepenny"
        "${1.threepence}" shouldBe "1 thruppence"
        "${1.thruppence}" shouldBe "1 thruppence"
        "$Groat" shouldBe "English denomination: groat"
        "${1.groats}" shouldBe "1 groats"
        "$Sixpenny" shouldBe "English denomination: sixpenny"
        "${1.sixpence}" shouldBe "1 sixpence"
        "${1.tanners}" shouldBe "1 sixpence"
        "$Shilling" shouldBe "English denomination: shilling"
        "${1.shillings}" shouldBe "1s"
        "${1.bob}" shouldBe "1s"
        "$Florin" shouldBe "English denomination: florin"
        "${1.florins}" shouldBe "1 florins"
        "$QuarterNoble" shouldBe "English denomination: quarter-noble"
        "${1.quarterNobles}" shouldBe "1 quarter-nobles"
        "$QuarterAngel" shouldBe "English denomination: gold quarter-angel"
        "${1.quarterAngels}" shouldBe "1 gold quarter-angels"
        "$HalfCrown" shouldBe "English denomination: half-crown"
        "${1.halfCrowns}" shouldBe "1 half-crowns"
        "$HalfAngel" shouldBe "English denomination: gold half-angel"
        "${1.halfAngels}" shouldBe "1 gold half-angels"
        "$Leopard" shouldBe "English denomination: gold leopard"
        "${1.leopards}" shouldBe "1 gold leopards"
        "$HalfNoble" shouldBe "English denomination: half-noble"
        "${1.halfNobles}" shouldBe "1 half-nobles"
        "$HalfGuinea" shouldBe "English denomination: half-guinea"
        "${1.halfGuineas}" shouldBe "1 half-guineas"
        "$Crown" shouldBe "English denomination: crown"
        "${1.crowns}" shouldBe "1 crowns"
        "$Angel" shouldBe "English denomination: gold angel"
        "${1.angels}" shouldBe "1 gold angels"
        "$Noble" shouldBe "English denomination: gold noble"
        "${1.nobles}" shouldBe "1 gold nobles"
        "$HalfSovereign" shouldBe "English denomination: gold half-sovereign"
        "${1.halfSovereigns}" shouldBe "1 gold half-sovereigns"
        "$Mark" shouldBe "English denomination: mark"
        "${1.marks}" shouldBe "1 marks"
        "$Pound" shouldBe "English denomination: pound"
        "${1.pounds}" shouldBe "£1"
        "$Sovereign" shouldBe "English denomination: gold sovereign"
        "${1.sovereigns}" shouldBe "1 gold sovereigns"
        "${1.quid}" shouldBe "£1"
        "$Guinea" shouldBe "English denomination: guinea"
        "${1.guineas}" shouldBe "1gns"
        "$DoubleSovereign" shouldBe
            "English denomination: gold double-sovereign"
        "${1.doubleSovereigns}" shouldBe "1 gold double-sovereigns"
        "$QuintupleSovereign" shouldBe
            "English denomination: gold quintuple-sovereign"
        "${1.quintupleSovereigns}" shouldBe "1 gold quintuple-sovereigns"
    }
}
