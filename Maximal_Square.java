package com.leetcode;

public class Maximal_Square {

	
	
//	使用动规解决，维护一个动规数组，表示在每一个顶点处正方形的边长；在每一个顶点处，判断这个顶点是否是1，若为1，则当前位置的dp[i][j]是由
//	dp[i-1][j],dp[i][j-1],dp[i-1][j-1]三者中的较小值加上1组成。
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        
        for (int i = 0; i < m; i++) {
			if(matrix[i][0] == '1'){
				dp[i][0] = 1;
				max = 1;
			}
		}
        
        for (int i = 0; i < n; i++) {
			if(matrix[0][i] == '1'){
				dp[0][i] = 1;
				max = 1;
			}
		}
        
        for(int i = 1; i< m ;i++){
        	for(int j = 1; j < n; j++){
        		if(matrix[i][j] == '0'){
        			dp[i][j] = 0;
        		}else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+1;
					max = Math.max(dp[i][j], max);
				}
        	}
        }
        return max*max;
    }
	
	public static void main(String[] args) {
		char[][] matrix= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(new Maximal_Square().maximalSquare(matrix));

	}

}
