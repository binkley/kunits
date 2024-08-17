package hm.binkley.kunits.system.english.volume.wine

import hm.binkley.kunits.into
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class EnglishWineVolumesTest {
    @Test
    fun `should convert`() {
        1L.tuns shouldBe 1.tuns
        1L.pipes shouldBe ((1 over 2).tuns into Pipe)
        1L.puncheons shouldBe ((1 over 3).tuns into Puncheon)
        1L.hogsheads shouldBe ((1 over 4).tuns into Hogshead)
        1L.tierces shouldBe ((1 over 6).tuns into Tierce)
        1L.wineBarrels shouldBe ((1 over 8).tuns into WineBarrel)
        1L.rundlets shouldBe ((1 over 14).tuns into Rundlet)
    }

    @Test
    fun `should pretty print`() {
        "$Tun" shouldBe "English volume: tun"
        "${1.tuns}" shouldBe "1 tuns"
        "$Pipe" shouldBe "English volume: pipe"
        "${1.pipes}" shouldBe "1 pipes"
        "$Puncheon" shouldBe "English volume: puncheon"
        "${1.puncheons}" shouldBe "1 puncheons"
        "$Hogshead" shouldBe "English volume: hogshead"
        "${1.hogsheads}" shouldBe "1 hhd"
        "${2.hogsheads}" shouldBe "2 hhds"
        "$Tierce" shouldBe "English volume: tierce"
        "${1.tierces}" shouldBe "1 tierces"
        "$WineBarrel" shouldBe "English volume: wine barrel"
        "${1.wineBarrels}" shouldBe "1 wine barrels"
        "$Rundlet" shouldBe "English volume: rundlet"
        "${1.rundlets}" shouldBe "1 rundlets"
    }
}
