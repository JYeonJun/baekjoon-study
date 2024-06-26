import math

def solution(left, right):
    answer = 0
    
    for i in range(left, right + 1):
        if int(math.sqrt(i)) == math.sqrt(i):
            answer -= i
        else:
            answer += i
    
    return answer
