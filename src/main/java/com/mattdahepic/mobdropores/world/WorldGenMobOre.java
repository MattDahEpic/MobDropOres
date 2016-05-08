package com.mattdahepic.mobdropores.world;

import com.mattdahepic.mobdropores.MobDropOres;
import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMobOre extends WorldGenerator {
    private Block block = MobDropOres.mob_ore;
    private int meta;
    private Block target;
    private int veinSize;
    int spawnChances;
    int minHeight;
    int maxHeight;

    public WorldGenMobOre(EnumMob mob, Block target, int veinSize, int spawnChances, int minHeight, int maxHeight) {
        this.meta = MobUtils.metaFromMob(mob);
        this.target = target;
        this.veinSize = veinSize+1;
        this.spawnChances = spawnChances;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
    @Override
    public boolean generate (World world, Random rand, BlockPos pos) {
        for (int i = veinSize; i > 0; i--) { //for all possible blocks
            if (rand.nextInt(veinSize+1) <= i) { //randomness with always at least one block
                switch (rand.nextInt(6)) { //make snake-like vein shapes
                    case 0:
                        pos = pos.up();
                        break;
                    case 1:
                        pos = pos.down();
                        break;
                    case 2:
                        pos = pos.north();
                        break;
                    case 3:
                        pos = pos.south();
                        break;
                    case 4:
                        pos = pos.east();
                        break;
                    case 5:
                        pos = pos.west();
                        break;
                }
                if (world.isBlockLoaded(pos)) {
                    if (world.getBlockState(pos).getBlock().equals(target)) {
                        world.setBlockState(pos, block.getStateFromMeta(meta));
                    }
                }
            }
        }
        return true;
    }
}
