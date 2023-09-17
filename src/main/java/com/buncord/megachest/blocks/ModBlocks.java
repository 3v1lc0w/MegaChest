package com.buncord.megachest.blocks;

import com.buncord.megachest.MegaChest;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MegaChest.MOD_ID);

    public static final RegistryObject<Block> MEGA_CHEST = BLOCKS.register(
        "mega_chest",
        () -> new MegaChestBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
                                     .strength(2.5F)
                                     .sound(SoundType.WOOD)
                                     .randomTicks()
        )
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
