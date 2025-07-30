package hm.binkley.kunits.system.discworld.ankhMorpork.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Dollar.Dollars
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Elim.Elims
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Farthing.Farthings
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Groat.Groats
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Halfpenny.Halfpennies
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Mite.Mites
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Shilling.Shillings
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Sixpence.Sixpences
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Thruppenny.Thruppence
import hm.binkley.kunits.system.discworld.ankhMorpork.denomination.Tuppenny.Tuppence
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AnkhMorporkDenominationsTest {
    @Test
    fun `should convert`() {
        1L.elims shouldBe ((1 over 16).pence into Elims)
        1L.mites shouldBe ((1 over 8).pence into Mites)
        1L.farthings shouldBe ((1 over 4).pence into Farthings)
        1L.halfpennies shouldBe ((1 over 2).pence into Halfpennies)
        1L.pence shouldBe 1.pence
        (1 over 1).pennies shouldBe 1.pence
        1L.pennies shouldBe 1.pence
        1.pennies shouldBe 1.pence
        1L.tuppence shouldBe (2.pence into Tuppence)
        1L.thruppence shouldBe (3.pence into Thruppence)
        1L.groats shouldBe (4.pence into Groats)
        1L.sixpences shouldBe (6.pence into Sixpences)
        1L.shillings shouldBe (12.pence into Shillings)
        1L.dollars shouldBe (240.pence into Dollars)
    }

    @Test
    fun `should pretty print`() {
        "$Elim" shouldBe "Ankh-Morpork denomination: elim"
        "${1.elims}" shouldBe "1 elims"
        "$Mite" shouldBe "Ankh-Morpork denomination: mite"
        "${1.mites}" shouldBe "1 mites"
        "$Farthing" shouldBe "Ankh-Morpork denomination: farthing"
        "${1.farthings}" shouldBe "1 farthings"
        "$Halfpenny" shouldBe "Ankh-Morpork denomination: halfpenny"
        "${1.halfpennies}" shouldBe "1 halfpennies"
        "$Penny" shouldBe "Ankh-Morpork denomination: penny"
        "${1.pence}" shouldBe "1p"
        "$Tuppenny" shouldBe "Ankh-Morpork denomination: tuppenny"
        "${1.tuppence}" shouldBe "1 tuppence"
        "$Thruppenny" shouldBe "Ankh-Morpork denomination: thruppenny"
        "${1.thruppence}" shouldBe "1 thruppence"
        "$Sixpence" shouldBe "Ankh-Morpork denomination: sixpence"
        "${1.sixpences}" shouldBe "1 sixpences"
        "$Groat" shouldBe "Ankh-Morpork denomination: groat"
        "${1.groats}" shouldBe "1 groats"
        "$Shilling" shouldBe "Ankh-Morpork denomination: shilling"
        "${1.shillings}" shouldBe "1s"
        "$Dollar" shouldBe "Ankh-Morpork denomination: dollar"
        "${1.dollars}" shouldBe "$1"
    }
}
