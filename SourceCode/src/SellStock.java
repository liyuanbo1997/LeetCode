package SourceCode.src;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 */
public class SellStock {
    //利用动态规划解决问题
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];//每几天 是持有股票还是卖出  该dp表示利润 不管持有还是不持有股票都跟之前无关  我记买入为负  卖出为正  目前假设只有0元
        dp[0][0]=0;dp[0][1] = -prices[0];//第1天持有股票的话 也只能是第一张股票
        for(int i=1;i<prices.length;i++){//0是不持有  1是持有
            dp[i][0] = Math.max(dp[i-1][1]+prices[i]-fee,dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
