package com.bconlon.greathunger.core.registry;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.core.api.MuncherVariant;

import java.util.*;

public class MuncherVariants
{
    public static Map<String, MuncherVariant> MUNCHER_VARIANTS = new HashMap<>();

    public static final MuncherVariant DEFAULT_STONE = register("default_stone", GreatHunger.MOD_ID, "textures/entity/muncher/stone/muncher.png", "textures/entity/muncher/stone/muncher_hiding.png");

    public static MuncherVariant register(String registryName, String modId, String defaultTextureLocation, String hidingTextureLocation) {
        MuncherVariant muncherVariant = new MuncherVariant(registryName, modId, defaultTextureLocation, hidingTextureLocation);
        MUNCHER_VARIANTS.put(registryName, muncherVariant);
        return muncherVariant;
    }
}
