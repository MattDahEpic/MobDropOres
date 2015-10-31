package com.mattdahepic.mobdropores;

import com.mattdahepic.mdecore.update.UpdateChecker;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.logging.log4j.Logger;

@Mod(name = MobDropOres.NAME,modid = MobDropOres.MODID,version = MobDropOres.VERSION,dependencies = MobDropOres.DEPENDENCIES)
public class MobDropOres {

    public static final String NAME = "Mob Drop Ores";
    public static final String VERSION = "@VERSION@";
    public static final String MODID = "mobdropores";
    public static final String DEPENDENCIES = "required-after:mdecore@[1.8-1.3,);required-after:Forge@[1.8-11.14.3.1535,);";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+MinecraftForge.MC_VERSION+"/"+MODID+".txt";
    public static final String CLIENT_PROXY = "com.mattdahepic.mobdropores.ClientProxy";
    public static final String COMMON_PROXY = "com.mattdahepic.mobdropores.CommonProxy";

    public static Logger logger;

    public static Block mob_ore;
    public static Item item_mob_ore;

    @Mod.Instance(MobDropOres.MODID)
    public static MobDropOres instance;

    @SidedProxy(serverSide = MobDropOres.COMMON_PROXY,clientSide = MobDropOres.CLIENT_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        FMLCommonHandler.instance().bus().register(instance);
        proxy.registerBlocks();
        logger.info("Registering Blocks");
        proxy.registerOreDict();
        logger.info("Registering Ore Dictionary Entries");
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        proxy.registerRenderers();
        logger.info("Registering Textures (if on client)");
        proxy.registerWorldGen();
        logger.info("Registering World Generator");
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {}
    @Mod.EventHandler
    public static void loadComplete (FMLLoadCompleteEvent e) {
        UpdateChecker.updateCheck(MODID, NAME, UPDATE_URL, VERSION, null);
    }
    @SubscribeEvent
    public void onPlayerJoinServer (PlayerEvent.PlayerLoggedInEvent e) {
        UpdateChecker.updateCheck(MODID, NAME, UPDATE_URL, VERSION, e.player);
    }
}
