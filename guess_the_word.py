import random

class Solution:
    def findSecretWord(self, wordlist, master):
        candidates = set(wordlist)
        
        while candidates:
            guess_word = random.choice(list(candidates))
            matching_chars = master.guess(guess_word)
            
            if matching_chars == 6:
                return  # If the guess is correct, exit
            
            self.remove_words_with_matching_chars(candidates, guess_word, matching_chars)
    
    def remove_words_with_matching_chars(self, candidates, guess_word, matching_chars):
        for word in list(candidates):
            if self.count_matching_chars(word, guess_word) != matching_chars:
                candidates.remove(word)
    
    def count_matching_chars(self, word1, word2):
        return sum(c1 == c2 for c1, c2 in zip(word1, word2))
