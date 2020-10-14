package q00121;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitInSingle {
    public static void main(String[] args) {
        MaxProfitInSingle main = new MaxProfitInSingle();
        int profit1 = main.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(profit1);
        int profit2 = main.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(profit2);
        int profit3 = main.maxProfit(new int[]{7,6,4,3,1});
        System.out.println(profit3);
    }

    public int maxProfit(int[] prices) {
        int p = 0;
        for (int i=0; i<prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                int min = prices[i];
                int max = min;
                for (int j=i+1; j<prices.length;j++) {
                    if (prices[j] <= min) {
                        i = j-1;
                    } else if (prices[j] > max) {
                        max = prices[j];
                    }
                }
                p = Math.max(p, max - min);
            }
        }
        return p;
    }
}
