package couk.rob4001.robocraft.blocks;

import java.util.Random;

import couk.rob4001.robocraft.RoboCraft;
import couk.rob4001.robocraft.statics.RenderIDs;
import couk.rob4001.robocraft.statics.Sprites;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class TinkerTable extends RCBlock {

        public TinkerTable (int id, int texture, Material material) {
                super(id, texture, material);
        }
        
        @Override
        public boolean onBlockActivated(World world, int x, int y, int z, 
        		EntityPlayer player, int these, float dont, float matter, float are) {
        	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        	if (tileEntity == null || player.isSneaking()) {
        		return false;
        	}
        	
        	player.openGui(RoboCraft.instance, 0, world, x, y, z);
        	return true;
        }
        
        @Override
        public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
                dropItems(world, x, y, z);
                super.breakBlock(world, x, y, z, par5, par6);
        }

        private void dropItems(World world, int x, int y, int z){
                Random rand = new Random();

                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (!(tileEntity instanceof IInventory)) {
                        return;
                }
                IInventory inventory = (IInventory) tileEntity;

                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                        ItemStack item = inventory.getStackInSlot(i);

                        if (item != null && item.stackSize > 0) {
                                float rx = rand.nextFloat() * 0.8F + 0.1F;
                                float ry = rand.nextFloat() * 0.8F + 0.1F;
                                float rz = rand.nextFloat() * 0.8F + 0.1F;

                                EntityItem entityItem = new EntityItem(world,
                                                x + rx, y + ry, z + rz,
                                                new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                                if (item.hasTagCompound()) {
                                        //TODO the function here doesn't seem to be present: entityItem.func_92014_d().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                                }

                                float factor = 0.05F;
                                entityItem.motionX = rand.nextGaussian() * factor;
                                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                                entityItem.motionZ = rand.nextGaussian() * factor;
                                world.spawnEntityInWorld(entityItem);
                                item.stackSize = 0;
                        }
                }
        }

        
        @Override
        public String getTextureFile () {
        	return Sprites.Model_TinkerTable;
        }
        
        @Override
        public boolean renderAsNormalBlock() {
            return false;
        }

        @Override
        public boolean isOpaqueCube() {
            return false;
        }

        @Override
        public int getRenderType() {
            return RenderIDs.TinkerTable;
        }       

		@Override
		public TileEntity createNewTileEntity(World var1) {
			return new TileEntityTinkerTable();
		}      

}