package couk.rob4001.robocraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {

	private static Item journal;

	public static void initialize() {
		journal = new Journal(0);
		LanguageRegistry.addName(journal, "Scientific Journal");
		GameRegistry.addShapelessRecipe(new ItemStack(journal), new Object[]{new ItemStack(Item.book),new ItemStack(Block.lever)});
	}

}
