package part01;

import part02.Test;

public class Product
{
    private int code = 0;
    private final String make;
    private final String model;
    private final double price;
    private int quantity;
    private int purchases;
    private final Department dept;

    public Product (String make, String model, double price, Department dept, int quantity)
    {
        this.make = make;
        this.model = model;
        this.price = price;
        this.dept = dept;
        this.quantity = quantity;
        this.code = nextCode();
    }
    public Product (String make, String model, double price, Department dept)
    {

        this.make = make;
        this.model = model;
        this.price = price;
        this.dept = dept;
        this.code=nextCode();
        quantity = 1;
    }

    public String toString() {
        return "code: " + this.getCode() +
                ", Make: '" + make  +  '\'' +
                ", Model:'" + model + '\'' +
                ", Price:" + price +
                ", Quantity: " + quantity +
                ", Purchases: " + purchases +
                ", Department: " + dept;
    }
    public boolean recordPurchase()
    {
        if (quantity > 0){
            quantity--;
            purchases++;
            System.out.println("Purchase Successful");
            return true;
        }
        System.out.println("Out Of Stock");
        return false;
    }
    public void addToQuantity(int num)
    {
        quantity += num;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public Department getDepartment() {
        return dept;
    }

    public String getCode() {
        String str= dept.toString().charAt(0) + String.format("%04d", code);
        return str;
    }
    public void setCode(int i)
    {
        this.code = i;
    }
    public int nextCode()
    {
        code++;
        return code;
    }

}
