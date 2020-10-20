package com.mattdahepic.mobdropores.common;

import com.mattdahepic.mdecore.common.registries.BlockRegistry;
import com.mattdahepic.mdecore.common.registries.ConfigRegistry;
import com.mattdahepic.mobdropores.common.block.MobOreBlock;
import com.mattdahepic.mobdropores.common.config.MDOConfig;
import com.mattdahepic.mobdropores.common.data.DataGenerators;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.HashMap;

@Mod("mobdropores")
public class MobDropOres extends BlockRegistry {
    public static final String MODID = "mobdropores";
    public static HashMap<EnumMob,Block> mob_ores = new HashMap<>();

    public MobDropOres () {
        //config
        ConfigRegistry.registerConfig(null, MDOConfig.COMMON_SPEC);

        //mod bus events
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.register(this);
        modBus.addListener(DataGenerators::gatherData);

        //forge bus events
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(this::registerFeatures);
    }

    public void registerFeatures (BiomeLoadingEvent event) {
        for (EnumMob mob : EnumMob.values()) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(mob.fillerBlockType,mob_ores.get(mob).getDefaultState(),mob.veinSize.get())).func_242733_d(mob.maxHeight.get()).func_242731_b(mob.spawnChances.get()));
        }
    }

    //TODO make tags

    protected ItemGroup getGroup() { return ItemGroup.BUILDING_BLOCKS; }
    @SubscribeEvent
    public void register(RegistryEvent.Register<Block> register) {
        for (EnumMob mob : EnumMob.values()) {
            mob_ores.put(mob,registerBlock(new MobOreBlock(mob),mob.name+"_ore"));
        }
    }
}
