/*
 *  Copyright (C) 2017 Zombie_Striker
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU General Public License as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program;
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307 USA
 */
package org.bananasamirite.minecraftscreenshareclient;

import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.*;

/**
 * Created by Zombie_Striker on 3/30/2016
 **/
public class RGBBlockColor {

    public static Map<MaterialData, RGBBlockValue> materialValue = new HashMap<>();

    public static RGBValue getRGBFromMatData(MaterialData m) {
        return getRGBFromMatData(m, false);
    }

    public static RGBValue getRGBFromMatData(MaterialData m, boolean topView) {
        for (MaterialData h : materialValue.keySet()) {
            if (h.getMaterial() == m.getMaterial()
                    && h.getData() == m.getData())
                return materialValue.get(h);
        }
        return null;
    }

    public static void activatePureBlocks() {
        if (!isVersionHigherThan(1, 12)) {
            new RGBBlockValue(new Color(23, 19, 19), Material.BLACK_WOOL);
            new RGBBlockValue(new Color(43, 53, 133),  Material.BLUE_WOOL);
            new RGBBlockValue(new Color(76, 48, 30), Material.BROWN_WOOL);
            new RGBBlockValue(new Color(49, 116, 143), Material.CYAN_WOOL);
            new RGBBlockValue(new Color(61, 61, 61), Material.GRAY_WOOL);
            new RGBBlockValue(new Color(55, 72, 28), Material.GREEN_WOOL);
            new RGBBlockValue(new Color(113, 143, 203), Material.LIGHT_BLUE_WOOL);
            new RGBBlockValue(new Color(66, 180, 58), Material.LIME_WOOL);
            new RGBBlockValue(new Color(184, 83, 193), Material.MAGENTA_WOOL);
            new RGBBlockValue(new Color(221, 129, 67), Material.ORANGE_WOOL);
            new RGBBlockValue(new Color(210, 128, 158), Material.PINK_WOOL);
            new RGBBlockValue(new Color(130, 62, 188), Material.PURPLE_WOOL);
            new RGBBlockValue(new Color(157, 56, 51), Material.RED_WOOL);
            new RGBBlockValue(new Color(162, 168, 168), Material.LIGHT_GRAY_WOOL);
            new RGBBlockValue(new Color(232, 231, 231), Material.WHITE_WOOL);
            new RGBBlockValue(new Color(188, 176, 42), Material.YELLOW_WOOL);
        } else {
            new RGBBlockValue(new Color(22, 22, 27), Material.BLACK_WOOL);
            new RGBBlockValue(new Color(53, 57, 158), Material.BLUE_WOOL);
            new RGBBlockValue(new Color(116, 73, 41), Material.BROWN_WOOL);
            new RGBBlockValue(new Color(21, 138, 146), Material.CYAN_WOOL);
            new RGBBlockValue(new Color(63, 68, 72), Material.GRAY_WOOL);
            new RGBBlockValue(new Color(85, 109, 28), Material.GREEN_WOOL);
            new RGBBlockValue(new Color(58, 175, 217), Material.LIGHT_BLUE_WOOL);
            new RGBBlockValue(new Color(111, 184, 26), Material.LIME_WOOL);
            new RGBBlockValue(new Color(189, 69, 190),Material.MAGENTA_WOOL);
            new RGBBlockValue(new Color(241, 118, 19), Material.ORANGE_WOOL);
            new RGBBlockValue(new Color(239, 141, 172), Material.PINK_WOOL);
            new RGBBlockValue(new Color(122, 42, 172), Material.PURPLE_WOOL);
            new RGBBlockValue(new Color(161, 40, 35), Material.RED_WOOL);
            new RGBBlockValue(new Color(142, 142, 135), Material.LIGHT_GRAY_WOOL);
            new RGBBlockValue(new Color(232, 235, 235), Material.WHITE_WOOL);
            new RGBBlockValue(new Color(249, 196, 38), Material.YELLOW_WOOL);

        }
        new RGBBlockValue(new Color(9, 11, 16), Material.BLACK_CONCRETE);
        new RGBBlockValue(new Color(45, 47, 144), Material.BLUE_CONCRETE);
        new RGBBlockValue(new Color(97, 60, 32), Material.BROWN_CONCRETE);
        new RGBBlockValue(new Color(22, 119, 136), Material.CYAN_CONCRETE);
        new RGBBlockValue(new Color(55, 58, 62), Material.GRAY_CONCRETE);
        new RGBBlockValue(new Color(72, 92, 37), Material.GREEN_CONCRETE);
        new RGBBlockValue(new Color(36, 137, 199), Material.LIGHT_BLUE_CONCRETE);
        new RGBBlockValue(new Color(94, 169, 25), Material.LIME_CONCRETE);
        new RGBBlockValue(new Color(170, 49, 160), Material.MAGENTA_CONCRETE);
        new RGBBlockValue(new Color(225, 97, 1), Material.ORANGE_CONCRETE);
        new RGBBlockValue(new Color(214, 102, 143), Material.PINK_CONCRETE);
        new RGBBlockValue(new Color(101, 32, 157), Material.PURPLE_CONCRETE);
        new RGBBlockValue(new Color(143, 33, 33), Material.RED_CONCRETE);
        new RGBBlockValue(new Color(125, 125, 115), Material.LIGHT_GRAY_CONCRETE);
        new RGBBlockValue(new Color(207, 213, 214), Material.WHITE_CONCRETE);
        new RGBBlockValue(new Color(241, 176, 22), Material.YELLOW_CONCRETE);
    }

