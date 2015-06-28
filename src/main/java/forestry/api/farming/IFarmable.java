/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.farming;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * IGermling describes a crop or other harvestable object and can be used to inspect item stacks and blocks for matches.
 */
public interface IFarmable {

	/**
	 * @param world
	 * @param pos
	 * @return true if the block at the given location is a "sapling" for this type, i.e. a non-harvestable immature version of the crop.
	 */
	boolean isSaplingAt(World world, BlockPos pos);

	/**
	 * @param world
	 * @param pos
	 * @return {@link ICrop} if the block at the given location is a harvestable and mature crop, null otherwise.
	 */
	ICrop getCropAt(World world, BlockPos pos);

	/**
	 * @param itemstack
	 * @return true if the item is a valid germling (plantable sapling, seed, etc.) for this type.
	 */
	boolean isGermling(ItemStack itemstack);

	/**
	 * @param itemstack
	 * @return true if the item is something that can drop from this type without actually being harvested as a crop. (Apples or sapling from decaying leaves.)
	 */
	boolean isWindfall(ItemStack itemstack);

	/**
	 * Plants a sapling by manipulating the world. The {@link IFarmLogic} should have verified the given location as valid. Called by the {@link IFarmHousing}
	 * which handles resources.
	 * 
	 * @param germling
	 * @param world
	 * @param pos
	 * @return true on success, false otherwise.
	 */
	boolean plantSaplingAt(EntityPlayer player, ItemStack germling, World world, BlockPos pos);

}
