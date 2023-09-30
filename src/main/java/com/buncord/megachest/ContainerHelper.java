package com.buncord.megachest;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.Optional;

public class ContainerHelper {

  public static CompoundTag saveAllItems(CompoundTag compoundTag, NonNullList<ItemStack> items) {
    ListTag listtag = new ListTag();

    for(int i = 0; i < items.size(); ++i) {
      ItemStack itemstack = items.get(i);

      if (!itemstack.isEmpty()) {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putInt("SlotInt", i);
        itemstack.save(compoundtag);
        listtag.add(compoundtag);
      }
    }

    compoundTag.put("Items", listtag);

    return compoundTag;
  }

  public static void loadAllItems(CompoundTag compoundTag, NonNullList<ItemStack> items) {
    ListTag listtag = compoundTag.getList("Items", 10);

    for(int i = 0; i < listtag.size(); ++i) {
      CompoundTag compoundtag = listtag.getCompound(i);

      int j;

      if (compoundtag.contains("SlotInt")) {
        j = compoundtag.getInt("SlotInt");
      } else {
        j = compoundtag.getByte("Slot") & 255;
      }

      if (j >= 0 && j < items.size()) {
        items.set(j, ItemStack.of(compoundtag));
      }
    }
  }

  public static <T> Optional<T> get(Class<T> clazz, @Nullable BlockGetter world, BlockPos pos) {
    if (!isBlockLoaded(world, pos)) {
      return Optional.empty();
    }

    BlockEntity tile = world.getBlockEntity(pos);

    if (tile == null) {
      return Optional.empty();
    }

    if (clazz.isInstance(tile)) {
      return Optional.of(clazz.cast(tile));
    }

    return Optional.empty();
  }

  public static boolean isBlockLoaded(@Nullable BlockGetter world, BlockPos pos) {
    if (world == null) {
      return false;
    }

    if (world instanceof LevelReader) {
      return ((LevelReader) world).hasChunkAt(pos);
    }

    return true;
  }

}