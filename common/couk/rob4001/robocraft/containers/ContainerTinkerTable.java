package couk.rob4001.robocraft.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import couk.rob4001.robocraft.blocks.ModBlocks;
import couk.rob4001.robocraft.item.ModItems;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;

public class ContainerTinkerTable extends Container {

	protected TileEntityTinkerTable tileEntity;
	// Create 3x3 crafting matrix
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	public IInventory researchInput=  new InventoryCrafting(this, 1, 1);
	public IInventory researchOutput = new InventoryCraftResult();
	
	private World worldObj;

	public ContainerTinkerTable(World world, InventoryPlayer inventoryPlayer,
			TileEntityTinkerTable te) {
		this.tileEntity = te;

		// the Slot constructor takes the IInventory and the slot number in that
		// it binds to
		// and the x-y coordinates it resides on-screen. For a SlotCrafting the
		// coords are the result slot
		this.addSlotToContainer(new SlotCrafting(inventoryPlayer.player,
				this.craftMatrix, this.craftResult, 0, 134, 40));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) { // id x y
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3,
						62 + j * 18, 23 + i * 18));
			}
		}

		//Add research output slot
		addSlotToContainer(new SlotCrafting(inventoryPlayer.player,
				this.researchInput, this.craftResult, 0, 134, 40));
		
		//Add research input slot
		this.addSlotToContainer(new Slot(this.researchInput, 0, 26, 23));

		this.worldObj = world;

		this.bindPlayerInventory(inventoryPlayer);
		this.onCraftMatrixChanged(this.craftMatrix);	
		this.onCraftMatrixChanged(this.researchInput);
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.tileEntity.isUseableByPlayer(var1);
	}

	@Override
	public void onCraftMatrixChanged(IInventory inv) {
		if (inv == craftMatrix) {
			this.craftResult.setInventorySlotContents(
					0,
					CraftingManager.getInstance().findMatchingRecipe(
							this.craftMatrix, this.worldObj));
		} else if (inv == researchInput) {
			if (researchInput.getStackInSlot(0) != null) {
				if (this.researchInput.getStackInSlot(0).itemID == (new ItemStack(ModItems.copperIngot)).itemID 
						&& Math.random() < 0.33
						&& this.researchInput.getStackInSlot(0) != null) {
					this.craftResult.setInventorySlotContents(
							0, new ItemStack(ModBlocks.copperOre));
					this.researchInput.setInventorySlotContents(0, null);
				} else {
					this.craftResult.setInventorySlotContents(0, null);
				}
			}
		}
	}

	// Action performed when gui is closed
	@Override
	public void onCraftGuiClosed(EntityPlayer par1EntityPlayer) {
		super.onCraftGuiClosed(par1EntityPlayer);

		if (!this.worldObj.isRemote) {
			for (int var2 = 0; var2 < 9; ++var2) {
				ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);
				if (var3 != null) {
					par1EntityPlayer.dropPlayerItem(var3);
				}
			}
			ItemStack var4 = this.researchInput.getStackInSlotOnClosing(0);
			if (var4 != null) {
				par1EntityPlayer.dropPlayerItem(var4);
			}
		}
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventoryPlayer,
						j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18,
					142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) this.inventorySlots.get(slot);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slot < 9) {
				if (!this.mergeItemStack(stackInSlot, 9, 45, true))
					return null;
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if (!this.mergeItemStack(stackInSlot, 0, 9, false))
				return null;

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize)
				return null;
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}

}
