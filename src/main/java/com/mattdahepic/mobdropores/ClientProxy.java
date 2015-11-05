package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers () {
        MobDropOres.logger.info("Registering Textures");
        Item mob_ore = Item.getItemFromBlock(MobDropOres.mob_ore);
        String name_prefix = "mob_ore_";
        String modifier_prefix = "mob=";
        for (EnumMob mob : EnumMob.values()) {
            reg(mob_ore,MobUtils.metaFromMob(mob),MobDropOres.MODID,name_prefix+mob.getName(),modifier_prefix+mob.getName());
        }
    }
    public void reg (Item item,int meta,String modid,String texture_name,String modifier) {
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(modid+":"+texture_name,"inventory"));
        ModelLoader.addVariantName(item,modid+":"+texture_name);
    }
}
