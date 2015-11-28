package com.mattdahepic.mobdropores;

import com.mattdahepic.mdecore.update.UpdateChecker;
import com.mattdahepic.mobdropores.config.Config;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(name = MobDropOres.NAME,modid = MobDropOres.MODID,version = MobDropOres.VERSION,dependencies = MobDropOres.DEPENDENCIES)
public class MobDropOres {

    public static final String NAME = "Mob Drop Ores";
    public static final String VERSION = "@VERSION@";
    public static final String MODID = "mobdropores";
    public static final String DEPENDENCIES = "required-after:mdecore@[1.8.8-1.5,);";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+MinecraftForge.MC_VERSION+"/"+MODID+".txt";
    public static final String CLIENT_PROXY = "com.mattdahepic.mobdropores.ClientProxy";
    public static final String COMMON_PROXY = "com.mattdahepic.mobdropores.CommonProxy";

    public static final Logger logger = LogManager.getLogger(MODID);

    public static Block mob_ore;
    public static Item item_mob_ore;

    @Mod.Instance(MobDropOres.MODID)
    public static MobDropOres instance;

    @SidedProxy(serverSide = MobDropOres.COMMON_PROXY,clientSide = MobDropOres.CLIENT_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(instance);
        Config.load(MODID,e,new Config());
        proxy.registerBlocks();
        proxy.registerOreDict();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        proxy.registerWorldGen();
        UpdateChecker.checkRemote(MODID,UPDATE_URL);
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {}
    @SubscribeEvent
    public void onPlayerJoinServer (PlayerEvent.PlayerLoggedInEvent e) {
        UpdateChecker.printMessageToPlayer(MODID,e.player);
    }
}
