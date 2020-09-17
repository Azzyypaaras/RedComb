package net.azzy.redcomb.brood

import kotlin.math.pow

data class IntBrood(val value: Long) : RawBrood<Long>(value, BroodType.INT) {

    override fun primAdd(value: RawBrood<*>): IntBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return IntBrood((this.value + value.wrappedValue as Double).toLong())
        else throw ArithmeticException()
    }

    override fun primMultiply(value: RawBrood<*>): IntBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return IntBrood((this.value * value.wrappedValue as Double).toLong())
        else throw ArithmeticException()
    }

    override fun primDivide(value: RawBrood<*>): IntBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return IntBrood((this.value / value.wrappedValue as Double).toLong())
        else throw ArithmeticException()
    }

    override fun primPow(value: RawBrood<*>): IntBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return IntBrood(this.value.toDouble().pow(value.wrappedValue as Double).toLong())
        else throw ArithmeticException()
    }
}