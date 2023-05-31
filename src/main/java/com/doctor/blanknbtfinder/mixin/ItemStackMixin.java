package com.doctor.blanknbtfinder.mixin;

import com.doctor.blanknbtfinder.BlankNBTFinder;
import com.doctor.blanknbtfinder.CommonConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.Optional;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract Holder<Item> getItemHolder();

    @Inject(method = "getOrCreateTag", at = @At("HEAD"))
    public void getOrCreateTag(CallbackInfoReturnable<CompoundTag> cir) {
        if (CommonConfig.COMMON_CONFIG.isLoaded() && !(CommonConfig.itemId.get().equals(""))) {
            ResourceLocation resourceLocation = new ResourceLocation(CommonConfig.itemId.get());
            if(this.getItemHolder().is(resourceLocation)) {
                StackTraceElement[] elements = Thread.currentThread().getStackTrace();
                for (int i = 0; i < 5; i++) {
                    BlankNBTFinder.LOGGER.info(elements[i] + "LENGTH ->" + elements.length);
                  }
                }
            }
        }
    }

