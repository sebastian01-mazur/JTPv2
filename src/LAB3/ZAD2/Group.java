package LAB3.ZAD2;

import java.util.ArrayList;
import java.util.List;

public class Group implements Figure {
    private List<Figure> figures = new ArrayList<>();

    public void addFigure(Figure f) {
        figures.add(f);
    }

    @Override
    public void move(double dx, double dy) {
        for (Figure f : figures) f.move(dx, dy);
    }

    @Override
    public void flip() {
        for (Figure f : figures) f.flip();
    }

    @Override
    public void rotate(double angle) {
        for (Figure f : figures) f.rotate(angle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return figures.equals(group.figures);
    }

    @Override
    public String toString() {
        return "Group" + figures.toString();
    }

    @Override
    public Group clone() {
        try {
            Group cloned = (Group) super.clone();
            cloned.figures = new ArrayList<>();
            for (Figure f : this.figures) {
                cloned.figures.add(f.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}