package com.bconlon.greathunger.client.renderer.entity;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.client.renderer.entity.model.MuncherModel;
import com.bconlon.greathunger.common.entity.MuncherEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MuncherRenderer extends MobRenderer<MuncherEntity, MuncherModel<MuncherEntity>>
{
    private static final ResourceLocation MUNCHER_LOCATION = new ResourceLocation(GreatHunger.MOD_ID, "textures/entity/muncher/muncher.png");
    private static final ResourceLocation MUNCHER_LUSH_LOCATION = new ResourceLocation(GreatHunger.MOD_ID, "textures/entity/muncher/muncher_lush.png");
    private static final ResourceLocation MUNCHER_DRIPSTONE_LOCATION = new ResourceLocation(GreatHunger.MOD_ID, "textures/entity/muncher/muncher_dripstone.png");

    public MuncherRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new MuncherModel<>(), 1.1F);
    }

    @Override
    protected void scale(MuncherEntity livingEntity, MatrixStack matrixStack, float partialTickTime) {
        matrixStack.scale(2.0F, 2.0F, 2.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(MuncherEntity muncherEntity) {
        return MUNCHER_LOCATION;
    }
}
