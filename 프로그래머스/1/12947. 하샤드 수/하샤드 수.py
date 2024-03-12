def solution(x):
    
    return x % sum(map(lambda k: int(k), list(str(x)))) == 0