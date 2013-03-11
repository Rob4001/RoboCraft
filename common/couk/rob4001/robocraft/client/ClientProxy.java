package couk.rob4001.robocraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import couk.rob4001.robocraft.CommonProxy;
import couk.rob4001.robocraft.client.renderers.ItemTinkerTableRenderer;
import couk.rob4001.robocraft.statics.BlockIds;
import couk.rob4001.robocraft.statics.RenderIDs;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	 public void registerRenderers () {
         MinecraftForgeClient.preloadTexture(ITEMS_PNG);
         MinecraftForgeClient.preloadTexture(BLOCK_PNG);
         
         RenderIDs.TinkerTable = RenderingRegistry.getNextAvailableRenderId();
         
         MinecraftForgeClient.registerItemRenderer(BlockIds.TinkerTable, new ItemTinkerTableRenderer());
        
 }
	
}
