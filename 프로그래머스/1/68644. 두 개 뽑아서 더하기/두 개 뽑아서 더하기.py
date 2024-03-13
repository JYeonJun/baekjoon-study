from itertools import combinations

def solution(numbers):
    num_comb = list(combinations(numbers, 2))
    return sorted(set(map(lambda x: sum(x), num_comb)))