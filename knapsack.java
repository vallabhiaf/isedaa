package check;

public class knapsack {
	static int max(int a,int b)
	{
		return (a>b)?a:b;
		
	}
	static int knapSack(int W,int wt[],int val[],int n) {
		int i,w,j;
		w=0;
		int k[][]=new int [n+1][W+1];
		int x[]=new int[10];
		for(i=0;i<=n;i++)
		{
			for(w=0;w<=W;w++)
			{
				if(i==0|| w==0)
					k[i][w]=0;
				else if(wt[i-1]<=w)
					k[i][w]=max(val[i-1]+k[i-1][w-wt[i-1]],k[i-1][w]);
				else 
					k[i][w]=k[i-1][w];
				
			}
			
		}
		for(i=1;i<=n;i++)
			x[i]=0;
			i=n;
			 j=W;
			while(i>0&&j>0)
			{
			if(k[i][j]!=k[i-1][j])
			{
			x[i]=1;
			
			j=j-wt[i-1];
			}
			i--;
			}
		System.out.println("The optimal set of items \n");
		for(i=1;i<=n;i++)
		{
		if(x[i]==1) {
			System.out.println(i);
			
		}
			
		}
			return k[n][W];
	}
	
	 public static void main(String args[])
	    {
	        int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack(W, wt, val, n));
	    }

}
