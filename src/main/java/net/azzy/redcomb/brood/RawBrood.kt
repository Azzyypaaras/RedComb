package net.azzy.redcomb.brood

open class RawBrood<T>(val wrappedValue: T, val type: BroodType) {

    open infix fun primAdd(value: RawBrood<*>): RawBrood<T> {
        return this
    }

    open infix fun primMultiply(value: RawBrood<*>): RawBrood<T> {
        return this
    }

    open infix fun primDivide(value: RawBrood<*>): RawBrood<T> {
        return this
    }

    open infix fun primPow(value: RawBrood<*>): RawBrood<T> {
        return this
    }

    open infix fun primCompare(value: Any?): Boolean {
        return this == value
    }
}

enum class BroodType(val heapPointer: Byte) {
    BREAK(-128),
    UNIT(0),
    POINTER(1),
    ARRAY(2),
    BYTE(3),
    INT(4),
    REAL(5),
    STRING(6),
    GLOBAL(127)
}