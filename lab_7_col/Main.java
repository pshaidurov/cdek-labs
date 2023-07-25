package lab_7_col;

import java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MrArrayList<Integer> mrArrayList = new MrArrayList<>();


        mrArrayList.add(1);
        mrArrayList.add(2);
        mrArrayList.add(3);
        mrArrayList.add(4);
        mrArrayList.add(5);
        mrArrayList.add(6);
        mrArrayList.get(2);
        mrArrayList.show();
        mrArrayList.remove(1);
        mrArrayList.remove(2);
        mrArrayList.remove(3);
        mrArrayList.show();
        mrArrayList.get(2);

        /*Scanner sc = new Scanner(System.in);

        String operation = sc.nextLine();

        if (operation.equals("add")){
            int oper = Integer.parseInt(operation);
            mrArrayList.add();
        }*/
    }
}