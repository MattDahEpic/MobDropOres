package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.blocks.ores.*;
import com.mattdahepic.mobdropores.config.Config;
import com.mattdahepic.mobdropores.utils.LogHelper;
import com.mattdahepic.mobdropores.world.MobDropOresGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MobDropOres.MODID,name = MobDropOres.NAME,version = MobDropOres.VERSION)
public class MobDropOres {
    @Mod.Instance("mobdropores")
    public static MobDropOres instance;

    public static final String MODID = "mobdropores";
    public static final String NAME = "Mob Drop Ores";
    public static final String VERSION = "mc1.8-v2.0";

    @SidedProxy(clientSide = "com.mattdahepic.mobdropores.client.ClientProxy",serverSide = "com.mattdahepic.mobdropores.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration configFile;

    //block
    public static Block oreSkeleton = new OreSkeleton();
    public static Block oreSpider = new OreSpider();
    public static Block oreGuardian = new OreGuardian();
    public static Block oreZombie = new OreZombie();
    public static Block oreCreeper = new OreCreeper();
    public static Block oreEnderman = new OreEnderman();
    public static Block oreBlaze = new OreBlaze();
    public static Block oreSlime = new OreSlime();
    public static Block oreWither = new OreWither();
    public static Block oreGhast = new OreGhast();
    public static Block oreWitch = new OreWitch();
    //item

    @Mod.EventHandler
    public static void preInit (FMLPreInitializationEvent event) {
        Config.load(event);
    }
    @Mod.EventHandler
    public static void init (FMLInitializationEvent event) {
        proxy.registerBlocksItems();
        proxy.registerOreDict();
        proxy.registerRenderers();
        GameRegistry.registerWorldGenerator(new MobDropOresGenerator(),0);
    }
    @Mod.EventHandler
    public static void postInit (FMLPostInitializationEvent event) {
        LogHelper.info("Ready to supplement your killing sprees!");
    }
}
