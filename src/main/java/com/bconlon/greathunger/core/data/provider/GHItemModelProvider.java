package com.bconlon.greathunger.core.data.provider;

import com.bconlon.greathunger.GreatHunger;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public abstract class GHItemModelProvider extends ItemModelProvider
{
    public GHItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, GreatHunger.MOD_ID, fileHelper);
    }

    public ItemModelBuilder eggItem(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
