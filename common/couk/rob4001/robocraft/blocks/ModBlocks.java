package couk.rob4001.robocraft.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

public class ModBlocks {

	//Blocks
    public final static Block tinkerTable = new TinkerTable(160, 0, Material.rock)
    .setHardness(5F)
    .setStepSound(Block.soundMetalFootstep)
    .setBlockName("tinkerTable")
    .setCreativeTab(CreativeTabs.tabBlock);    
    
	public static void initialize() {
		
		//Tinker Table
		GameRegistry.registerBlock(tinkerTable, "tinkerTable");
		LanguageRegistry.addName(tinkerTable, "Tinker Table");
		MinecraftForge.setBlockHarvestLevel(tinkerTable, "pickaxe", 0);		
	}

}
