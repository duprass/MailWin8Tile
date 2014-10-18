/**
 * Created by Olga on 17.10.2014.
 */
public abstract class Component implements Default, Action {
    private int x;
    private int y;
    private String font;
    private int width;
    private int height;

    protected Component(int x, int y, String font, int width, int height) {
        setX(x);
        setY(y);
        setHeight(height);
        setWidth(width);
        setFont(font);
    }

    protected Component() {
        this(125, 125, "Arial", 100, 100);
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        } else {
            return;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 0) {
            this.y = y;
        } else {
            return;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width > MIN_WIDTH) {
            this.width = width;
        } else {
            return;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > MIN_HEIGHT) {
            this.height = height;
        } else {
            return;
        }
    }

    public abstract void mouseOn();

    public abstract void click();
}

interface Default {
    int MIN_WIDTH = 10;
    int MIN_HEIGHT = 10;

    String getFont();

    void setFont(String font);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);
}

interface Action {
    void mouseOn();
    void mouseOff();
    void click();
}