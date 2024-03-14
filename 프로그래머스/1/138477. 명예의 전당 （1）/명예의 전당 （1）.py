import math
def solution(k, score):
    answer = []
    
    award = []
    min_score = score[0]
    for s in score:
        if len(award) == k:
            if s >= min_score:
                award.remove(min_score)
                award.append(s)
                award.sort()
                min_score = award[0]
        else:
            award.append(s)
            min_score = min(min_score, s)
        answer.append(min_score)
    
    return answer