package org.bananasamirite.minecraftscreenshareclient;

import org.bukkit.Location;

public class LocationUtils {
    public static boolean isLocationInLocations(Location loc1, Location loc2, Location loc3) {
        double lowestX = Math.min(loc1.getX(), loc2.getX());
        double highestX = Math.max(loc1.getX(), loc2.getX());
        double lowestZ = Math.min(loc1.getZ(), loc2.getZ());
        double highestZ = Math.max(loc1.getZ(), loc2.getZ());

        System.out.println("lowestX: " + lowestX);
        System.out.println("highestX: " + highestX);
        System.out.println("lowestZ: " + lowestZ);
        System.out.println("highestZ: " + highestZ);
        System.out.println(loc3.getX() > lowestX);
        System.out.println(loc3.getX() < highestX);
        System.out.println(loc3.getZ() > lowestZ);
        System.out.println(loc3.getZ() < highestZ);

        return loc3.getX() > lowestX && loc3.getX() < highestX
                && loc3.getZ() > lowestZ && loc3.getZ() < highestZ;
    }
}
