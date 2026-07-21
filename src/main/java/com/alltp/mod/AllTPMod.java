package com.alltp.mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("alltp")
public class AllTPMod {

    private static final Logger LOGGER = LogManager.getLogger();

    public AllTPMod() {
        MinecraftForge.EVENT_BUS.register(new TPEventHandler());
        LOGGER.info("AllTP Mod loaded - everyone can now use /tp without OP!");
    }
}
