package com.bconlon.greathunger.common.registry;

import com.bconlon.greathunger.GreatHunger;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GHItemRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GreatHunger.MOD_ID);

    public static final RegistryObject<SpawnEggItem> MUNCHER_SPAWN_EGG = ITEMS.register("muncher_spawn_egg", () -> new SpawnEggItem(GHEntityTypeRegistry.MUNCHER_TYPE, 0x878289, 0x504B55, new Item.Properties().tab(ItemGroup.TAB_MISC)));
}
