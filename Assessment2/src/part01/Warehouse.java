package part01;

import java.util.ArrayList;


public class Warehouse
{
    private static int i = 0;
    private final ArrayList<Product> data = new ArrayList<Product>();
    private String name = "";

    public Warehouse(String name)
    {
        this.name = name;
    }

    public Product[] getAllProducts()
        {
            Product[] p = data.toArray(new Product[data.size()]);
            return p;
        }

    public String addProduct(String make, String model, double price, Department dept)
    {
        String str = "";
        boolean multiple = false;
            for(int i = 0; i < data.size(); i++)
            {
                if((data.get(i).getModel().equals(model) && data.get(i).getMake().equals(make) && data.get(i).getDepartment().equals(dept)))
                {
                    data.get(i).addToQuantity(1);
                    multiple = true;
                    str = "Added 1 Product to\n" +
                    "======================\n"
                    + data.get(i).getCode();
                }
            }
            if(!multiple)
            {
                Product prod = new Product(make, model, price, dept);
                data.add(prod);
                checkCode();
                str="Added 1 New Product:\n" +
                    "======================\n"
                +   "New ID: " + data.get(data.size()-1);
            }
            return str ;
        }




    public String addProduct(String make, String model, double price, Department dept, int quantity)
    {
        boolean multiple = false;
        Product prod = new Product(make,model,price,dept,quantity);

        if(prod == null || quantity < 1)
        {
            return ("ERROR: Details are incorrect");
        }
        else
        {
            String str = "";
            for(int i = 0; i < data.size(); i++)
            {
                if((data.get(i).getModel().equals(model) && data.get(i).getMake().equals(make) && data.get(i).getDepartment().equals(dept)))
                {
                    data.get(i).addToQuantity(quantity);
                    multiple = true;
                    str = "Added " + quantity + " Products to\n" +
                        "=====================================================================================\n"
                            + data.get(i).getCode();
                }
            }
            if(!multiple)
            {
                data.add(prod);
                checkCode();
                     str="Added "+quantity+" New Products\n" +
                        "======================================================================================\n"
                    + data.get(data.size()-1);
            }
            return str ;
        }
    }
    public boolean deleteProduct(String code)
    {
        for (int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getCode().equals(code));
            {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean restock(String model, int num)
    {
        Product[] p = data.toArray(new Product[data.size()]);
        for (int i = 0; i < p.length; i++)
        {
            if(data.get(i).getModel().equals(model));
            {
                data.get(i).addToQuantity(num);
                System.out.println("Restocked Successfully");
                return true;
            }
        }
        System.out.println("Error");
        return false;
    }


    public Product search(String make, String model)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getMake().equals(make) && data.get(i).getModel().equals(model));
            {
                return data.get(i);
            }
        }
        return null;
    }



    public ArrayList<Product> search (Department dept)
    {
        ArrayList<Product> e = new ArrayList<Product>();
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getDepartment() == dept);
            {
                e.add(data.get(i));
            }
        }
        return e;
    }


    public Product search (String code)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getCode().equals(code))
            {
                return data.get(i);
            }
        }
        return null;
    }

    public String findID (String code)
    {
        for(int i = 0; i < data.size();i++)
        {
            if(code.equals(data.get(i).getCode()))
            {
                String str = "Code: " + code + "\n"
            +   "=========================================================\n" + data.get(i);
                return str;
            }
        }
        return "ERROR: Code Doesnt Exist";
    }

    private void checkCode()
    {
        for (int i = 0;i<data.size();i++)
        {
            data.get(i).setCode(i+1);
        }
    }



    public String toString() {
        Product[] electrical = new Product[data.size()];
        Product[] photographic = new Product[data.size()];
        Product[] computing = new Product[data.size()];
        Product[] books = new Product[data.size()];
        Product[] music = new Product[data.size()];
        Product[] fashion = new Product[data.size()];
        Product[] other = new Product[data.size()];
        String out = "";
        int e = 0;
        int p = 0;
        int c = 0;
        int b = 0;
        int m = 0;
        int f = 0;
        int o = 0;

        for (int i = 0; i < data.size(); i++) {
            switch (data.get(i).getDepartment().toString()) {
                case "Electrical":
                    electrical[e] = data.get(i);
                    e++;
                    break;
                case "Photographic":
                    photographic[p] = data.get(i);
                    p++;
                    break;
                case "Computing":
                    computing[c] = data.get(i);
                    c++;
                    break;
                case "Books":
                    books[b] = data.get(i);
                    b++;
                    break;
                case "Music":
                    music[m] = data.get(i);
                    m++;
                    break;
                case "Fashion":
                    fashion[f] = data.get(i);
                    f++;
                    break;
                case "Other":
                    other[o] = data.get(i);
                    o++;
                    break;
            }
        }

        String str = "Electrical\n" + "----------\n";
        for (int i = 0; i < electrical.length; i++) {
            if(electrical[i] != null)
            str += electrical[i] + "\n";
        }
        str += "\nPhotographic" + "\n----------\n";
        for (int i = 0; i < photographic.length; i++) {
            if(photographic[i] != null)
            {
                str += photographic[i] + "\n";
            }

        }

        str += "\nComputing" + "\n----------\n";

        for (int i = 0; i < computing.length; i++) {
            if (computing[i] != null) {
                str += computing[i] + "\n";
            }

        }

        str += "\nBooks" + "\n----------\n";
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null)
            {
                str += books[i] + "\n";
            }
        }

        str += "\nMusic" + "\n----------\n";

        for (int i = 0; i < music.length; i++)
        {
            if(music[i] != null) {
                str += music[i] + "\n";
            }
        }
        str += "\nFashion" + "\n----------\n";
        for (int i = 0; i < fashion.length; i++)
        {
            if(fashion[i] != null)
            {
                str += fashion[i] + "\n";
            }
        }

        str += "\nOther" + "\n----------\n";

        for (int i = 0; i < other.length; i++)
        {
            if(other[i] != null)
            {
                str += other[i] + "\n";
            }
        }

        return str;
    }
}
