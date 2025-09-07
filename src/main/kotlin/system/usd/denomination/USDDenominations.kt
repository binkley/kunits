package hm.binkley.kunits.system.usd.denomination

import hm.binkley.kunits.Denomination
import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.into
import hm.binkley.kunits.system.usd.USD
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
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.FixedBigRational.Companion.TEN
import hm.binkley.math.fixed.FixedBigRational.Companion.TWO
import hm.binkley.math.fixed.over
import java.text.NumberFormat

/** The USD denominations. */
sealed class USDDenominations<
    U : USDDenominations<U, M>,
    M : USDDenomination<U, M>
    >(
    name: String,
    dollars: FixedBigRational
) : Units<Denomination, USD, U, M>(Denomination, USD, name, dollars)

sealed class USDDenomination<
    U : USDDenominations<U, M>,
    M : USDDenomination<U, M>
    >(
    unit: U,
    quantity: FixedBigRational
) : Measure<Denomination, USD, U, M>(unit, quantity)

/**
 * Formats USD money following US locale rules.
 * Example: "$4.33".
 *
 * **NOTE**: The JDK formatting classes are _not_ thread-safe.
 * Pass in a "currency instance" for the JDK `NumberFormat`.
 * For example, with USD denominations, you can use
 * `NumberFormat.getCurrencyInstance(US)`.
 *
 * NB &mdash; use `Measure<Denomination, USD, *, *>` rather than
 * `USDDenomination<*, *>` to better match generics using [into].
 */
fun Measure<Denomination, USD, *, *>.format(formatter: NumberFormat): String =
    formatter.format((this into Dollars).quantity.toBigDecimal())

class HundredDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<HundredDollars, HundredDollar>(HundredDollars, quantity) {
    companion object HundredDollars :
        USDDenominations<HundredDollars, HundredDollar>(
            "hundred dollar bill",
            100 over 1
        ) {
        override fun new(quantity: FixedBigRational) = HundredDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $100"
    }
}

val FixedBigRational.hundredDollars get() = HundredDollars.new(this)
val Long.hundredDollars get() = (this over 1).hundredDollars
val Int.hundredDollars get() = (this over 1).hundredDollars

class FiftyDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<FiftyDollars, FiftyDollar>(FiftyDollars, quantity) {
    companion object FiftyDollars : USDDenominations<FiftyDollars, FiftyDollar>(
        "fifty dollar bill",
        50 over 1
    ) {
        override fun new(quantity: FixedBigRational) = FiftyDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $50"
    }
}

val FixedBigRational.fiftyDollars get() = FiftyDollars.new(this)
val Long.fiftyDollars get() = (this over 1).fiftyDollars
val Int.fiftyDollars get() = (this over 1).fiftyDollars

class TwentyDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<TwentyDollars, TwentyDollar>(TwentyDollars, quantity) {
    companion object TwentyDollars :
        USDDenominations<TwentyDollars, TwentyDollar>(
            "twenty dollar bill",
            20 over 1
        ) {
        override fun new(quantity: FixedBigRational) = TwentyDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $20"
    }
}

val FixedBigRational.twentyDollars get() = TwentyDollars.new(this)
val Long.twentyDollars get() = (this over 1).twentyDollars
val Int.twentyDollars get() = (this over 1).twentyDollars

class TenDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<TenDollars, TenDollar>(TenDollars, quantity) {
    companion object TenDollars : USDDenominations<TenDollars, TenDollar>(
        "ten dollar bill",
        TEN
    ) {
        override fun new(quantity: FixedBigRational) = TenDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $10"
    }
}

val FixedBigRational.tenDollars get() = TenDollars.new(this)
val Long.tenDollars get() = (this over 1).tenDollars
val Int.tenDollars get() = (this over 1).tenDollars

class FiveDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<FiveDollars, FiveDollar>(FiveDollars, quantity) {
    companion object FiveDollars : USDDenominations<FiveDollars, FiveDollar>(
        "five dollar bill",
        5 over 1
    ) {
        override fun new(quantity: FixedBigRational) = FiveDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $5"
    }
}

val FixedBigRational.fiveDollars get() = FiveDollars.new(this)
val Long.fiveDollars get() = (this over 1).fiveDollars
val Int.fiveDollars get() = (this over 1).fiveDollars

class TwoDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<TwoDollars, TwoDollar>(TwoDollars, quantity) {
    companion object TwoDollars : USDDenominations<TwoDollars, TwoDollar>(
        "two dollar bill",
        TWO
    ) {
        override fun new(quantity: FixedBigRational) = TwoDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $2"
    }
}

val FixedBigRational.twoDollars get() = TwoDollars.new(this)
val Long.twoDollars get() = (this over 1).twoDollars
val Int.twoDollars get() = (this over 1).twoDollars

class Dollar private constructor(quantity: FixedBigRational) :
    USDDenomination<Dollars, Dollar>(Dollars, quantity) {
    companion object Dollars : USDDenominations<Dollars, Dollar>(
        "dollar bill",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Dollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity $1"
    }
}

val FixedBigRational.dollars get() = Dollars.new(this)
val Long.dollars get() = (this over 1).dollars
val Int.dollars get() = (this over 1).dollars

class DollarCoin private constructor(quantity: FixedBigRational) :
    USDDenomination<DollarCoins, DollarCoin>(DollarCoins, quantity) {
    companion object DollarCoins : USDDenominations<DollarCoins, DollarCoin>(
        "dollar coin",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = DollarCoin(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 100¢"
    }
}

val FixedBigRational.dollarCoins get() = DollarCoins.new(this)
val Long.dollarCoins get() = (this over 1).dollarCoins
val Int.dollarCoins get() = (this over 1).dollarCoins

class HalfDollar private constructor(quantity: FixedBigRational) :
    USDDenomination<HalfDollars, HalfDollar>(HalfDollars, quantity) {
    companion object HalfDollars : USDDenominations<HalfDollars, HalfDollar>(
        "half dollar",
        1 over 2
    ) {
        override fun new(quantity: FixedBigRational) = HalfDollar(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 50¢"
    }
}

val FixedBigRational.halfDollars get() = HalfDollars.new(this)
val Long.halfDollars get() = (this over 1).halfDollars
val Int.halfDollars get() = (this over 1).halfDollars

class Quarter private constructor(quantity: FixedBigRational) :
    USDDenomination<Quarters, Quarter>(Quarters, quantity) {
    companion object Quarters : USDDenominations<Quarters, Quarter>(
        "quarter",
        1 over 4
    ) {
        override fun new(quantity: FixedBigRational) = Quarter(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 25¢"
    }
}

val FixedBigRational.quarters get() = Quarters.new(this)
val Long.quarters get() = (this over 1).quarters
val Int.quarters get() = (this over 1).quarters

class Dime private constructor(quantity: FixedBigRational) :
    USDDenomination<Dimes, Dime>(Dimes, quantity) {
    companion object Dimes : USDDenominations<Dimes, Dime>(
        "dime",
        1 over 10
    ) {
        override fun new(quantity: FixedBigRational) = Dime(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 10¢"
    }
}

val FixedBigRational.dimes get() = Dimes.new(this)
val Long.dimes get() = (this over 1).dimes
val Int.dimes get() = (this over 1).dimes

class Nickel private constructor(quantity: FixedBigRational) :
    USDDenomination<Nickels, Nickel>(Nickels, quantity) {
    companion object Nickels : USDDenominations<Nickels, Nickel>(
        "nickel",
        1 over 20
    ) {
        override fun new(quantity: FixedBigRational) = Nickel(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 5¢"
    }
}

val FixedBigRational.nickels get() = Nickels.new(this)
val Long.nickels get() = (this over 1).nickels
val Int.nickels get() = (this over 1).nickels

class Penny private constructor(quantity: FixedBigRational) :
    USDDenomination<Pennies, Penny>(Pennies, quantity) {
    companion object Pennies : USDDenominations<Pennies, Penny>(
        "penny",
        1 over 100
    ) {
        override fun new(quantity: FixedBigRational) = Penny(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity 1¢"
    }
}

val FixedBigRational.pennies get() = Pennies.new(this)
val Long.pennies get() = (this over 1).pennies
val Int.pennies get() = (this over 1).pennies

// Common alias for pennies, eg, "4.dollars + 33.cents"
val FixedBigRational.cents get() = pennies
val Long.cents get() = pennies
val Int.cents get() = pennies
