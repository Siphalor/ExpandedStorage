package ninjaphenix.cursedchests;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.util.Identifier;
import ninjaphenix.cursedchests.api.block.entity.CursedChestBlockEntity;
import ninjaphenix.cursedchests.api.client.gui.container.ScrollableScreen;
import ninjaphenix.cursedchests.client.render.block.entity.CursedChestBlockEntityRenderer;

@Environment(EnvType.CLIENT)
public class CursedChestsClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        BlockEntityRendererRegistry.INSTANCE.register(CursedChestBlockEntity.class, new CursedChestBlockEntityRenderer());
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("cursedchests", "scrollcontainer"), ScrollableScreen::createScreen);
    }
}
