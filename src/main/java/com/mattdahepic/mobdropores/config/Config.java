package com.mattdahepic.mobdropores.config;

import com.mattdahepic.mobdropores.MobDropOres;
import com.mattdahepic.mobdropores.block.EnumMob;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
    public static ConfigSectionMobOre zombie;
    public static ConfigSectionMobOre blaze;
    public static ConfigSectionMobOre creeper;
    public static ConfigSectionMobOre enderman;
    public static ConfigSectionMobOre ghast;
    public static ConfigSectionMobOre guardian;
    public static ConfigSectionMobOre skeleton;
    public static ConfigSectionMobOre slime;
    public static ConfigSectionMobOre spider;
    public static ConfigSectionMobOre witch;
    public static ConfigSectionMobOre wither;
    public static ConfigSectionMobOre wither_skeleton;
    public static void load (FMLPreInitializationEvent event) {
        MobDropOres.configFile = new Configuration(event.getSuggestedConfigurationFile());
        zombie = new ConfigSectionMobOre(EnumMob.ZOMBIE.getName(),6,16,0,64);
        blaze = new ConfigSectionMobOre(EnumMob.BLAZE.getName(),4,2,0,128);
        creeper = new ConfigSectionMobOre(EnumMob.CREEPER.getName(),5,8,0,64);
        enderman = new ConfigSectionMobOre(EnumMob.ENDERMAN.getName(),3,4,0,75);
        ghast = new ConfigSectionMobOre(EnumMob.GHAST.getName(),3,3,0,128);
        guardian = new ConfigSectionMobOre(EnumMob.GUARDIAN.getName(),4,3,0,64);
        skeleton = new ConfigSectionMobOre(EnumMob.SKELETON.getName(),6,6,0,64);
        slime = new ConfigSectionMobOre(EnumMob.SLIME.getName(),4,6,16,24);
        spider = new ConfigSectionMobOre(EnumMob.SPIDER.getName(),5,4,0,64);
        witch = new ConfigSectionMobOre(EnumMob.WITCH.getName(),3,5,0,64);
        wither = new ConfigSectionMobOre(EnumMob.WITHER.getName(),1,1,0,10);
        wither_skeleton = new ConfigSectionMobOre(EnumMob.WITHER_SKELETON.getName(),1,2,0,32);
        syncConfig(MobDropOres.configFile);
    }
    public static void syncConfig (Configuration config) {
        try {
            Config.processConfig(config);
        } catch (Exception e) {
            MobDropOres.logger.error("Error loading config!");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
    public static void processConfig (Configuration c) {
        zombie.load(c);
        blaze.load(c);
        creeper.load(c);
        enderman.load(c);
        ghast.load(c);
        guardian.load(c);
        skeleton.load(c);
        slime.load(c);
        spider.load(c);
        witch.load(c);
        wither.load(c);
        wither_skeleton.load(c);
    }
}
