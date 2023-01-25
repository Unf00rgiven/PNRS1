package rad.sa.listama;

import android.graphics.drawable.Drawable;

public class Karakter {
    private Drawable nimage;
    private String ntext;

    public Karakter(Drawable nimage, String ntext) {
        this.nimage = nimage;
        this.ntext = ntext;
    }

    public Drawable getNimage() {
        return nimage;
    }

    public String getNtext() {
        return ntext;
    }

    public void setNimage(Drawable nimage) {
        this.nimage = nimage;
    }

    public void setNtext(String ntext) {
        this.ntext = ntext;
    }
}
