package mod.akkamaddi.arsenic.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class ArsenicLootInjectorProvider extends LootTableInjectorProvider
{

    public ArsenicLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        
        // REQUIRED TABLES.
        // desert_pyramid injection table.
        LootPool.Builder foo = createChestPool(1,2, 0.75F)
            .add(ItemLootEntry.lootTableItem(ModItems.old_lace_chest.get()).setWeight(10))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_salt.get())
                    .setWeight(10)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_gold_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_gold_chestplate.get()).setWeight(1));
        addInjectionTable(ArsenicAndLace.MODID, "desert_pyramid", foo);
        
        // jungle_temple
        foo = createChestPool(1,1, 0.75F)
            .add(ItemLootEntry.lootTableItem(ModItems.old_lace_chest.get()).setWeight(10))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_salt.get())
                        .setWeight(10)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_gold_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_gold_boots.get()).setWeight(1));
        addInjectionTable(ArsenicAndLace.MODID, "jungle_temple", foo);
        
        // stronghold
        foo = createChestPool(1,1, 0.33F)
            .add(ItemLootEntry.lootTableItem(ModItems.old_lace_chest.get()).setWeight(1));
        addInjectionTable(ArsenicAndLace.MODID, "stronghold", foo);
        
        // OPTIONAL TABLES
        // abandoned mineshaft
        foo = createChestPool(1,1, 0.33F)
                .add(ItemLootEntry.lootTableItem(ModItems.orpiment.get())
                        .setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
            .add(ItemLootEntry.lootTableItem(ModItems.realgar.get())
                    .setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(ArsenicAndLace.MODID, "abandoned_mineshaft", foo);

        foo = createChestPool(1,1, 0.33F)
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_gold_ingot.get())
                        .setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(ArsenicAndLace.MODID, "shipwreck_treasure", foo);
        
        // simple dungeon
        foo = createChestPool(1,1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_gold_ingot.get())
                        .setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_ingot.get())
                    .setWeight(10)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 5))));
            addInjectionTable(ArsenicAndLace.MODID, "simple_dungeon", foo);
        
        // villagers
        foo = createChestPool(1, 1, 0.10F)
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_ingot.get()).setWeight(5)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(ArsenicAndLace.MODID, "village_armorer", foo);

        foo = createChestPool(1,1, 0.10F)
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_pickaxe.get()).setWeight(5))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_shovel.get()).setWeight(5))
            .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_ingot.get())
                    .setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(ArsenicAndLace.MODID, "village_toolsmith", foo);

        foo = createChestPool(1,1, 0.10F)
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_axe.get()).setWeight(5))
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_pickaxe.get()).setWeight(5))
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_sword.get()).setWeight(5))
                .add(ItemLootEntry.lootTableItem(ModItems.arsenide_bronze_ingot.get())
                        .setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(ArsenicAndLace.MODID, "village_weaponsmith", foo);
                
        return tables;
    } // end getTables()

} // end class
