package com.buncord.megachest;

import com.buncord.megachest.block_entities.ModBlockEntities;
import com.buncord.megachest.blocks.ModBlocks;
import com.buncord.megachest.containers.ModContainers;
import com.buncord.megachest.items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MegaChest.MOD_ID)
public class MegaChest
{
    public static final String MOD_ID = "megachest";

    public MegaChest() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlockEntities.register(eventBus);
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModContainers.register(eventBus);
    }
}
