def solution(t, p):
    answer = 0
    
    p_len = len(p)
    
    for i in range(0, len(t) - p_len + 1):
        if ''.join(t[i: i + p_len]) <= p:
            answer += 1
        
    return answer