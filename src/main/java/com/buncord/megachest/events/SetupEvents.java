package com.buncord.megachest.events;

import com.buncord.megachest.MegaChest;
import com.buncord.megachest.containers.ModContainers;
import com.buncord.megachest.screens.MegaChestScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
		modid = MegaChest.MOD_ID,
		bus = Mod.EventBusSubscriber.Bus.MOD,
		value = Dist.CLIENT
)
public class SetupEvents {

	@SubscribeEvent
	static void onClientSetup(FMLClientSetupEvent evt) {
		evt.enqueueWork(() -> {
			MenuScreens.register(ModContainers.MEGA_CHEST.get(), MegaChestScreen::new);
		});
	}

}
