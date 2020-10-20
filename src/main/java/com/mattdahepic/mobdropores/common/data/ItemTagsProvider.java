package com.mattdahepic.mobdropores.common.data;

import com.mattdahepic.mdecore.common.helpers.TagsHelper;
import com.mattdahepic.mobdropores.common.EnumMob;
import com.mattdahepic.mobdropores.common.MobDropOres;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagsProvider extends net.minecraft.data.ItemTagsProvider {
    public ItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, MobDropOres.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        for (EnumMob mob : EnumMob.values()) {
            copy(TagsHelper.Block.forgeTag("ores/"+mob.name),TagsHelper.Item.forgeTag("ores/"+mob.name));
        }
    }
}
