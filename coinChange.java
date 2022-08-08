class Solution {

public int coinChange(int[] coins, int amount) {
    int n=coins.length;
    
    int[][] dp=new int[n+1][amount+1];
    
    // Initialization
    
    // 1st row & col
    for(int i=0;i < n+1;i++)
        for(int j=0;j < amount+1;j++){
            if(i==0)
                dp[i][j]=Integer.MAX_VALUE - 1;
            if(j==0)
                dp[i][j]=0;
        }
    
    // 2nd row
    for(int j=1;j < amount+1;j++)
        if(j % coins[0]==0)
            dp[1][j]=j/coins[0];
        else
            dp[1][j]=Integer.MAX_VALUE - 1;
    
    // Iteration
    for(int i=1;i < n+1;i++)
        for(int j=1;j < amount+1;j++)
            if(coins[i-1] <= j)
                dp[i][j]=Math.min(1 + dp[i][j-coins[i-1]],dp[i-1][j]);
            else
                dp[i][j]=dp[i-1][j];
    
    if(dp[n][amount] >= Integer.MAX_VALUE - 1)
        return -1;
    
    return dp[n][amount];
}
}
