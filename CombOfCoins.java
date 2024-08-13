class CombOfCoins {
    public int change(int amount, int[] coins) {
        int T[][]= new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
        T[i][0]=0;
        for(int i=0;i<=amount;i++)
        T[0][i]=1;
        for(int i=1;i<T.length;i++){
            for(int j=1;j<T[0].length;j++){
                if(j<coins[i-1])
                T[i][j]=T[i-1][j];
                else if(j>coins[i])
                T[i][j]=T[i][j-coins[i]]+1;
                else
                T[i][j]+=1;
            }
        }
        return Math.max(-1, T[coins.length][amount]);
    }
}