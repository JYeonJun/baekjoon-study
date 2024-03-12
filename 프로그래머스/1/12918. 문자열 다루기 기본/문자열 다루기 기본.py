def solution(s):
    answer = True
    
    if len(s) == 4 or len(s) == 6:
        for ch in s:
            if not ch.isdigit():
                answer = False
    else:
        answer = False
    return answer