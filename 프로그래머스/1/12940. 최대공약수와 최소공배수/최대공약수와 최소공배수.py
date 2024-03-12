import math
def solution(n, m):
    return [get_gcd(n, m), get_lcm(n, m)]

def get_gcd(n, m):
    while m > 0:
        n, m = m, n % m
    return n

def get_lcm(n, m):
    return (n * m) / get_gcd(n, m)