package com.bconlon.greathunger.core.data;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.registry.GHEntityTypeRegistry;
import com.bconlon.greathunger.common.registry.GHItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class GHLanguageData extends LanguageProvider
{
    public GHLanguageData(DataGenerator gen) {
        super(gen, GreatHunger.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(GHItemRegistry.MUNCHER_SPAWN_EGG, "Muncher Spawn Egg");
        addEntityType(GHEntityTypeRegistry.MUNCHER, "Muncher");
    }
}
