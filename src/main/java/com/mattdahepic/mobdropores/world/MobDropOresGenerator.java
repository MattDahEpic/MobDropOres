package com.mattdahepic.mobdropores.world;

import com.mattdahepic.mobdropores.config.Config;
import com.mattdahepic.mobdropores.config.OreGenConfigOption;
import com.mattdahepic.mobdropores.utils.LogHelper;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class MobDropOresGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random,int chunkX, int chunkZ,World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimension = world.provider.dimensionId;
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
        generateOre(Config.arrow,world,random,posX,posZ);
        generateOre(Config.bone,world,random,posX,posZ);
        generateOre(Config.enderpearl,world,random,posX,posZ);
        generateOre(Config.gunpowder,world,random,posX,posZ);
        generateOre(Config.netherStar,world,random,posX,posZ);
        generateOre(Config.rottenFlesh,world,random,posX,posZ);
        generateOre(Config.slimeball,world,random,posX,posZ);
        generateOre(Config.string,world,random,posX,posZ);
    }
    private void generateNether(World world,Random random,int posX,int posZ) {
        //LogHelper.info("Generating nether ores...");
        Block base = Blocks.netherrack;
        generateOre(Config.blazeRod,world,random,posX,posZ,base);
        generateOre(Config.ghastTear,world,random,posX,posZ,base);
    }
    private void generateEnd(World world,Random random,int posX,int posZ) {
        //LogHelper.info("Generating end ores...");
        Block base = Blocks.end_stone;
    }
    public void generateOre (OreGenConfigOption ore,World world, Random random,int posX,int posZ) {
        generateOre(ore,world,random,posX,posZ,null);
    }
    public void generateOre (OreGenConfigOption ore,World world, Random random,int posX,int posZ, Block base) {
        if (ore.enabled) {
            for (int i = 0; i < ore.veinAmount; i++) {
                if (random.nextInt(ore.rarity) == 0) {
                    int x = posX + random.nextInt(16);
                    int y = ore.minY + random.nextInt(ore.maxY - ore.minY + 1);
                    int z = posZ + random.nextInt(16);
                    if (base == null) {
                        new WorldGenMinable(ore.block, ore.veinSize).generate(world, random, x, y, z);
                    } else {
                        new WorldGenMinable(ore.block, ore.veinSize, base).generate(world, random, x, y, z);
                    }
                    if (Config.superCheatyDebugLogs) {
                        LogHelper.info("Generating a(n) " + ore.block.getLocalizedName() + " at the position " + x + "," + y + "," + z + " in the dimension " + world.provider.dimensionId + ".");
                    }
                }
            }
        }
    }
}
