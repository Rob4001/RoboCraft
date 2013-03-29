package couk.rob4001.robocraft.research;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ResearchHandler {
	
	public static ResearchResult researchItem(ItemStack is ,EntityPlayer player){
		ResearchResult result = new ResearchResult();
		Random rand = new Random();
		//Query Research Map for a research that requires that item (Requires player to see if unlockable)
		ResearchItem[] list = ResearchMap.findResearch(is);
		ArrayList<ResearchItem> completed = getCompleted();
		if (list.length >0){
		for(ResearchItem item:list){
			if (completed.contains(item))continue;
			
		}
		}else{
			result.setItemUsed(rand.nextInt(list.length)>= completed.size()*1.5).setSuccessful(false);
		}
		return result;
	}

	private static ArrayList<ResearchItem> getCompleted() {
		// TODO Auto-generated method stub
		return null;
	}

}

class ResearchResult{
private int id;
private boolean successful;
private boolean itemUsed;

public boolean isItemUsed() {
	return itemUsed;
}
public ResearchResult setItemUsed(boolean itemUsed) {
	this.itemUsed = itemUsed;
	return this;
}
public int getId() {
	return id;
}
public ResearchResult setId(int id) {
	this.id = id;
	return this;
}
public boolean isSuccessful() {
	return successful;
}
public ResearchResult setSuccessful(boolean successful) {
	this.successful = successful;
	return this;
}


}