    public static void activateColoredBlocks() {
//        new RGBBlockValue(new Color(19, 19, 19), "COAL_BLOCK");
//        new RGBBlockValue(new Color(159, 165, 177), "CLAY");
//        new RGBBlockValue(new Color(134, 96, 67), "DIRT");
//        new RGBBlockValue(new Color(81, 217, 117), "EMERALD_BLOCK");
//        new RGBBlockValue(new Color(219, 219, 219), "IRON_BLOCK");
        if (!isVersionHigherThan(1, 12)) {
            new RGBBlockValue(new Color(23, 19, 19), Material.BLACK_WOOL);
            new RGBBlockValue(new Color(43, 53, 133),  Material.BLUE_WOOL);
            new RGBBlockValue(new Color(76, 48, 30), Material.BROWN_WOOL);
            new RGBBlockValue(new Color(49, 116, 143), Material.CYAN_WOOL);
            new RGBBlockValue(new Color(61, 61, 61), Material.GRAY_WOOL);
            new RGBBlockValue(new Color(55, 72, 28), Material.GREEN_WOOL);
            new RGBBlockValue(new Color(113, 143, 203), Material.LIGHT_BLUE_WOOL);
            new RGBBlockValue(new Color(66, 180, 58), Material.LIME_WOOL);
            new RGBBlockValue(new Color(184, 83, 193), Material.MAGENTA_WOOL);
            new RGBBlockValue(new Color(221, 129, 67), Material.ORANGE_WOOL);
            new RGBBlockValue(new Color(210, 128, 158), Material.PINK_WOOL);
            new RGBBlockValue(new Color(130, 62, 188), Material.PURPLE_WOOL);
            new RGBBlockValue(new Color(157, 56, 51), Material.RED_WOOL);
            new RGBBlockValue(new Color(162, 168, 168), Material.LIGHT_GRAY_WOOL);
            new RGBBlockValue(new Color(232, 231, 231), Material.WHITE_WOOL);
            new RGBBlockValue(new Color(188, 176, 42), Material.YELLOW_WOOL);
        } else {
            new RGBBlockValue(new Color(22, 22, 27), Material.BLACK_WOOL);
            new RGBBlockValue(new Color(53, 57, 158), Material.BLUE_WOOL);
            new RGBBlockValue(new Color(116, 73, 41), Material.BROWN_WOOL);
            new RGBBlockValue(new Color(21, 138, 146), Material.CYAN_WOOL);
            new RGBBlockValue(new Color(63, 68, 72), Material.GRAY_WOOL);
            new RGBBlockValue(new Color(85, 109, 28), Material.GREEN_WOOL);
            new RGBBlockValue(new Color(58, 175, 217), Material.LIGHT_BLUE_WOOL);
            new RGBBlockValue(new Color(111, 184, 26), Material.LIME_WOOL);
            new RGBBlockValue(new Color(189, 69, 190),Material.MAGENTA_WOOL);
            new RGBBlockValue(new Color(241, 118, 19), Material.ORANGE_WOOL);
            new RGBBlockValue(new Color(239, 141, 172), Material.PINK_WOOL);
            new RGBBlockValue(new Color(122, 42, 172), Material.PURPLE_WOOL);
            new RGBBlockValue(new Color(161, 40, 35), Material.RED_WOOL);
            new RGBBlockValue(new Color(142, 142, 135), Material.LIGHT_GRAY_WOOL);
            new RGBBlockValue(new Color(232, 235, 235), Material.WHITE_WOOL);
            new RGBBlockValue(new Color(249, 196, 38), Material.YELLOW_WOOL);

        }
        new RGBBlockValue(new Color(9, 11, 16), Material.BLACK_CONCRETE);
        new RGBBlockValue(new Color(45, 47, 144), Material.BLUE_CONCRETE);
        new RGBBlockValue(new Color(97, 60, 32), Material.BROWN_CONCRETE);
        new RGBBlockValue(new Color(22, 119, 136), Material.CYAN_CONCRETE);
        new RGBBlockValue(new Color(55, 58, 62), Material.GRAY_CONCRETE);
        new RGBBlockValue(new Color(72, 92, 37), Material.GREEN_CONCRETE);
        new RGBBlockValue(new Color(36, 137, 199), Material.LIGHT_BLUE_CONCRETE);
        new RGBBlockValue(new Color(94, 169, 25), Material.LIME_CONCRETE);
        new RGBBlockValue(new Color(170, 49, 160), Material.MAGENTA_CONCRETE);
        new RGBBlockValue(new Color(225, 97, 1), Material.ORANGE_CONCRETE);
        new RGBBlockValue(new Color(214, 102, 143), Material.PINK_CONCRETE);
        new RGBBlockValue(new Color(101, 32, 157), Material.PURPLE_CONCRETE);
        new RGBBlockValue(new Color(143, 33, 33), Material.RED_CONCRETE);
        new RGBBlockValue(new Color(125, 125, 115), Material.LIGHT_GRAY_CONCRETE);
        new RGBBlockValue(new Color(207, 213, 214), Material.WHITE_CONCRETE);
        new RGBBlockValue(new Color(241, 176, 22), Material.YELLOW_CONCRETE);

        new RGBBlockValue(new Color(170, 92, 51), Material.ACACIA_PLANKS);// Accacia
        new RGBBlockValue(new Color(61, 40, 18), Material.DARK_OAK_PLANKS);// Dark oak
        new RGBBlockValue(new Color(196, 179, 123), Material.BIRCH_PLANKS);// birch
        new RGBBlockValue(new Color(154, 111, 77), Material.JUNGLE_PLANKS);// jungle
        new RGBBlockValue(new Color(157, 128, 79), Material.OAK_PLANKS);// oak
        new RGBBlockValue(new Color(104, 78, 47), Material.SPRUCE_PLANKS);// spruce
    }

