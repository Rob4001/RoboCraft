package couk.rob4001.robocraft;

import generation.RobocraftWorldGenerator;
import net.minecraft.creativetab.CreativeTabs;
import couk.rob4001.robocraft.blocks.ModBlocks;
import couk.rob4001.robocraft.gui.GUIHandler;
import couk.rob4001.robocraft.item.ModItems;
import couk.rob4001.robocraft.research.ResearchMap;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "robo", name = "RoboMod", version = "@VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = { "Robocraft" }, packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec = @SidedPacketHandler(channels = { "Robocraft" }, packetHandler = ServerPacketHandler.class))
public class RoboCraft {

	// The instance of your mod that Forge uses.
	@Instance("robo")
	public static RoboCraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "couk.rob4001.robocraft.client.ClientProxy", serverSide = "couk.rob4001.robocraft.CommonProxy")
	public static CommonProxy proxy;

	public static int idShift = 500;
	public static CreativeTabs creativeTab = new RCCreativeTab();

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.initialize();
		ModBlocks.initialize();
	}

	@Init
	public void load(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(this, new GUIHandler());
		NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
		GameRegistry.registerWorldGenerator(new RobocraftWorldGenerator());
		proxy.registerTileEntities();		
		proxy.registerRenderers();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		ResearchMap.init();
	}
}
