def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    
    cnt = 0
    for i in range(len(win_nums)):
        if lottos[i] in win_nums:
            cnt += 1
    
    return [rank[cnt + lottos.count(0)], rank[cnt]]