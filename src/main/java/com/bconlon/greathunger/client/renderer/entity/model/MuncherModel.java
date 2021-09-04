package com.bconlon.greathunger.client.renderer.entity.model;

import com.bconlon.greathunger.common.entity.MuncherEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MuncherModel<T extends MuncherEntity> extends EntityModel<T>
{
    private final ModelRenderer head_upper;
    private final ModelRenderer head_lower;
    private final ModelRenderer body;
    private final ModelRenderer legs;

    public MuncherModel() {
        this.texWidth = 128;
        this.texHeight = 128;

        this.head_upper = new ModelRenderer(this);
        this.head_upper.setPos(0.0F, 30.0F, 0.0F);
        this.head_upper.texOffs(0, 0).addBox(-9.0F, -25.0F, -11.0F, 18.0F, 7.0F, 22.0F, 0.0F, false);
        this.head_upper.texOffs(0, 59).addBox(-9.0F, -20.0F, -11.0F, 18.0F, 1.0F, 22.0F, 0.0F, false);

        this.head_lower = new ModelRenderer(this);
        this.head_lower.setPos(0.0F, 24.0F, 0.0F);
        this.head_lower.texOffs(0, 29).addBox(-9.0F, -13.0F, -11.0F, 18.0F, 6.0F, 22.0F, 0.0F, false);
        this.head_lower.texOffs(0, 59).addBox(-9.0F, -12.0F, -11.0F, 18.0F, 1.0F, 22.0F, 0.0F, false);
        this.head_lower.texOffs(60, 57).addBox(-8.0F, -18.0F, -9.0F, 16.0F, 6.0F, 18.0F, 0.0F, false);

        this.body = new ModelRenderer(this);
        this.body.setPos(0.0F, 24.0F, 0.0F);
        this.body.texOffs(58, 0).addBox(-7.0F, -7.0F, -3.0F, 14.0F, 4.0F, 12.0F, 0.0F, false);

        this.legs = new ModelRenderer(this);
        this.legs.setPos(0.0F, 24.0F, 0.0F);
        this.legs.texOffs(0, 0).addBox(-8.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        this.legs.texOffs(0, 0).addBox(4.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        this.legs.texOffs(0, 0).addBox(4.0F, -6.0F, 6.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        this.legs.texOffs(0, 0).addBox(-8.0F, -6.0F, 6.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T muncherEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.head_upper.render(matrixStack, buffer, packedLight, packedOverlay);
        this.head_lower.render(matrixStack, buffer, packedLight, packedOverlay);
        this.body.render(matrixStack, buffer, packedLight, packedOverlay);
        this.legs.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