    public static void activateBlocks() {

        new RGBBlockValue(new Color(85, 85, 85), new Color(85, 85, 85),
                new Color(76, 76, 76), new Color(91, 91, 91), "BEDROCK");
        new RGBBlockValue(new Color(117, 211, 215), "BEACON");
//        new RGBBlockValue(new Color(148, 104, 86), "BRICK");
        new RGBBlockValue(new Color(110, 89, 65), new Color(103, 94, 51),
                new Color(119, 71, 40), new Color(99, 96, 70), "BOOKSHELF",
                false);
        // new RGBBlockValue(new Color(56, 56, 56), Material.CAULDRON);
        // Causes see through glitch when placed
        new RGBBlockValue(new Color(115, 93, 59), new Color(112, 92, 64),
                new Color(118, 97, 63), new Color(109, 102, 74), "WORKBENCH",
                false);
        new RGBBlockValue(new Color(109, 73, 44), "WORKBENCH", true);
        // new RGBBlockValue(new Color(13, 96, 23), "CACTUS");// breaks
        new RGBBlockValue(new Color(19, 19, 19), "COAL_BLOCK");
        new RGBBlockValue(new Color(115, 115, 115), "COAL_ORE");
        new RGBBlockValue(new Color(159, 165, 177), "CLAY");
        new RGBBlockValue(new Color(228, 206, 207), "CAKE_BLOCK", true);
        new RGBBlockValue(new Color(123, 123, 123), "COBBLESTONE");
        new RGBBlockValue(new Color(170, 132, 110), new Color(165, 131, 113),
                new Color(166, 131, 115), new Color(157, 127, 115), "COMMAND");
        new RGBBlockValue(new Color(105, 126, 105), new Color(105, 123, 105),
                new Color(103, 121, 103), new Color(100, 118, 100),
                "MOSSY_COBBLESTONE");
//        new RGBBlockValue(new Color(133, 118, 96), "DAYLIGHT_DETECTOR", true);
//        new RGBBlockValue(new Color(105, 109, 113),
//                "DAYLIGHT_DETECTOR_INVERTED", true);
        new RGBBlockValue(new Color(109, 221, 215), new Color(105, 222, 216),
                new Color(122, 227, 222), new Color(80, 215, 208),
                "DIAMOND_BLOCK");
        new RGBBlockValue(new Color(132, 140, 144), new Color(130, 140, 144),
                new Color(128, 139, 142), new Color(131, 150, 154),
                "DIAMOND_ORE");
        new RGBBlockValue(new Color(161, 161, 161), "DOUBLE_STEP", 8);
        new RGBBlockValue(new Color(134, 96, 67), "DIRT");
        new RGBBlockValue(new Color(81, 217, 117), "EMERALD_BLOCK");
        new RGBBlockValue(new Color(109, 131, 117), new Color(110, 130, 117),
                new Color(110, 129, 116), new Color(107, 130, 114),
                "EMERALD_ORE");
        new RGBBlockValue(new Color(220, 222, 164), "ENDER_STONE");
        // new RGBBlockValue(new Color(104, 55, 51),
        // Material.ENCHANTMENT_TABLE,true);
        new RGBBlockValue(new Color(84, 111, 91), "ENDER_PORTAL_FRAME", true);
        new RGBBlockValue(new Color(104, 104, 104), new Color(103, 103, 103),
                new Color(133, 133, 133), new Color(131, 131, 131), "FURNACE",
                false);
        new RGBBlockValue(new Color(100, 100, 100), "FURNACE", true);
        new RGBBlockValue(new Color(119, 122, 73), new Color(155, 127, 76),
                new Color(144, 120, 73), new Color(130, 106, 59), "GLOWSTONE");
        new RGBBlockValue(new Color(249, 239, 83), new Color(250, 241, 74),
                new Color(252, 245, 92), new Color(251, 230, 71), "GOLD_BLOCK");
        new RGBBlockValue(new Color(144, 142, 128), new Color(144, 140, 128),
                new Color(142, 139, 124), new Color(154, 147, 124), "GOLD_ORE");
//        new RGBBlockValue(new Color(127, 124, 123), "GRAVEL");
        new RGBBlockValue(new Color(150, 90, 67), "HARD_CLAY");
        new RGBBlockValue(new Color(136, 131, 127), "IRON_ORE");
        new RGBBlockValue(new Color(37, 23, 16), Material.BLACK_TERRACOTTA);
        new RGBBlockValue(new Color(75, 61, 92), Material.BLUE_TERRACOTTA);
        new RGBBlockValue(new Color(78, 52, 36), Material.BROWN_TERRACOTTA);
        new RGBBlockValue(new Color(86, 90, 91), Material.CYAN_TERRACOTTA);
        new RGBBlockValue(new Color(58, 42, 36), Material.GRAY_TERRACOTTA);
        new RGBBlockValue(new Color(75, 82, 42), Material.GREEN_TERRACOTTA);
        new RGBBlockValue(new Color(114, 109, 138), Material.LIGHT_BLUE_TERRACOTTA);
        new RGBBlockValue(new Color(100, 116, 51), Material.LIME_TERRACOTTA);
        new RGBBlockValue(new Color(148, 86, 108), Material.MAGENTA_TERRACOTTA);
        new RGBBlockValue(new Color(163, 85, 39), Material.ORANGE_TERRACOTTA);
        new RGBBlockValue(new Color(160, 77, 78), Material.PINK_TERRACOTTA);
        new RGBBlockValue(new Color(115, 68, 84), Material.PURPLE_TERRACOTTA);
        new RGBBlockValue(new Color(142, 59, 45), Material.RED_TERRACOTTA);
        new RGBBlockValue(new Color(136, 107, 98), Material.LIGHT_GRAY_TERRACOTTA);
        new RGBBlockValue(new Color(210, 178, 161), Material.WHITE_TERRACOTTA);
        new RGBBlockValue(new Color(190, 136, 36), Material.YELLOW_TERRACOTTA);
        new RGBBlockValue(new Color(204, 172, 122), new Color(203, 171, 121),
                new Color(202, 171, 121), new Color(203, 172, 121),
                "HUGE_MUSHROOM_1"); // / inside brown
        new RGBBlockValue(new Color(142, 107, 83), "HUGE_MUSHROOM_1", 1);
        new RGBBlockValue(new Color(208, 204, 194), "HUGE_MUSHROOM_2");
        new RGBBlockValue(new Color(183, 38, 36), "HUGE_MUSHROOM_2", 1);
        new RGBBlockValue(new Color(219, 219, 219), "IRON_BLOCK");
        new RGBBlockValue(new Color(101, 68, 51), "JUKEBOX", false);
        new RGBBlockValue(new Color(107, 73, 55), "JUKEBOX", true);
        new RGBBlockValue(new Color(41, 77, 153), new Color(39, 68, 138),
                new Color(39, 65, 138), new Color(38, 61, 126), "LAPIS_BLOCK");
        new RGBBlockValue(new Color(104, 116, 139), new Color(108, 116, 132),
                new Color(95, 106, 136), new Color(95, 109, 138), "LAPIS_ORE");
        new RGBBlockValue(new Color(105, 99, 89), Material.ACACIA_LOG);// Accacia
        new RGBBlockValue(new Color(51, 41, 23), Material.DARK_OAK_LOG);// darkoak
        new RGBBlockValue(new Color(206, 205, 200), new Color(215, 215, 210),
                new Color(214, 215, 209), new Color(200, 199, 195), "BIRCH_LOG");// birch
        new RGBBlockValue(new Color(87, 68, 27), Material.JUNGLE_LOG);// jungle
        new RGBBlockValue(new Color(102, 81, 50), Material.OAK_LOG);// oak
        new RGBBlockValue(new Color(46, 29, 12), Material.SPRUCE_LOG);// spruce
        new RGBBlockValue(new Color(138, 144, 36), new Color(144, 149, 37),
                new Color(139, 144, 36), new Color(144, 148, 37),
                "MELON_BLOCK", false);
        new RGBBlockValue(new Color(150, 152, 37), "MELON_BLOCK", true);
        new RGBBlockValue(new Color(102, 89, 89), new Color(98, 81, 77),
                new Color(126, 91, 64), new Color(125, 90, 63), "MYCEL", false);
        new RGBBlockValue(new Color(111, 100, 106), "MYCEL", true);
//        new RGBBlockValue(new Color(45, 23, 27), "NETHER_BRICK");
        new RGBBlockValue(new Color(120, 62, 60), new Color(111, 53, 52),
                new Color(109, 52, 51), new Color(107, 52, 49), "NETHERRACK");
        new RGBBlockValue(new Color(123, 88, 57), "DIRT", 2);
        new RGBBlockValue(new Color(20, 18, 30), "OBSIDIAN");
        new RGBBlockValue(new Color(152, 127, 86), "PISTON_BASE", 1);
        new RGBBlockValue(new Color(138, 147, 99), new Color(139, 146, 98),
                new Color(140, 149, 100), new Color(144, 145, 98),
                "PISTON_STICKY_BASE", 1);
        new RGBBlockValue(new Color(134, 108, 108), new Color(133, 108, 108),
                new Color(131, 104, 104), new Color(137, 102, 102),
                "REDSTONE_ORE");
        new RGBBlockValue(new Color(170, 92, 51), Material.ACACIA_PLANKS);// Accacia
        new RGBBlockValue(new Color(61, 40, 18), Material.DARK_OAK_PLANKS);// Dark oak
        new RGBBlockValue(new Color(196, 179, 123), Material.BIRCH_PLANKS);// birch
        new RGBBlockValue(new Color(154, 111, 77), Material.JUNGLE_PLANKS);// jungle
        new RGBBlockValue(new Color(157, 128, 79), Material.OAK_PLANKS);// oak
        new RGBBlockValue(new Color(104, 78, 47), Material.SPRUCE_PLANKS);// spruce
        new RGBBlockValue(new Color(190, 118, 22), "PUMPKIN", true);
        new RGBBlockValue(new Color(232, 228, 220), "QUARTZ_BLOCK", 0);
        new RGBBlockValue(new Color(137, 99, 98), new Color(130, 91, 86),
                new Color(129, 87, 82), new Color(114, 75, 71), "QUARTZ_ORE");
        new RGBBlockValue(new Color(70, 44, 27), "REDSTONE_LAMP_OFF");
        new RGBBlockValue(new Color(119, 89, 55), "REDSTONE_LAMP_ON"); // ==
        new RGBBlockValue(new Color(217, 210, 157), "SANDSTONE", false); // rough
        new RGBBlockValue(new Color(216, 208, 157), "SANDSTONE", true); // rough
        new RGBBlockValue(new Color(220, 212, 162), "SANDSTONE", 2, false); // smooth
        new RGBBlockValue(new Color(240, 251, 251), "SNOW_BLOCK");//
        new RGBBlockValue(new Color(82, 62, 50), new Color(83, 63, 50),
                new Color(88, 68, 55), new Color(87, 67, 54), "SOUL_SAND");
        new RGBBlockValue(new Color(195, 196, 85), "SPONGE");
        /*
         * new RGBBlockValue(new Color(174, 100, 80), "TNT", false);
         * RGBBlockValue(new Color(139, 67, 47), new Color(117, 63, 48), new
         * Color(131, 62, 43), new Color(109, 60, 47), "TNT", true);
         */
        // No longer wants to work
        new RGBBlockValue(new Color(125, 125, 125), "STONE", 0);// base
        new RGBBlockValue(new Color(122, 122, 12), "SMOOTH_BRICK");
        new RGBBlockValue(new Color(122, 127, 111), new Color(114, 119, 104),
                new Color(110, 115, 101), new Color(114, 117, 108),
                "SMOOTH_BRICK", 1);// moss
        new RGBBlockValue(new Color(119, 119, 119), "SMOOTH_BRICK", 3);// chissle
        if (!isVersionHigherThan(1, 12)) {
            new RGBBlockValue(new Color(23, 19, 19), Material.BLACK_WOOL);
            new RGBBlockValue(new Color(43, 53, 133),  Material.BLUE_WOOL);
            new RGBBlockValue(new Color(76, 48, 30), Material.BROWN_WOOL);
            new RGBBlockValue(new Color(49, 116, 143), Material.CYAN_WOOL);
            new RGBBlockValue(new Color(61, 61, 61), Material.GRAY_WOOL);
            new RGBBlockValue(new Color(55, 72, 28), Material.GREEN_WOOL);
            new RGBBlockValue(new Color(113, 143, 203), Material.LIGHT_BLUE_WOOL);
            new RGBBlockValue(new Color(66, 180, 58), Material.LIME_WOOL);
            new RGBBlockValue(new Color(184, 83, 193), Material.MAGENTA_WOOL);
            new RGBBlockValue(new Color(221, 129, 67), Material.ORANGE_WOOL);
            new RGBBlockValue(new Color(210, 128, 158), Material.PINK_WOOL);
            new RGBBlockValue(new Color(130, 62, 188), Material.PURPLE_WOOL);
            new RGBBlockValue(new Color(157, 56, 51), Material.RED_WOOL);
            new RGBBlockValue(new Color(162, 168, 168), Material.LIGHT_GRAY_WOOL);
            new RGBBlockValue(new Color(232, 231, 231), Material.WHITE_WOOL);
            new RGBBlockValue(new Color(188, 176, 42), Material.YELLOW_WOOL);
        } else {
            new RGBBlockValue(new Color(22, 22, 27), Material.BLACK_WOOL);
            new RGBBlockValue(new Color(53, 57, 158), Material.BLUE_WOOL);
            new RGBBlockValue(new Color(116, 73, 41), Material.BROWN_WOOL);
            new RGBBlockValue(new Color(21, 138, 146), Material.CYAN_WOOL);
            new RGBBlockValue(new Color(63, 68, 72), Material.GRAY_WOOL);
            new RGBBlockValue(new Color(85, 109, 28), Material.GREEN_WOOL);
            new RGBBlockValue(new Color(58, 175, 217), Material.LIGHT_BLUE_WOOL);
            new RGBBlockValue(new Color(111, 184, 26), Material.LIME_WOOL);
            new RGBBlockValue(new Color(189, 69, 190),Material.MAGENTA_WOOL);
            new RGBBlockValue(new Color(241, 118, 19), Material.ORANGE_WOOL);
            new RGBBlockValue(new Color(239, 141, 172), Material.PINK_WOOL);
            new RGBBlockValue(new Color(122, 42, 172), Material.PURPLE_WOOL);
            new RGBBlockValue(new Color(161, 40, 35), Material.RED_WOOL);
            new RGBBlockValue(new Color(142, 142, 135), Material.LIGHT_GRAY_WOOL);
            new RGBBlockValue(new Color(232, 235, 235), Material.WHITE_WOOL);
            new RGBBlockValue(new Color(249, 196, 38), Material.YELLOW_WOOL);

        }
        new RGBBlockValue(new Color(9, 11, 16), Material.BLACK_CONCRETE);
        new RGBBlockValue(new Color(45, 47, 144), Material.BLUE_CONCRETE);
        new RGBBlockValue(new Color(97, 60, 32), Material.BROWN_CONCRETE);
        new RGBBlockValue(new Color(22, 119, 136), Material.CYAN_CONCRETE);
        new RGBBlockValue(new Color(55, 58, 62), Material.GRAY_CONCRETE);
        new RGBBlockValue(new Color(72, 92, 37), Material.GREEN_CONCRETE);
        new RGBBlockValue(new Color(36, 137, 199), Material.LIGHT_BLUE_CONCRETE);
        new RGBBlockValue(new Color(94, 169, 25), Material.LIME_CONCRETE);
        new RGBBlockValue(new Color(170, 49, 160), Material.MAGENTA_CONCRETE);
        new RGBBlockValue(new Color(225, 97, 1), Material.ORANGE_CONCRETE);
        new RGBBlockValue(new Color(214, 102, 143), Material.PINK_CONCRETE);
        new RGBBlockValue(new Color(101, 32, 157), Material.PURPLE_CONCRETE);
        new RGBBlockValue(new Color(143, 33, 33), Material.RED_CONCRETE);
        new RGBBlockValue(new Color(125, 125, 115), Material.LIGHT_GRAY_CONCRETE);
        new RGBBlockValue(new Color(207, 213, 214), Material.WHITE_CONCRETE);
        new RGBBlockValue(new Color(241, 176, 22), Material.YELLOW_CONCRETE);

        // these fall
//        new RGBBlockValue(new Color(26, 27, 32), "CONCRETE_POWDER",
//                DyeColor.BLACK);
//        new RGBBlockValue(new Color(71, 74, 168), "CONCRETE_POWDER",
//                DyeColor.BLUE);
//        new RGBBlockValue(new Color(125, 85, 54), "CONCRETE_POWDER",
//                DyeColor.BROWN);
//        new RGBBlockValue(new Color(37, 146, 157), "CONCRETE_POWDER",
//                DyeColor.CYAN);
//        new RGBBlockValue(new Color(78, 82, 86), "CONCRETE_POWDER",
//                DyeColor.GRAY);
//        new RGBBlockValue(new Color(98, 120, 45), "CONCRETE_POWDER",
//                DyeColor.GREEN);
//        new RGBBlockValue(new Color(74, 180, 213), "CONCRETE_POWDER",
//                DyeColor.LIGHT_BLUE);
//        new RGBBlockValue(new Color(125, 190, 42), "CONCRETE_POWDER",
//                DyeColor.LIME);
//        new RGBBlockValue(new Color(193, 84, 185), "CONCRETE_POWDER",
//                DyeColor.MAGENTA);
//        new RGBBlockValue(new Color(228, 132, 32), "CONCRETE_POWDER",
//                DyeColor.ORANGE);
//        new RGBBlockValue(new Color(229, 153, 182), "CONCRETE_POWDER",
//                DyeColor.PINK);
//        new RGBBlockValue(new Color(131, 55, 178), "CONCRETE_POWDER",
//                DyeColor.PURPLE);
//        new RGBBlockValue(new Color(169, 55, 51), "CONCRETE_POWDER",
//                DyeColor.RED);
//        new RGBBlockValue(new Color(155, 155, 148), "CONCRETE_POWDER",
//                DyeColor.LIGHT_GRAY);
//        new RGBBlockValue(new Color(227, 229, 229), "CONCRETE_POWDER",
//                DyeColor.WHITE);
//        new RGBBlockValue(new Color(233, 199, 54), "CONCRETE_POWDER",
//                DyeColor.YELLOW);

        // ============================================================================================
        // TODO: Check if these enum values are correct when 1.12 officially
        // comes out.
        new RGBBlockValue(new Color(226, 228, 186), new Color(190, 214, 208),
                new Color(191, 215, 208), new Color(134, 194, 224),
                "WHITE_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(85, 36, 39), new Color(64, 22, 23),
                new Color(65, 22, 23), new Color(62, 41, 45),
                "BLACK_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(49, 71, 146), new Color(46, 61, 135),
                new Color(49, 64, 141), new Color(51, 75, 156),
                "BLUE_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(158, 103, 65), new Color(118, 112, 95),
                new Color(117, 111, 95), new Color(107, 98, 81),
                "BROWN_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(68, 130, 135), new Color(38, 123, 131),
                new Color(35, 85, 93), new Color(65, 135, 141),
                "CYAN_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(87, 93, 96), new Color(75, 84, 88),
                new Color(83, 93, 96), new Color(90, 95, 98),
                "GRAY_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(135, 153, 105), new Color(110, 139, 52),
                new Color(110, 138, 51), new Color(103, 131, 48),
                "GREEN_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(74, 138, 195), new Color(94, 169, 212),
                new Color(98, 155, 204), new Color(119, 199, 228),
                "LIGHT_BLUE_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(133, 197, 46), new Color(178, 198, 60),
                new Color(178, 199, 61), new Color(163, 197, 51),
                "LIME_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(207, 101, 188), new Color(208, 103, 189),
                new Color(205, 96, 188), new Color(206, 99, 190),
                "MAGENTA_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(193, 151, 77), new Color(132, 155, 112),
                new Color(133, 153, 111), new Color(44, 173, 170),
                "ORANGE_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(232, 157, 181), new Color(242, 155, 184),
                new Color(242, 154, 184), new Color(232, 157, 182),
                "PINK_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(120, 62, 160), new Color(104, 46, 143),
                new Color(104, 46, 143), new Color(113, 42, 162),
                "PURPLE_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(168, 45, 41), new Color(179, 54, 49),
                new Color(195, 70, 61), new Color(190, 68, 59),
                "RED_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(153, 173, 175), new Color(146, 163, 165),
                new Color(121, 159, 161), new Color(157, 174, 176),
                "SILVER_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(226, 228, 186), new Color(190, 214, 208),
                new Color(191, 215, 208), new Color(134, 194, 224),
                "WHITE_GLAZED_TERRACOTTA");
        new RGBBlockValue(new Color(255, 222, 118), new Color(239, 196, 87),
                new Color(239, 196, 86), new Color(213, 165, 76),
                "YELLOW_GLAZED_TERRACOTTA");

        // 1.8
        new RGBBlockValue(new Color(153, 114, 100), "STONE", 1);// gran-hard
        new RGBBlockValue(new Color(141, 109, 99), "STONE", 2);// gran-smooth
        new RGBBlockValue(new Color(180, 180, 183), "STONE", 3);// dorite-hard
        new RGBBlockValue(new Color(183, 183, 186), "STONE", 4);// dorite-smooth
        new RGBBlockValue(new Color(131, 131, 131), "STONE", 5);// ander-hard
        new RGBBlockValue(new Color(133, 133, 135), "STONE", 6);// ander-smooth

        new RGBBlockValue(new Color(161, 119, 19), new Color(162, 118, 19),
                new Color(158, 119, 19), new Color(158, 118, 18), "HAY_BLOCK",
                3);
        new RGBBlockValue(new Color(121, 200, 101), "SLIME_BLOCK");
        new RGBBlockValue(new Color(176, 203, 193), new Color(177, 203, 194),
                new Color(178, 204, 194), new Color(180, 205, 196),
                "SEA_LANTERN");
        new RGBBlockValue(new Color(89, 149, 122), new Color(96, 156, 129),
                new Color(93, 150, 125), new Color(94, 152, 127), "PRISMARINE",
                0);
        new RGBBlockValue(new Color(100, 160, 143), "PRISMARINE", 1);
        new RGBBlockValue(new Color(60, 88, 75), "PRISMARINE", 2);
        new RGBBlockValue(new Color(151, 180, 231), "PACKED_ICE");
        new RGBBlockValue(new Color(172, 28, 9), "REDSTONE_BLOCK");
        new RGBBlockValue(new Color(127, 201, 108), "SLIME_BLOCK");
        // 1.9

        new RGBBlockValue(new Color(166, 122, 166), "PURPUR_BLOCK");
        new RGBBlockValue(new Color(170, 127, 170), "PURPUR_PILLAR", 1);
        new RGBBlockValue(new Color(226, 231, 171), "END_BRICKS");
        new RGBBlockValue(new Color(168, 86, 31), "RED_SANDSTONE", 2);
        new RGBBlockValue(new Color(158, 156, 61), new Color(156, 155, 61),
                new Color(161, 159, 63), new Color(161, 159, 64), "SPONGE", 1); // wet

        // 1.10

        new RGBBlockValue(new Color(140, 69, 26), new Color(113, 65, 27),
                new Color(138, 66, 25), new Color(134, 67, 29), "MAGMA");
        new RGBBlockValue(new Color(226, 212, 201), "BONE_BLOCK", 3);
        new RGBBlockValue(new Color(69, 4, 7), "RED_NETHER_BRICK");
        new RGBBlockValue(new Color(117, 6, 7), "NETHER_WART_BLOCK");
        new RGBBlockValue(new Color(73, 60, 74), "STRUCTURE_BLOCK");

        new RGBBlockValue(new Color(130, 157, 146), new Color(131, 153, 144),
                new Color(130, 152, 143), new Color(128, 143, 136),
                "COMMAND_CHAIN");
        new RGBBlockValue(new Color(124, 108, 170), new Color(126, 111, 165),
                new Color(124, 108, 163), new Color(123, 107, 153),
                "COMMAND_REPEATING");

        // 1.11

        // new RGBBlockValue(new Color(62, 59, 59), "OBSERVER", false);
        /**
         * Depending on which way you choose (north-south or east-west), the
         * sides and colors may be drastically different (one side is all dark
         * gray the other has a light gray stip in the middle). Removing for now
         * since I cannot determine which side a user chooses.
         */

    }

