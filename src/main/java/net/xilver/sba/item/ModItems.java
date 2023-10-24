package net.xilver.sba.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xilver.sba.SBA;

public class ModItems {

    private static void addItemstoBuildingBlocksTabItemGroup(FabricItemGroupEntries entries) {

    }
    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier(SBA.MOD_ID, name), item);

    }

    public static void RegisterModItems() {

        SBA.LOGGER.info("Registering Mod Items for " + SBA.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemstoBuildingBlocksTabItemGroup);

    }

}
