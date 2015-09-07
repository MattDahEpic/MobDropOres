package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.BlockMobOre;
import com.mattdahepic.mobdropores.block.ItemBlockMobOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = MobDropOres.NAME,modid = MobDropOres.MODID,version = MobDropOres.VERSION,dependencies = MobDropOres.DEPENDENCIES)
public class MobDropOres {
    public static final String NAME = "Mob Drop Ores";
    public static final String VERSION = "@VERSION@";
    public static final String MODID = "mobdropores";
    public static final String DEPENDENCIES = "";
    public static final String UPDATE_URL = "";
    public static final String CLIENT_PROXY = "com.mattdahepic.mobdropores.ClientProxy";
    public static final String COMMON_PROXY = "com.mattdahepic.mobdropores.CommonProxy";

    public static Block mob_ore;
    public static Item item_mob_ore;

    @Mod.Instance(MobDropOres.MODID)
    public static MobDropOres instance;

    @SidedProxy(serverSide = MobDropOres.COMMON_PROXY,clientSide = MobDropOres.CLIENT_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        proxy.registerBlocks();
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {}
}
