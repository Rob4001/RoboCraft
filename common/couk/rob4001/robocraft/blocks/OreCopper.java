package couk.rob4001.robocraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class OreCopper extends RCBlock {

	public OreCopper(int blockID, Material material) {
		super(blockID, material );		
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName("copperOre");
		
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
}