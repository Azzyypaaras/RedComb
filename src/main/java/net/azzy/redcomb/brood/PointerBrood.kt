package net.azzy.redcomb.brood

data class PointerBrood(val pointerType: Byte, private val value: Int) : RawBrood<Int>(value, BroodType.POINTER) {

}