package couk.rob4001.robocraft;

import net.minecraft.creativetab.CreativeTabs;
import couk.rob4001.robocraft.blocks.ModBlocks;
import couk.rob4001.robocraft.item.ModItems;
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



@Mod(modid="robo", name="RoboMod", version="@VERSION@")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class RoboCraft {

        // The instance of your mod that Forge uses.
        @Instance("Generic")
        public static RoboCraft instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="couk.rob4001.robocraft.client.ClientProxy", serverSide="couk.rob4001.robocraft.CommonProxy")
        public static CommonProxy proxy;

		public static int idShift = 500;       
		public static CreativeTabs creativeTab = new RCCreativeTab();   
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                ModItems.initialize();
                ModBlocks.initialize();
                
                
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
