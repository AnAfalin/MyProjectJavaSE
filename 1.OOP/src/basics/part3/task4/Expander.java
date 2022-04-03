package basics.part3.task4;

public class Expander {
    public void expand(Square box){
        box.setDepth(box.getDepth() * 2);
        box.setHeight(box.getHeight() * 2);
        box.setWidth(box.getWidth() * 2);
    }
}
