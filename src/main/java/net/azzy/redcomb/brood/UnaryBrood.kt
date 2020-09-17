package net.azzy.redcomb.brood

import kotlin.IllegalArgumentException

data class UnaryBrood(val operator: UnaryOperator) : RawBrood<UnaryBrood.UnaryOperator>(operator, BroodType.UNIT) {

    companion object{
        infix fun parseUnary(token: String) = unaryRegistrar[token]?.let(::UnaryBrood) ?: throw IllegalArgumentException("WHAT, HOW")

        val unaryRegistrar = hashMapOf<String, UnaryOperator>()

        init {
            for(op in UnaryOperator.values())
                unaryRegistrar[op.key] = op
        }
    }

    enum class UnaryOperator(val key: String){
        ADD("+"),
        MUL("*"),
        DIV("/"),
        MOD("%"),
        ASS("="),
        POW("**"),
        AND("&&"),
        OOR("||"),
        XOR("!|"),
        SEQ("=="),
        HEQ("===")
    }
}