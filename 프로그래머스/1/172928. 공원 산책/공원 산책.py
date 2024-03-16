def solution(park, routes):
    map = [[ch for ch in line] for line in park]
    H, W = len(map), len(map[0])
    
    now_point = [0, 0]
    for i in range(len(map)):
        for j in range(len(map[0])):
            if map[i][j] == 'S':
                now_point = [i, j]
    for route in routes:
        check = 0
        direction, num = route.split()[0], int(route.split()[1])
        ny, nx = now_point[0], now_point[1]
        
        if direction == 'N' and ny - num >= 0:
            check = 2
            for i in range(num):
                ny -= 1
                if map[ny][nx] == 'X':
                    check = 1
                    break
        elif direction == 'S' and ny + num < H:
            check = 2
            for i in range(num):
                ny += 1
                if map[ny][nx] == 'X':
                    check = 1
                    break
        elif direction == 'W' and nx - num >= 0:
            check = 2
            for i in range(num):
                nx -= 1
                if map[ny][nx] == 'X':
                    check = 1
                    break
        elif direction == 'E' and nx + num < W:
            check = 2
            for i in range(num):
                nx += 1
                if map[ny][nx] == 'X':
                    check = 1
                    break
        
        if check == 2:
            now_point = [ny, nx]
    
    return now_point