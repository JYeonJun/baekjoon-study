def solution(s):
    answer = 0
    
    x = s[0]
    x_cnt, o_cnt = 0, 0
    for i, ch in enumerate(s):
        print(f'x = {x}')
        if ch == x:
            x_cnt += 1
        else:
            o_cnt += 1
        
        if x_cnt != 0 and x_cnt == o_cnt:
            answer += 1
            x_cnt, o_cnt = 0, 0
            x = s[i + 1] if i < len(s) - 1 else '0'
        elif i == len(s) - 1:
            answer += 1
        
    return answer