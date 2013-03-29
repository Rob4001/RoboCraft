package couk.rob4001.robocraft.research;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResearchMap {

	public static int minDisplayColumn;
	public static int minDisplayRow;
	public static int maxDisplayColumn;
	public static int maxDisplayRow;

	public static List<ResearchItem> researchList = new ArrayList<ResearchItem>();

	public static boolean isResearch(ResearchItem research) {
		if (researchList.contains(research))
			return true;
		return false;
	}

	public static ResearchItem firstResearch = (new ResearchItem(0,
			"openInventory", 0, 0, Item.book, null))
			.registerResearch();
	public static ResearchItem SecondResearch = (new ResearchItem(1,
			"sjdufeInventory", 1, 2, Item.book,  new ResearchItem[]{firstResearch}))
			.registerResearch();

	public static void init() {
	}

	static ResearchItem[] findResearch(ItemStack is) {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO:Add more research!

}
