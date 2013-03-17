package couk.rob4001.robocraft;

import net.minecraft.client.multiplayer.WorldClient;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	// Client stuff
	public void registerRenderers() {
		// Nothing here as this is the server side proxy
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTinkerTable.class,
				"containerTinkerTable");
		
	}

	public WorldClient getClientWorld() {
		return null;
	}

}
