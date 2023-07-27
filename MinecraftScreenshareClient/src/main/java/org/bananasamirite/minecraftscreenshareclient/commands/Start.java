package org.bananasamirite.minecraftscreenshareclient.commands;

import org.bananasamirite.minecraftscreenshareclient.DisplayThread;
import org.bananasamirite.minecraftscreenshareclient.MinecraftScreenshareClient;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.URI;

public class Start implements CommandExecutor {
    private MinecraftScreenshareClient client;
    public Start(MinecraftScreenshareClient client) {
        this.client = client;
        this.client.getCommand("start").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage("You must be a player. ");
            return true;
        }

        String server = args[0];

        try {
            this.client.getDisplayThreadManager().createThread(server, p, p.getLocation());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }
}
