package com.bconlon.greathunger.core.data;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.registry.EntityTypeRegistry;
import com.bconlon.greathunger.common.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageData extends LanguageProvider
{
    public LanguageData(DataGenerator gen) {
        super(gen, GreatHunger.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ItemRegistry.MUNCHER_SPAWN_EGG, "Muncher Spawn Egg");
        addEntityType(EntityTypeRegistry.MUNCHER, "Muncher");
    }
}
