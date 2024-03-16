def solution(players, callings):
    
    players_rate = {p : idx for idx, p in enumerate(players)}
    
    for c in callings:
        c_rank = players_rate[c]
        players_rate[c] -= 1
        players_rate[players[c_rank - 1]] += 1
        players[c_rank - 1], players[c_rank] = players[c_rank], players[c_rank - 1]
    
    return players