    private static final String SERVER_VERSION;

    static {
        String name = Bukkit.getServer().getClass().getName();
        name = name.substring(name.indexOf("craftbukkit.")
                + "craftbukkit.".length());
        name = name.substring(0, name.indexOf("."));
        SERVER_VERSION = name;
    }

    /**
     * This checks if the the server is running on a version higher or equal to
     * the one specified. Useage: upToDate(1,8) will check if the version is
     * greater than or equal to 1.8
     *
     * @param mainVersion The first value (will most likely only be 1 )
     * @param secondVersion The second value (The 8 in 1.8.3 )
     * @return if the server version is greater than or equal to specified
     *         version.
     */
    public static boolean isVersionHigherThan(int mainVersion, int secondVersion) {
        String firstChar = SERVER_VERSION.substring(1, 2);
        int fInt = Integer.parseInt(firstChar);
        if (fInt < mainVersion)
            return false;
        StringBuilder secondChar = new StringBuilder();
        for (int i = 3; i < 10; i++) {
            if (SERVER_VERSION.charAt(i) == '_'
                    || SERVER_VERSION.charAt(i) == '.')
                break;
            secondChar.append(SERVER_VERSION.charAt(i));
        }
        int sInt = Integer.parseInt(secondChar.toString());
        if (sInt < secondVersion)
            return false;
        return true;
    }

