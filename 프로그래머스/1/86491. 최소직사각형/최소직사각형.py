import math

def solution(sizes):
    answer = 0
    
    max_max = 0
    min_max = 0
    
    for card in sizes:
        size_max = max(card)    
        size_min = min(card)
        max_max = max(max_max, size_max)
        min_max = max(min_max, size_min)
    
    return max_max * min_max