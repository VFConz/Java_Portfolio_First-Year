package part02;

import part01.Department;
import part01.Product;

public class testApp {




    public static void main (String[] args)
    {
        try{
            Product product = new Product("test", "", 42,Department.ELECTRICAL, 5);
            System.out.println("Product Added Successfully");
        }
        catch(Exception er) {
        System.out.println(er);
    }

    }
}
