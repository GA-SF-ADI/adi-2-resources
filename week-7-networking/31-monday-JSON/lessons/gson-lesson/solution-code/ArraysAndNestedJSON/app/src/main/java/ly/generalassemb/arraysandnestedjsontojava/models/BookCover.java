package ly.generalassemb.arraysandnestedjsontojava.models;

/**
 * Object to model a book cover from JSON results
 *
 * It has a color and a material value.
 */
public class BookCover {
    private String color;
    private String material;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
