package hm.binkley.kunits.system.usd.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.usd.denomination.Dime.Dimes
import hm.binkley.kunits.system.usd.denomination.Dollar.Dollars
import hm.binkley.kunits.system.usd.denomination.DollarCoin.DollarCoins
import hm.binkley.kunits.system.usd.denomination.FiftyDollar.FiftyDollars
import hm.binkley.kunits.system.usd.denomination.FiveDollar.FiveDollars
import hm.binkley.kunits.system.usd.denomination.HalfDollar.HalfDollars
import hm.binkley.kunits.system.usd.denomination.HundredDollar.HundredDollars
import hm.binkley.kunits.system.usd.denomination.Nickel.Nickels
import hm.binkley.kunits.system.usd.denomination.Penny.Pennies
import hm.binkley.kunits.system.usd.denomination.Quarter.Quarters
import hm.binkley.kunits.system.usd.denomination.TenDollar.TenDollars
import hm.binkley.kunits.system.usd.denomination.TwentyDollar.TwentyDollars
import hm.binkley.kunits.system.usd.denomination.TwoDollar.TwoDollars
import hm.binkley.math.fixed.over
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class USDDenominationsTest {
    @Test
    fun `should convert`() {
        1L.pennies shouldBe 1.pennies
        1L.nickels shouldBe (5.pennies into Nickels)
        1L.dimes shouldBe (2.nickels into Dimes)
        1L.quarters shouldBe ((5 over 2).dimes into Quarters)
        1L.halfDollars shouldBe (2.quarters into HalfDollars)
        1L.dollarCoins shouldBe (2.halfDollars into DollarCoins)
        1L.dollars shouldBe (1.dollarCoins into Dollars)
        1L.twoDollars shouldBe (2.dollars into TwoDollars)
        1L.fiveDollars shouldBe ((5 over 2).twoDollars into FiveDollars)
        1L.tenDollars shouldBe (2.fiveDollars into TenDollars)
        1L.twentyDollars shouldBe (2.tenDollars into TwentyDollars)
        1L.fiftyDollars shouldBe ((5 over 2).twentyDollars into FiftyDollars)
        1L.hundredDollars shouldBe (2.fiftyDollars into HundredDollars)
        1L.hundredDollars shouldBe 1.hundredDollars
    }

    @Test
    fun `should pretty print`() {
        "$Pennies" shouldBe "USD penny"
        "${1.pennies}" shouldBe "1 1¢"
        "$Nickels" shouldBe "USD nickel"
        "${1.nickels}" shouldBe "1 5¢"
        "$Dimes" shouldBe "USD dime"
        "${1.dimes}" shouldBe "1 10¢"
        "$Quarters" shouldBe "USD quarter"
        "${1.quarters}" shouldBe "1 25¢"
        "$HalfDollars" shouldBe "USD half dollar"
        "${1.halfDollars}" shouldBe "1 50¢"
        "$DollarCoins" shouldBe "USD dollar coin"
        "${1.dollarCoins}" shouldBe "1 100¢"
        "$Dollars" shouldBe "USD dollar bill"
        "${1.dollars}" shouldBe "1 \$1"
        "$TwoDollars" shouldBe "USD two dollar bill"
        "${1.twoDollars}" shouldBe "1 \$2"
        "$FiveDollars" shouldBe "USD five dollar bill"
        "${1.fiveDollars}" shouldBe "1 \$5"
        "$TenDollars" shouldBe "USD ten dollar bill"
        "${1.tenDollars}" shouldBe "1 \$10"
        "$TwentyDollars" shouldBe "USD twenty dollar bill"
        "${1.twentyDollars}" shouldBe "1 \$20"
        "$FiftyDollars" shouldBe "USD fifty dollar bill"
        "${1.fiftyDollars}" shouldBe "1 \$50"
        "$HundredDollars" shouldBe "USD hundred dollar bill"
        "${1.hundredDollars}" shouldBe "1 \$100"
    }
}
