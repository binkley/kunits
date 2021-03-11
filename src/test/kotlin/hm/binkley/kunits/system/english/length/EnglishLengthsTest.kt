package hm.binkley.kunits.system.english.length

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishLengthsTest {
    @Test
    fun `should convert`() {
        1.poppyseeds shouldBe 1.poppyseeds.poppyseeds
        1L.poppyseeds.barleycorns shouldBe (1 over 4).barleycorns
        1.poppyseeds.inches shouldBe (1 over 12).inches
        1.poppyseeds.sticks shouldBe (1 over 24).sticks
        1.poppyseeds.hands shouldBe (1 over 48).hands
        1.poppyseeds.feet shouldBe (1 over 144).feet
        1.poppyseeds.yards shouldBe (1 over 432).yards

        4.poppyseeds shouldBe 1.barleycorns.poppyseeds
        1.barleycorns shouldBe 1L.barleycorns.barleycorns
        1.barleycorns.inches shouldBe (1 over 3).inches
        1.barleycorns.sticks shouldBe (1 over 6).sticks
        1.barleycorns.hands shouldBe (1 over 12).hands
        1.barleycorns.feet shouldBe (1 over 36).feet
        1.barleycorns.yards shouldBe (1 over 108).yards

        12.poppyseeds shouldBe 1.inches.poppyseeds
        3.barleycorns shouldBe 1L.inches.barleycorns
        1.inches shouldBe 1.inches.inches
        1.inches.sticks shouldBe (1 over 2).sticks
        1.inches.hands shouldBe (1 over 4).hands
        1.inches.feet shouldBe (1 over 12).feet
        1.inches.yards shouldBe (1 over 36).yards

        24.poppyseeds shouldBe 1.sticks.poppyseeds
        6.barleycorns shouldBe 1L.sticks.barleycorns
        2.inches shouldBe 1.sticks.inches
        1.sticks shouldBe 1.sticks.sticks
        1.sticks.hands shouldBe (1 over 2).hands
        1.sticks.feet shouldBe (1 over 6).feet
        1.sticks.yards shouldBe (1 over 18).yards

        48.poppyseeds shouldBe 1.hands.poppyseeds
        12.barleycorns shouldBe 1L.hands.barleycorns
        4.inches shouldBe 1.hands.inches
        2.sticks shouldBe 1.hands.sticks
        1.hands shouldBe 1.hands.hands
        1.hands.feet shouldBe (1 over 3).feet
        1.hands.yards shouldBe (1 over 9).yards

        144.poppyseeds shouldBe 1.feet.poppyseeds
        36.barleycorns shouldBe 1L.feet.barleycorns
        12.inches shouldBe 1.feet.inches
        6.sticks shouldBe 1.feet.sticks
        3.hands shouldBe 1.feet.hands
        1.feet shouldBe 1.feet.feet
        1.feet.yards shouldBe (1 over 3).yards

        432.poppyseeds shouldBe 1.yards.poppyseeds
        108.barleycorns shouldBe 1L.yards.barleycorns
        36.inches shouldBe 1.yards.inches
        18.sticks shouldBe 1.yards.sticks
        9.hands shouldBe 1.yards.hands
        3.feet shouldBe 1.yards.feet
        1.yards shouldBe 1.yards.yards
    }

    @Test
    fun `should pretty print`() {
        "$Poppyseeds" shouldBe "English poppyseed"
        "${1.poppyseeds}" shouldBe "1 poppyseeds"
        "$Barleycorns" shouldBe "English barleycorn"
        "${1.barleycorns}" shouldBe "1 barleycorns"
        "$Inches" shouldBe "English inch"
        "${1.inches}" shouldBe "1\""
        "$Sticks" shouldBe "English stick"
        "${1.sticks}" shouldBe "1 sticks"
        "$Hands" shouldBe "English hand"
        "${1.hands}" shouldBe "1 hh"
        "$Feet" shouldBe "English foot"
        "${1.feet}" shouldBe "1'"
        "$Yards" shouldBe "English yard"
        "${1.yards}" shouldBe "1 yd"
    }
}
