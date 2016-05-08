package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.BlockMobOre;
import com.mattdahepic.mobdropores.block.ItemBlockMobOre;
import com.mattdahepic.mobdropores.config.MDOConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = MobDropOres.NAME,modid = MobDropOres.MODID,version = MobDropOres.VERSION,dependencies = MobDropOres.DEPENDENCIES,updateJSON = MobDropOres.UPDATE_JSON)
public class MobDropOres {
    static final String NAME = "Mob Drop Ores";
    static final String VERSION = "@VERSION@";
    public static final String MODID = "mobdropores";
    static final String DEPENDENCIES = "required-after:mdecore@[1.9-1.0.2,);";
    static final String UPDATE_JSON = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+MODID+".json";

    public static Block mob_ore = new BlockMobOre();
    public static Item item_mob_ore = new ItemBlockMobOre(mob_ore);

    @SidedProxy(serverSide = "com.mattdahepic.mobdropores.ClientProxy",clientSide = "com.mattdahepic.mobdropores.CommonProxy")
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
