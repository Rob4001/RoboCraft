package couk.rob4001.robocraft.research;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class ResearchMap {

	public static int minDisplayColumn;
	public static int minDisplayRow;
	public static int maxDisplayColumn;
	public static int maxDisplayRow;
	
	public static List<ResearchItem> researchList = new ArrayList<ResearchItem>();
	public static boolean isResearch(ResearchItem research) {
		if(researchList.contains(research))return true;
		return false;
	}
	
	
	public static ResearchItem firstResearch = (new ResearchItem(0, "openInventory", 0, 0, Item.book, (ResearchItem)null)).registerResearch();
	
	//TODO:Add more research!

}
