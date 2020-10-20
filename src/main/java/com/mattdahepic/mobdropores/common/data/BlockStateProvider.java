package com.mattdahepic.mobdropores.common.data;

import com.mattdahepic.mobdropores.common.EnumMob;
import com.mattdahepic.mobdropores.common.MobDropOres;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MobDropOres.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (EnumMob mob : EnumMob.values()) {
            simpleBlock(MobDropOres.mob_ores.get(mob),models().cubeAll(mob.name+"_ore",new ResourceLocation(MobDropOres.MODID, "block/"+mob.name)));
        }
    }
}
