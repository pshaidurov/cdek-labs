package lab_6_core;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Scanner sc1 = new Scanner(System.in);

        int amountOfProducts = 0;
        boolean amount_status = true;

        while (amount_status) {
            System.out.println("How many groceries do you want to order?");
            try {
                String amount_str = sc1.nextLine();
                amountOfProducts = Integer.parseInt(amount_str);
                if (amountOfProducts < 1) {
                    System.out.println("Wrong number of product list!");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong symbol of product list!");
            }
        }


        int INPUT_LENGTH = 3;


        String[] masOfProducts = new String[amountOfProducts];
        Integer[] masOfCosts = new Integer[amountOfProducts];
        Integer[] masOfCounts = new Integer[amountOfProducts];

        System.out.println("Enter your shopping list, the number of products and their price. To close the list, enter \"exit\"");


        Check check = new Check(INPUT_LENGTH);
        int countOfCycle = 0;
        int countOfProducts = 0;
        while (sc.hasNext() && countOfCycle < amountOfProducts) {
            String s = sc.nextLine();
            if ("exit".equals(s)) {
                break;
            }
            countOfCycle++;

            String[] parts = s.split(" ");

            if (check.checkLength(parts)) {
                continue;
            }

            String productName = parts[0];
            int productCost;
            int productCount;
            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            if (parts.length != 3) {
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            boolean productAlreadyExists = false;
            for (int i = 0; i < amountOfProducts; i++) {
                if (productName.equals(masOfProducts[i])) {
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }
            if (!productAlreadyExists) {
                //for (int i = 0; i < 5; i++){
                //  if(masOfProducts[i] == ){
                masOfProducts[countOfProducts] = productName;
                masOfCosts[countOfProducts] = productCost;
                masOfCounts[countOfProducts] = productCount;
                countOfProducts++;
                //}
                //}
            }

        }

        String[] sortedProducts = new String[amountOfProducts];
        System.arraycopy(masOfProducts, 0, sortedProducts, 0, amountOfProducts);

        Arrays.sort(sortedProducts, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null || o2 == null) return 1;
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });

        System.out.println(Arrays.toString(sortedProducts));

        long sum = 0;
        for (int i = 0; i < amountOfProducts; i++) {
            sum += (long) masOfCosts[i] * masOfCounts[i];
        }

        System.out.println("Final order price: " + sum);

        double amountOfProducts1 = amountOfProducts;
        if (amountOfProducts1 > 3) {
            amountOfProducts1 = 3;
        }

        for (int j = 0; j < amountOfProducts1; j++) {
            int indexOfMostPopulatedProduct = 0;
            for (int i = 0; i < amountOfProducts; i++) {
                if (masOfCounts[i] > masOfCounts[indexOfMostPopulatedProduct]) {
                    indexOfMostPopulatedProduct = i;
                }
            }
            System.out.println("Most popular product is " + masOfProducts[indexOfMostPopulatedProduct]);
            masOfProducts[indexOfMostPopulatedProduct] = null;
            masOfCounts[indexOfMostPopulatedProduct] = 0;
            masOfCosts[indexOfMostPopulatedProduct] = 0;
        }
    }
}