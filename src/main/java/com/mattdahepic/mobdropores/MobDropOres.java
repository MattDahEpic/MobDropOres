package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.blocks.ores.*;
import com.mattdahepic.mobdropores.config.Config;
import com.mattdahepic.mobdropores.utils.LogHelper;
import com.mattdahepic.mobdropores.world.MobDropOresGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = MobDropOres.MODID,name = MobDropOres.NAME,version = MobDropOres.VERSION)
public class MobDropOres {
    @Mod.Instance("mobdropores")
    public static MobDropOres instance;

    public static final String MODID = "mobdropores";
    public static final String NAME = "Mob Drop Ores";
    public static final String VERSION = "mc1.7.10-v1.1";

    @SidedProxy(clientSide = "com.mattdahepic.mobdropores.client.ClientProxy",serverSide = "com.mattdahepic.mobdropores.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration configFile;

    //blocks
    public static Block oreRottenFlesh = new OreRottenFlesh();
    public static Block oreGunpowder = new OreGunpowder();
    public static Block oreEnderpearl = new OreEnderpearl();
    public static Block oreBlazeRod = new OreBlazeRod();
    public static Block oreString = new OreString();
    public static Block oreSpiderEye = new OreSpiderEye();
    public static Block oreGhastTear = new OreGhastTear();
    public static Block oreArrow = new OreArrow();
    public static Block oreBone = new OreBone();
    public static Block oreSlimeball = new OreSlimeball();
    public static Block oreNetherStar = new OreNetherStar();
    //items

    @Mod.EventHandler
    public static void preInit (FMLPreInitializationEvent event) {
        Config.load(event);
    }
    @Mod.EventHandler
    public static void init (FMLInitializationEvent event) {
        //proxy.registerRenderers();
        proxy.registerBlocksItems();
        proxy.registerOreDict();
        GameRegistry.registerWorldGenerator(new MobDropOresGenerator(),0);
    }
    @Mod.EventHandler
    public static void postInit (FMLPostInitializationEvent event) {
        LogHelper.info("Ready to supplement your killing sprees!");
    }
}
