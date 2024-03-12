import math

def solution(left, right):
    answer = 0
    
    for i in range(left, right + 1):
        if is_divisor_count_even(i): # 짝수라면
            answer += i
        else:
            answer -= i
    
    return answer

def is_divisor_count_even(num):
    cnt = 0
    for i in range(1, int(math.sqrt(num)) + 1):
        if num % i == 0:
            if i**2 == num:
                cnt += 1
            else:
                cnt += 2
    return cnt & 1 == 0