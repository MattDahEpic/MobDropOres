package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers () {
        Item mob_ore = Item.getItemFromBlock(MobDropOres.mob_ore);
        String name_prefix = "mob_ore_";
        String modifier_prefix = "mob=";
        for (EnumMob mob : EnumMob.values()) {
            reg(mob_ore,MobUtils.metaFromMob(mob),MobDropOres.MODID,name_prefix+mob.getName(),modifier_prefix+mob.getName());
        }
    }
    private void reg (Item item,int meta,String modid,String texture_name,String modifier) {
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(modid+":"+texture_name,"inventory"));
        ModelLoader.registerItemVariants(item,new ResourceLocation(modid,texture_name));
    }
}
