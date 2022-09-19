class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        
        if not strs:
            return strs
        
        tmp_res = {}
        for i, string in enumerate(strs):
            sort = ''.join(sorted(string))
            if sort in tmp_res:
                tmp_res[sort].append(i)
            else:
                tmp_res[sort] = [i]
            
        res = []
        for key, val in tmp_res.items():
            res.append([strs[i] for i in val])
            
        return res