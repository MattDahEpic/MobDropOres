package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import com.mattdahepic.mobdropores.config.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreSpider extends MobOre {
    public static final String NAME = "oreSpider";
    public OreSpider () {
        super(1);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float stringChance = rand.nextFloat();
        float spiderEyeChance = rand.nextFloat();
        if (stringChance < Config.stringChance) {
            ret.add(new ItemStack(Items.string,super.getAmountDrops(rand,Config.maxStringBase,Config.maxStringBonus,fortune)));
        }
        if (spiderEyeChance < Config.spiderEyeChance) {
            ret.add(new ItemStack(Items.spider_eye,super.getAmountDrops(rand,Config.maxSpiderEyeBase,Config.maxSpiderEyeBonus,fortune)));
        }
        return ret;
    }
}
