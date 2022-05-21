package mod.akkamaddi.arsenic.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

public class ArsenicLootTableProvider extends BlockLootTableProvider
{

    public ArsenicLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.arsenic_block.get());
        standardDropTable(ModBlocks.raw_arsenic_block.get());
        standardDropTable(ModBlocks.arsenide_bronze_block.get());
        standardDropTable(ModBlocks.arsenide_gold_block.get());
        standardDropTable(ModBlocks.tenebrium_block.get());
        standardDropTable(ModBlocks.arsenic_plate.get());
        specialDropTable(ModBlocks.arsenic_ore_stone.get(), ModItems.raw_arsenic.get());
        specialDropTable(ModBlocks.arsenic_ore_deepslate.get(), ModItems.raw_arsenic.get());
        return tables;
    }

} // end class
