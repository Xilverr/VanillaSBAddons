package net.xilver.sba.util;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.mixin.loot.table.LootTableMixin;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.LootTableProvider;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Weight;

public class ModLootTableModifiers {
    private static final Identifier WITHER_ID
            = new Identifier("minecraft","entities/wither");
    /*private static final Identifier BARTER
            = new Identifier("minecraft", "gameplay/piglin_bartering");*/


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            //checks for Wither Loot Table
            if(WITHER_ID.equals(id)) {
                //Adds Ancient Debris and End Portal Frames to the loot table
                LootPool.Builder ancientdebris = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Blocks.ANCIENT_DEBRIS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(ancientdebris.build());
                LootPool.Builder endportalframe = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Blocks.END_PORTAL_FRAME))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(endportalframe.build());
            }
            /*if(BARTER.equals(id)) {
                //Adds Netherrack to Bartering Trades
                LootPool.Builder netherrack = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally()
                        .with(ItemEntry.builder(Blocks.NETHERRACK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 8.0f)).build());
                tableBuilder.pool(netherrack.build());
            }*/

        });
    }
}
