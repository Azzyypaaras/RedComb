package net.azzy.redcomb.brood

class BreakBrood(val value: BreakType) : RawBrood<BreakBrood.BreakType>(value, BroodType.BREAK) {

    companion object{
        infix fun parseBreak(token: String) = breakRegistrar[token]?.let(::BreakBrood) ?: throw IllegalArgumentException("WHAT, HOW")

        val breakRegistrar = hashMapOf<String, BreakType>()

        init {
            for(op in BreakType.values())
                breakRegistrar[op.key] = op
            ""[0].isWhitespace()
        }
    }

    enum class BreakType(val key: String){
        END(";"),
        DFS("DFST"),
        DFN("DFND"),
        FNS("FNST"),
        FNN("FNND")
    }
}