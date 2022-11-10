package me.drawethree.ultraprisontestenchant;

import dev.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import dev.drawethree.ultraprisoncore.enchants.model.UltraPrisonEnchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class representing your custom enchant. When creating custom enchants please make sure that your class extends 'UltraPrisonEnchantment'
 */
public final class TestEnchant extends UltraPrisonEnchantment {

    /**
     * Class attribute chance - Represent the chance of triggering the enchant
     */
    private double chance;

    /**
     * Constructor of your custom enchant. You can load any parameters after calling super() constructors. Make sure to include unique id!
     * Please make sure that enchants.yml config in UltraPrisonCore (not in this plugin) has this enchant properties in config!
     */
    public TestEnchant() {
        super(UltraPrisonEnchants.getInstance(), 99);
        this.chance = this.plugin.getEnchantsConfig().getYamlConfig().getDouble("enchants." + id + ".Chance");
    }

    /**
     * Overridden method what should be done when player equips pickaxe with this enchant
     *
     * @param p       Player who equipped
     * @param pickAxe ItemStack of pickaxe that is held in hand
     * @param level   level of enchant
     */
    @Override
    public void onEquip(Player p, ItemStack pickAxe, int level) {
        p.sendMessage("You have equipped a pickaxe with TestEnchant!");
    }

    /**
     * Overridden method what should be done when player un-equips pickaxe with this enchant
     *
     * @param p       Player who equipped
     * @param pickAxe ItemStack of pickaxe that is held in hand
     * @param level   level of enchant
     */
    @Override
    public void onUnequip(Player p, ItemStack pickAxe, int level) {
        p.sendMessage("You have unequipped a pickaxe with TestEnchant!");
    }


    /**
     * Overridden method what should be done when player breaks a block in mine with this enchant
     *
     * @param e            BlockBreakEvent
     * @param enchantLevel level of enchant
     */
    @Override
    public void onBlockBreak(BlockBreakEvent e, int enchantLevel) {
        if (this.chance * enchantLevel >= ThreadLocalRandom.current().nextDouble(100)) {
            e.getPlayer().sendMessage("You have triggered the enchant!");
        }
    }

    /**
     * This method is called when UltraPrisonCore is reloaded, it should reload every needed attribute from config.
     */
    @Override
    public void reload() {
        this.chance = this.plugin.getEnchantsConfig().getYamlConfig().getDouble("enchants." + id + ".Chance");
    }

    /**
     * Overridden method to get author who created this enchant.
     *
     * @return String - name of author
     */
    @Override
    public String getAuthor() {
        return "Drawethree";
    }
}