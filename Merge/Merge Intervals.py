class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        lst = []
        if len(intervals)==0:
            return lst
        intervals = sorted(intervals,key = lambda x:x[0])
        lst.append(intervals[0])
        j = 1
        for i in range(1,len(intervals)):
            lo = intervals[i][0]
            hi = intervals[i][1]
            if lo<=lst[j-1][1]:
                if hi>lst[j-1][1]:
                    lst[j-1][1] = hi
            else:
                lst.append(intervals[i])
                j += 1
        return lst
