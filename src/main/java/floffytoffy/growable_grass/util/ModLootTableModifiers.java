package floffytoffy.growable_grass.util;

import floffytoffy.growable_grass.register.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;


public class ModLootTableModifiers {
private static final Identifier SHORT_GRASS_BLOCK_ID = Identifier.of("minecraft", "blocks/short_grass");
private static final Identifier BROWN_MUSHROOM_BLOCK_ID = Identifier.of("minecraft", "blocks/brown_mushroom");
    private static final Identifier RED_MUSHROOM_BLOCK_ID = Identifier.of("minecraft", "blocks/red_mushroom");
    private static final Identifier BERRY_BUSH_BLOCK_ID = Identifier.of("minecraft", "blocks/sweet_berry_bush");
    private static final Identifier CRIMSON_ROOTS_BLOCK_ID = Identifier.of("minecraft", "blocks/crimson_roots");
    private static final Identifier WARPED_ROOTS_BLOCK_ID = Identifier.of("minecraft", "blocks/warped_roots");

    public static void modifyLootTables() {
        ModLootTableModifiers.register(RED_MUSHROOM_BLOCK_ID, ModItems.MYCELIUM_FIBRES, .25f, 1, 0.0f, 4.0f);
        ModLootTableModifiers.register(BROWN_MUSHROOM_BLOCK_ID, ModItems.MYCELIUM_FIBRES, .25f, 1, 0.0f, 4.0f);
        ModLootTableModifiers.register(SHORT_GRASS_BLOCK_ID, ModItems.GRASS_SEEDS, .2f, 1, 0.0f, 2.0f);
        ModLootTableModifiers.register(BERRY_BUSH_BLOCK_ID, ModItems.PODZOL_FIBRES, .2f, 1, 0.0f, 2.0f);
        ModLootTableModifiers.register(CRIMSON_ROOTS_BLOCK_ID, ModItems.CRIMSON_FIBRES, .2f, 1, 0.0f, 2.0f);
        ModLootTableModifiers.register(WARPED_ROOTS_BLOCK_ID, ModItems.WARPED_FIBRES, .2f, 1, 0.0f, 2.0f);
    }

    public static void register(Identifier identifier, Item item, float chance, int rolls, float minCount, float maxCount){
        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (identifier.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(rolls))
                        .conditionally(RandomChanceLootCondition.builder(chance)) //1=100%
                        .with(ItemEntry.builder(item))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount))
                                .build());
                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
