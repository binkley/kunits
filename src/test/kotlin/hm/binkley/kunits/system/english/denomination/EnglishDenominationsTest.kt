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
import hm.binkley.kunits.system.english.denomination.Guinea.Guineas
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
        1L.threepence shouldBe (3.pence into Threepence)
        1L.sixpence shouldBe (6.pence into Sixpence)
        1L.shillings shouldBe (12.pence into Shillings)
        1L.florins shouldBe (24.pence into Florins)
        1L.crowns shouldBe (60.pence into Crowns)
        1L.marks shouldBe (160.pence into Marks)
        1L.pounds shouldBe (240.pence into Pounds)
        1L.guineas shouldBe (252.pence into Guineas)
    }

    @Test
    fun `should pretty print`() {
        "$Farthings" shouldBe "English denomination: farthing"
        "${1.farthings}" shouldBe "1 farthings"
        "$Halfpenny" shouldBe "English denomination: halfpenny"
        "${1.halfpence}" shouldBe "1 halfpennies"
        "$Penny" shouldBe "English denomination: penny"
        "${1.pence}" shouldBe "1d"
        "$Threepenny" shouldBe "English denomination: threepenny"
        "${1.threepence}" shouldBe "1 threepence"
        "$Sixpenny" shouldBe "English denomination: sixpenny"
        "${1.sixpence}" shouldBe "1 sixpence"
        "$Shilling" shouldBe "English denomination: shilling"
        "${1.shillings}" shouldBe "1s"
        "$Florin" shouldBe "English denomination: florin"
        "${1.florins}" shouldBe "1 florins"
        "$Crowns" shouldBe "English denomination: crown"
        "${1.crowns}" shouldBe "1 crowns"
        "$Marks" shouldBe "English denomination: mark"
        "${1.marks}" shouldBe "1 marks"
        "$Pounds" shouldBe "English denomination: pound"
        "${1.pounds}" shouldBe "£1"
        "$Guineas" shouldBe "English denomination: guinea"
        "${1.guineas}" shouldBe "1gns"
    }
}
