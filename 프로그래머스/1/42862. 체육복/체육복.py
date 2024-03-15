def solution(n, lost, reserve):
    
    _reserve = [r for r in reserve if r not in lost]
    _lost = [l for l in lost if l not in reserve]
    
    answer = n - len(_lost)
    _reserve.sort()
    _lost.sort()
    for num in _reserve:
        if (num - 1) in _lost:
            answer += 1
            _lost.remove(num - 1)
        elif (num + 1) in _lost:
            answer += 1
            _lost.remove(num + 1)
    
    return answer