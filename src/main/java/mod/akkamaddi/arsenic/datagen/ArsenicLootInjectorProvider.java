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
        
        // desert_pyramid injection table.
        LootPool.Builder foo = createChestPool(1,1, 0.25F)
                .addEntry(ItemLootEntry.builder(ModItems.old_lace_chest.get()).weight(1));
        addInjectionTable(ArsenicAndLace.MODID, "desert_pyramid", foo);
        
        // jungle_temple
        foo = createChestPool(1,1, 0.25F)
                .addEntry(ItemLootEntry.builder(ModItems.old_lace_chest.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.arsenide_salt.get())
                            .weight(3)
                            .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))));
        addInjectionTable(ArsenicAndLace.MODID, "jungle_temple", foo);
        return tables;
    }

} // end class
