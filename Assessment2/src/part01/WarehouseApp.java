package part01;

import org.w3c.dom.ls.LSOutput;
import part01.Department;
import part01.Product;
import part01.Warehouse;
import part03.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class WarehouseApp
{

    static final String PROMPT = "---->";
    static final String SPACES = " ";
    static final String[] options = {"Add New Product", "Delete a Product",
            "List Products for Department", "List all Products", "Add Stock for a Product",
            "Sales Report", "Record Purchase", "Quit"};
    static final int QUIT = options.length;

    static Warehouse wh = new Warehouse("Conor Ltd");
    static int count = 0; // 0 to start with
    static String title = "Warehouse Manager";
    static Menu menu = new Menu(title, options);
    static Scanner in = new Scanner(System.in);


    public static void main (String[] args)
    {
        addProducts();
        int choice;
        do {
            menu.display();
            choice = menu.getUserChoice();

            if (choice != QUIT)
            {
                processChoice(choice);
            }
        }
        while( choice != QUIT );
        System.out.println("\nGoodbye!");
        in.close();
    }

    private static void processChoice(int choice) {
        switch(choice) {
            case 1 : addNewProduct();
                break;
            case 2 : deleteAProduct();
                break;
            case 3 : listProductsforDepartment();
                break;
            case 4 : listAllProducts();
                break;
            case 5 : addStock();
                break;
            case 6 : salesReport();
                break;
            case 7 : recordPurchase();
                break;
            default: System.out.println("Option "+choice+" is invalid.");
        }
        System.out.println();
    }

    public static void addProducts(){
        wh.addProduct("test", "test",49.99,Department.ELECTRICAL);
        wh.addProduct("test", "test",49.99,Department.FASHION);
        wh.addProduct("test", "test",49.99,Department.COMPUTING);
        wh.addProduct("test", "test",49.99,Department.MUSIC);
        wh.addProduct("test", "test",49.99,Department.OTHER);
        wh.addProduct("test", "test",49.99,Department.PHOTOGRAPHIC);
        wh.addProduct("test", "test",49.99,Department.BOOKS);
        wh.addProduct("test", "test",49.99,Department.ELECTRICAL,6);
        wh.addProduct("test", "teest",49.99,Department.ELECTRICAL,6);
        wh.addProduct("test", "test",49.99,Department.FASHION);
        wh.addProduct("test", "test",49.99,Department.COMPUTING);
        wh.addProduct("test", "test",49.99,Department.MUSIC);
        wh.addProduct("test", "test",49.99,Department.OTHER);
        wh.addProduct("test", "test",49.99,Department.PHOTOGRAPHIC);
        wh.addProduct("test", "test",49.99,Department.BOOKS);

    }



    public static void salesReport()
    {
        System.out.println(wh.toString());
    }

    public static void deleteAProduct()
    {
        System.out.println("Please Input Code for Deletion");
        boolean result = wh.deleteProduct(in.next());
        if (!result)
        {

            System.out.println("ERROR: Code doesn't Exist");
        }
        else
        {
            System.out.println("Removed Successfully");
        }
    }


    public static void listProductsforDepartment()
    {
        System.out.println("Please Input Department Name");
        String str= in.next();
        Department d = null;
        for(Department department : Department.values())
        {
            if(department.toString().equals(str))
            {
                d = department;
            }
        }

        ArrayList <Product> arr = wh.search(d);

        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i).getDepartment() == d)
            {
                System.out.println(arr.get(i));
            }
        }

    }

    public static void listAllProducts()
    {
        Product[] p = wh.getAllProducts();

        for(int i = 0; i < p.length; i++)
        {
            System.out.println(p[i]);
        }
    }

    public static void addStock()
    {
        System.out.println("Please enter Product Code");
        String str = in.next();
        if(wh.search(str)==null)
        {
            System.out.println("Product does not Exist.");
        }
        else if(wh.search(str)!=null)
        {
            System.out.println("Enter Amount of New Stock: ");
            int num = in.nextInt();
            wh.restock(wh.search(str).getModel(), num);
            System.out.println("Restock Successful");
        }
    }

    public static void recordPurchase()
    {
        System.out.println("Please enter Product Code");
        String str = in.next();

        if(wh.search(str)!=null)
        {
            System.out.println("Enter Amount of New Purchases: ");
            int num = in.nextInt();
            for(int i = 0; i < num; i++)
            {
                wh.search(str).recordPurchase();
            }

            if(num == 1)
            {
                System.out.println("Product Purchase Successfully Recorded");
            }
            else if(num > 1)
            {
                System.out.println(num + " Product Purchases Successfully Recorded.");
            }
        }
    }

    public static void addNewProduct()
    {

        System.out.println("Make: ");
        String make = in.next();
        System.out.println("Model: ");
        String model = in.next();
        Scanner priceIn = new Scanner(System.in);
        System.out.println("Price: ");
        double price = priceIn.nextDouble();
        System.out.println("Department: ");
        String dep = in.next();
        Department dept = null;
        switch (dep) {
            case "Electrical":
                dept = Department.ELECTRICAL;
                break;
            case "Photographic":
                dept = Department.PHOTOGRAPHIC;
                break;
            case "Computing":
                dept = Department.COMPUTING;
                break;
            case "Books":
                dept = Department.BOOKS;
                break;
            case "Music":
                dept = Department.MUSIC;
                break;
            case "Fashion":
                dept = Department.FASHION;
                break;
            case "Other":
                dept = Department.OTHER;
                break;
        }

        int quantity;
        System.out.println("Is there multiple items (y/n)");
        String choice = in.next();
        if(choice.equals("y"))
        {
            System.out.println("Enter Quantity");
            quantity = in.nextInt();
            System.out.println(wh.addProduct(make,model,price,dept,quantity));
        }
        else
        {
            wh.addProduct(make,model,price,dept);
            System.out.println(wh.addProduct(make,model,price,dept));
        }

    }

}

