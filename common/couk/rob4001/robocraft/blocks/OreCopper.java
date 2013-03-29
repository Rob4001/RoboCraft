package couk.rob4001.robocraft.blocks;

import java.util.Random;

import couk.rob4001.robocraft.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class OreCopper extends Block {

	public OreCopper(int blockID, Material material) {
		super(blockID, material );		
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName("copperOre");
		
		setCreativeTab(CreativeTabs.tabBlock);
	}
}