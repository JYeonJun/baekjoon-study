def solution(food):
    
    answer = []
    for i, cnt in enumerate(food[1:]):
        answer.append(str(i + 1) * (cnt//2))
    return ''.join(answer) + '0' + ''.join(answer[::-1])