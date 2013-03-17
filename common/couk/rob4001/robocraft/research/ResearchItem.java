package couk.rob4001.robocraft.research;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResearchItem {

	public int displayColumn;
	public int displayRow;
	public ResearchItem[] parents;
	public ItemStack icon;
	private String researchDescription;
	private String name;
	public int id;
	public ResearchItem[] siblings;
	public int iconIndex;

	public boolean getSpecial() {
		return false;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.researchDescription;
	}

	public ResearchItem(int id, String name, int column, int row, Item icon,
			ResearchItem[] parent) {
		this(id, name, column, row, new ItemStack(icon), parent);
	}

	public ResearchItem(int id, String name, int column, int row, Block icon,
			ResearchItem[] parent) {
		this(id, name, column, row, new ItemStack(icon), parent);
	}

	public ResearchItem(int id, String name, int column, int row,
			ItemStack icon, ResearchItem[] parent) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.researchDescription = "achievement." + name + ".desc";
		this.displayColumn = column;
		this.displayRow = row;

		if (column < ResearchMap.minDisplayColumn) {
			ResearchMap.minDisplayColumn = column;
		}

		if (row < ResearchMap.minDisplayRow) {
			ResearchMap.minDisplayRow = row;
		}

		if (column > ResearchMap.maxDisplayColumn) {
			ResearchMap.maxDisplayColumn = column;
		}

		if (row > ResearchMap.maxDisplayRow) {
			ResearchMap.maxDisplayRow = row;
		}

		this.parents = parent;
	}

	public ResearchItem registerResearch() {
		ResearchMap.researchList.add(this);
		return this;
	}

	public boolean getHidden() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAutoUnlock() {
		// TODO Auto-generated method stub
		return false;
	}

}
