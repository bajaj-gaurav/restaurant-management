package core;

public class MainRestaurant {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("pizzahut");

        restaurant.addItem("jp nagar", 1, "curry", "panner butter masala", 200);
        restaurant.addItem("jp nagar", 2, "curry", "aloo butter masala", 500);
        restaurant.addItem("jp nagar", 1, "curry", "baigan butter masala", 600);
        restaurant.addItem("jp nagar", 1, "curry", "chicker butter masala", 400);
        restaurant.addItem("jp nagar", 1, "bread", "naan", 20);
        restaurant.addItem("jp nagar", 1, "bread", "kulcha", 30);
        restaurant.addItem("jp nagar", 1, "bread", "roti", 40);
        restaurant.addItem("jp nagar", 1, "fastfood", "pizza", 200);
        restaurant.addItem("jp nagar", 1, "fastfood", "burger", 400);
        restaurant.addItem("jp nagar", 1, "fastfood", "pasta", 300);

        restaurant.addTable("jp nagar", 1);
        restaurant.addTable("jp nagar", 2);
        restaurant.addTable("jp nagar", 3);
        restaurant.addTable("jp nagar", 4);
        restaurant.addTable("jp nagar", 5);

        Customer customer = new Customer(restaurant);
        customer.getMenu("jp nagar", 1);

        for (Table table : customer.getFreeTables("jp nagar")) {
            System.out.println(table);
        }

        Order order1 = customer.createOrder("jp nagar");
        System.out.println("Occupied seat " + order1.getTable().getTableId());
        order1.addItemstoMeal("kulcha");
        order1.addItemstoMeal("pasta");

        Customer customer2 = new Customer(restaurant);
        System.out.println("Available tables");
        for (Table table : customer2.getFreeTables("jp nagar")) {
            System.out.println(table);
        }
        Order order2 = customer.createOrder("jp nagar");
        System.out.println("Available tables");
        System.out.println("Occupied seat " + order2.getTable().getTableId());
        order2.addItemstoMeal("burger");
        order2.addItemstoMeal("pasta");

        System.out.println("Bill is payed " + customer.payBill(order1));
        System.out.println("Bill is payed " + customer.payBill(order2));


    }
}
