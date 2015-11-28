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

public class OreSlime extends MobOre {
    public static final String NAME = "oreSlime";
    public OreSlime () {
        super(1);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float slimeBallChance = rand.nextFloat();
        if (slimeBallChance < Config.slimeBallChance) {
            ret.add(new ItemStack(Items.slime_ball,super.getAmountDrops(rand,Config.maxSlimeBallBase,Config.maxSlimeBallBonus,fortune)));
        }
        return ret;
    }
}
