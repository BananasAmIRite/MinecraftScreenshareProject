package org.bananasamirite.minecraftscreenshareclient;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.function.IntFunction;

public class DisplaySocketListener implements WebSocket.Listener {

    private final DisplayThread thread;

    static int a = 0;

    public DisplaySocketListener(DisplayThread thread) {
        this.thread = thread;
    }
    @Override
    public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer buf, boolean last) {
        BufferedImage img = new BufferedImage(thread.getSizeX(), thread.getSizeY(), BufferedImage.TYPE_INT_ARGB);
        List<Integer> data = new ArrayList<>();
        while (buf.hasRemaining()) {
            try {
                data.add(Byte.toUnsignedInt(buf.get()));
            } catch(Exception err) {
                err.printStackTrace();
            }
        }

//        System.out.println(data);

        int[] dataArr = data.stream().mapToInt(Integer::intValue).toArray();
//
//        System.out.println(Arrays.toString(dataArr));

//        thread.getInitializer().sendMessage("Received buffer");
//        thread.getInitializer().sendMessage("Buffer size: " + dataArr.length);
//        System.out.println(thread.getStartLocation());
//
        try {
            img.getRaster().setPixels(0, 0, thread.getSizeX(), thread.getSizeY(), dataArr);
        } catch(Exception e) {

        }

//        try {
//            ImageIO.write(img, "png", new File("./images/image" + a + ".png"));
//            System.out.println("written");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        thread.getInitializer().sendMessage("Rasterized image. Width: " + img.getWidth() + ". Height: " + img.getHeight() + ". ");


        final List<Runnable> fns = new ArrayList<>();


        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                try {

                    Color clr = new Color(img.getRGB(x, y));

//                    System.out.println("color of x: " + x + ", y: " + y + " is " + clr + ", rgb val is: " + img.getRGB(x, y));

                    MaterialData mat = RGBBlockColor.getClosestBlockValue(clr, true);
                    Location loc = thread.getStartLocation().clone().add(x, 0, y);
                    fns.add(() -> loc.getBlock().setType(mat.getMaterial()));
                } catch(Exception err) {
                    err.printStackTrace();
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Runnable fn : fns) {
                    fn.run();
                }
            }
        }.runTask(MinecraftScreenshareClient.instance);
//        System.out.println("ended");
        webSocket.request(1);
        a++;
        return null;
//        return WebSocket.Listener.super.onBinary(webSocket, data, last);
    }

//    @Override
//    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
//        thread.getInitializer().sendMessage("Thread has stopped: " + reason);
//        thread.stopThread();
//        return null;
//    }
}
