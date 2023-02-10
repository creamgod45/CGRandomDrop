package cg.creamgod45;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CGRandomDrop extends JavaPlugin {

    public static Logger logger;
    public static CGRandomDrop plugin;

    @Override
    public void onEnable() {
        plugin = this;
        logger = getServer().getLogger();
        getServer().getPluginManager().registerEvents(new Event(), this);
        Utils.ConsoleInfoPrint("&b&mCGRandomDrop | System.Online");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Utils.ConsoleInfoPrint("&b&mCGRandomDrop | System.Offline");
    }
}
