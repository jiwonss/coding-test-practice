from sys import stdin
from collections import deque
input = stdin.readline

dx = [2, 1, -1, -2, -2, -1, 1, 2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        if [x, y] == end:
            break
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= I or ny < 0 or ny >= I:
                continue
            if board[nx][ny]:
                continue
            board[nx][ny] = board[x][y] + 1
            q.append([nx, ny])

t = int(input())
for _ in range(t):
    I = int(input())
    start, end = list(map(int, input().split())), list(map(int, input().split()))
    board = [[0] * I for _ in range(I)]
    bfs(start)
    print(board[end[0]][end[1]])
                
