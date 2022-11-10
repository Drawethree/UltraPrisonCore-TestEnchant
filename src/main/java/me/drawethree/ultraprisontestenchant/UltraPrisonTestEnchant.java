package me.drawethree.ultraprisontestenchant;

import dev.drawethree.ultraprisoncore.UltraPrisonCore;
import dev.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import dev.drawethree.ultraprisoncore.enchants.api.UltraPrisonEnchantsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of our plugin. Before creating a plugin, please make sure you have UltraPrisonCore and spigot in your classpath!
 */
public final class UltraPrisonTestEnchant extends JavaPlugin {

    private static final String UPC_PLUGIN_NAME = "UltraPrisonCore";

    private TestEnchant enchant;

    private UltraPrisonEnchantsAPI api;

    @Override
    public void onEnable() {

        // Check if we have UltraPrisonCore plugin enabled
        if (!Bukkit.getPluginManager().isPluginEnabled(UPC_PLUGIN_NAME)) {
            this.getLogger().warning("Unable to hook into UltraPrisonCore! Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        UltraPrisonCore ultraPrisonCore = UltraPrisonCore.getInstance();

        // Check if we have enchants module enabled
        if (!ultraPrisonCore.isModuleEnabled(UltraPrisonEnchants.MODULE_NAME)) {
            this.getLogger().warning("Enchants module is disabled! Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }


        // Get the API for Enchants module
        this.api = ultraPrisonCore.getEnchants().getApi();

        //Create new instance of our custom enchant
        this.enchant = new TestEnchant();

        //Register it via API
        this.api.registerEnchant(this.enchant);

        //You are done. Have fun with your custom enchants! :)

    }

    @Override
    public void onDisable() {
        // Unregistering of enchant when we disable the plugin
        this.api.unregisterEnchant(this.enchant);
    }
}
