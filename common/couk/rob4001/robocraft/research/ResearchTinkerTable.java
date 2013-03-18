package couk.rob4001.robocraft.research;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ResearchTinkerTable implements IInventory {

	/** List of stacks in the research slot **/
	private ItemStack[] stackList;
	
	private Container eventHandler;
	
	public ResearchTinkerTable(Container container) {
		this.stackList = new ItemStack[1];
		this.eventHandler = container;	
	}
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return var1 >= this.getSizeInventory() ? null : this.stackList[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		 if (this.stackList[var1] != null)
	        {
	            ItemStack var3;

	            if (this.stackList[var1].stackSize <= var2)
	            {
	                var3 = this.stackList[var1];
	                this.stackList[var1] = null;
	                this.eventHandler.onCraftMatrixChanged(this);
	                return var3;
	            }
	            else
	            {
	                var3 = this.stackList[var1].splitStack(var2);

	                if (this.stackList[var1].stackSize == 0)
	                {
	                    this.stackList[var1] = null;
	                }

	                this.eventHandler.onCraftMatrixChanged(this);
	                return var3;
	            }
	        }
	        else
	        {
	            return null;
	        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		if (this.stackList[var1] != null)
        {
            ItemStack var2 = this.stackList[var1];
            this.stackList[var1] = null;
            return var2;
        }
        else
        {
            return null;
        }
	}

	
	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		 this.stackList[var1] = var2;
	     this.eventHandler.onCraftMatrixChanged(this);		
	}

	@Override
	public String getInvName() {
		return "container.tinkertable.research";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

}
