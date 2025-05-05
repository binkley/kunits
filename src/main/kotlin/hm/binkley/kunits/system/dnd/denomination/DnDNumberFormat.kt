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
        toAppendTo: StringBuffer,
        pos: FieldPosition
    ): StringBuffer {
        val coins =
            number.copper into GoldPieces into listOf(
                GoldPieces,
                SilverPieces,
                CopperPieces
            )
        val gp = coins[0]
        val sp = coins[1]
        val cp = coins[2]
        val buffer = toAppendTo // ?: StringBuffer() -- TODO: is this possible?

        when (style) {
            SHORT -> {
                if (gp.quantity.isZero()) {
                    buffer.append("-/")
                } else {
                    buffer.append(
                        "${gp.quantity}/"
                    )
                }
                if (sp.quantity.isZero()) {
                    buffer.append("-/")
                } else {
                    buffer.append(
                        "${sp.quantity}/"
                    )
                }
                if (cp.quantity.isZero()) {
                    buffer.append('-')
                } else {
                    buffer.append(
                        "${cp.quantity}"
                    )
                }
            }

            LONG -> {
                val longCoinage = mutableListOf<String>()
                if (!gp.quantity.isZero()) longCoinage.add("$gp")
                if (!sp.quantity.isZero()) longCoinage.add("$sp")
                if (!cp.quantity.isZero()) longCoinage.add("$cp")
                if (longCoinage.isEmpty()) {
                    buffer.append("0 cp")
                } else {
                    longCoinage.joinTo(
                        buffer,
                        separator = " "
                    )
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
