import sys
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        #finding the left boundary of the unsorted array i.e the min element of the unsorted subarray
        leftmin = sys.maxsize
        prev = -sys.maxsize - 1
        fl = False
        for x in nums:
            if fl:
                leftmin = min(x,leftmin)
            elif x < prev:
                fl = True
                leftmin = min(x,leftmin)
            else:
                prev = x
        
        #finding the right boundary of the unsorted array i.e the max element of the unsorted subarray
        prev = sys.maxsize
        rightmax = -sys.maxsize - 1
        fl = False
        for i in range(len(nums)-1,-1,-1):
            if fl:
                rightmax = max(nums[i],rightmax)
            elif nums[i] > prev:
                fl = True
                rightmax = max(nums[i],rightmax)
            else:
                prev = nums[i]
                
        #finding the correct index of the min element of the unsorted subarray        
        leftind = 0
        for i in range(len(nums)):
            if leftmin < nums[i]:
                leftind = i
                break
        
         #finding the correct index of the max element of the unsorted subarray      
        rightind = -1
        for i in range(len(nums)-1,-1,-1):
            if rightmax > nums[i]:
                rightind = i
                break
                
        return rightind - leftind + 1
        
