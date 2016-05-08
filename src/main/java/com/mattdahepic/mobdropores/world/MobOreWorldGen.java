package com.mattdahepic.mobdropores.world;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.config.MDOConfig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MobOreWorldGen implements IWorldGenerator {
    private WorldGenMobOre gen_zombie;
    private WorldGenMobOre gen_blaze;
    private WorldGenMobOre gen_creeper;
    private WorldGenMobOre gen_enderman;
    private WorldGenMobOre gen_ghast;
    private WorldGenMobOre gen_guardian;
    private WorldGenMobOre gen_skeleton;
    private WorldGenMobOre gen_slime;
    private WorldGenMobOre gen_spider;
    private WorldGenMobOre gen_witch;
    private WorldGenMobOre gen_wither;
    private WorldGenMobOre gen_wither_skeleton;
    public MobOreWorldGen () {
        //WorldGenMobOre(EnumMob,targetBlock,veinSize,spawnChances,minHeight,maxHeight);
        gen_zombie = new WorldGenMobOre(EnumMob.ZOMBIE, Blocks.STONE, MDOConfig.zombie_maxVeinSize,MDOConfig.zombie_spawnChances,MDOConfig.zombie_minY,MDOConfig.zombie_maxY);
        gen_blaze = new WorldGenMobOre(EnumMob.BLAZE,Blocks.NETHERRACK, MDOConfig.blaze_maxVeinSize, MDOConfig.blaze_spawnChances, MDOConfig.blaze_minY, MDOConfig.blaze_maxY);
        gen_creeper = new WorldGenMobOre(EnumMob.CREEPER,Blocks.STONE, MDOConfig.creeper_maxVeinSize, MDOConfig.creeper_spawnChances, MDOConfig.creeper_minY, MDOConfig.creeper_maxY);
        gen_enderman = new WorldGenMobOre(EnumMob.ENDERMAN,Blocks.STONE, MDOConfig.enderman_maxVeinSize, MDOConfig.enderman_spawnChances, MDOConfig.enderman_minY, MDOConfig.enderman_maxY);
        gen_ghast = new WorldGenMobOre(EnumMob.GHAST,Blocks.NETHERRACK, MDOConfig.ghast_maxVeinSize, MDOConfig.ghast_spawnChances, MDOConfig.ghast_minY, MDOConfig.ghast_maxY);
        gen_guardian = new WorldGenMobOre(EnumMob.GUARDIAN,Blocks.STONE, MDOConfig.guardian_maxVeinSize, MDOConfig.guardian_spawnChances, MDOConfig.guardian_minY, MDOConfig.guardian_maxY);
        gen_skeleton = new WorldGenMobOre(EnumMob.SKELETON,Blocks.STONE, MDOConfig.skeleton_maxVeinSize, MDOConfig.skeleton_spawnChances, MDOConfig.skeleton_minY, MDOConfig.skeleton_maxY);
        gen_slime = new WorldGenMobOre(EnumMob.SLIME,Blocks.STONE, MDOConfig.slime_maxVeinSize, MDOConfig.slime_spawnChances, MDOConfig.slime_minY, MDOConfig.slime_maxY);
        gen_spider = new WorldGenMobOre(EnumMob.SPIDER,Blocks.STONE, MDOConfig.spider_maxVeinSize, MDOConfig.spider_spawnChances, MDOConfig.spider_minY, MDOConfig.spider_maxY);
        gen_witch = new WorldGenMobOre(EnumMob.WITCH,Blocks.STONE, MDOConfig.witch_maxVeinSize, MDOConfig.witch_spawnChances, MDOConfig.witch_minY, MDOConfig.witch_maxY);
        gen_wither = new WorldGenMobOre(EnumMob.WITHER,Blocks.STONE, MDOConfig.wither_maxVeinSize, MDOConfig.wither_spawnChances, MDOConfig.wither_minY, MDOConfig.wither_maxY);
        gen_wither_skeleton = new WorldGenMobOre(EnumMob.WITHER_SKELETON,Blocks.STONE, MDOConfig.wither_skeleton_maxVeinSize, MDOConfig.wither_skeleton_spawnChances, MDOConfig.wither_skeleton_minY, MDOConfig.wither_skeleton_maxY);
    }
    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //overworld
                runGenerator(gen_zombie,world,rand,chunkX,chunkZ,gen_zombie.spawnChances,gen_zombie.minHeight,gen_zombie.maxHeight);
                runGenerator(gen_creeper,world,rand,chunkX,chunkZ,gen_creeper.spawnChances,gen_creeper.minHeight,gen_creeper.maxHeight);
                runGenerator(gen_enderman,world,rand,chunkX,chunkZ,gen_enderman.spawnChances,gen_enderman.minHeight,gen_enderman.maxHeight);
                runGenerator(gen_guardian,world,rand,chunkX,chunkZ,gen_guardian.spawnChances,gen_guardian.minHeight,gen_guardian.maxHeight);
                runGenerator(gen_skeleton,world,rand,chunkX,chunkZ,gen_skeleton.spawnChances,gen_skeleton.minHeight,gen_skeleton.maxHeight);
                runGenerator(gen_slime,world,rand,chunkX,chunkZ,gen_slime.spawnChances,gen_slime.minHeight,gen_slime.maxHeight);
                runGenerator(gen_spider,world,rand,chunkX,chunkZ,gen_spider.spawnChances,gen_spider.minHeight,gen_spider.maxHeight);
                runGenerator(gen_witch,world,rand,chunkX,chunkZ,gen_witch.spawnChances,gen_witch.minHeight,gen_witch.maxHeight);
                runGenerator(gen_wither,world,rand,chunkX,chunkZ,gen_wither.spawnChances,gen_wither.minHeight,gen_wither.maxHeight);
                runGenerator(gen_wither_skeleton,world,rand,chunkX,chunkZ,gen_wither_skeleton.spawnChances,gen_wither_skeleton.minHeight,gen_wither_skeleton.maxHeight);
                break;
            case -1: //nether
                runGenerator(gen_blaze,world,rand,chunkX,chunkZ,gen_blaze.spawnChances,gen_blaze.minHeight,gen_blaze.maxHeight);
                runGenerator(gen_ghast,world,rand,chunkX,chunkZ,gen_ghast.spawnChances,gen_ghast.minHeight,gen_ghast.maxHeight);
                break;
        }
    }
    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + 8 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + 8 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x,y,z));
        }
    }
}
