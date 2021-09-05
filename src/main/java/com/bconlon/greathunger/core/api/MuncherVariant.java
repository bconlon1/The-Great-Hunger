package com.bconlon.greathunger.core.api;

import net.minecraft.util.ResourceLocation;

public class MuncherVariant
{
    private final String registryName;
    private final String modId;
    private final String defaultTextureLocation;
    private final String hidingTextureLocation;

    public MuncherVariant(String registryName, String modId, String defaultTextureLocation, String hidingTextureLocation) {
        this.registryName = registryName;
        this.modId = modId;
        this.defaultTextureLocation = defaultTextureLocation;
        this.hidingTextureLocation = hidingTextureLocation;
    }

    public String getRegistryName() {
        return this.registryName;
    }

    public ResourceLocation getDefaultTextureLocation() {
        return new ResourceLocation(this.modId, this.defaultTextureLocation);
    }

    public ResourceLocation getHidingTextureLocation() {
        return new ResourceLocation(this.modId, this.hidingTextureLocation);
    }
}
