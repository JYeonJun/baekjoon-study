def solution(babbling):
    
    word = ['aya', 'ye', 'woo', 'ma']
    answer = 0
    
    for b in babbling:
        for w in word:
            if w * 2 not in b:
                b = b.replace(w, ' ')
                
        if b.isspace():
            answer += 1
            
    return answer