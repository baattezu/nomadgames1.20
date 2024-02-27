package com.example.examplemod.datagen;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.datagen.loot.AddItemModifier;
import com.example.examplemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ExampleMod.MODID);
    }

    @Override
    protected void start() {
        add("assyk_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.ASSYK.get()));
        add("assyk_from_sheep", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("entities/sheep")).build()}, ModItems.ASSYK.get()));
        add("assyk_from_bonuschest", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/spawn_bonus_chest")).build()}, ModItems.ASSYK.get()));
    }
}
