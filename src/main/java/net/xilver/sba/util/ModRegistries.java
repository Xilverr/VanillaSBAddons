package net.xilver.sba.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCustomTrades();
    }
    private static void registerCustomTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(

                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.BAMBOO,1),
                            6, 2, 0.02f));
                });
    }

}
