package org.bananasamirite.minecraftscreenshareclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DisplayThreadManager {
    private final Map<UUID, DisplayThread> threads = new HashMap<>();

    public void createThread(String endpoint, Player initializer, Location start) throws IOException, InterruptedException {

        ObjectMapper m = new ObjectMapper();

        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
        HttpRequest req = HttpRequest.newBuilder(URI.create("http://" + endpoint).resolve("/info/")).GET().header("Content-Type", "application/json").build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        ServerInfo info = m.readValue(res.body(), ServerInfo.class);

        DisplayThread t = new DisplayThread(this, initializer, UUID.randomUUID(), URI.create("ws://" + endpoint), info.getSizeX(), info.getSizeY(), start);
        t.run();
        threads.put(t.getUuid(), t);
    }

    public void removeThread(UUID uuid) {
        threads.remove(uuid);
    }

    public Map<UUID, DisplayThread> getThreads() {
        return threads;
    }
}
