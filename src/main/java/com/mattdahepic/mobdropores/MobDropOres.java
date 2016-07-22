package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.config.MDOConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

@Mod(name = MobDropOres.NAME,modid = MobDropOres.MODID,version = MobDropOres.VERSION,dependencies = MobDropOres.DEPENDENCIES,updateJSON = MobDropOres.UPDATE_JSON)
public class MobDropOres {
    static final String NAME = "Mob Drop Ores";
    static final String VERSION = "@VERSION@";
    public static final String MODID = "mobdropores";
    static final String DEPENDENCIES = "required-after:mdecore@[1.9.4-1.0,);";
    static final String UPDATE_JSON = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+MODID+".json";

    public static List<Block> mob_ores = new ArrayList<Block>();
    public static List<Item> item_mob_ores = new ArrayList<Item>();

    @SidedProxy(serverSide = "com.mattdahepic.mobdropores.CommonProxy",clientSide = "com.mattdahepic.mobdropores.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        new MDOConfig().initalize(e);
        proxy.registerBlocks();
        proxy.registerOreDict();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerWorldGen();
    }
}