    /**
     * This will return the Material and durability that has the closest color
     * to Color "c".
     *
     * @param c
     *            - The color value
     * @return The closest material and durability.
     */
    public static MaterialData getClosestBlockValue(Color c, boolean topView) {
        Color[] color = new Color[4];
        color[0] = c;
        color[1] = c;
        color[2] = c;
        color[3] = c;
        return getClosestBlockValue(color, topView);
    }

    /**
     * The color value of the four closest colors. Use this if you want to
     * preserve hard edges in images. For the array, you need four color values.
     * Use the following chart to understand which pixel should be at which
     * index:
     *
     * | 0 | 1 |
     *
     * |---|---|
     *
     * | 2 | 3 |
     *
     * @param c
     *            - The color value
     * @return The closest material and durability.
     */
    public static MaterialData getClosestBlockValue(Color c[], boolean topView) {

        int[] r = new int[4];
        int[] b = new int[4];
        int[] g = new int[4];
        for (int i = 0; i < c.length; i++) {
            r[i] = c[i].getRed();
            b[i] = c[i].getBlue();
            g[i] = c[i].getGreen();
        }

        double cR = 1000000;
        double cB = 1000000;
        double cG = 1000000;

        MaterialData closest = null;

        double[] tR = new double[4];
        double[] tG = new double[4];
        double[] tB = new double[4];
        for (Entry<MaterialData, RGBBlockValue> entry : materialValue
                .entrySet()) {
            for (int i = 0; i < 4; i++) {
                tR[i] = entry.getValue().r[i] - r[i];
                tG[i] = entry.getValue().g[i] - g[i];
                tB[i] = entry.getValue().b[i] - b[i];
                if (tR[i] < 0)
                    tR[i] = -tR[i];
                if (tG[i] < 0)
                    tG[i] = -tG[i];
                if (tB[i] < 0)
                    tB[i] = -tB[i];
            }
            if ((tR[0] * tR[0]) + (tG[0] * tG[0]) + (tB[0] * tB[0])
                    + (tR[1] * tR[1]) + (tG[1] * tG[1]) + (tB[1] * tB[1])
                    + (tR[2] * tR[2]) + (tG[2] * tG[2]) + (tB[2] * tB[2])
                    + (tR[3] * tR[3]) + (tG[3] * tG[3]) + (tB[3] * tB[3]) < cR
                    + cG + cB) {
                if (entry.getValue().hasFaces()) {
                    if (entry.getValue().isTop() != topView)
                        continue;
                }
                cR = 0;
                cB = 0;
                cG = 0;
                for (int i = 0; i < 4; i++) {
                    cR += (tR[i] * tR[i]);
                    cB += (tB[i] * tB[i]);
                    cG += (tG[i] * tG[i]);
                }
                closest = entry.getKey();
            }
        }
        return closest;
    }

