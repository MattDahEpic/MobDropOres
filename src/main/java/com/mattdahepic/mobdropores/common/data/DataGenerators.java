package com.mattdahepic.mobdropores.common.data;

import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class DataGenerators {
    public static void gatherData (GatherDataEvent event) {
        if (event.includeServer()) {
            BlockTagsProvider btp = new BlockTagsProvider(event.getGenerator(), event.getExistingFileHelper());
            event.getGenerator().addProvider(btp);
            event.getGenerator().addProvider(new ItemTagsProvider(event.getGenerator(), btp, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            event.getGenerator().addProvider(new BlockStateProvider(event.getGenerator(), event.getExistingFileHelper()));
            event.getGenerator().addProvider(new ItemModelProvider(event.getGenerator(), event.getExistingFileHelper()));
        }
    }
}
