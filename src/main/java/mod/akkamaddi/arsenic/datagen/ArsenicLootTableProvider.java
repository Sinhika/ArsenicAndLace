package mod.akkamaddi.arsenic.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.ResourceLocation;

public class ArsenicLootTableProvider extends BlockLootTableProvider
{

    public ArsenicLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.arsenic_block.get());
        standardDropTable(ModBlocks.arsenide_bronze_block.get());
        standardDropTable(ModBlocks.arsenide_gold_block.get());
        standardDropTable(ModBlocks.tenebrium_block.get());
        standardDropTable(ModBlocks.arsenic_plate.get());
        
        return tables;
    }

} // end class
