package hm.binkley.kunits.system.usd.denomination

import hm.binkley.kunits.Denominations
import hm.binkley.kunits.Measure
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
import java.util.Locale.US

/** The USD denominations. */
sealed class USDDenominations<U : USDDenominations<U>>(
    name: String,
    dollars: FixedBigRational,
) : Denominations<USD, U>(USD, name, dollars)

/** Formats USD money following US locale rules.  Example: "$4.33". */
fun Measure<USD, *>.format(): String = NumberFormat.getCurrencyInstance(US)
    .format((this into Dollars).quantity.toBigDecimal())

class HundredDollar private constructor(value: FixedBigRational) :
    Measure<USD, HundredDollars>(HundredDollars, value) {

    companion object HundredDollars :
        USDDenominations<HundredDollars>("hundred dollar bill", (100 over 1)) {
        override fun new(value: FixedBigRational) = HundredDollar(value)
        override fun format(value: FixedBigRational) = "$value \$100"
    }
}

val FixedBigRational.hundredDollars get() = HundredDollars.new(this)
val Long.hundredDollars get() = (this over 1).hundredDollars
val Int.hundredDollars get() = (this over 1).hundredDollars

class FiftyDollar private constructor(value: FixedBigRational) :
    Measure<USD, FiftyDollars>(FiftyDollars, value) {

    companion object FiftyDollars :
        USDDenominations<FiftyDollars>("fifty dollar bill", (50 over 1)) {
        override fun new(value: FixedBigRational) = FiftyDollar(value)
        override fun format(value: FixedBigRational) = "$value \$50"
    }
}

val FixedBigRational.fiftyDollars get() = FiftyDollars.new(this)
val Long.fiftyDollars get() = (this over 1).fiftyDollars
val Int.fiftyDollars get() = (this over 1).fiftyDollars

class TwentyDollar private constructor(value: FixedBigRational) :
    Measure<USD, TwentyDollars>(TwentyDollars, value) {

    companion object TwentyDollars :
        USDDenominations<TwentyDollars>("twenty dollar bill", (20 over 1)) {
        override fun new(value: FixedBigRational) = TwentyDollar(value)
        override fun format(value: FixedBigRational) = "$value \$20"
    }
}

val FixedBigRational.twentyDollars get() = TwentyDollars.new(this)
val Long.twentyDollars get() = (this over 1).twentyDollars
val Int.twentyDollars get() = (this over 1).twentyDollars

class TenDollar private constructor(value: FixedBigRational) :
    Measure<USD, TenDollars>(TenDollars, value) {

    companion object TenDollars :
        USDDenominations<TenDollars>("ten dollar bill", TEN) {
        override fun new(value: FixedBigRational) = TenDollar(value)
        override fun format(value: FixedBigRational) = "$value \$10"
    }
}

val FixedBigRational.tenDollars get() = TenDollars.new(this)
val Long.tenDollars get() = (this over 1).tenDollars
val Int.tenDollars get() = (this over 1).tenDollars

class FiveDollar private constructor(value: FixedBigRational) :
    Measure<USD, FiveDollars>(FiveDollars, value) {

    companion object FiveDollars :
        USDDenominations<FiveDollars>("five dollar bill", (5 over 1)) {
        override fun new(value: FixedBigRational) = FiveDollar(value)
        override fun format(value: FixedBigRational) = "$value \$5"
    }
}

val FixedBigRational.fiveDollars get() = FiveDollars.new(this)
val Long.fiveDollars get() = (this over 1).fiveDollars
val Int.fiveDollars get() = (this over 1).fiveDollars

class TwoDollar private constructor(value: FixedBigRational) :
    Measure<USD, TwoDollars>(TwoDollars, value) {

    companion object TwoDollars :
        USDDenominations<TwoDollars>("two dollar bill", TWO) {
        override fun new(value: FixedBigRational) = TwoDollar(value)
        override fun format(value: FixedBigRational) = "$value \$2"
    }
}

