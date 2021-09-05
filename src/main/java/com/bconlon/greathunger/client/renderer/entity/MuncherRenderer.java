package com.bconlon.greathunger.client.renderer.entity;

import com.bconlon.greathunger.client.renderer.entity.model.MuncherModel;
import com.bconlon.greathunger.common.entity.MuncherEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MuncherRenderer extends MobRenderer<MuncherEntity, MuncherModel<MuncherEntity>>
{
    public MuncherRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new MuncherModel<>(), 1.1F);
    }

    @Override
    protected void setupRotations(MuncherEntity muncherEntity, MatrixStack matrixStack, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupRotations(muncherEntity, matrixStack, ageInTicks, rotationYaw, partialTicks);
        if (muncherEntity.getHiding()) {
            matrixStack.translate(0.0F, -0.875F, 0.0F);
        }
    }

    @Override
    protected void scale(MuncherEntity muncherEntity, MatrixStack matrixStack, float partialTickTime) {
        super.scale(muncherEntity, matrixStack, partialTickTime);
        matrixStack.scale(2.0F, 2.0F, 2.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(MuncherEntity muncherEntity) {
        if (!muncherEntity.getHiding()) {
            return muncherEntity.getMuncherVariant().getDefaultTextureLocation();
        } else {
            return muncherEntity.getMuncherVariant().getHidingTextureLocation();
        }
    }
}
