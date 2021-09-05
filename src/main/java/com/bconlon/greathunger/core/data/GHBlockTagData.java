package com.bconlon.greathunger.core.data;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.registry.GHTagsRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class GHBlockTagData extends BlockTagsProvider
{
    public GHBlockTagData(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, GreatHunger.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Great Hunger Block Tags";
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags() {
        tag(GHTagsRegistry.Blocks.MUNCHER_SPAWNING_BLOCKS)
                .add(Blocks.STONE);
    }
}
