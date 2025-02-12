def solution(park, routes):
    w, h = len(park), len(park[0])
    direction = {"N" : [-1, 0], "S" : [1, 0], "W" : [0, -1], "E" : [0, 1]}
    
    answer = [0, 0]
    for i in range(w):
        for j in range(h):
            if park[i][j] == 'S':
                answer = [i, j]
    
    for route in routes:
        op, n = route.split()
        x, y = answer
        for _ in range(int(n)):
            nx = x + direction[op][0]
            ny = y + direction[op][1]
            if nx < 0 or nx >= w or ny < 0 or ny >= h:
                break
            if park[nx][ny] == 'X':
                break
            x, y = nx, ny
        else:
            answer = [x, y]
    return answer