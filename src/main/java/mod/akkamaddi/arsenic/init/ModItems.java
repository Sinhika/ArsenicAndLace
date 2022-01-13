package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.content.ArsenicArmorMaterial;
import mod.akkamaddi.arsenic.content.ArsenicAxeItem;
import mod.akkamaddi.arsenic.content.ArsenicItemTier;
import mod.akkamaddi.arsenic.content.ArsenicSwordItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, ArsenicAndLace.MODID);
    
    // ingots, chunks, and dusts
    public static final RegistryObject<Item> arsenic_ingot = ITEMS.register("arsenic_ingot", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenic_nugget = ITEMS.register("arsenic_nugget", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenic_dust = ITEMS.register("arsenic_dust", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> realgar = ITEMS.register("realgar", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> orpiment = ITEMS.register("orpiment", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_salt = ITEMS.register("arsenide_salt", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_arsenic_chunk = ITEMS.register("medium_arsenic_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_arsenic_chunk = ITEMS.register("large_arsenic_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_bronze_ingot = ITEMS.register("arsenide_bronze_ingot", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_bronze_nugget = ITEMS.register("arsenide_bronze_nugget", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_bronze_dust = ITEMS.register("arsenide_bronze_dust", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_arsenide_bronze_chunk = ITEMS.register("medium_arsenide_bronze_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_arsenide_bronze_chunk = ITEMS.register("large_arsenide_bronze_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_gold_ingot = ITEMS.register("arsenide_gold_ingot", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_gold_nugget = ITEMS.register("arsenide_gold_nugget", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> arsenide_gold_dust = ITEMS.register("arsenide_gold_dust", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_arsenide_gold_chunk = ITEMS.register("medium_arsenide_gold_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_arsenide_gold_chunk = ITEMS.register("large_arsenide_gold_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> tenebrium_ingot = ITEMS.register("tenebrium_ingot", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tenebrium_nugget = ITEMS.register("tenebrium_nugget", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tenebrium_dust = ITEMS.register("tenebrium_dust", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_tenebrium_chunk = ITEMS.register("medium_tenebrium_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_tenebrium_chunk = ITEMS.register("large_tenebrium_chunk", 
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // TOOLS
    // swords
    public static final RegistryObject<ArsenicSwordItem> arsenic_sword = ITEMS.register("arsenic_sword",
            () -> new ArsenicSwordItem(ArsenicItemTier.ARSENIC, 3, -2.4F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArsenicSwordItem> arsenide_bronze_sword = ITEMS.register("arsenide_bronze_sword",
            () -> new ArsenicSwordItem(ArsenicItemTier.ARSENIDE_BRONZE, 3, -2.4F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArsenicSwordItem> arsenide_gold_sword = ITEMS.register("arsenide_gold_sword",
            () -> new ArsenicSwordItem(ArsenicItemTier.ARSENIDE_GOLD, 3, -2.4F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArsenicSwordItem> tenebrium_sword = ITEMS.register("tenebrium_sword",
            () -> new ArsenicSwordItem(ArsenicItemTier.TENEBRIUM, 3, -2.4F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // axes
    public static final RegistryObject<ArsenicAxeItem> arsenic_axe = ITEMS.register("arsenic_axe",
            () -> new ArsenicAxeItem(ArsenicItemTier.ARSENIC, 7.0F, -3.1F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));    
    public static final RegistryObject<ArsenicAxeItem> arsenide_bronze_axe = ITEMS.register("arsenide_bronze_axe",
            () -> new ArsenicAxeItem(ArsenicItemTier.ARSENIDE_BRONZE, 7.0F, -3.1F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));    
    public static final RegistryObject<ArsenicAxeItem> arsenide_gold_axe = ITEMS.register("arsenide_gold_axe",
            () -> new ArsenicAxeItem(ArsenicItemTier.ARSENIDE_GOLD, 7.0F, -3.1F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));    
    public static final RegistryObject<ArsenicAxeItem> tenebrium_axe = ITEMS.register("tenebrium_axe",
            () -> new ArsenicAxeItem(ArsenicItemTier.TENEBRIUM, 7.0F, -3.1F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));    

    // pickaxes
    public static final RegistryObject<PickaxeItem> arsenic_pickaxe = ITEMS.register("arsenic_pickaxe",
            () -> new PickaxeItem(ArsenicItemTier.ARSENIC, 1, -2.8F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> arsenide_bronze_pickaxe = ITEMS.register("arsenide_bronze_pickaxe",
            () -> new PickaxeItem(ArsenicItemTier.ARSENIDE_BRONZE, 1, -2.8F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> arsenide_gold_pickaxe = ITEMS.register("arsenide_gold_pickaxe",
            () -> new PickaxeItem(ArsenicItemTier.ARSENIDE_GOLD, 1, -2.8F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> tenebrium_pickaxe = ITEMS.register("tenebrium_pickaxe",
            () -> new PickaxeItem(ArsenicItemTier.TENEBRIUM, 1, -2.8F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
   
    // shovels
    public static final RegistryObject<ShovelItem> arsenic_shovel = ITEMS.register("arsenic_shovel",
            () -> new ShovelItem(ArsenicItemTier.ARSENIC, 1.5F, -3.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> arsenide_bronze_shovel = ITEMS.register("arsenide_bronze_shovel",
            () -> new ShovelItem(ArsenicItemTier.ARSENIDE_BRONZE, 1.5F, -3.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> arsenide_gold_shovel = ITEMS.register("arsenide_gold_shovel",
            () -> new ShovelItem(ArsenicItemTier.ARSENIDE_GOLD, 1.5F, -3.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> tenebrium_shovel = ITEMS.register("tenebrium_shovel",
            () -> new ShovelItem(ArsenicItemTier.TENEBRIUM, 1.5F, -3.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // hoes
    public static final RegistryObject<HoeItem> arsenic_hoe = ITEMS.register("arsenic_hoe",
            () -> new HoeItem(ArsenicItemTier.ARSENIC, -1, -2.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> arsenide_bronze_hoe = ITEMS.register("arsenide_bronze_hoe",
            () -> new HoeItem(ArsenicItemTier.ARSENIDE_BRONZE, -1, -2.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> arsenide_gold_hoe = ITEMS.register("arsenide_gold_hoe",
            () -> new HoeItem(ArsenicItemTier.ARSENIDE_GOLD, -1, -2.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> tenebrium_hoe = ITEMS.register("tenebrium_hoe",
            () -> new HoeItem(ArsenicItemTier.TENEBRIUM, -1, -2.0F,
            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // ARMORS
    // old lace shroud
    public static final RegistryObject<ArmorItem> old_lace_chest = ITEMS.register("old_lace_chest",
            () -> new ArmorItem(ArsenicArmorMaterial.OLD_LACE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // arsenide bronze
    public static final RegistryObject<ArmorItem> arsenide_bronze_helmet = ITEMS.register("arsenide_bronze_helmet",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_BRONZE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> arsenide_bronze_leggings = ITEMS.register("arsenide_bronze_leggings",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_BRONZE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> arsenide_bronze_chestplate = ITEMS.register("arsenide_bronze_chestplate",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_BRONZE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> arsenide_bronze_boots = ITEMS.register("arsenide_bronze_boots",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_BRONZE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // arsenide gold
    public static final RegistryObject<ArmorItem> arsenide_gold_helmet = ITEMS.register("arsenide_gold_helmet",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_GOLD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> arsenide_gold_leggings = ITEMS.register("arsenide_gold_leggings",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_GOLD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> arsenide_gold_chestplate = ITEMS.register("arsenide_gold_chestplate",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_GOLD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> arsenide_gold_boots = ITEMS.register("arsenide_gold_boots",
            () -> new ArmorItem(ArsenicArmorMaterial.ARSENIDE_GOLD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // tenebrium
    public static final RegistryObject<ArmorItem> tenebrium_helmet = ITEMS.register("tenebrium_helmet",
            () -> new ArmorItem(ArsenicArmorMaterial.TENEBRIUM, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tenebrium_leggings = ITEMS.register("tenebrium_leggings",
            () -> new ArmorItem(ArsenicArmorMaterial.TENEBRIUM, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tenebrium_chestplate = ITEMS.register("tenebrium_chestplate",
            () -> new ArmorItem(ArsenicArmorMaterial.TENEBRIUM, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tenebrium_boots = ITEMS.register("tenebrium_boots",
            () -> new ArmorItem(ArsenicArmorMaterial.TENEBRIUM, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
} // end class
