package net.azzy.redcomb.internal

import net.azzy.redcomb.RedComb
import net.azzy.redcomb.RedComb.Companion.REDLOG
import net.azzy.redcomb.brood.RawBrood
import net.azzy.redcomb.struct.RedClass
import java.util.*

class Propolis(private val lexer: Ampoule) {

    private val preProcessStack = Stack<RawBrood<*>>()
    private val processStack = Stack<RawBrood<*>>()

    infix fun read(clazz: RedClass){
        lexer parse clazz.code.trim().split(10.toChar())
        preProcessStack.addAll(lexer.broodQueue)
        for(brood in preProcessStack)
            REDLOG.error(brood)
    }

    fun process() {
    }
}