package couk.rob4001.robocraft.blocks;

import couk.rob4001.robocraft.statics.BlockIds;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ModBlocks {

	//Blocks
    public final static Block tinkerTable = new TinkerTable(BlockIds.TinkerTable, 0, Material.rock)
    .setHardness(5F)
    .setStepSound(Block.soundMetalFootstep)
    .setBlockName("tinkerTable")
    .setCreativeTab(CreativeTabs.tabBlock);    
    
	public static void initialize() {
		addNames();
		setHarvestLevels();
		blockRegistration();
		addBlockRecipes();		
	}
	
	public static void addNames() {
		LanguageRegistry.addName(tinkerTable, "Tinker Table");
	}
	
	public static void setHarvestLevels() {
		MinecraftForge.setBlockHarvestLevel(tinkerTable, "pickaxe", 0);
	}
	
	public static void addBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(tinkerTable), "lr", "ca", 
				'l', new ItemStack(Block.lever), 'r', new ItemStack(Item.redstone),
				'c', new ItemStack(Block.workbench), 'a', new ItemStack(Block.anvil));
	}
	
	public static void blockRegistration() {
		GameRegistry.registerBlock(tinkerTable, "tinkerTable");
	}

}
