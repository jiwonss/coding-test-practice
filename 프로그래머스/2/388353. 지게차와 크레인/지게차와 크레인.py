from collections import deque

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def solution(storage, requests):
    n, m = len(storage), len(storage[0])
    grid = [['.'] * (m + 2) for _ in range(n + 2)]
    
    for i in range(n):
        for j in range(m):
            grid[i + 1][j + 1] = storage[i][j]

    container_type = set()
    for s in storage:
        container_type.update(s)

    def bfs(target):
        q = deque([(0, 0)])
        visited = [[0] * (m + 2) for _ in range(n + 2)]
        visited[0][0] = 1
        
        remove_list = []
        while q:
            x, y = q.popleft()
            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]
                if not (0 <= nx < n + 2 and 0 <= ny < m + 2): continue
                if visited[nx][ny] == 1: continue
                if grid[nx][ny] == '.':
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                elif grid[nx][ny] == target:
                    visited[nx][ny] = 1
                    remove_list.append((nx, ny))
        return remove_list

    answer = n * m
    for request in requests:
        target = request[0]
        if target not in container_type: continue

        if len(request) == 1:
            for x, y in bfs(target):
                grid[x][y] = '.'
                answer -= 1
        else:
            for i in range(1, n + 1):
                for j in range(1, m + 1):
                    if grid[i][j] == target:
                        grid[i][j] = '.'
                        answer -= 1
            container_type.remove(target)
            
    return answer