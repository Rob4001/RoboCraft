package couk.rob4001.robocraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import couk.rob4001.robocraft.CommonProxy;

public class ClientProxy extends CommonProxy{

	 public void registerRenderers () {
         MinecraftForgeClient.preloadTexture(ITEMS_PNG);
         MinecraftForgeClient.preloadTexture(BLOCK_PNG);
 }
	
}
