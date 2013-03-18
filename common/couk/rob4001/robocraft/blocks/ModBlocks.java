package couk.rob4001.robocraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import couk.rob4001.robocraft.item.ModItems;
import couk.rob4001.robocraft.statics.BlockIds;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	// Blocks
	public final static Block tinkerTable = new TinkerTable(
			BlockIds.TinkerTable, 0, Material.rock).setHardness(5F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("tinkerTable");
	
	public final static Block copperOre = new OreCopper(BlockIds.CopperOre, 0, Material.iron);

	public static void initialize() {
		addNames();
		setHarvestLevels();
		blockRegistration();
		addBlockRecipes();
		addSmelting();
	}

	public static void addNames() {
		LanguageRegistry.addName(tinkerTable, "Tinker Table");
		LanguageRegistry.addName(copperOre, "Copper Ore");
	}

	public static void setHarvestLevels() {
		MinecraftForge.setBlockHarvestLevel(tinkerTable, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", 2);
		
	}

	public static void addBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(tinkerTable), "lr", "ca", 'l',
				new ItemStack(Block.lever), 'r', new ItemStack(Item.redstone),
				'c', new ItemStack(Block.workbench), 'a', new ItemStack(
						Block.anvil));
	}

	public static void blockRegistration() {
		GameRegistry.registerBlock(tinkerTable, "tinkerTable");			
		GameRegistry.registerBlock(copperOre, "copperOre");
	}
	
	public static void addSmelting() {
		GameRegistry.addSmelting(copperOre.blockID, new ItemStack(ModItems.copperIngot), 0.1F);
	}

}
