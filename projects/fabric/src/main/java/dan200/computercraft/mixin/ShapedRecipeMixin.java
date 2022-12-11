/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.mixin;

import com.google.gson.JsonObject;
import dan200.computercraft.shared.FabricCommonHooks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShapedRecipe.class)
class ShapedRecipeMixin {
    @Inject(method = "itemStackFromJson", at = @At("RETURN"))
    @SuppressWarnings("UnusedMethod")
    private static void itemStackFromJson(JsonObject json, CallbackInfoReturnable<ItemStack> cir) {
        // This is a fairly invasive mixin in the sense that every mod goes through this code path. We might want to
        // remove this and use custom recipes types in the future.
        FabricCommonHooks.addRecipeResultTag(cir.getReturnValue(), json);
    }
}
