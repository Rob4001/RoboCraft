package couk.rob4001.robocraft.client;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.MinecraftForgeClient;
import couk.rob4001.robocraft.CommonProxy;
import couk.rob4001.robocraft.client.renderers.ItemTinkerTableRenderer;
import couk.rob4001.robocraft.client.renderers.TileTinkerTableRenderer;
import couk.rob4001.robocraft.statics.BlockIds;
import couk.rob4001.robocraft.statics.RenderIDs;
import couk.rob4001.robocraft.statics.Sprites;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(Sprites.Items);
		MinecraftForgeClient.preloadTexture(Sprites.Block);
		MinecraftForgeClient.preloadTexture(Sprites.Model_TinkerTable);

		RenderIDs.TinkerTable = RenderingRegistry.getNextAvailableRenderId();
		MinecraftForgeClient.registerItemRenderer(BlockIds.TinkerTable,
				new ItemTinkerTableRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntityTinkerTable.class, new TileTinkerTableRenderer());
	}
	
	public WorldClient getClientWorld()
	  {
	    return FMLClientHandler.instance().getClient().theWorld;
	  }


}
