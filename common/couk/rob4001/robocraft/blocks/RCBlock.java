package couk.rob4001.robocraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import couk.rob4001.robocraft.RoboCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class RCBlock extends BlockContainer {

	protected RCBlock(int par1, Material par3Material) {
		super(par1, par3Material);
		this.setCreativeTab(RoboCraft.creativeTab);
	}

	/**
	 * Sets the direction of the block when placed
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLiving entityLiving,ItemStack is) {
 
		int direction = 0;
		int facing = MathHelper
				.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

		if (facing == 0) {
			direction = ForgeDirection.NORTH.ordinal();
		} else if (facing == 1) {
			direction = ForgeDirection.EAST.ordinal();
		} else if (facing == 2) {
			direction = ForgeDirection.SOUTH.ordinal();
		} else if (facing == 3) {
			direction = ForgeDirection.WEST.ordinal();
		}

		world.setBlockMetadataWithNotify(x, y, z, direction,0x02);
	}
	
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {

	        blockIcon = iconRegister.registerIcon("robo:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	    }

}
