package hm.binkley.kunits

import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class OperatorsTest {
    @Test
    fun `should posite`() {
        +(1L.foo) shouldBe (+1).foo
    }

    @Test
    fun `should negate`() {
        -(1.foo) shouldBe (-1L).foo
    }

    @Test
    fun `should add`() {
        1.foo + 2.foo shouldBe 3.foo
    }

    @Test
    fun `should subtract`() {
        3.foo - 2.foo shouldBe 1.foo
    }

    @Test
    fun `should multiply`() {
        1.foo * 3 shouldBe 3.foo
        3 * 1.foo shouldBe 3.foo
        1.foo * 3L shouldBe 3.foo
        3L * 1.foo shouldBe 3.foo
        1.foo * (3 over 1) shouldBe 3.foo
        (3 over 1) * 1.foo shouldBe 3.foo
    }

    @Test
    fun `should divide`() {
        3.foo / 4.bar shouldBe (3 over 8)
        3.foo / 3 shouldBe 1.foo
        3.foo / 3L shouldBe 1.foo
        3.foo / (3 over 1) shouldBe 1.foo
    }
}
