package com.caro.code;

import java.util.Objects;

public class ToaDo {
    private int x;
    private int y;

    public ToaDo(){

    }

    public ToaDo(int x, int y){
        this.x = x;
        this.y = y;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToaDo toaDo = (ToaDo) o;
        return x == toaDo.x && y == toaDo.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "ToaDo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
