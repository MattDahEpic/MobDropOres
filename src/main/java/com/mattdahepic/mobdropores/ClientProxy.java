package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers () {
        Item mob_ore = Item.getItemFromBlock(MobDropOres.mob_ore);
        String name_prefix = "mob_ore_";
        String modifier_prefix = "mob=";
        for (int i = 0; i < EnumMob.values().length; i++) {
            String mob_name = MobUtils.mobFromMeta(i).getName();
            reg(mob_ore,i,MobDropOres.MODID,name_prefix+mob_name,modifier_prefix+mob_name);
        }
    }
    public void reg (Item item,int meta,String modid,String texture_name,String modifier) {
        //ModelBakery.addVariantName(item,modid+":"+texture_name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,meta,new ModelResourceLocation(modid+":"+texture_name,modifier));
    }
}
