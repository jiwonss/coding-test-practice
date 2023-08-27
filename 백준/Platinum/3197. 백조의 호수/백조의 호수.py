from sys import stdin
from collections import deque

input = stdin.readline
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

r, c = map(int, input().split())
lake, swan = [], []
for x in range(r):
    t = list(input().replace('\n', ''))
    lake.append(t)
    for y in range(len(t)):
        if t[y] == 'L':
            swan.append([x, y])

time = [[0] * c for _ in range(r)]

def melt_time_set():
    visited = [[0] * c for _ in range(r)]
    q = deque()
    for i in range(r):
        for j in range(c):
            if lake[i][j] == '.' or lake[i][j] == 'L':
                q.append([i, j])
                time[i][j] = 0
                visited[i][j] = 1

    last_time = 0
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < r and 0 <= ny < c and not visited[nx][ny]:
                q.append([nx, ny])
                time[nx][ny] = time[x][y] + 1
                visited[nx][ny] = 1
                last_time = time[nx][ny]
    return last_time

def bfs(start, mid, end):
    q = deque()
    q.append(start)
    visited = [[0] * c for _ in range(r)]
    while q:
        x, y = q.popleft()
        visited[x][y] = 1
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < r and 0 <= ny < c and not visited[nx][ny]:
                visited[nx][ny] = 1
                if nx == end[0] and ny == end[1]:
                    return True
                if time[nx][ny] <= mid:
                    q.append([nx, ny])
    return False

min_value, max_value = 0, melt_time_set()
answer = max_value
while min_value <= max_value:
    mid = (min_value + max_value) // 2
    if bfs(swan[0], mid, swan[1]):
        answer = mid
        max_value = mid - 1
    else:
        min_value = mid + 1
print(answer)