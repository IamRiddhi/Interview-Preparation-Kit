class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        lst = []
        j = 0
        if len(intervals) == 0:
            lst.append(newInterval)
            return lst
        if len(newInterval)==0:
            return intervals
        lo = 0
        hi = len(intervals) - 1
        while lo<= hi:
            mid = lo + (hi-lo)//2
            if intervals[mid][0] == newInterval[0]:
                lo = mid
                break
            elif intervals[mid][0] < newInterval[0]:
                lo = mid + 1
            else:
                hi = mid - 1
        for i in range(lo):
            lst.append(intervals[i])
            j += 1
        if j>0 and newInterval[0] <= lst[j-1][1]:
            if newInterval[1] > lst[j-1][1]:
                lst[j-1][1] = newInterval[1]
        else:
            lst.append(newInterval)
            j += 1
        for i in range(lo,len(intervals)):
            if intervals[i][0] <= lst[j-1][1]:
                if intervals[i][1] > lst[j-1][1]:
                    lst[j-1][1] = intervals[i][1]
            else:
                lst.append(intervals[i])
                j += 1
        return lst
