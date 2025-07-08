import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        int prices[] = {7,1,5,3,6,4};
        int prices[] = {7, 6, 4, 3, 1};
        System.out.println(profit(prices));
    }

    static int profit(int prices[]) {
        int dupArr[] = Arrays.copyOf(prices, prices.length);
        Arrays.sort(dupArr);
        System.out.println(Arrays.toString(dupArr));
        boolean isMinValueSearched = false;
        int minVal = dupArr[0];
        int minIndex = 0;
        int maxVal = 0;
        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            if (val == minVal) {
                minIndex = prices[i];
                break;
            }
        }
        for (int i = minIndex + 1; i < prices.length; i++) {
            int max = prices[i] - prices[minIndex];
            if (maxVal < max) {
                maxVal = max;
            }
        }
        return maxVal;
    }
}
