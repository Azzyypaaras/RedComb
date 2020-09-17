package net.azzy.redcomb.brood

import kotlin.math.pow

data class RealBrood(val value: Double) : RawBrood<Double>(value, BroodType.REAL) {

    override fun primAdd(value: RawBrood<*>): RealBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return RealBrood((this.value + value.wrappedValue as Double))
        else throw ArithmeticException()
    }

    override fun primMultiply(value: RawBrood<*>): RealBrood {
        if (value is IntBrood || value is RealBrood)
            return RealBrood((this.value * value.wrappedValue as Double))
        else throw ArithmeticException()
    }

    override fun primDivide(value: RawBrood<*>): RealBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return RealBrood((this.value / value.wrappedValue as Double))
        else throw ArithmeticException()
    }

    override fun primPow(value: RawBrood<*>): RealBrood {
        if (value is IntBrood || value is RealBrood || value is ByteBrood)
            return RealBrood(this.value.toDouble().pow(value.wrappedValue as Double))
        else throw ArithmeticException()
    }
}