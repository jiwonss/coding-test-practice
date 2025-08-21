from collections import deque

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def bfs(land, sx, sy):
    q = deque([(sx, sy)])
    
    comp_map[sx][sy] = comp_id
    cnt = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if not (0 <= nx < n and 0 <= ny < m):
                continue
            if comp_map[nx][ny] != -1 or not land[nx][ny]:
                continue
            cnt += 1
            comp_map[nx][ny] = comp_id
            q.append([nx, ny])
    comp_size[comp_id] = cnt
            
def solution(land):
    global n, m, comp_id, comp_size, comp_map
    
    n, m = len(land), len(land[0])
    
    comp_map, comp_size = [[-1] * m for _ in range(n)], dict()
    
    comp_id = 0
    for i in range(n):
        for j in range(m):
            if land[i][j] and comp_map[i][j] == -1:
                bfs(land, i, j)
                comp_id += 1
            
    answer = 0
    for y in range(m):
        s, total = set(), 0
        for x in range(n):
            cid = comp_map[x][y]
            if cid != -1 and cid not in s:
                s.add(cid)
                total += comp_size[cid]
        answer = max(answer, total)
    return answer