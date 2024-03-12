def solution(a, b):
    total_sum = 0
    a, b = min(a, b),max(a, b)
    for i in range(a, b + 1):
        total_sum += i
    return total_sum