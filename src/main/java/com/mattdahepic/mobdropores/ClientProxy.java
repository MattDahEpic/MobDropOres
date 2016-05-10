package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers () {
        Item mob_ore = Item.getItemFromBlock(MobDropOres.mob_ore);
        String modifier_prefix = "mob=";
        for (EnumMob mob : EnumMob.values()) {
            ModelLoader.setCustomModelResourceLocation(mob_ore,MobUtils.metaFromMob(mob),new ModelResourceLocation("mobdropores:mob_ore",modifier_prefix+mob.getName()));
        }
    }
}
