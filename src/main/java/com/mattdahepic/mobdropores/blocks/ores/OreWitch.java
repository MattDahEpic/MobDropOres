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

public class OreWitch extends MobOre {
    public static final String NAME = "oreWitch";
    public OreWitch () {
        super(2);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float bottleChance = rand.nextFloat();
        float glowstoneChance = rand.nextFloat();
        float gunpowderChance = rand.nextFloat();
        float redstoneChance = rand.nextFloat();
        float spiderEyeChance = rand.nextFloat();
        float sugarChance = rand.nextFloat();
        float stickChance = rand.nextFloat();
        if (bottleChance < Config.bottleChance) {
            ret.add(new ItemStack(Items.glass_bottle,super.getAmountDrops(rand,Config.maxBottleBase,Config.maxBottleBonus,fortune)));
        }
        if (glowstoneChance < Config.glowstoneChance) {
            ret.add(new ItemStack(Items.glowstone_dust,super.getAmountDrops(rand,Config.maxGlowstoneBase,Config.maxGlowstoneBonus,fortune)));
        }
        if (gunpowderChance < Config.gunpowderChanceWitch) {
            ret.add(new ItemStack(Items.gunpowder,super.getAmountDrops(rand,Config.maxGunpowderBaseWitch,Config.maxGunpowderBonusWitch,fortune)));
        }
        if (redstoneChance < Config.redstoneChance) {
            ret.add(new ItemStack(Items.redstone,super.getAmountDrops(rand,Config.maxRedstoneBase,Config.maxRadstoneBonus,fortune)));
        }
        if (spiderEyeChance < Config.spiderEyeChanceWitch) {
            ret.add(new ItemStack(Items.spider_eye,super.getAmountDrops(rand,Config.maxSpiderEyeBaseWitch,Config.maxSpiderEyeBonusWitch,fortune)));
        }
        if (sugarChance < Config.sugarChance) {
            ret.add(new ItemStack(Items.sugar,super.getAmountDrops(rand,Config.maxSugarBase,Config.maxSugarBonus,fortune)));
        }
        if (stickChance < Config.stickChance) {
            ret.add(new ItemStack(Items.stick,super.getAmountDrops(rand,Config.maxStickBase,Config.maxStickBonus,fortune)));
        }
        return ret;
    }
}
