package com.bconlon.greathunger.common.registry;

import com.bconlon.greathunger.GreatHunger;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class GHTagsRegistry
{
    public static class Blocks
    {
        public static final ITag.INamedTag<Block> MUNCHER_SPAWNING_BLOCKS = tag("muncher_spawning_blocks");

        private static ITag.INamedTag<Block> tag(String name) {
            return BlockTags.bind(new ResourceLocation(GreatHunger.MOD_ID, name).toString());
        }
    }
}
