package com.bconlon.greathunger;

import com.bconlon.greathunger.client.GHRendering;
import com.bconlon.greathunger.common.registry.GHEntityTypeRegistry;
import com.bconlon.greathunger.common.registry.GHItemRegistry;
import com.bconlon.greathunger.core.data.GHItemModelData;
import com.bconlon.greathunger.core.data.GHLanguageData;
import com.bconlon.greathunger.core.data.GHBlockTagData;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GreatHunger.MOD_ID)
public class GreatHunger
{
    public static final String MOD_ID = "great_hunger";
    public static final Logger LOGGER = LogManager.getLogger();

    public GreatHunger() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::dataSetup);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> Client::clientInitialization);

        DeferredRegister<?>[] registers = {
                GHEntityTypeRegistry.ENTITIES,
                GHItemRegistry.ITEMS
        };

        for (DeferredRegister<?> register : registers) {
            register.register(modEventBus);
        }
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        GHEntityTypeRegistry.registerSpawnPlacements();
    }

    public void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        if (event.includeClient()) {
            generator.addProvider(new GHItemModelData(generator, helper));
            generator.addProvider(new GHLanguageData(generator));
        }
        if (event.includeServer()) {
            generator.addProvider(new GHBlockTagData(generator, helper));
        }
    }

    public static class Client
    {
        public static void clientInitialization() {
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            modEventBus.addListener(Client::clientSetup);
        }

        public static void clientSetup(FMLClientSetupEvent event) {
            GHRendering.registerEntityRenderers();
        }
    }
}

