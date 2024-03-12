def solution(num):
    answer = 0
    
    while num != 1:
        if answer == 500:
            answer = -1
            break
        if is_num_env(num):
            num /= 2
        else:
            num = num * 3 + 1
        answer += 1
    
    return answer

def is_num_env(num):
    return int(num) & 1 == 0