/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int platformsNeeded(int arrival[], int departure[]){
		int i=0;
        int j=0;
        int plat = 0;
        int khali = 0;
        Arrays.sort(arrival);
        Arrays.sort(departure);
        while(i<arrival.length && j<departure.length)
        {
            if(arrival[i]<departure[j])
            {
                if(khali==0)
                    plat++;
                else
                    khali--;
                i++;
            }
            else if(arrival[i]>departure[j])
            {
                j++;
                khali++;
            }
            else
            {
                i++;
                j++;
            }
            //System.out.println("plat:"+plat+" khali:"+khali);
        }
        return plat;
		
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    int dep[] = new int[n];
		    for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		    for(int i=0;i<n;i++) dep[i] = sc.nextInt();
		    System.out.println(platformsNeeded(arr,dep));
		}
	}
}
