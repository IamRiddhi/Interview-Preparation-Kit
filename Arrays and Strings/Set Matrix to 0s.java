class Solution {
    public void setZeroes(int[][] a) {
        int n = a.length;
	    int m = a[0].length;
	    boolean rowFlag = false;
	    boolean colFlag = false;
	    for(int i=0;i<n;i++)
	        for(int j=0;j<m;j++)
	        {
	            if(a[i][j] == 0)
	            {
	                if(i==0 && j==0)
	                   {
	                       rowFlag = true;
	                       colFlag = true;
	                   }
	                else if(i==0)
	                    rowFlag = true;
	                 else if(j==0)
	                    colFlag = true;
	                 else
	                    a[0][j] = a[i][0] = 0;
	            }
	        }
	        
	        for(int i=1;i<n;i++)
	            for(int j=1;j<m;j++)
	            {
	                if(a[0][j] == 0 || a[i][0] == 0)
	                    a[i][j] = 0;
	            }
            
            if(colFlag)	        
	            for(int i=0;i<n;i++)
	                a[i][0] = 0;
	       
	       if(rowFlag)
	            for(int j=0;j<m;j++)
	                a[0][j] = 0;
	        
    }
}
