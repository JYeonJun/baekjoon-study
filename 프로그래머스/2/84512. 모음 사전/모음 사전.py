from itertools import *

def solution(word):
    answer = 0
    all_products = create_all_products()
    all_products.sort()
    for i, w in enumerate(all_products):
        if w == word:
            answer = i + 1
    return answer

def create_all_products():
    words = ['A', 'E', 'I', 'O', 'U']
    
    all_products = []
    for i in range(1, 6):
        for p in product(words, repeat=i):
            word = ''.join(p)
            all_products.append(word)
            
    return all_products