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

public class OreEnderman extends MobOre {
    public static final String NAME = "oreEnderman";
    public OreEnderman () {
        super(2);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float pearlChance = rand.nextFloat();
        if (pearlChance < Config.pearlChance) {
            ret.add(new ItemStack(Items.ender_pearl,super.getAmountDrops(rand,Config.maxPearlBase,Config.maxPearlBonus,fortune)));
        }
        return ret;
    }
}
