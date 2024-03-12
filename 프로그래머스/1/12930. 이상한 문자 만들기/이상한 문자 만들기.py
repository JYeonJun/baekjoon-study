def solution(s):
    answer = []
    idx = 0
    for char in s:
        if char == ' ':
            answer.append(' ')
            idx = 0
        else:
            if idx & 1 == 1: # 홀수번째인 경우
                answer.append(char.lower())
            else:
                answer.append(char.upper())
            idx += 1
        
    return ''.join(answer)