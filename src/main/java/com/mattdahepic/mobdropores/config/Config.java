package com.mattdahepic.mobdropores.config;

import com.mattdahepic.mobdropores.MobDropOres;
import com.mattdahepic.mobdropores.utils.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {
    //defaults
    public static float netherStarChance = 0.01F;
    public static boolean superCheatyDebugLogs = false;
    public static int maximumDropsNoFortune = 3;
    public static int maximumDropsPerFortuneLevel = 2;
    public static boolean multipleDropsEnabled = true;

    public static OreGenConfigOption arrow = new OreGenConfigOption(MobDropOres.oreArrow);
    public static OreGenConfigOption blazeRod = new OreGenConfigOption(MobDropOres.oreBlazeRod);
    public static OreGenConfigOption bone = new OreGenConfigOption(MobDropOres.oreBone);
    public static OreGenConfigOption enderpearl = new OreGenConfigOption(MobDropOres.oreEnderpearl);
    public static OreGenConfigOption ghastTear = new OreGenConfigOption(MobDropOres.oreGhastTear);
    public static OreGenConfigOption gunpowder = new OreGenConfigOption(MobDropOres.oreGunpowder);
    public static OreGenConfigOption netherStar = new OreGenConfigOption(MobDropOres.oreNetherStar);
    public static OreGenConfigOption rottenFlesh = new OreGenConfigOption(MobDropOres.oreRottenFlesh);
    public static OreGenConfigOption slimeball = new OreGenConfigOption(MobDropOres.oreSlimeball);
    public static OreGenConfigOption spiderEye = new OreGenConfigOption(MobDropOres.oreSpiderEye);
    public static OreGenConfigOption string = new OreGenConfigOption(MobDropOres.oreString);

    public static void load (FMLPreInitializationEvent event) {
        MobDropOres.configFile = new Configuration(event.getSuggestedConfigurationFile());
        syncConfig();
    }
    public static void syncConfig () {
        try {
            Config.processConfig(MobDropOres.configFile);
        } catch (Exception e) {
            LogHelper.error("Error loading config!");
        } finally {
            if (MobDropOres.configFile.hasChanged()) {
                MobDropOres.configFile.save();
            }
        }
    }
    @SubscribeEvent
    public void onConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(MobDropOres.MODID)) {
            LogHelper.info("Saving Config...");
            syncConfig();
        }
    }
    public static void processConfig (Configuration c) {
        superCheatyDebugLogs = c.getBoolean("superCheatyDebugLogs",Configuration.CATEGORY_GENERAL,superCheatyDebugLogs,"Enable logs that show where every ore is trying to be generated in the world? It's cheaty!");
        maximumDropsNoFortune = c.getInt("maximumDropsNoFortune",Configuration.CATEGORY_GENERAL,maximumDropsNoFortune,1,Integer.MAX_VALUE-1,"The maximum amount of drops that can be obtained from a single ore without Fortune on the pickaxe. Does not apply to nether star ore.");
        maximumDropsPerFortuneLevel = c.getInt("maximumDropsPerFortuneLevel",Configuration.CATEGORY_GENERAL,maximumDropsPerFortuneLevel,1,Integer.MAX_VALUE-1,"Each level of fortune on a pickaxe will have a chance to add up to this many drops to the amount of something dropped from an ore, added to the result selected from the maximum drops without fortune. Excludes Nether Star Ore.");
        multipleDropsEnabled = c.getBoolean("multipleDropsEnabled",Configuration.CATEGORY_GENERAL,multipleDropsEnabled,"Enable the ability to drop multiple drops from a single ore?");

        arrow.enabled = true;
        arrow.veinAmount = 2;
        arrow.veinSize = 5;
        arrow.minY = 0;
        arrow.maxY = 64;
        arrow.rarity = 1;
        arrow.loadValue(c,"arrow");

        blazeRod.enabled = true;
        blazeRod.veinAmount = 1;
        blazeRod.veinSize = 3;
        blazeRod.minY = 12;
        blazeRod.maxY = 64;
        blazeRod.rarity = 5;
        blazeRod.loadValue(c,"blazeRod");

        bone.enabled = true;
        bone.veinAmount = 2;
        bone.veinSize = 4;
        bone.minY = 20;
        bone.maxY = 128;
        bone.rarity = 2;
        bone.loadValue(c,"bone");

        enderpearl.enabled = true;
        enderpearl.veinAmount = 1;
        enderpearl.veinSize = 1;
        enderpearl.minY = 0;
        enderpearl.maxY = 16;
        enderpearl.rarity = 10;
        bone.loadValue(c,"enderpearl");

        ghastTear.enabled = true;
        ghastTear.veinAmount = 1;
        ghastTear.veinSize = 1;
        ghastTear.minY = 0;
        ghastTear.maxY = 128;
        ghastTear.rarity = 5;
        ghastTear.loadValue(c,"ghastTear");

        gunpowder.enabled = true;
        gunpowder.veinAmount = 2;
        gunpowder.veinSize = 4;
        gunpowder.minY = 0;
        gunpowder.maxY = 64;
        gunpowder.rarity = 3;
        gunpowder.loadValue(c,"gunpowder");

        netherStar.enabled = true;
        netherStar.veinAmount = 1;
        netherStar.veinSize = 1;
        netherStar.minY = 0;
        netherStar.maxY = 3;
        netherStar.rarity = 15;
        netherStar.loadValue(c,"netherStar");
        netherStarChance = c.getFloat("netherStarChance","netherStar",netherStarChance,0.0F,1.0F,"Chance out of 1.0 to get a nether star from nether star ore.");

        rottenFlesh.enabled = true;
        rottenFlesh.veinAmount = 5;
        rottenFlesh.veinSize = 10;
        rottenFlesh.minY = 0;
        rottenFlesh.maxY = 255;
        rottenFlesh.rarity = 1;
        rottenFlesh.loadValue(c,"rottenFlesh");

        slimeball.enabled = true;
        slimeball.veinAmount = 2;
        slimeball.veinSize = 3;
        slimeball.minY = 16;
        slimeball.maxY = 64;
        slimeball.rarity = 2;
        slimeball.loadValue(c,"slimeball");

        spiderEye.enabled = true;
        spiderEye.veinAmount = 1;
        spiderEye.veinSize = 2;
        spiderEye.minY = 12;
        spiderEye.maxY = 70;
        spiderEye.rarity = 2;
        spiderEye.loadValue(c,"spiderEye");

        string.enabled = true;
        string.veinAmount = 2;
        string.veinSize = 2;
        string.minY = 30;
        string.maxY = 64;
        string.rarity = 2;
        string.loadValue(c,"string");
    }
    private Config() {}
}
