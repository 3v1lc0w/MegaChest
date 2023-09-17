package com.buncord.megachest.block_entities;

import com.buncord.megachest.MegaChest;
import com.buncord.megachest.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MegaChest.MOD_ID);

  public static final RegistryObject<BlockEntityType<MegaChestBlockEntity>> MEGA_CHEST =
      BLOCK_ENTITIES.register(
          "mega_chest",
          () -> BlockEntityType.Builder.of(
              MegaChestBlockEntity::new,
              ModBlocks.MEGA_CHEST.get()
          ).build(null)
      );

  public static void register(IEventBus eventBus) {
    BLOCK_ENTITIES.register(eventBus);
  }

}
