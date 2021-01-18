package hm.binkley.kunits.system.english.length

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishLengthsTest {
    @Test
    fun `should convert`() {
        1.poppyseeds shouldBe 1.poppyseeds.to(Poppyseeds)
        1L.poppyseeds.to(Barleycorns) shouldBe (1 over 4).barleycorns
        1.poppyseeds.to(Inches) shouldBe (1 over 12).inches
        1.poppyseeds.to(Sticks) shouldBe (1 over 24).sticks
        1.poppyseeds.to(Hands) shouldBe (1 over 48).hands
        1.poppyseeds.to(Feet) shouldBe (1 over 144).feet
        1.poppyseeds.to(Yards) shouldBe (1 over 432).yards

        4.poppyseeds shouldBe 1.barleycorns.to(Poppyseeds)
        1.barleycorns shouldBe 1L.barleycorns.to(Barleycorns)
        1.barleycorns.to(Inches) shouldBe (1 over 3).inches
        1.barleycorns.to(Sticks) shouldBe (1 over 6).sticks
        1.barleycorns.to(Hands) shouldBe (1 over 12).hands
        1.barleycorns.to(Feet) shouldBe (1 over 36).feet
        1.barleycorns.to(Yards) shouldBe (1 over 108).yards

        12.poppyseeds shouldBe 1.inches.to(Poppyseeds)
        3.barleycorns shouldBe 1L.inches.to(Barleycorns)
        1.inches shouldBe 1.inches.to(Inches)
        1.inches.to(Sticks) shouldBe (1 over 2).sticks
        1.inches.to(Hands) shouldBe (1 over 4).hands
        1.inches.to(Feet) shouldBe (1 over 12).feet
        1.inches.to(Yards) shouldBe (1 over 36).yards

        24.poppyseeds shouldBe 1.sticks.to(Poppyseeds)
        6.barleycorns shouldBe 1L.sticks.to(Barleycorns)
        2.inches shouldBe 1.sticks.to(Inches)
        1.sticks shouldBe 1.sticks.to(Sticks)
        1.sticks.to(Hands) shouldBe (1 over 2).hands
        1.sticks.to(Feet) shouldBe (1 over 6).feet
        1.sticks.to(Yards) shouldBe (1 over 18).yards

        48.poppyseeds shouldBe 1.hands.to(Poppyseeds)
        12.barleycorns shouldBe 1L.hands.to(Barleycorns)
        4.inches shouldBe 1.hands.to(Inches)
        2.sticks shouldBe 1.hands.to(Sticks)
        1.hands shouldBe 1.hands.to(Hands)
        1.hands.to(Feet) shouldBe (1 over 3).feet
        1.hands.to(Yards) shouldBe (1 over 9).yards

        144.poppyseeds shouldBe 1.feet.to(Poppyseeds)
        36.barleycorns shouldBe 1L.feet.to(Barleycorns)
        12.inches shouldBe 1.feet.to(Inches)
        6.sticks shouldBe 1.feet.to(Sticks)
        3.hands shouldBe 1.feet.to(Hands)
        1.feet shouldBe 1.feet.to(Feet)
        1.feet.to(Yards) shouldBe (1 over 3).yards

        432.poppyseeds shouldBe 1.yards.to(Poppyseeds)
        108.barleycorns shouldBe 1L.yards.to(Barleycorns)
        36.inches shouldBe 1.yards.to(Inches)
        18.sticks shouldBe 1.yards.to(Sticks)
        9.hands shouldBe 1.yards.to(Hands)
        3.feet shouldBe 1.yards.to(Feet)
        1.yards shouldBe 1.yards.to(Yards)
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
