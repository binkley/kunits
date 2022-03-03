package hm.binkley.kunits.system.usd.denomination

import hm.binkley.kunits.Denomination
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
sealed class USDDenomination<U : USDDenomination<U>>(
    name: String,
    dollars: FixedBigRational,
) : Denomination<USD, U>(USD, name, dollars)

/** Formats USD money following US locale rules.  Example: "$4.33". */
fun Measure<USD, *>.format(): String = NumberFormat.getCurrencyInstance(US)
    .format((this into Dollars).value.toBigDecimal())

class HundredDollar private constructor(value: FixedBigRational) :
    Measure<USD, HundredDollars>(HundredDollars, value) {

    companion object HundredDollars :
        USDDenomination<HundredDollars>("hundred dollar bill", (100 over 1)) {
        override fun new(value: FixedBigRational) = HundredDollar(value)
        override fun format(value: FixedBigRational) = "$value \$100"
    }
}

val Int.hundredDollars get() = (this over 1).hundredDollars
val Long.hundredDollars get() = (this over 1).hundredDollars
val FixedBigRational.hundredDollars get() = HundredDollars.new(this)

class FiftyDollar private constructor(value: FixedBigRational) :
    Measure<USD, FiftyDollars>(FiftyDollars, value) {

    companion object FiftyDollars :
        USDDenomination<FiftyDollars>("fifty dollar bill", (50 over 1)) {
        override fun new(value: FixedBigRational) = FiftyDollar(value)
        override fun format(value: FixedBigRational) = "$value \$50"
    }
}

val Int.fiftyDollars get() = (this over 1).fiftyDollars
val Long.fiftyDollars get() = (this over 1).fiftyDollars
val FixedBigRational.fiftyDollars get() = FiftyDollars.new(this)

class TwentyDollar private constructor(value: FixedBigRational) :
    Measure<USD, TwentyDollars>(TwentyDollars, value) {

    companion object TwentyDollars :
        USDDenomination<TwentyDollars>("twenty dollar bill", (20 over 1)) {
        override fun new(value: FixedBigRational) = TwentyDollar(value)
        override fun format(value: FixedBigRational) = "$value \$20"
    }
}

val Int.twentyDollars get() = (this over 1).twentyDollars
val Long.twentyDollars get() = (this over 1).twentyDollars
val FixedBigRational.twentyDollars get() = TwentyDollars.new(this)

class TenDollar private constructor(value: FixedBigRational) :
    Measure<USD, TenDollars>(TenDollars, value) {

    companion object TenDollars :
        USDDenomination<TenDollars>("ten dollar bill", TEN) {
        override fun new(value: FixedBigRational) = TenDollar(value)
        override fun format(value: FixedBigRational) = "$value \$10"
    }
}

val Int.tenDollars get() = (this over 1).tenDollars
val Long.tenDollars get() = (this over 1).tenDollars
val FixedBigRational.tenDollars get() = TenDollars.new(this)

class FiveDollar private constructor(value: FixedBigRational) :
    Measure<USD, FiveDollars>(FiveDollars, value) {

    companion object FiveDollars :
        USDDenomination<FiveDollars>("five dollar bill", (5 over 1)) {
        override fun new(value: FixedBigRational) = FiveDollar(value)
        override fun format(value: FixedBigRational) = "$value \$5"
    }
}

val Int.fiveDollars get() = (this over 1).fiveDollars
val Long.fiveDollars get() = (this over 1).fiveDollars
val FixedBigRational.fiveDollars get() = FiveDollars.new(this)

class TwoDollar private constructor(value: FixedBigRational) :
    Measure<USD, TwoDollars>(TwoDollars, value) {

    companion object TwoDollars :
        USDDenomination<TwoDollars>("two dollar bill", TWO) {
        override fun new(value: FixedBigRational) = TwoDollar(value)
        override fun format(value: FixedBigRational) = "$value \$2"
    }
}

