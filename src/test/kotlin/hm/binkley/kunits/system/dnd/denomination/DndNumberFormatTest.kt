package hm.binkley.kunits.system.dnd.denomination

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class DndNumberFormatTest {
    @ParameterizedTest(name = "{0} cp → {2} ({1})")
    @CsvSource(
        // cp, style, expected
        "0,    SHORT, -/-/-",
        "0,    LONG,  0 cp",
        "5,    SHORT, -/-/5",
        "5,    LONG,  5 cp",
        "10,   SHORT, -/1/-",
        "10,   LONG,  1 sp",
        "17,   SHORT, -/1/7",
        "17,   LONG,  1 sp 7 cp",
        "100,  SHORT, 1/-/-",
        "100,  LONG,  1 gp",
        "123,  SHORT, 1/2/3",
        "123,  LONG,  1 gp 2 sp 3 cp",
        "237,  SHORT, 2/3/7",
        "237,  LONG,  2 gp 3 sp 7 cp",
        "1000, SHORT, 10/-/-",
        "1000, LONG,  10 gp"
    )
    fun `should format DnD currency correctly`(
        cp: Long,
        style: String,
        expected: String
    ) {
        val format = DnDNumberFormat(DnDFormatStyle.valueOf(style))

        format.format(cp) shouldBe expected
    }

    @Test
    fun `TODO should not format from a double for now`() {
        shouldThrow<NotImplementedError> {
            DnDNumberFormat().format(1.0)
        }
    }

    @Test
    fun `TODO should not parse for now`() {
        shouldThrow<NotImplementedError> {
            DnDNumberFormat().parse("1 gp")
        }
    }
}