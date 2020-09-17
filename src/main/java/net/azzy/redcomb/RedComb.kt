package net.azzy.redcomb

import net.fabricmc.api.ModInitializer
import net.azzy.redcomb.internal.Ampoule
import net.azzy.redcomb.internal.Propolis
import net.azzy.redcomb.struct.RedClass
import org.apache.logging.log4j.LogManager

class RedComb : ModInitializer {

    override fun onInitialize() {
        val compiler = Propolis(Ampoule())
        compiler read RedClass(
                """
                "get a load of this guy"
                "haha funni"DFND "uwu owo"
                3 + 3
                1 * 1
                """
        )
    }

    companion object {
        val REDLOG = LogManager.getLogger("Redcomb - Lang")
    }
}