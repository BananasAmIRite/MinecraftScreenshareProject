package org.bananasamirite.minecraftscreenshareclient;

import org.bananasamirite.minecraftscreenshareclient.commands.Start;
import org.bananasamirite.minecraftscreenshareclient.commands.Stop;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftScreenshareClient extends JavaPlugin {

    private final DisplayThreadManager displayThreadManager;

    public static MinecraftScreenshareClient instance;

    public MinecraftScreenshareClient() {
        this.displayThreadManager = new DisplayThreadManager();
        instance = this;

        RGBBlockColor.activateColoredBlocks();
    }

    public DisplayThreadManager getDisplayThreadManager() {
        return displayThreadManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        new Start(this);
        new Stop(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void main(String[] args) {}
}
