from sys import stdin
from collections import deque
input = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs():
    while q:
        x, y, time = q.popleft()
        if board[x][y] == '@':
            if x == 0 or x == h - 1 or y == 0 or y == w - 1:
                print(time + 1)
                return
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx >= h or ny < 0 or ny >= w:
                    continue
                if board[nx][ny] == '.':
                    board[nx][ny] = board[x][y]
                    q.append([nx, ny, time + 1])
        else:
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx >= h or ny < 0 or ny >= w:
                    continue
                if board[nx][ny] == '.':
                    board[nx][ny] = board[x][y]
                    q.append([nx, ny, -1])
    print("IMPOSSIBLE")

t = int(input())
for _ in range(t):
    w, h = map(int, input().split())
    board = []
    q = deque()
    for i in range(h):
        board.append(list(input().strip()))
        for j in range(w):
            if board[i][j] == '@':
                q.append([i, j, 0])
            if board[i][j] == '*':
                q.appendleft([i, j, -1])
    bfs()