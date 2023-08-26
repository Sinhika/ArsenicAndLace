package mod.akkamaddi.arsenic.datagen;

import java.util.function.BiConsumer;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ArsenicLootInjectorSubprovider extends LootTableInjectorProvider
{

    @Override
    public void generate(BiConsumer<ResourceLocation, Builder> bar) 
    {
        
        // REQUIRED TABLES.
        // desert_pyramid injection table.
        LootPool.Builder foo = createChestPool(1,2, 0.75F)
            .add(LootItem.lootTableItem(ModItems.old_lace_chest.get()).setWeight(10))
            .add(LootItem.lootTableItem(ModItems.arsenide_salt.get())
                    .setWeight(10)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.arsenide_gold_helmet.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.arsenide_gold_chestplate.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "desert_pyramid"), foo);
        
        // jungle_temple
        foo = createChestPool(1,1, 0.75F)
            .add(LootItem.lootTableItem(ModItems.old_lace_chest.get()).setWeight(10))
            .add(LootItem.lootTableItem(ModItems.arsenide_salt.get())
                        .setWeight(10)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.arsenide_gold_leggings.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.arsenide_gold_boots.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "jungle_temple"), foo);
        
        // stronghold
        foo = createChestPool(1,1, 0.33F)
            .add(LootItem.lootTableItem(ModItems.old_lace_chest.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "stronghold"), foo);
        
        // OPTIONAL TABLES
        // abandoned mineshaft
        foo = createChestPool(1,1, 0.33F)
                .add(LootItem.lootTableItem(ModItems.orpiment.get())
                        .setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
            .add(LootItem.lootTableItem(ModItems.realgar.get())
                    .setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "abandoned_mineshaft"), foo);

        foo = createChestPool(1,1, 0.33F)
                .add(LootItem.lootTableItem(ModItems.arsenide_gold_ingot.get())
                        .setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "shipwreck_treasure"), foo);
        
        // simple dungeon
        foo = createChestPool(1,1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.arsenide_gold_ingot.get())
                        .setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.arsenide_bronze_ingot.get())
                    .setWeight(10)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))));
            addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "simple_dungeon"), foo);
        
        // villagers
        foo = createChestPool(1, 1, 0.10F)
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_helmet.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_chestplate.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_leggings.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_boots.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_ingot.get()).setWeight(5)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "village_armorer"), foo);

        foo = createChestPool(1,1, 0.10F)
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_pickaxe.get()).setWeight(5))
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_shovel.get()).setWeight(5))
            .add(LootItem.lootTableItem(ModItems.arsenide_bronze_ingot.get())
                    .setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "village_toolsmith"), foo);

        foo = createChestPool(1,1, 0.10F)
                .add(LootItem.lootTableItem(ModItems.arsenide_bronze_axe.get()).setWeight(5))
                .add(LootItem.lootTableItem(ModItems.arsenide_bronze_pickaxe.get()).setWeight(5))
                .add(LootItem.lootTableItem(ModItems.arsenide_bronze_sword.get()).setWeight(5))
                .add(LootItem.lootTableItem(ModItems.arsenide_bronze_ingot.get())
                        .setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(ArsenicAndLace.MODID, "village_weaponsmith"), foo);
                

    } // end getTables()

} // end class
