public class Another {
    public static void main(String[] args) {
        String orderInfo = "1,огурцы,20.05;2,помидоры,123.45;3,зайцы,0.50";
        System.out.println(getTotalOrderAmount(orderInfo));
        // Вывод: 144.0
    }

    static double getTotalOrderAmount(String orderInfo) {
        double totalAmount = 0d;
        final String[] items = orderInfo.split(";");

        for (String item : items) {
            final String[] itemInfo = item.split(",");
            totalAmount += Double.parseDouble(itemInfo[2]);
        }

        return totalAmount;
    }
}
