from collections import Counter

def solution(topping):
    answer = 0
    
    chulsu = Counter(topping)
    brother = set()
    
    for top in topping:
        chulsu[top] -= 1
        brother.add(top)
        
        if(chulsu[top] == 0):
            chulsu.pop(top)
        
        if(len(chulsu) == len(brother)):
            answer += 1
    
    return answer