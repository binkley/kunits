package hm.binkley.kunits.system.dnd.denomination

import hm.binkley.kunits.into
import hm.binkley.kunits.system.dnd.denomination.Copper.CopperPieces
import hm.binkley.kunits.system.dnd.denomination.DnDFormatStyle.LONG
import hm.binkley.kunits.system.dnd.denomination.DnDFormatStyle.SHORT
import hm.binkley.kunits.system.dnd.denomination.Gold.GoldPieces
import hm.binkley.kunits.system.dnd.denomination.Silver.SilverPieces
import hm.binkley.math.isZero
import java.text.FieldPosition
import java.text.NumberFormat
import java.text.ParsePosition

class DnDNumberFormat(val style: DnDFormatStyle = SHORT) : NumberFormat() {
    override fun format(
        number: Double,
        toAppendTo: StringBuffer,
        pos: FieldPosition
    ): StringBuffer = TODO("Not yet implemented")

    override fun format(
        number: Long,
        buffer: StringBuffer,
        pos: FieldPosition
    ): StringBuffer {
        val (gpCoins, spCoins, cpCoins) = number.copper into listOf(
            GoldPieces,
            SilverPieces,
            CopperPieces
        )
        val gp = gpCoins.quantity
        val sp = spCoins.quantity
        val cp = cpCoins.quantity

        when (style) {
            SHORT -> {
                if (gp.isZero()) buffer.append("-/") else buffer.append("$gp/")
                if (sp.isZero()) buffer.append("-/") else buffer.append("$sp/")
                if (cp.isZero()) buffer.append('-') else buffer.append("$cp")
            }

            LONG -> {
                val longCoinage = mutableListOf<String>()
                if (!gp.isZero()) longCoinage.add("$gpCoins")
                if (!sp.isZero()) longCoinage.add("$spCoins")
                if (!cp.isZero()) longCoinage.add("$cpCoins")
                if (longCoinage.isEmpty()) {
                    buffer.append("0 cp")
                } else {
                    longCoinage.joinTo(buffer, separator = " ")
                }
            }
        }

        return buffer
    }

    override fun parse(
        source: String?,
        parsePosition: ParsePosition?
    ): Number? = TODO("Not yet implemented")
}
