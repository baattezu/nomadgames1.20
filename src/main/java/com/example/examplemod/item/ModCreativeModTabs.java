package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

    public static final RegistryObject<CreativeModeTab> NOMAD_GAMES =
            CREATIVE_MODE_TABS.register("nomad_games",
                    () -> CreativeModeTab.builder().icon(() ->new ItemStack(ModItems.ASSYK.get()))
                            .title(Component.translatable("creativetab.nomadgames"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.ASSYK.get());
                                pOutput.accept(ModItems.RED_ASSYK.get());
                                pOutput.accept(Items.SADDLE);
                            }))
                            .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
