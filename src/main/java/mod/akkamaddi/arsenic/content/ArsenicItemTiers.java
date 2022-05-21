package mod.akkamaddi.arsenic.content;

import java.util.List;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.fusion.content.FusionItemTiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public final class ArsenicItemTiers
{
	public static final TagKey<Block> ARSENIC_TAG = 
			BlockTags.create(new ResourceLocation(ArsenicAndLace.MODID, "needs_arsenic_tool"));
	public static final TagKey<Block> ARSENIDE_BRONZE_TAG = 
			BlockTags.create(new ResourceLocation(ArsenicAndLace.MODID, "needs_arsenide_bronze_tool"));
	public static final TagKey<Block> ARSENIDE_GOLD_TAG = 
			BlockTags.create(new ResourceLocation(ArsenicAndLace.MODID, "needs_arsenide_gold_tool"));
	public static final TagKey<Block> TENEBRIUM_TAG = 
			BlockTags.create(new ResourceLocation(ArsenicAndLace.MODID, "needs_tenebrium_tool"));

	public static final Tier ARSENIC = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.STONE.getLevel(), 62, 2.0F, 2.0F, 10, ARSENIC_TAG,
					()->Ingredient.of(ModItems.arsenic_ingot.get())),
			new ResourceLocation(ArsenicAndLace.MODID, "arsenic"), 
			List.of(Tiers.STONE), List.of(Tiers.IRON));
	
	public static final Tier ARSENIDE_BRONZE = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.IRON.getLevel(), 640, 9.5F, 2.0F, 9, ARSENIDE_BRONZE_TAG,
					()->Ingredient.of(ModItems.arsenide_bronze_ingot.get())),
			new ResourceLocation(ArsenicAndLace.MODID, "arsenide_bronze"), 
			List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

	public static final Tier ARSENIDE_GOLD = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.STONE.getLevel(), 56, 12.0F, 2.0F, 20, ARSENIDE_GOLD_TAG,
					()->Ingredient.of(ModItems.arsenide_gold_ingot.get())),
			new ResourceLocation(ArsenicAndLace.MODID, "arsenide_gold"), 
			List.of(Tiers.STONE), List.of(Tiers.IRON));
	
	public static final Tier TENEBRIUM = TierSortingRegistry.registerTier(
			new ForgeTier(5, 3820, 9.0F, 3.0F, 17, TENEBRIUM_TAG,
					()->Ingredient.of(ModItems.tenebrium_ingot.get())),
			new ResourceLocation(ArsenicAndLace.MODID, "tenebrium"), 
			List.of(Tiers.NETHERITE), List.of(FusionItemTiers.SINISITE));
	
} // end class
