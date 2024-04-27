abstract class Customer {
    private String firstName;
    private String surname;

    public Customer(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public abstract double findBillAmount();
}

class LocalCustomer extends Customer {
    private int quantityBoughtP;
    private double discountRate;

    public LocalCustomer(String firstName, String surname, int quantityBoughtP, double discountRate) {
        super(firstName, surname);
        this.quantityBoughtP = quantityBoughtP;
        this.discountRate = discountRate;
    }

    public int getQuantityBoughtP() {
        return quantityBoughtP;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public double findBillAmount() {
        double unitPriceP = Item.getPriceOfItemP();
        return quantityBoughtP * unitPriceP * (1 - discountRate);
    }
}

class ForeignCustomer extends Customer {
    private int quantityBoughtQ;
    private double taxRate;

    public ForeignCustomer(String firstName, String surname, int quantityBoughtQ, double taxRate) {
        super(firstName, surname);
        this.quantityBoughtQ = quantityBoughtQ;
        this.taxRate = taxRate;
    }

    public int getQuantityBoughtQ() {
        return quantityBoughtQ;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public double findBillAmount() {
        double unitPriceQ = Item.getPriceOfItemQ();
        return quantityBoughtQ * unitPriceQ * (1 + taxRate);
    }
}

class Item {
    private static double unitPriceP = 10.0;
    private static double unitPriceQ = 15.0;

    public static double getPriceOfItemP() {
        return unitPriceP;
    }

    public static void setPriceOfItemP(double price) {
        unitPriceP = price;
    }

    public static double getPriceOfItemQ() {
        return unitPriceQ;
    }

    public static void setPriceOfItemQ(double price) {
        unitPriceQ = price;
    }
}

public class JavaApplication1 {
    public static void main(String[] args) {
        LocalCustomer localCustomerA = new LocalCustomer("Susith", "Deshan", 5, 10);
        Item.setPriceOfItemP(12.0);
        double billAmountA = localCustomerA.findBillAmount();
        System.out.println("Local Customer: " + localCustomerA.getFirstName() + " " + localCustomerA.getSurname());
        System.out.println("Bill Amount: $" + billAmountA);

        ForeignCustomer foreignCustomerB = new ForeignCustomer("Nipul", "Kanishka", 10, 1.2);
        Item.setPriceOfItemQ(18.0);
        double billAmountB = foreignCustomerB.findBillAmount();
        System.out.println("Foreign Customer: " + foreignCustomerB.getFirstName() + " " + foreignCustomerB.getSurname());
        System.out.println("Bill Amount: $" + billAmountB);
    }
}
