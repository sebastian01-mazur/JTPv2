package LAB3.ZAD2;

public interface Figure extends Cloneable {
    void move(double dx, double dy);
    void flip();
    void rotate(double x);
    boolean equals(Object o);
    String toString();
    Figure clone();

    // Metoda domyślna ułatwiająca grupowanie (varargs)
    default Group group(Figure... figures) {
        Group newGroup = new Group();
        newGroup.addFigure(this.clone());
        for (Figure f : figures) {
            newGroup.addFigure(f.clone());
        }
        return newGroup;
    }
}