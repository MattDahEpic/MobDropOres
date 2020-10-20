package com.mattdahepic.mobdropores.common.data;

import com.mattdahepic.mobdropores.common.EnumMob;
import com.mattdahepic.mobdropores.common.MobDropOres;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MobDropOres.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (EnumMob mob : EnumMob.values()) {
            withExistingParent(mob.name+"_ore", new ResourceLocation(MobDropOres.MODID,"block/"+mob.name+"_ore"));
        }
    }
}
