/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

// Quinzième and ilk
@file:Suppress(
    "ClassName",
    "NonAsciiCharacters",
    "ObjectPropertyName"
)

package hm.binkley.kunits.system.english.volume.wine

import hm.binkley.kunits.Measure
import hm.binkley.kunits.Units
import hm.binkley.kunits.Volume
import hm.binkley.kunits.system.english.English
import hm.binkley.kunits.system.english.volume.wine.Hogshead.Hogsheads
import hm.binkley.kunits.system.english.volume.wine.Pipe.Pipes
import hm.binkley.kunits.system.english.volume.wine.Puncheon.Puncheons
import hm.binkley.kunits.system.english.volume.wine.Rundlet.Rundlets
import hm.binkley.kunits.system.english.volume.wine.Tierce.Tierces
import hm.binkley.kunits.system.english.volume.wine.Tun.Tuns
import hm.binkley.kunits.system.english.volume.wine.WineBarrel.WineBarrels
import hm.binkley.math.fixed.FixedBigRational
import hm.binkley.math.fixed.FixedBigRational.Companion.ONE
import hm.binkley.math.fixed.over

sealed class EnglishVolumes<
    U : EnglishVolumes<U, M>,
    M : EnglishVolume<U, M>,
    >(
    name: String,
    seconds: FixedBigRational,
) : Units<Volume, English, U, M>(Volume, English, name, seconds)

sealed class EnglishVolume<
    U : EnglishVolumes<U, M>,
    M : EnglishVolume<U, M>,
    >(
    unit: U,
    quantity: FixedBigRational,
) : Measure<Volume, English, U, M>(unit, quantity)

class Tun private constructor(quantity: FixedBigRational) :
    EnglishVolume<Tuns, Tun>(Tuns, quantity) {
    companion object Tuns : EnglishVolumes<Tuns, Tun>(
        "tun",
        ONE
    ) {
        override fun new(quantity: FixedBigRational) = Tun(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity tuns"
    }
}

val FixedBigRational.tuns get() = Tuns.new(this)
val Long.tuns get() = (this over 1).tuns
val Int.tuns get() = (this over 1).tuns

class Pipe private constructor(quantity: FixedBigRational) :
    EnglishVolume<Pipes, Pipe>(Pipes, quantity) {
    companion object Pipes : EnglishVolumes<Pipes, Pipe>(
        "pipe",
        (1 over 2)
    ) {
        override fun new(quantity: FixedBigRational) = Pipe(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity pipes"
    }
}

val FixedBigRational.pipes get() = Pipes.new(this)
val Long.pipes get() = (this over 1).pipes
val Int.pipes get() = (this over 1).pipes

class Puncheon private constructor(quantity: FixedBigRational) :
    EnglishVolume<Puncheons, Puncheon>(Puncheons, quantity) {
    companion object Puncheons : EnglishVolumes<Puncheons, Puncheon>(
        "puncheon",
        (1 over 3)
    ) {
        override fun new(quantity: FixedBigRational) = Puncheon(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity puncheons"
    }
}

val FixedBigRational.puncheons get() = Puncheons.new(this)
val Long.puncheons get() = (this over 1).puncheons
val Int.puncheons get() = (this over 1).puncheons

class Hogshead private constructor(quantity: FixedBigRational) :
    EnglishVolume<Hogsheads, Hogshead>(Hogsheads, quantity) {
    companion object Hogsheads : EnglishVolumes<Hogsheads, Hogshead>(
        "hogshead",
        (1 over 4)
    ) {
        override fun new(quantity: FixedBigRational) = Hogshead(quantity)
        override fun format(quantity: FixedBigRational) =
            if (ONE == quantity) "$quantity hhd" else "$quantity hhds"
    }
}

val FixedBigRational.hogsheads get() = Hogsheads.new(this)
val Long.hogsheads get() = (this over 1).hogsheads
val Int.hogsheads get() = (this over 1).hogsheads

class Tierce private constructor(quantity: FixedBigRational) :
    EnglishVolume<Tierces, Tierce>(Tierces, quantity) {
    companion object Tierces : EnglishVolumes<Tierces, Tierce>(
        "tierce",
        (1 over 6)
    ) {
        override fun new(quantity: FixedBigRational) = Tierce(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity tierces"
    }
}

val FixedBigRational.tierces get() = Tierces.new(this)
val Long.tierces get() = (this over 1).tierces
val Int.tierces get() = (this over 1).tierces

class WineBarrel private constructor(quantity: FixedBigRational) :
    EnglishVolume<WineBarrels, WineBarrel>(WineBarrels, quantity) {
    companion object WineBarrels : EnglishVolumes<WineBarrels, WineBarrel>(
        "wine barrel",
        (1 over 8)
    ) {
        override fun new(quantity: FixedBigRational) = WineBarrel(quantity)
        override fun format(quantity: FixedBigRational) =
            "$quantity wine barrels"
    }
}

val FixedBigRational.wineBarrels get() = WineBarrels.new(this)
val Long.wineBarrels get() = (this over 1).wineBarrels
val Int.wineBarrels get() = (this over 1).wineBarrels

class Rundlet private constructor(quantity: FixedBigRational) :
    EnglishVolume<Rundlets, Rundlet>(Rundlets, quantity) {
    companion object Rundlets : EnglishVolumes<Rundlets, Rundlet>(
        "rundlet",
        (1 over 14)
    ) {
        override fun new(quantity: FixedBigRational) = Rundlet(quantity)
        override fun format(quantity: FixedBigRational) = "$quantity rundlets"
    }
}

val FixedBigRational.rundlets get() = Rundlets.new(this)
val Long.rundlets get() = (this over 1).rundlets
val Int.rundlets get() = (this over 1).rundlets
