package net.azzy.redcomb.internal

import com.sun.jdi.InvalidTypeException
import net.azzy.redcomb.RedComb.Companion.REDLOG
import net.azzy.redcomb.brood.*
import net.azzy.redcomb.brood.*
import java.util.*
import kotlin.collections.HashSet
import kotlin.concurrent.thread

class Ampoule {

    val broodQueue = Stack<RawBrood<*>>()
    lateinit var tokenHolder: List<String>

    infix fun parse(block: List<String>) {
        for(rawLine in block){
            var line = rawLine.trim()
            var 
            var unbakedBrood = ""
            for (i in line.indices){
                var token = line[i]
                if(token.isWhitespace()){
                    if(unbakedBrood.isNotEmpty()){
                        this bake unbakedBrood
                        unbakedBrood = ""
                        hold = false
                    }
                }
                else
                    unbakedBrood += token
            }
            if(unbakedBrood.isNotEmpty()){
                this bake unbakedBrood
            }
        }
    }

    infix fun bake(token: String) {

        fun bakeInt() = broodQueue.push(IntBrood(token.toLong()))
        fun bakeReal() = broodQueue.push(RealBrood(token.toDouble()))
        fun bakeByte() = broodQueue.push(ByteBrood(token.toByte()))
        fun bakePointer() = { ->
            tokenHolder = token.split("@")
            broodQueue.push(PointerBrood(tokenHolder[0].toByte(), tokenHolder[1].toInt()))
        }
        fun bakeUnary() = broodQueue.push(UnaryBrood.parseUnary(token))
        fun bakeString() = broodQueue.push(StringBrood(token.removePrefix("\"").removeSuffix("\"")))

            if (token[0].isDigit())
                with(token) {
                    when {
                        contains(".") -> bakeReal()
                        endsWith("b", true) -> bakeByte()
                        contains("@") -> bakePointer()
                        else -> bakeInt()
                    }
                }
            else
                with(token) {
                    when {
                        (startsWith("\"") && endsWith("\"")) -> bakeString()
                        isUnary(this) -> bakeUnary()
                        else -> throw InvalidTypeException("$token is not a valid brood!")
                    }
                }


    }

    fun isUnary(token: String) = UnaryBrood.unaryRegistrar.contains(token)

    //fun isBreak(token: String): Boolean {
    //}
}