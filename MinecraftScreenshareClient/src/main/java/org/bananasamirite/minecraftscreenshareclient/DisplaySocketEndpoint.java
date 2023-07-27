package org.bananasamirite.minecraftscreenshareclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;


import java.awt.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@ClientEndpoint
public class DisplaySocketEndpoint extends Endpoint {

    private final DisplayThread thread;

    public DisplaySocketEndpoint(DisplayThread thread) {
        this.thread = thread;
    }

    @OnMessage
    public void onMessage(Session sess, String message) {
        System.out.println("received message: " + message);
    }

    @Override
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println ("--- Connected " + session.getId());
        session.addMessageHandler(new MessageHandler.Whole<ByteBuffer>() {

            @Override
            public void onMessage(ByteBuffer buf) {
//                System.out.println("received buffer");
//                BufferedImage img = new BufferedImage(thread.getSizeX(), thread.getSizeY(), BufferedImage.TYPE_INT_ARGB);
//                List<Integer> data = new ArrayList<>();
////                System.out.println(data);
//                while (buf.hasRemaining()) {
//                    try {
//                        data.add(Byte.toUnsignedInt(buf.get()));
//                    } catch(Exception err) {
//                        err.printStackTrace();
//                    }
//                }
//
////        System.out.println("data size: " + data.size());
////        System.out.println("buff capacity: " + buf.capacity());
//
//                data.remove(data.size() - 1);
//
////        System.out.println(data);
//
//                int[] dataArr = data.stream().mapToInt(Integer::intValue).toArray();
////
////        System.out.println(Arrays.toString(dataArr));
//
////        thread.getInitializer().sendMessage("Received buffer");
////        thread.getInitializer().sendMessage("Buffer size: " + dataArr.length);
////        System.out.println(thread.getStartLocation());
////
//
////                System.out.println("thread width: " + thread.getSizeX()  + " " + thread.getSizeY());
////                System.out.println("img width: " + img.getWidth()  + " " + img.getHeight());
//                try {
//                    img.getRaster().setPixels(0, 0, thread.getSizeX(), thread.getSizeY(), dataArr);
//                } catch(Exception e) {
////                    e.printStackTrace();
//                }

//                try {
//                    ImageIO.write(img, "png", new File("./images/image.png"));
//                    System.out.println("written");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        thread.getInitializer().sendMessage("Rasterized image. Width: " + img.getWidth() + ". Height: " + img.getHeight() + ". ");


                final List<Runnable> fns = new ArrayList<>();

                for (int y = 0; y < thread.getSizeY(); y++) {
                    for (int x = 0; x < thread.getSizeX(); x++) {
                        int[] colorRGBA = new int[4];
                        for (int clr = 0; clr < 4; clr++) {

                            colorRGBA[clr] = Byte.toUnsignedInt(buf.get());
                            if (clr != 3) {
                                // not all colors fed
                                continue;
                            }

                            try {
                                if (colorRGBA[3] == 0)
                                    break; // alpha value is usually never 0, so imma use that as the indicator to switch

                                Color color = new Color(colorRGBA[0], colorRGBA[1], colorRGBA[2], colorRGBA[3]);

//                    System.out.println("color of x: " + x + ", y: " + y + " is " + clr + ", rgb val is: " + img.getRGB(x, y));

                                MaterialData mat = RGBBlockColor.getClosestBlockValue(color, true);
                                Location loc = thread.getStartLocation().clone().add(x, 0, y);
                                if (loc.getBlock().getType() != mat.getMaterial())
                                    fns.add(() -> loc.getBlock().setType(mat.getMaterial()));
                            } catch (Exception err) {
                                err.printStackTrace();
                            }
                        }
                    }
                }

                runRunnables(fns);
//                System.out.println("ended");
            }
        });

        session.addMessageHandler(new MessageHandler.Whole<String>() {
                                      @Override
                                      public void onMessage(String message) {
//                                          System.out.println("received message");
                                          ObjectMapper m = new ObjectMapper();
// """
//                    {"data": [[0, 0, 0, 0, 0, 1], [0, 0, 5, 6, 7, 255]]}"""
                                          PixelChangeData data = null;
                                          try {
                                              data = m.readValue(message, PixelChangeData.class);
                                          } catch (JsonProcessingException e) {
                                              e.printStackTrace();
                                          }

                                          if (data == null) return;

                                          final List<Runnable> fns = new ArrayList<>();
                                          for (PixelChangeData.PixelChange changedPixel : data.getData()) {
                                              Color color = new Color(changedPixel.getR(), changedPixel.getG(), changedPixel.getB(), changedPixel.getA());

//                    System.out.println("color of x: " + x + ", y: " + y + " is " + clr + ", rgb val is: " + img.getRGB(x, y));

                                              MaterialData mat = RGBBlockColor.getClosestBlockValue(color, true);
                                              Location loc = thread.getStartLocation().clone().add(changedPixel.getX(), 0, changedPixel.getY());
                                              fns.add(() -> loc.getBlock().setType(mat.getMaterial()));
                                          }

                                            runRunnables(fns);
                                      }
                                  });
//        try {
//            session.getBasicRemote().sendText("start");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @OnMessage
    public void onBuffer(byte[] buf, Session session) {

    }


    @OnMessage
    public void onString(String message, Session session) {
            System.out.println ("--- Received " + message);
    }

    @OnMessage
    public void onPong(PongMessage msg) {
        System.out.println(msg.getApplicationData());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("--- Session: " + session.getId());
        System.out.println("--- Closing because: " + closeReason);

        final List<Runnable> blocksToCleanup = new ArrayList<>();

        for (int x = 0; x < thread.getSizeX(); x++) {
            for (int y = 0; y < thread.getSizeY(); y++) {
                Location loc = thread.getStartLocation().clone().add(x, 0, y);
                blocksToCleanup.add(() -> loc.getBlock().setType(Material.AIR));
            }
        }

        runRunnables(blocksToCleanup);
    }

//    public static void main(String[] args) {
//        ClientManager client = ClientManager.createClient();
//        try {
//            URI uri = new URI("ws://localhost:8025/folder/app");
//            c
//            client.connectToServer(MyClientEndpoint.class, uri);
//            while(true) {}
//        } catch (DeploymentException | URISyntaxException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    private void runRunnables(List<Runnable> fns) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Runnable fn : fns) {
                    fn.run();
                }
            }
        }.runTask(MinecraftScreenshareClient.instance);
    }
}