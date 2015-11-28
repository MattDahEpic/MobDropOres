package com.mattdahepic.mobdropores.world;

import com.google.common.base.Predicate;
import com.mattdahepic.mobdropores.config.Config;
import com.mattdahepic.mobdropores.config.OreGenConfigOption;
import com.mattdahepic.mobdropores.utils.LogHelper;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MobDropOresGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random,int chunkX, int chunkZ,World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimension = world.provider.getDimensionId();
        int x = 16*chunkX;
        int z = 16*chunkZ;

        switch (dimension) {
            case -1: //nether
                generateNether(world,random,x,z);
            case 0: //overworld
                generateSurface(world,random,x,z);
            case 1: //end
                generateEnd(world,random,x,z);
            default: //not a vanilla dimension
                generateSurface(world,random,x,z);
        }
    }
    private void generateSurface(World world,Random random,int posX, int posZ) {
        //LogHelper.info("Generating \"overworld\" ores...");
        generateOre(Config.skeleton,world,random,posX,posZ);
        generateOre(Config.spider,world,random,posX,posZ);
        generateOre(Config.guardian,world,random,posX,posZ);
        generateOre(Config.zombie,world,random,posX,posZ);
        generateOre(Config.creeper,world,random,posX,posZ);
        generateOre(Config.enderman,world,random,posX,posZ);
        generateOre(Config.slime,world,random,posX,posZ);
        generateOre(Config.wither,world,random,posX,posZ);
        generateOre(Config.witch,world,random,posX,posZ);
    }
    private void generateNether(World world,Random random,int posX,int posZ) {
        //LogHelper.info("Generating nether ores...");
        Predicate base = BlockHelper.forBlock(Blocks.netherrack);
        generateOre(Config.blaze,world,random,posX,posZ,base);
        generateOre(Config.ghast,world,random,posX,posZ,base);
    }
    private void generateEnd(World world,Random random,int posX,int posZ) {
        //LogHelper.info("Generating end ores...");
        Predicate base = BlockHelper.forBlock(Blocks.end_stone);
    }
    public void generateOre (OreGenConfigOption ore,World world, Random random,int posX,int posZ) {
        generateOre(ore,world,random,posX,posZ,null);
    }
    public void generateOre (OreGenConfigOption ore,World world, Random random,int posX,int posZ, Predicate base) {
        if (ore.enabled) {
            for (int i = 0; i < ore.veinAmount; i++) {
                if (random.nextInt(ore.rarity) == 0) {
                    int x = posX + random.nextInt(16);
                    int y = ore.minY + random.nextInt(ore.maxY - ore.minY + 1);
                    int z = posZ + random.nextInt(16);
                    BlockPos pos = new BlockPos(x, y, z);
                    if (base == null) {
                        new WorldGenMinable(ore.block, ore.veinSize).generate(world, random, pos);
                    } else {
                        new WorldGenMinable(ore.block, ore.veinSize, base).generate(world, random, pos);
                    }
                    if (Config.superCheatyDebugLogs) {
                        LogHelper.info("Generating a(n) " + ore.block.getBlock().getLocalizedName() + " at the position " + x + "," + y + "," + z + " in the dimension " + world.provider.getDimensionId() + ".");
                    }
                }
            }
        }
    }
}
