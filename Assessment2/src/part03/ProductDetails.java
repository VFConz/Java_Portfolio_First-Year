package part03;

import javax.swing.*;

public class ProductDetails
{
    protected String Description = "";
    protected ImageIcon image = null;

    ProductDetails(String Description, ImageIcon image)
    {
        this.Description = Description;
        this.image = image;
    }

    public String getDescription() {
        return Description;
    }

    public ImageIcon getImage() {
        return image;
    }
}
