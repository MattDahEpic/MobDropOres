package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.BlockMobOre;
import com.mattdahepic.mobdropores.block.EnumMob;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers () {
        final String modifier_prefix = "mob=";
        for (EnumMob mob : EnumMob.values()) {
            Item block = Item.getItemFromBlock(mob.getBlock());
            ModelLoader.setCustomModelResourceLocation(block,mob.getMeta(),new ModelResourceLocation("mobdropores:mob_ore",modifier_prefix+mob.getName()));
            ModelLoader.setCustomStateMapper(mob.getBlock(), new StateMapperBase() {
                @Override
                protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                    return new ModelResourceLocation("mobdropores:mob_ore",modifier_prefix+((EnumMob)state.getValue(BlockMobOre.MOB)).getName());
                }
            });
        }
    }
}
