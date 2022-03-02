package hm.binkley.kunits

import hm.binkley.kunits.Foo.Foos
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import java.lang.System.identityHashCode

internal class UnitsTest {
    @Test
    fun `should pretty print`() {
        "$Metasyntactic" shouldBe "Metasyntactic"
        "$Foos" shouldBe "Metasyntactic foo"
        "${1.foos}" shouldBe "1 foos"
    }

    @Test
    fun `should be named`() {
        Metasyntactic.name shouldBe "Metasyntactic"
        Foos.name shouldBe "foo"
    }

    @Test
    fun `should be part of a system`() {
        Foos.system shouldBe Metasyntactic
    }

    @Suppress("ReplaceCallWithBinaryOperator")
    @Test
    fun `should equate`() {
        val measure = 1.foos
        measure.equals(measure).shouldBeTrue()
        measure.equals(this).shouldBeFalse()
        measure.equals(1.groks).shouldBeFalse()
        measure.equals(1.bars).shouldBeFalse()
        measure.equals(2.foos).shouldBeFalse()
    }

    @Test
    fun `should hash`() {
        val measure = 1.foos
        identityHashCode(measure) shouldNotBe measure.hashCode()
    }
}
