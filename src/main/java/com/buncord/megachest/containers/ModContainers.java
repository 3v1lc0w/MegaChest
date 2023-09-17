package com.buncord.megachest.containers;

import com.buncord.megachest.MegaChest;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainers {

  public static final DeferredRegister<MenuType<?>> CONTAINERS =
      DeferredRegister.create(ForgeRegistries.CONTAINERS, MegaChest.MOD_ID);

  public static final RegistryObject<MenuType<MegaChestContainerMenu>> MEGA_CHEST =
      CONTAINERS.register("mega_chest", () -> IForgeMenuType.create(MegaChestContainerMenu::new));


  public static void register(IEventBus eventBus) {
    CONTAINERS.register(eventBus);
  }
}
