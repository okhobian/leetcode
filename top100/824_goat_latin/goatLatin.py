class Solution:
    def toGoatLatin(self, S: str) -> str:
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        words = S.split()
        result = [None]*len(words)
        
        for i, word in enumerate(words):
            if word[0] in vowels:
                result[i] = word + 'ma' + (i+1)*'a'
            else:
                result[i] = word[1:] + word[0] + 'ma' + (i+1)*'a'
        
        return ' '.join(result)            