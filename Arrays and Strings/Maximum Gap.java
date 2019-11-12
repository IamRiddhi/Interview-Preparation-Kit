class Bucket
{
    public int minimum = Integer.MAX_VALUE;
    public int maximum = Integer.MIN_VALUE;
}
class Solution {
    public int maximumGap(int[] nums) {
        
        int n = nums.length;
        
        if(n<2)
            return 0;
        
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            minimum = Math.min(nums[i],minimum);
            maximum = Math.max(nums[i],maximum);
        }
        
        int bucketSize = Math.max(1,(maximum-minimum)/(n-1)); 
        int noOfBuckets = (int)Math.ceil((double)(maximum-minimum+1)/bucketSize);
        
        Bucket[] buckets = new Bucket[noOfBuckets];
        
        // insert elements into appropriate buckets
        for(int element : nums)
        {
            int bucketIndex = (element-minimum)/bucketSize;
            if(buckets[bucketIndex]==null)
                buckets[bucketIndex] = new Bucket();
            buckets[bucketIndex].maximum = Math.max(buckets[bucketIndex].maximum,element);
            buckets[bucketIndex].minimum = Math.min(buckets[bucketIndex].minimum,element);
        }
        // get max-gap inter buckets
        int maxGap = 0;
        Bucket prevBucket = null;
        for(int i=0;i<buckets.length;i++)
        {
            if(prevBucket != null && buckets[i] != null)
                maxGap = Math.max(buckets[i].minimum-prevBucket.maximum,maxGap);
            if(buckets[i] != null)
                prevBucket = buckets[i];
        }
        
        return maxGap;
        
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().maximumGap(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
