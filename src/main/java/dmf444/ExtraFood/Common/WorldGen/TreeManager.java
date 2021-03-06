package dmf444.ExtraFood.Common.WorldGen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class TreeManager implements IWorldGenerator {
	

@Override
public void generate(Random random, int chunkX, int chunkZ, World world,
		IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	switch(world.provider.dimensionId){
		case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
	}
	
}

private void generateEnd(World world, Random random, int x, int z) {
	
}

private void generateSurface(World world, Random random, int x, int z) {
	for (int i = 0; i < 3; i++){
		int Xcoord1 = x + random.nextInt(16); //where in chuck it generates
		int Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
		int Zcoord1 = z + random.nextInt(16); //where in chunk it generates

		final BiomeGenBase biome = world.getBiomeGenForCoords(Xcoord1, Zcoord1);

		if(biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleEdge || biome == BiomeGenBase.jungleHills) {
			new BananaWorldGenTrees(false, 6, 3, 0, true).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}else if(shouldTreesSpawn(biome)){
			int rand = random.nextInt(100);
			if(rand > 75) {
				new OliveWorldGenTrees(false).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
			}
		}
		
	}
	
}

private void generateNether(World world, Random random, int x, int z) {
	
}


	private boolean shouldTreesSpawn(BiomeGenBase biome){
		if(biome == BiomeGenBase.coldTaiga || biome == BiomeGenBase.coldTaigaHills || biome == BiomeGenBase.deepOcean || biome == BiomeGenBase.desert ||
				biome == BiomeGenBase.desertHills || biome == BiomeGenBase.megaTaiga || biome == BiomeGenBase.river || biome == BiomeGenBase.megaTaigaHills ||
				biome == BiomeGenBase.ocean || biome == BiomeGenBase.taiga || biome == BiomeGenBase.taigaHills){
			return false;
		}
		return true;
	}
}