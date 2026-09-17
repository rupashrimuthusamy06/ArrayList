import java.util.*;

record  GroceryList(String name, String type, int count) {

     public GroceryList(String name){
        this(name, "DIARY", 1);
    }

}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void addItem(ArrayList<String> groceryList) {
        System.out.print("Enter the name of the grocery items to add: ");
        String[] items = scanner.nextLine().split(",");
        for (String item : items) {
            String trimmed = item.trim();
            System.out.println(trimmed);
            System.out.println(groceryList.indexOf(trimmed));

            if (groceryList.indexOf(trimmed) < 0) {
                groceryList.add(trimmed);
            }
        }
        groceryList.sort(Comparator.naturalOrder());
    }

    public static void removeItem(ArrayList<String> groceryList) {
        System.out.print("Enter the name of the grocery item to remove from the list: ");

        String[] items = scanner.nextLine().split(",");

        for (String item : items) {
            String trimmed = item.trim();
            System.out.println(trimmed);
            System.out.println(groceryList.indexOf(trimmed));

            if (groceryList.indexOf(trimmed) > 0) {
                groceryList.remove(trimmed);
            }
        }
        groceryList.sort(Comparator.naturalOrder());
        groceryList.sort(Comparator.reverseOrder());
    }

    public static void printItem() {
        System.out.println(""" 
                Available options is to select:
                 0. To exit the process
                 1. Add an item to the grocery list.
                 2. Remove an item from the grocery list.
                """);
    }

    public static void reverseList(List<Integer> nums, int left, int right) {

        while (left < right) {
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
//         ArrayList<GroceryList> groceryList = new ArrayList<>();
//         groceryList.add(new GroceryList("MILK"));
//         System.out.println(groceryList.getFirst());
//
//         String[] items = {"Apple", "orange", "Mango"};
//         List<String> list = List.of(items);

        ArrayList<String> groceryList1 = new ArrayList<>();
//        groceryList1.add("pineapple");
//        System.out.println(groceryList1);
//
//        groceryList1.add("Cucumber");
//        groceryList1.addAll(Arrays.asList("pomegranate","papaya"));
//        System.out.println(groceryList1);
//
//        groceryList1.remove("pomegranate");
//        System.out.println(groceryList1.contains("pomegranate"));
//
//        System.out.println(groceryList1);
//
//        groceryList1.sort(Comparator.naturalOrder());
//        System.out.println(groceryList1);
//        groceryList1.sort(Comparator.reverseOrder());
//        System.out.println(groceryList1);
//
//
        boolean flag = true;
        while (flag) {
            printItem();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 0:
                    System.out.println("Operation is Complete");
                    flag = false;
                    break;
                case 1:
                    addItem(groceryList1);
                    break;

                case 2:
                    removeItem(groceryList1);
                    System.out.println(groceryList1);
                    break;
            }
            System.out.print(" grocery item: " + groceryList1);
        }
        System.out.println();
        System.out.println("Goodbye!");
        // Move all Zeros to end
        List<Integer> nums = new ArrayList<>(List.of(0, 1, 0, 3, 12));
        System.out.println(nums);
        int insertPos = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != 0) {
                nums.set(insertPos, nums.get(i));
                insertPos++;
            }
        }
        for (int i = insertPos; i < nums.size(); i++) {
            nums.set(i, 0);
        }

        System.out.println("Moving all zeros to end " + nums);


        //Problem: Rotate a list to the right by k steps
        List<Integer> numsRotate = new ArrayList<>(List.of(0, 1, 0, 3, 12));
        int k = 9;
        int n = numsRotate.size();
        if(n == 0){
            System.out.println("Nothing to move");
            return;
        }
        if (k>n && n != 0){
            k = k % n;
            System.out.println(k);

        }
        reverseList(numsRotate , 0 , numsRotate.size()-1);
        System.out.println(numsRotate);
        reverseList(numsRotate , 0 , k-1);
        System.out.println(numsRotate);
        reverseList(numsRotate , k , numsRotate.size()-1);
        System.out.println(numsRotate);

        //        Merge two sorted lists into one sorted list

        List<Integer> a = new ArrayList<>(List.of(1, 1, 2, 4, 5, 6, 7, 9, 10));
        List<Integer> b = new ArrayList<>(List.of(1, 2, 3,5, 6, 7, 8));
        List<Integer> c = new ArrayList<>();
        System.out.println(a.size());
        System.out.println(b.size());

        int i=0;
        int j=0;

        while(i < a.size() && j<  b.size()){
            if(a.get(i) < b.get(j)){
                c.add(a.get(i));
                i++;
                System.out.println("inside the if" + c + " value of i is = " + i);
            }
            else{
                c.add(b.get(j));
                j++;
                System.out.println("inside the else" + c  + " value of j is = " + j);

            }
        }

        while (i >= a.size() && j < b.size()){
            c.add(b.get(j));
            j++;
            System.out.println("inside the next while" + c  + " value of j is = " + j);
        }

        while (i < a.size() && j >= b.size()){
            c.add(a.get(i));
            i++;
            System.out.println("inside the next while" + c  + " value of j is = " + j);
        }

//        if(a.size() > b.size()){
//            for(i = b.size(); i < a.size(); i++){
//                c.add(a.get(i));
//            }
//        }
//        else{
//            for(i = a.size(); i < b.size(); i++){
//                c.add(b.get(i));
//            }
//        }

        System.out.println("The final result" +c);
        }
    }



