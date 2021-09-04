package com.bconlon.greathunger.core.data;

import com.bconlon.greathunger.common.registry.ItemRegistry;
import com.bconlon.greathunger.core.data.provider.ItemModelDataProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelData extends ItemModelDataProvider
{
    public ItemModelData(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    public String getName() {
        return "Great Hunger Item Models";
    }

    @Override
    protected void registerModels() {
        eggItem(ItemRegistry.MUNCHER_SPAWN_EGG);
    }
}
