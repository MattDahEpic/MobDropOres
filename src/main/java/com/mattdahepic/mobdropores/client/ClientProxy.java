package com.mattdahepic.mobdropores.client;

import com.mattdahepic.mobdropores.CommonProxy;
import com.mattdahepic.mobdropores.MobDropOres;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        // This is for rendering entities and so forth later on
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreSkeleton),0,new ModelResourceLocation("mobdropores:oreSkeleton","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreSpider),0,new ModelResourceLocation("mobdropores:oreSpider","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreGuardian),0,new ModelResourceLocation("mobdropores:oreGuardian","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreZombie),0,new ModelResourceLocation("mobdropores:oreZombie","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreCreeper),0,new ModelResourceLocation("mobdropores:oreCreeper","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreEnderman),0,new ModelResourceLocation("mobdropores:oreEnderman","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreBlaze),0,new ModelResourceLocation("mobdropores:oreBlaze","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreSlime),0,new ModelResourceLocation("mobdropores:oreSlime","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreWither),0,new ModelResourceLocation("mobdropores:oreWither","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreGhast),0,new ModelResourceLocation("mobdropores:oreGhast","inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MobDropOres.oreWitch),0,new ModelResourceLocation("mobdropores:oreWitch","inventory"));
    }
}
