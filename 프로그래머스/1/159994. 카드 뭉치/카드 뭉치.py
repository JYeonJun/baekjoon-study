def solution(cards1, cards2, goal):
    answer = 'Yes'
    
    for s in goal:
        c1 = cards1[0] if len(cards1) > 0 else ''
        c2 = cards2[0] if len(cards2) > 0 else ''
        if s == c1:
            cards1.pop(0)
        elif s == c2:
            cards2.pop(0)
        else:
            answer = 'No'
            break
    
    return answer