    /**
     * This gets all the pixel values for an image. Use this to get all the
     * pixels for an image.
     *
     * The first array stores the Row value (e.g. MC's "Y" value), and the
     * second array stores the Columb value (MC's X or Z)
     *
     * For example: If you want to get the pixel at the top left of an image,
     * use convertTo2DWithoutUsingGetRGB(Image)[HEIGHT][0]
     *
     * For example: If you want to get the pixel at the bottom right of an
     * image, use convertTo2DWithoutUsingGetRGB(Image)[0][WIDTH]
     *
     * @param image
     * @return
     */
    public static Pixel[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {
        if (image.getRaster().getDataBuffer() instanceof DataBufferByte) {
            final byte[] pixels = ((DataBufferByte) image.getRaster()
                    .getDataBuffer()).getData();
            final int width = image.getWidth();
            final int height = image.getHeight();
            final boolean hasAlphaChannel = image.getAlphaRaster() != null;

            Pixel[][] result = new Pixel[height][width];
            int pixelLength = 0;
            int offset = 0;
            if (hasAlphaChannel) {
                pixelLength = 4;
                offset = 1;
            } else {
                pixelLength = 3;
            }

            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int r = 0;
                int b = 0;
                int g = 0;
                // argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                b += ((int) pixels[pixel + offset] & 0xff); // blue
                g += (((int) pixels[pixel + offset + 1] & 0xff) /* << 8 */); // green
                r += (((int) pixels[pixel + offset + 2] & 0xff) /* << 16 */); // red
                result[row][col] = new Pixel(r, g, b);
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }

            return result;
        } else if (image.getRaster().getDataBuffer() instanceof DataBufferInt) {
            final int[] pixels = ((DataBufferInt) image.getRaster()
                    .getDataBuffer()).getData();
            final int width = image.getWidth();
            final int height = image.getHeight();
            final boolean hasAlphaChannel = image.getAlphaRaster() != null;

            Pixel[][] result = new Pixel[height][width];
            if (hasAlphaChannel) {
                final int pixelLength = 4;
                for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                    int r = 0;
                    int b = 0;
                    int g = 0;
                    // argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                    b += ((int) pixels[pixel + 1] & 0xff); // blue
                    g += (((int) pixels[pixel + 2] & 0xff) /* << 8 */); // green
                    r += (((int) pixels[pixel + 3] & 0xff) /* << 16 */); // red
                    result[row][col] = new Pixel(r, g, b);
                    col++;
                    if (col == width) {
                        col = 0;
                        row++;
                    }
                }
            } else {
                final int pixelLength = 1;
                for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                    int r = 0;
                    int b = 0;
                    int g = 0;
                    int rgb = pixels[pixel];
                    r = (rgb >> 16) & 0xFF;
                    g = (rgb >> 8) & 0xFF;
                    b = rgb & 0xFF;
                    result[row][col] = new Pixel(r, g, b);
                    col++;
                    if (col == width) {
                        col = 0;
                        row++;
                    }
                }
            }

