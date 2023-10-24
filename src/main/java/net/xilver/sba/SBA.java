package net.xilver.sba;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.village.VillagerProfession;
import net.xilver.sba.item.ModItems;
import net.xilver.sba.util.ModLootTableModifiers;
import net.xilver.sba.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SBA implements ModInitializer {
	public static final String MOD_ID = "sbaddons";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerModStuffs();
		ModItems.RegisterModItems();
	}
}