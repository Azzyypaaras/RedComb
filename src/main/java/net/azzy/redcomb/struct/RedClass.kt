package net.azzy.redcomb.struct

data class RedClass(val code: String, val metadata: ClassMetadata = ClassMetadata("NULL", "DEFAULT", -1)) {
    data class ClassMetadata(val author: String, val name: String, val uuid: Short)
}