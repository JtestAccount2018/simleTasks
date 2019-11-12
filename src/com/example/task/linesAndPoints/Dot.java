package com.example.task.linesAndPoints;

import java.util.Objects;

public class Dot<X, Y> {
    private X x;
    private Y y;

    public Dot(X t, Y d) {
        this.x = t;
        this.y = d;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot<?, ?> dot = (Dot<?, ?>) o;
        return Objects.equals(x, dot.x) &&
                Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