            return result;
        }
        return null;
    }

    /**
     * Creates a file with an image where each pixel represense the colorcode
     * for a block
     *
     * @param output
     *            file
     * @param bottomLeft
     *            corner of the image
     * @param topRight
     *            corner of the image
     */
    @SuppressWarnings("deprecation")
    public void createImageFromBlocks(File output, Location bottomLeft,
                                      Location topRight) {
        boolean isX = bottomLeft.getBlockZ() == topRight.getBlockZ();
        MaterialData[][] blocks = new MaterialData[topRight.getBlockY()
                - bottomLeft.getBlockY()][isX ? Math.max(topRight.getBlockX(),
                bottomLeft.getBlockX())
                - Math.min(topRight.getBlockX(), bottomLeft.getBlockX()) : Math
                .max(topRight.getBlockZ(), bottomLeft.getBlockZ())
                - Math.min(topRight.getBlockZ(), bottomLeft.getBlockZ())];
        for (int y = bottomLeft.getBlockY(); y < topRight.getBlockY(); y++) {
            if (isX) {
                for (int x = Math.min(topRight.getBlockX(),
                        bottomLeft.getBlockX()); x < Math.max(
                        topRight.getBlockX(), bottomLeft.getBlockX()); x++) {
                    Block t = new Location(topRight.getWorld(), x, y,
                            topRight.getBlockZ()).getBlock();
                    blocks[y - bottomLeft.getBlockY()][x
                            - Math.min(topRight.getBlockX(),
                            bottomLeft.getBlockX())] = MaterialData
                            .getMatDataByTypes(t.getType(), t.getData());
                }
            } else {
                for (int z = Math.min(topRight.getBlockZ(),
                        bottomLeft.getBlockZ()); z < Math.max(
                        topRight.getBlockZ(), bottomLeft.getBlockZ()); z++) {
                    Block t = new Location(topRight.getWorld(),
                            topRight.getBlockX(), y, z).getBlock();
                    blocks[y - bottomLeft.getBlockY()][z
                            - Math.min(topRight.getBlockZ(),
                            bottomLeft.getBlockZ())] = MaterialData
                            .getMatDataByTypes(t.getType(), t.getData());
                }
            }
        }
        createImageFromBlocks(output, blocks);
    }

    /**
     * Creates a file with an image where each pixel represense the colorcode
     * for a block
     *
     * @param output
     *            file
     * @param blocks the
     *            material data for each block. first array being the Y, the
     *            second being the X or Z;
     */
    public void createImageFromBlocks(File output, MaterialData[][] blocks) {
        BufferedImage canvas = new BufferedImage(blocks[0].length,
                blocks.length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < blocks.length; y++) {
            for (int x = 0; x < blocks[0].length; x++) {
                for (MaterialData rgb : materialValue.keySet()) {
                    if (rgb.getMaterial() == blocks[y][x].getMaterial()
                            && rgb.getData() == blocks[y][x].getData()) {
                        int col = (materialValue.get(rgb).r[0] << 16)
                                | (materialValue.get(rgb).g[0] << 8)
                                | materialValue.get(rgb).b[0];
                        canvas.setRGB(x, y, col);
                    }
                }
            }
        }
        try {
            ImageIO.write(canvas, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Pixel {
        public int r;
        public int b;
        public int g;

        public Pixel(int r, int g, int b) {
            this.r = r;
            this.b = b;
            this.g = g;
        }
    }

}

class RGBValue {
    protected int[] r = new int[4];
    protected int[] b = new int[4];
    protected int[] g = new int[4];

    public RGBValue(Color c) {
        init(c, c, c, c);
    }

    public RGBValue(Color c, Color c2, Color c3, Color c4) {
        init(c, c2, c3, c4);
    }

    private void init(Color c, Color c2, Color c3, Color c4) {
        this.r[0] = c.getRed();
        this.g[0] = c.getGreen();
        this.b[0] = c.getBlue();
        // /
        this.r[1] = c2.getRed();
        this.g[1] = c2.getGreen();
        this.b[1] = c2.getBlue();
        // /
        this.r[2] = c3.getRed();
        this.g[2] = c3.getGreen();
        this.b[2] = c3.getBlue();
        // /
        this.r[3] = c4.getRed();
        this.g[3] = c4.getGreen();
        this.b[3] = c4.getBlue();
    }
}

class RGBBlockValue extends RGBValue {

    private boolean hasFaces = false;
    private boolean isTop = false;

    public boolean isTop() {
        return isTop;
    }

    public boolean hasFaces() {
        return hasFaces;
    }

    public RGBBlockValue(Color c, String mat) {
        super(c);
        if (Material.matchMaterial(mat) == null)
            return;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(mat), (byte) 0), this);

    }

    public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String m) {
        super(c, c2, c3, c4);
        if (Material.matchMaterial(m) == null) {
            System.out.println("Material, " + m + " not found. ");
            return;
        }
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(m), (byte) 0), this);
    }

    public RGBBlockValue(Color c, String m, byte d) {
        super(c);
        if (Material.matchMaterial(m) == null)
            return;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(m), d), this);
    }

    public RGBBlockValue(Color c, String mat, int d) {
        super(c);
        if (Material.matchMaterial(mat) == null)
            return;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(mat), (byte) d), this);
    }

    public RGBBlockValue(Color c, String mat, int d, boolean isTop) {
        super(c);
        if (Material.matchMaterial(mat) == null)
            return;
        this.isTop = isTop;
        this.hasFaces = true;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(mat), (byte) d), this);
    }

    public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat,
                         int d) {
        super(c, c2, c3, c4);
        if (Material.matchMaterial(mat) == null)
            return;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(mat), (byte) d), this);
    }

    public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat,
                         boolean isTop) {
        super(c, c2, c3, c4);
        if (Material.matchMaterial(mat) == null)
            return;
        this.hasFaces = true;
        this.isTop = isTop;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(mat), (byte) 0), this);
    }

    public RGBBlockValue(Color c, String mat, boolean isTop) {
        super(c);
        if (Material.matchMaterial(mat) == null)
            return;
        this.hasFaces = true;
        this.isTop = isTop;
        RGBBlockColor.materialValue.put(
                new MaterialData(Material.matchMaterial(mat), (byte) 0), this);
    }

    public RGBBlockValue(Color c, Material mat) {
        super(c);
//        byte dyecolor = -1;
//        if ((RGBBlockColor.isVersionHigherThan(1, 10)))
//            dyecolor = (byte) ReflectionUtil.invokeMethod(d, "getWoolData",
//                    null);
//        else
//            dyecolor = (byte) ReflectionUtil.invokeMethod(d, "getData", null);
        RGBBlockColor.materialValue.put(
                new MaterialData(mat), this);
    }
}

class MaterialData implements ConfigurationSerializable {

    private Material m;
    private byte data;

    public MaterialData(Material m, byte data) {
        ConfigurationSerialization.registerClass(MaterialData.class);
        this.setMaterial(m);
        this.data = data;
    }

    public MaterialData(Material m) {
        ConfigurationSerialization.registerClass(MaterialData.class);
        this.setMaterial(m);
        this.data = 0;
    }

    public static MaterialData getMatDataByTypes(Material mat, byte data) {
        for (MaterialData key : RGBBlockColor.materialValue.keySet())
            if (key.getData() == data && key.getMaterial() == mat)
                return key;
        return null;
    }

    public byte getData() {
        return data;
    }

    public Material getMaterial() {
        return m;
    }

    public MaterialData(Map<String, Object> data) {
        this.setMaterial(Material.valueOf((String) data.get("m")));
        this.data = Byte.parseByte((String) data.get("data"));
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("m", this.getMaterial().toString());
        data.put("data", this.data + "");
        return data;
    }

    public void setMaterial(Material m) {
        this.m = m;
    }
}