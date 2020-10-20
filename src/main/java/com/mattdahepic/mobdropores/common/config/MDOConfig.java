package com.mattdahepic.mobdropores.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class MDOConfig {
    public static class Common {
        public static ForgeConfigSpec.IntValue zombie_veinSize;
        public static ForgeConfigSpec.IntValue zombie_maxHeight;
        public static ForgeConfigSpec.IntValue zombie_spawnChances;
        public static ForgeConfigSpec.IntValue creeper_veinSize;
        public static ForgeConfigSpec.IntValue creeper_maxHeight;
        public static ForgeConfigSpec.IntValue creeper_spawnChances;
        public static ForgeConfigSpec.IntValue enderman_veinSize;
        public static ForgeConfigSpec.IntValue enderman_maxHeight;
        public static ForgeConfigSpec.IntValue enderman_spawnChances;
        public static ForgeConfigSpec.IntValue guardian_veinSize;
        public static ForgeConfigSpec.IntValue guardian_maxHeight;
        public static ForgeConfigSpec.IntValue guardian_spawnChances;
        public static ForgeConfigSpec.IntValue skeleton_veinSize;
        public static ForgeConfigSpec.IntValue skeleton_maxHeight;
        public static ForgeConfigSpec.IntValue skeleton_spawnChances;
        public static ForgeConfigSpec.IntValue slime_veinSize;
        public static ForgeConfigSpec.IntValue slime_maxHeight;
        public static ForgeConfigSpec.IntValue slime_spawnChances;
        public static ForgeConfigSpec.IntValue spider_veinSize;
        public static ForgeConfigSpec.IntValue spider_maxHeight;
        public static ForgeConfigSpec.IntValue spider_spawnChances;
        public static ForgeConfigSpec.IntValue witch_veinSize;
        public static ForgeConfigSpec.IntValue witch_maxHeight;
        public static ForgeConfigSpec.IntValue witch_spawnChances;
        public static ForgeConfigSpec.IntValue wither_veinSize;
        public static ForgeConfigSpec.IntValue wither_maxHeight;
        public static ForgeConfigSpec.IntValue wither_spawnChances;

        public static ForgeConfigSpec.IntValue chicken_veinSize;
        public static ForgeConfigSpec.IntValue chicken_maxHeight;
        public static ForgeConfigSpec.IntValue chicken_spawnChances;
        public static ForgeConfigSpec.IntValue cow_veinSize;
        public static ForgeConfigSpec.IntValue cow_maxHeight;
        public static ForgeConfigSpec.IntValue cow_spawnChances;
        public static ForgeConfigSpec.IntValue pig_veinSize;
        public static ForgeConfigSpec.IntValue pig_maxHeight;
        public static ForgeConfigSpec.IntValue pig_spawnChances;
        public static ForgeConfigSpec.IntValue sheep_veinSize;
        public static ForgeConfigSpec.IntValue sheep_maxHeight;
        public static ForgeConfigSpec.IntValue sheep_spawnChances;
        public static ForgeConfigSpec.IntValue rabbit_veinSize;
        public static ForgeConfigSpec.IntValue rabbit_maxHeight;
        public static ForgeConfigSpec.IntValue rabbit_spawnChances;
        public static ForgeConfigSpec.IntValue squid_veinSize;
        public static ForgeConfigSpec.IntValue squid_maxHeight;
        public static ForgeConfigSpec.IntValue squid_spawnChances;

        public static ForgeConfigSpec.IntValue blaze_veinSize;
        public static ForgeConfigSpec.IntValue blaze_maxHeight;
        public static ForgeConfigSpec.IntValue blaze_spawnChances;
        public static ForgeConfigSpec.IntValue ghast_veinSize;
        public static ForgeConfigSpec.IntValue ghast_maxHeight;
        public static ForgeConfigSpec.IntValue ghast_spawnChances;
        public static ForgeConfigSpec.IntValue wither_skeleton_veinSize;
        public static ForgeConfigSpec.IntValue wither_skeleton_maxHeight;
        public static ForgeConfigSpec.IntValue wither_skeleton_spawnChances;

        public Common (ForgeConfigSpec.Builder builder) {
            builder.comment("For each ore type there are a few options.","veinSize determined the maximum size of veins. An ore with veinSize set to 5 can spawn in veins of 1-5 ore blocks.","maxHeight is the maximum world height an ore can spawn at. An ore with a maxHeight of 64 will be able to be found from levels 0-64","spawnChances detemines the amount of chances an ore has to spawn in a chunk, it does not guarantee a spawn for every try. Coal has a chance of 20 and diamond has a chance of 1.","");

            builder.push("zombie");
            zombie_veinSize = builder.defineInRange("veinSize",6,0,256);
            zombie_maxHeight = builder.defineInRange("maxHeight",64,0,256);
            zombie_spawnChances = builder.defineInRange("spawnChance",16,0,256);
            builder.pop();
            builder.push("creeper");
            creeper_veinSize = builder.defineInRange("veinSize",5,0,256);
            creeper_maxHeight = builder.defineInRange("maxHeight",64,0,256);
            creeper_spawnChances = builder.defineInRange("spawnChance",8,0,256);
            builder.pop();
            builder.push("enderman");
            enderman_veinSize = builder.defineInRange("veinSize",3,0,256);
            enderman_maxHeight = builder.defineInRange("maxHeight",75,0,256);
            enderman_spawnChances = builder.defineInRange("spawnChance",4,0,256);
            builder.pop();
            builder.push("guardian");
            guardian_veinSize = builder.defineInRange("veinSize",4,0,256);
            guardian_maxHeight = builder.defineInRange("maxHeight",64,0,256);
            guardian_spawnChances = builder.defineInRange("spawnChance",3,0,256);
            builder.pop();
            builder.push("skeleton");
            skeleton_veinSize = builder.defineInRange("veinSize",6,0,256);
            skeleton_maxHeight = builder.defineInRange("maxHeight",64,0,256);
            skeleton_spawnChances = builder.defineInRange("spawnChance",6,0,256);
            builder.pop();
            builder.push("slime");
            slime_veinSize = builder.defineInRange("veinSize",4,0,256);
            slime_maxHeight = builder.defineInRange("maxHeight",24,0,256);
            slime_spawnChances = builder.defineInRange("spawnChance",6,0,256);
            builder.pop();
            builder.push("spider");
            spider_veinSize = builder.defineInRange("veinSize",5,0,256);
            spider_maxHeight = builder.defineInRange("maxHeight",64,0,256);
            spider_spawnChances = builder.defineInRange("spawnChance",4,0,256);
            builder.pop();
            builder.push("witch");
            witch_veinSize = builder.defineInRange("veinSize",3,0,256);
            witch_maxHeight = builder.defineInRange("maxHeight",64,0,256);
            witch_spawnChances = builder.defineInRange("spawnChance",5,0,256);
            builder.pop();
            builder.push("wither");
            wither_veinSize = builder.defineInRange("veinSize",1,0,256);
            wither_maxHeight = builder.defineInRange("maxHeight",4,0,256);
            wither_spawnChances = builder.defineInRange("spawnChance",1,0,256);
            builder.pop();

            builder.push("chicken");
            chicken_veinSize = builder.defineInRange("veinSize",3,0,256);
            chicken_maxHeight = builder.defineInRange("maxHeight",128,0,256);
            chicken_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
            builder.push("cow");
            cow_veinSize = builder.defineInRange("veinSize",3,0,256);
            cow_maxHeight = builder.defineInRange("maxHeight", 128,0,256);
            cow_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
            builder.push("pig");
            pig_veinSize = builder.defineInRange("veinSize",3,0,256);
            pig_maxHeight = builder.defineInRange("maxHeight", 128,0,256);
            pig_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
            builder.push("sheep");
            sheep_veinSize = builder.defineInRange("veinSize",3,0,256);
            sheep_maxHeight = builder.defineInRange("maxHeight",128,0,256);
            sheep_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
            builder.push("rabbit");
            rabbit_veinSize = builder.defineInRange("veinSize",3,0,256);
            rabbit_maxHeight = builder.defineInRange("maxHeight",128,0,256);
            rabbit_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
            builder.push("squid");
            squid_veinSize = builder.defineInRange("veinSize",3,0,256);
            squid_maxHeight = builder.defineInRange("maxHeight",128,0,256);
            squid_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();

            builder.push("blaze");
            blaze_veinSize = builder.defineInRange("veinSize",4,0,256);
            blaze_maxHeight = builder.defineInRange("maxHeight",128,0,256);
            blaze_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
            builder.push("ghast");
            ghast_veinSize = builder.defineInRange("veinSize",3,0,256);
            ghast_maxHeight = builder.defineInRange("maxHeight",128,0,256);
            ghast_spawnChances = builder.defineInRange("spawnChance",3,0,256);
            builder.pop();
            builder.push("wither_skeleton");
            wither_skeleton_veinSize = builder.defineInRange("veinSize",1,0,256);
            wither_skeleton_maxHeight = builder.defineInRange("maxHeight",32,0,256);
            wither_skeleton_spawnChances = builder.defineInRange("spawnChance",2,0,256);
            builder.pop();
        }
    }
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    static {
        Pair<Common, ForgeConfigSpec> specPair = (new ForgeConfigSpec.Builder()).configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
