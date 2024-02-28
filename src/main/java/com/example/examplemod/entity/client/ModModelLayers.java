package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation ASSYK_LAYER = new ModelLayerLocation(
            new ResourceLocation(ExampleMod.MODID, "assyk_layer"), "main");


    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

}