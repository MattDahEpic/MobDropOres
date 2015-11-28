package com.mattdahepic.mobdropores.utils;

import com.mattdahepic.mobdropores.MobDropOres;
import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class LogHelper {
    public static void info (String message) {
        FMLLog.log(MobDropOres.MODID,Level.INFO,message);
    }
    public static void warn (String message) {
        FMLLog.log(MobDropOres.MODID,Level.WARN,message);
    }
    public static void error (String message) {
        FMLLog.log(MobDropOres.MODID,Level.ERROR,message);
    }
}
