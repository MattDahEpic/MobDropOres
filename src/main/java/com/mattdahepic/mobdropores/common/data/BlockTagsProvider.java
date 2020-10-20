package com.mattdahepic.mobdropores.common.data;

import com.mattdahepic.mdecore.common.helpers.TagsHelper;
import com.mattdahepic.mobdropores.common.EnumMob;
import com.mattdahepic.mobdropores.common.MobDropOres;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagsProvider extends net.minecraft.data.BlockTagsProvider {
    public BlockTagsProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, MobDropOres.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        for (EnumMob mob : EnumMob.values()) {
            getOrCreateBuilder(TagsHelper.Block.forgeTag("ores/"+mob.name)).add(MobDropOres.mob_ores.get(mob));
        }
    }
}
