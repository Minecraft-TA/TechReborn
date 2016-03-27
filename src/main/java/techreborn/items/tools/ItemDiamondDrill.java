package techreborn.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import techreborn.config.ConfigTechReborn;

public class ItemDiamondDrill extends ItemDrill
{

	public ItemDiamondDrill()
	{
		super(ToolMaterial.DIAMOND, "techreborn.diamondDrill", ConfigTechReborn.DiamondDrillCharge,
				ConfigTechReborn.DiamondDrillTier, 2.5F, 15F);
		this.cost = 250;
	}

	@Override
	public boolean canHarvestBlock(IBlockState state)
	{
		return Items.diamond_pickaxe.canHarvestBlock(state) || Items.diamond_shovel.canHarvestBlock(state);
	}

	@Override
	public String getTextureName(int damage)
	{
		return "techreborn:items/tool/diamondDrill";
	}

	@Override
	public int getMaxMeta()
	{
		return 1;
	}
}
