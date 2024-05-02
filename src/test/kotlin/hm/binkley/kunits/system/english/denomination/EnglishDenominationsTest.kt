/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package hm.binkley.kunits.system.english.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.english.denomination.Crown.Crowns
import hm.binkley.kunits.system.english.denomination.Farthing.Farthings
import hm.binkley.kunits.system.english.denomination.Florin.Florins
import hm.binkley.kunits.system.english.denomination.Groat.Groats
import hm.binkley.kunits.system.english.denomination.Guinea.Guineas
import hm.binkley.kunits.system.english.denomination.HalfCrown.HalfCrowns
import hm.binkley.kunits.system.english.denomination.HalfGroat.HalfGroats
import hm.binkley.kunits.system.english.denomination.HalfGuinea.HalfGuineas
import hm.binkley.kunits.system.english.denomination.HalfSovereign.HalfSovereigns
import hm.binkley.kunits.system.english.denomination.Halfpenny.Halfpence
import hm.binkley.kunits.system.english.denomination.Mark.Marks
import hm.binkley.kunits.system.english.denomination.Pound.Pounds
import hm.binkley.kunits.system.english.denomination.Shilling.Shillings
import hm.binkley.kunits.system.english.denomination.Sixpenny.Sixpence
import hm.binkley.kunits.system.english.denomination.Threepenny.Threepence
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishDenominationsTest {
    @Test
    fun `should convert`() {
        1L.farthings shouldBe ((1 over 4).pence into Farthings)
        1L.halfpence shouldBe ((1 over 2).pence into Halfpence)
        1L.pence shouldBe 1.pence
        1L.halfGroats shouldBe (2.pence into HalfGroats)
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
        1L.florins shouldBe (24.pence into Florins)
        1L.halfCrowns shouldBe (30.pence into HalfCrowns)
        1L.crowns shouldBe (60.pence into Crowns)
        1L.halfSovereigns shouldBe (120.pence into HalfSovereigns)
        1L.halfGuineas shouldBe (126.pence into HalfGuineas)
        1L.marks shouldBe (160.pence into Marks)
        1L.pounds shouldBe (240.pence into Pounds)
        (1 over 1).quid shouldBe 1.pounds
        1L.quid shouldBe 1.pounds
        1L.guineas shouldBe (252.pence into Guineas)
    }

    @Test
    fun `should pretty print`() {
        "$Farthing" shouldBe "English denomination: farthing"
        "${1.farthings}" shouldBe "1 farthings"
        "$Halfpenny" shouldBe "English denomination: halfpenny"
        "${1.halfpence}" shouldBe "1 halfpennies"
        "$Penny" shouldBe "English denomination: penny"
        "${1.pence}" shouldBe "1d"
        "$HalfGroat" shouldBe "English denomination: half-groat"
        "${1.halfGroats}" shouldBe "1 half-groats"
        "$Threepenny" shouldBe "English denomination: threepenny"
        "${1.threepence}" shouldBe "1 threepence"
        "${1.thruppence}" shouldBe "1 threepence"
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
        "$HalfCrown" shouldBe "English denomination: half-crown"
        "${1.halfCrowns}" shouldBe "1 half-crowns"
        "$HalfGuinea" shouldBe "English denomination: half-guinea"
        "${1.halfGuineas}" shouldBe "1 half-guineas"
        "$Crown" shouldBe "English denomination: crown"
        "${1.crowns}" shouldBe "1 crowns"
        "$HalfSovereign" shouldBe "English denomination: half-sovereign"
        "${1.halfSovereigns}" shouldBe "1 half-sovereigns"
        "$Mark" shouldBe "English denomination: mark"
        "${1.marks}" shouldBe "1 marks"
        "$Pound" shouldBe "English denomination: pound"
        "${1.pounds}" shouldBe "£1"
        "${1.quid}" shouldBe "£1"
        "$Guinea" shouldBe "English denomination: guinea"
        "${1.guineas}" shouldBe "1gns"
    }
}
