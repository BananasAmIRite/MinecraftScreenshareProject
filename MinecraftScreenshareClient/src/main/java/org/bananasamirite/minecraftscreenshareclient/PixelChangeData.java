package org.bananasamirite.minecraftscreenshareclient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class PixelChangeData {
    @JsonProperty("data")
    private List<PixelChange> data;

    public List<PixelChange> getData() {
        return data;
    }

    public void setData(List<PixelChange> data) {
        this.data = data;
    }

    @JsonFormat(shape=JsonFormat.Shape.ARRAY)
    @JsonPropertyOrder({"x", "y", "r", "g", "b", "a"})
    public static class PixelChange {
        private int x;
        private int y;
        private int r;
        private int g;
        private int b;
        private int a;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "PixelChange{" +
                    "x=" + x +
                    ", y=" + y +
                    ", r=" + r +
                    ", g=" + g +
                    ", b=" + b +
                    ", a=" + a +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PixelChangeData{" + data + '}';
    }
//
//    public static void main(String[] args) {
//        try {
//            ObjectMapper m = new ObjectMapper();
//
//            var data = m.readValue("""
//                    {"data": [[0, 0, 0, 0, 0, 1], [0, 0, 5, 6, 7, 255]]}""", PixelChangeData.class);
//            System.out.println(data);
//        } catch(Exception err) {
//            err.printStackTrace();
//        }
//    }
}
