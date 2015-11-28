package com.mattdahepic.mobdropores.config;

import com.mattdahepic.mobdropores.block.EnumMob;
import net.minecraftforge.common.config.Configuration;

public class Config extends com.mattdahepic.mdecore.config.Config {
    public static ConfigSectionMobOre zombie = new ConfigSectionMobOre(EnumMob.ZOMBIE.getName(),6,16,0,64);
    public static ConfigSectionMobOre blaze = new ConfigSectionMobOre(EnumMob.BLAZE.getName(),4,2,0,128);
    public static ConfigSectionMobOre creeper = new ConfigSectionMobOre(EnumMob.CREEPER.getName(),5,8,0,64);
    public static ConfigSectionMobOre enderman = new ConfigSectionMobOre(EnumMob.ENDERMAN.getName(),3,4,0,75);
    public static ConfigSectionMobOre ghast = new ConfigSectionMobOre(EnumMob.GHAST.getName(),3,3,0,128);
    public static ConfigSectionMobOre guardian = new ConfigSectionMobOre(EnumMob.GUARDIAN.getName(),4,3,0,64);
    public static ConfigSectionMobOre skeleton = new ConfigSectionMobOre(EnumMob.SKELETON.getName(),6,6,0,64);
    public static ConfigSectionMobOre slime = new ConfigSectionMobOre(EnumMob.SLIME.getName(),4,6,16,24);
    public static ConfigSectionMobOre spider = new ConfigSectionMobOre(EnumMob.SPIDER.getName(),5,4,0,64);
    public static ConfigSectionMobOre witch = new ConfigSectionMobOre(EnumMob.WITCH.getName(),3,5,0,64);
    public static ConfigSectionMobOre wither = new ConfigSectionMobOre(EnumMob.WITHER.getName(),1,1,0,10);
    public static ConfigSectionMobOre wither_skeleton = new ConfigSectionMobOre(EnumMob.WITHER_SKELETON.getName(),1,2,0,32);
    @Override
    public void processConfig (Configuration c) {
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
