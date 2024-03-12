def solution(phone_number):
    answer = ''
    len_phone_number = len(phone_number)
    for i,ch in enumerate(phone_number):
        if i < len_phone_number - 4:
            answer += '*'
        else:
            answer += ch
    
    return answer