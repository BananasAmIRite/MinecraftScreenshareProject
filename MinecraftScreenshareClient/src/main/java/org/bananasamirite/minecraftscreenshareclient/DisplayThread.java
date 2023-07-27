package org.bananasamirite.minecraftscreenshareclient;

import jakarta.websocket.ClientEndpointConfig;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.glassfish.tyrus.client.ClientManager;

import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;
import org.glassfish.tyrus.core.AnnotatedEndpoint;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

public class DisplayThread implements Runnable {

    private final DisplayThreadManager manager;
    private final Player initializer;
    private final UUID uuid;
    private final URI server;
    private final int sizeX;
    private final int sizeY;
    private final Location startLocation;
    private final World world;
    private Session session;

    private boolean isRunning = false;

    public DisplayThread(DisplayThreadManager manager, Player initializer, UUID uuid, URI server, int sizeX, int sizeY, Location start) {
        this.manager = manager;
        this.initializer = initializer;
        this.uuid = uuid;
        this.server = server;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.startLocation = start;
        this.world = start.getWorld();
    }

    @Override
    public void run() {
//        HttpClient client = HttpClient.newHttpClient();
//        WebSocket.Builder builder = client.newWebSocketBuilder();
//        initializer.sendMessage("Starting socket...");
//        Future<WebSocket> socket = builder.buildAsync(server, new DisplaySocketListener(this));
//        try {
//            WebSocket s = socket.get();
//            initializer.sendMessage("Socket started. ");
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        Thread.currentThread().setContextClassLoader(WebSocketContainer.class.getClassLoader());
        WebSocketContainer c = ContainerProvider.getWebSocketContainer();
        try {
            this.session = c.connectToServer(new DisplaySocketEndpoint(this), ClientEndpointConfig.Builder.create().build(), this.server);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stopThread() throws IOException {
        isRunning = false;
        this.session.close();
        this.manager.removeThread(this.uuid);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public World getWorld() {
        return world;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return startLocation.clone().add(sizeX, 0, sizeY);
    }

    public Player getInitializer() {
        return initializer;
    }

    public UUID getUuid() {
        return uuid;
    }
}
