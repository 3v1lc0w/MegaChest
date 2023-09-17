package com.buncord.megachest.items;

import com.buncord.megachest.MegaChest;
import com.buncord.megachest.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MegaChest.MOD_ID);

    public static RegistryObject<Item> MEGA_CHEST = ITEMS.register(
        "mega_chest",
        () -> new MegaChestBlockItem(
            ModBlocks.MEGA_CHEST.get(),
            new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)
        )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
