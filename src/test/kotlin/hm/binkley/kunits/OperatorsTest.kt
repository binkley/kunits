package hm.binkley.kunits

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OperatorsTest {
    @Test
    fun `should posite`() {
        +(1L.foos) shouldBe (+1).foos
    }

    @Test
    fun `should negate`() {
        -(1.foos) shouldBe (-1L).foos
    }

    @Test
    fun `should add`() {
        1.foos + 2.foos shouldBe 3.foos
    }

    @Test
    fun `should subtract`() {
        3.foos - 2.foos shouldBe 1.foos
    }

    @Test
    fun `should multiply`() {
        1.foos * 3 shouldBe 3.foos
        3 * 1.foos shouldBe 3.foos
        1.foos * 3L shouldBe 3.foos
        3L * 1.foos shouldBe 3.foos
        1.foos * (3 over 1) shouldBe 3.foos
        (3 over 1) * 1.foos shouldBe 3.foos
    }

    @Test
    fun `should divide`() {
        3.foos / 4.bars shouldBe (3 over 8)
        3.foos / 3 shouldBe 1.foos
        3.foos / 3L shouldBe 1.foos
        3.foos / (3 over 1) shouldBe 1.foos
    }
}
