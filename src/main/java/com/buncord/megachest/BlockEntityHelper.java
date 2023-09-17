package com.buncord.megachest;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.Optional;

public class BlockEntityHelper {

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