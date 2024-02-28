package com.example.examplemod.entity.client;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.example.examplemod.ExampleMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownTridentRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class AssykModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;

	public AssykModel(ModelPart root) {
		super(RenderType::entitySolid);
		this.root = root.getChild("layers");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition layers = partdefinition.addOrReplaceChild("layers", CubeListBuilder.create(), PartPose.offset(8.0F, 24.0F, -8.0F));

		layers.addOrReplaceChild("bottomlayer2", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(10.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 0).addBox(10.0F, -2.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 8).mirror().addBox(10.0F, -4.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 8).mirror().addBox(10.0F, -3.0F, 11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 2).mirror().addBox(10.0F, -6.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(6, 8).mirror().addBox(10.0F, -8.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 12).mirror().addBox(10.0F, -7.0F, 11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 12).mirror().addBox(10.0F, -7.0F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 2).addBox(10.0F, -7.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).mirror().addBox(10.0F, -8.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(6, 8).mirror().addBox(10.0F, -7.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 16).mirror().addBox(10.0F, -6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 16).mirror().addBox(10.0F, -4.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 16).mirror().addBox(10.0F, -3.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 0).addBox(10.0F, -3.0F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 6).mirror().addBox(10.0F, -3.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-16.0F, 0.0F, 0.0F));

		layers.addOrReplaceChild("middlelayer", CubeListBuilder.create().texOffs(0, 4).addBox(-10.0F, -6.0F, 5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -4.0F, 5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -5.0F, 3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -4.0F, 4.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -6.0F, 3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -6.0F, 3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -6.0F, 7.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -4.0F, 7.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -3.0F, 9.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -4.0F, 10.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -6.0F, 10.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -7.0F, 4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-10.0F, -7.0F, 10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		layers.addOrReplaceChild("bottomlayer", CubeListBuilder.create().texOffs(0, 4).addBox(-12.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).mirror().addBox(-12.0F, -2.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(4, 8).addBox(-12.0F, -4.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 8).addBox(-12.0F, -3.0F, 11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-12.0F, -6.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 8).addBox(-12.0F, -8.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 12).addBox(-12.0F, -7.0F, 11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 12).addBox(-12.0F, -7.0F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).mirror().addBox(-12.0F, -7.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 2).addBox(-12.0F, -8.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 8).addBox(-12.0F, -7.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 16).addBox(-12.0F, -6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 16).addBox(-12.0F, -4.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 16).addBox(-12.0F, -3.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).mirror().addBox(-12.0F, -3.0F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(4, 6).addBox(-12.0F, -3.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}