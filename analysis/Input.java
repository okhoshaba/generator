public class Input {
    public static void main(String[] args) {

        String s = "";
        int n = 0;
//        boolean flag = false;

        try {
            s = args[0];
        } catch (Exception e) {
            System.out.println("The first argument must be present!");
            System.exit(1);
        }

        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The second argument must be an integer.");
            System.exit(1);
        }

/*        
        try {
            flag = Boolean.parseBoolean(args[2]);
        } catch (Exception e) {
            System.out.println("The third argument must be parseable to boolean.");
            System.exit(1);
        }
*/
        for (int i = 0; i < n; i++) {
            System.out.println(s);
//            if (flag)
//                System.out.println(String.format("Iteration %d", i));
        }
    }
}

