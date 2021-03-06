package couk.rob4001.robocraft.generation;

import java.util.Random;

import couk.rob4001.robocraft.RoboCraft;
import couk.rob4001.robocraft.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class RobocraftWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
		
	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		for(int k = 0; k < 25; k++) {
			int firstBlockXCoord = i + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(64);
        	int firstBlockZCoord = j + random.nextInt(16);
        	
        	(new WorldGenMinable(ModBlocks.copperOre.blockID, 13))
        	.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