val FixedBigRational.twoDollars get() = TwoDollars.new(this)
val Long.twoDollars get() = (this over 1).twoDollars
val Int.twoDollars get() = (this over 1).twoDollars

class Dollar private constructor(value: FixedBigRational) :
    Measure<USD, Dollars>(Dollars, value) {

    companion object Dollars : USDDenominations<Dollars>("dollar bill", ONE) {
        override fun new(value: FixedBigRational) = Dollar(value)
        override fun format(value: FixedBigRational) = "$value \$1"
    }
}

val FixedBigRational.dollars get() = Dollars.new(this)
val Long.dollars get() = (this over 1).dollars
val Int.dollars get() = (this over 1).dollars

class DollarCoin private constructor(value: FixedBigRational) :
    Measure<USD, DollarCoins>(DollarCoins, value) {

    companion object DollarCoins :
        USDDenominations<DollarCoins>("dollar coin", ONE) {
        override fun new(value: FixedBigRational) = DollarCoin(value)
        override fun format(value: FixedBigRational) = "$value 100¢"
    }
}

val FixedBigRational.dollarCoins get() = DollarCoins.new(this)
val Long.dollarCoins get() = (this over 1).dollarCoins
val Int.dollarCoins get() = (this over 1).dollarCoins

class HalfDollar private constructor(value: FixedBigRational) :
    Measure<USD, HalfDollars>(HalfDollars, value) {

    companion object HalfDollars :
        USDDenominations<HalfDollars>("half dollar", (1 over 2)) {
        override fun new(value: FixedBigRational) = HalfDollar(value)
        override fun format(value: FixedBigRational) = "$value 50¢"
    }
}

val FixedBigRational.halfDollars get() = HalfDollars.new(this)
val Long.halfDollars get() = (this over 1).halfDollars
val Int.halfDollars get() = (this over 1).halfDollars

class Quarter private constructor(value: FixedBigRational) :
    Measure<USD, Quarters>(Quarters, value) {

    companion object Quarters :
        USDDenominations<Quarters>("quarter", (1 over 4)) {
        override fun new(value: FixedBigRational) = Quarter(value)
        override fun format(value: FixedBigRational) = "$value 25¢"
    }
}

val FixedBigRational.quarters get() = Quarters.new(this)
val Long.quarters get() = (this over 1).quarters
val Int.quarters get() = (this over 1).quarters

class Dime private constructor(value: FixedBigRational) :
    Measure<USD, Dimes>(Dimes, value) {

    companion object Dimes : USDDenominations<Dimes>("dime", (1 over 10)) {
        override fun new(value: FixedBigRational) = Dime(value)
        override fun format(value: FixedBigRational) = "$value 10¢"
    }
}

val FixedBigRational.dimes get() = Dimes.new(this)
val Long.dimes get() = (this over 1).dimes
val Int.dimes get() = (this over 1).dimes

class Nickel private constructor(value: FixedBigRational) :
    Measure<USD, Nickels>(Nickels, value) {

    companion object Nickels :
        USDDenominations<Nickels>("nickel", (1 over 20)) {
        override fun new(value: FixedBigRational) = Nickel(value)
        override fun format(value: FixedBigRational) = "$value 5¢"
    }
}

val FixedBigRational.nickels get() = Nickels.new(this)
val Long.nickels get() = (this over 1).nickels
val Int.nickels get() = (this over 1).nickels

class Penny private constructor(value: FixedBigRational) :
    Measure<USD, Pennies>(Pennies, value) {

    companion object Pennies :
        USDDenominations<Pennies>("penny", (1 over 100)) {
        override fun new(value: FixedBigRational) = Penny(value)
        override fun format(value: FixedBigRational) = "$value 1¢"
    }
}

val FixedBigRational.pennies get() = Pennies.new(this)
val Long.pennies get() = (this over 1).pennies
val Int.pennies get() = (this over 1).pennies
