package com.bconlon.greathunger.core.data;

import com.bconlon.greathunger.common.registry.GHItemRegistry;
import com.bconlon.greathunger.core.data.provider.GHItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GHItemModelData extends GHItemModelProvider
{
    public GHItemModelData(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    public String getName() {
        return "Great Hunger Item Models";
    }

    @Override
    protected void registerModels() {
        eggItem(GHItemRegistry.MUNCHER_SPAWN_EGG);
    }
}