val Int.twoDollars get() = (this over 1).twoDollars
val Long.twoDollars get() = (this over 1).twoDollars
val FixedBigRational.twoDollars get() = TwoDollars.new(this)

class Dollar private constructor(value: FixedBigRational) :
    Measure<USD, Dollars>(Dollars, value) {

    companion object Dollars : USDDenomination<Dollars>("dollar bill", ONE) {
        override fun new(value: FixedBigRational) = Dollar(value)
        override fun format(value: FixedBigRational) = "$value \$1"
    }
}

val Int.dollars get() = (this over 1).dollars
val Long.dollars get() = (this over 1).dollars
val FixedBigRational.dollars get() = Dollars.new(this)

class DollarCoin private constructor(value: FixedBigRational) :
    Measure<USD, DollarCoins>(DollarCoins, value) {

    companion object DollarCoins :
        USDDenomination<DollarCoins>("dollar coin", ONE) {
        override fun new(value: FixedBigRational) = DollarCoin(value)
        override fun format(value: FixedBigRational) = "$value 100¢"
    }
}

val Int.dollarCoins get() = (this over 1).dollarCoins
val Long.dollarCoins get() = (this over 1).dollarCoins
val FixedBigRational.dollarCoins get() = DollarCoins.new(this)

class HalfDollar private constructor(value: FixedBigRational) :
    Measure<USD, HalfDollars>(HalfDollars, value) {

    companion object HalfDollars :
        USDDenomination<HalfDollars>("half dollar", (1 over 2)) {
        override fun new(value: FixedBigRational) = HalfDollar(value)
        override fun format(value: FixedBigRational) = "$value 50¢"
    }
}

val Int.halfDollars get() = (this over 1).halfDollars
val Long.halfDollars get() = (this over 1).halfDollars
val FixedBigRational.halfDollars get() = HalfDollars.new(this)

class Quarter private constructor(value: FixedBigRational) :
    Measure<USD, Quarters>(Quarters, value) {

    companion object Quarters :
        USDDenomination<Quarters>("quarter", (1 over 4)) {
        override fun new(value: FixedBigRational) = Quarter(value)
        override fun format(value: FixedBigRational) = "$value 25¢"
    }
}

val Int.quarters get() = (this over 1).quarters
val Long.quarters get() = (this over 1).quarters
val FixedBigRational.quarters get() = Quarters.new(this)

class Dime private constructor(value: FixedBigRational) :
    Measure<USD, Dimes>(Dimes, value) {

    companion object Dimes : USDDenomination<Dimes>("dime", (1 over 10)) {
        override fun new(value: FixedBigRational) = Dime(value)
        override fun format(value: FixedBigRational) = "$value 10¢"
    }
}

val Int.dimes get() = (this over 1).dimes
val Long.dimes get() = (this over 1).dimes
val FixedBigRational.dimes get() = Dimes.new(this)

class Nickel private constructor(value: FixedBigRational) :
    Measure<USD, Nickels>(Nickels, value) {

    companion object Nickels :
        USDDenomination<Nickels>("nickel", (1 over 20)) {
        override fun new(value: FixedBigRational) = Nickel(value)
        override fun format(value: FixedBigRational) = "$value 5¢"
    }
}

val Int.nickels get() = (this over 1).nickels
val Long.nickels get() = (this over 1).nickels
val FixedBigRational.nickels get() = Nickels.new(this)

class Penny private constructor(value: FixedBigRational) :
    Measure<USD, Pennies>(Pennies, value) {

    companion object Pennies :
        USDDenomination<Pennies>("penny", (1 over 100)) {
        override fun new(value: FixedBigRational) = Penny(value)
        override fun format(value: FixedBigRational) = "$value 1¢"
    }
}

val Int.pennies get() = (this over 1).pennies
val Long.pennies get() = (this over 1).pennies
val FixedBigRational.pennies get() = Pennies.new(this)
