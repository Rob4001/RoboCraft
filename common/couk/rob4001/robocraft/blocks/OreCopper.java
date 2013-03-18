package couk.rob4001.robocraft.blocks;

import java.util.Random;

import couk.rob4001.robocraft.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class OreCopper extends Block {

	public OreCopper(int blockID, int spriteIndex, Material material) {
		super(blockID, spriteIndex, material );		
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setBlockName("copperOre");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getTextureFile() {
		return "/textures/block.png";
	}
}