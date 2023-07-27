package org.bananasamirite.minecraftscreenshareclient.commands;

import org.bananasamirite.minecraftscreenshareclient.DisplayThread;
import org.bananasamirite.minecraftscreenshareclient.LocationUtils;
import org.bananasamirite.minecraftscreenshareclient.MinecraftScreenshareClient;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Stop implements CommandExecutor {
    private final MinecraftScreenshareClient client;
    public Stop(MinecraftScreenshareClient client) {
        this.client = client;
        this.client.getCommand("stop").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage("You must be a player. ");
            return true;
        }

            for (DisplayThread thread : this.client.getDisplayThreadManager().getThreads().values()) {
                System.out.println(thread.getStartLocation());
                System.out.println(thread.getEndLocation());
                if (LocationUtils.isLocationInLocations(thread.getStartLocation(), thread.getEndLocation(), p.getLocation())) {
                    try {
                        thread.stopThread();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    p.sendMessage("Stopped screenshare. ");
                    return true;
                }
            }
            p.sendMessage("Not in a screenshare zone");

        return true;
    }
}
