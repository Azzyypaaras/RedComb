package net.azzy.redcomb.brood

import java.lang.Math.pow
import kotlin.math.pow

data class ByteBrood(val value: Byte) : RawBrood<Byte>(value, BroodType.BYTE) {

    override fun primAdd(value: RawBrood<*>): ByteBrood {
        if (value is ByteBrood || value is IntBrood || value is RealBrood)
            return ByteBrood((this.value + value.wrappedValue as Double).toInt().toByte())
        else throw ArithmeticException()
    }

    override fun primMultiply(value: RawBrood<*>): ByteBrood {
        if (value is ByteBrood || value is IntBrood || value is RealBrood)
            return ByteBrood((this.value * value.wrappedValue as Double).toInt().toByte())
        else throw ArithmeticException()
    }

    override fun primDivide(value: RawBrood<*>): ByteBrood {
        if (value is ByteBrood || value is IntBrood || value is RealBrood)
            return ByteBrood((this.value * value.wrappedValue as Double).toInt().toByte())
        else throw ArithmeticException()
    }

    override fun primPow(value: RawBrood<*>): ByteBrood {
        if (value is ByteBrood || value is IntBrood || value is RealBrood)
            return ByteBrood(this.value.toDouble().pow(value.wrappedValue as Double).toInt().toByte())
        else throw ArithmeticException()
    }
}