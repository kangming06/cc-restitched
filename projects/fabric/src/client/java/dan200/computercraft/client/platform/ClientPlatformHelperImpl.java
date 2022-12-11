/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.client.platform;

import com.google.auto.service.AutoService;
import dan200.computercraft.shared.network.NetworkMessage;
import dan200.computercraft.shared.network.server.ServerNetworkContext;
import dan200.computercraft.shared.platform.NetworkHandler;
import net.fabricmc.fabric.api.client.model.BakedModelManagerHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;

@AutoService(dan200.computercraft.impl.client.ClientPlatformHelper.class)
public class ClientPlatformHelperImpl implements ClientPlatformHelper {
    @Override
    public void sendToServer(NetworkMessage<ServerNetworkContext> message) {
        Minecraft.getInstance().player.connection.send(NetworkHandler.encodeServer(message));
    }

    @Override
    public BakedModel getModel(ModelManager manager, ResourceLocation location) {
        var model = BakedModelManagerHelper.getModel(manager, location);
        return model == null ? manager.getMissingModel() : model;
    }
}
