from sys import stdin
from collections import deque
input = stdin.readline

n, m = map(int, input().split())
board = []
for i in range(n):
    board.append(list(input().strip()))
    if 'R' or 'B' in board[i]:
        for j in range(m):
            if board[i][j] == 'R':
                rx, ry = i, j
            if board[i][j] == 'B':
                bx, by = i, j
q = deque()
visited = [[[[0] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

q.append([rx, ry, bx, by, 1])
visited[rx][ry][bx][by] = 1

def move(x, y, dx, dy):
    cnt = 0
    while board[x + dx][y + dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        cnt += 1
    return x, y, cnt

def bfs():
    while q:
        rx, ry, bx, by, cnt = q.popleft()
        if cnt > 10:
            break
        for i in range(4):
            nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = move(bx, by, dx[i], dy[i])
            if board[nbx][nby] == 'O':
                continue
            if board[nrx][nry] == 'O':
                print(cnt)
                return
            if nrx == nbx and nry == nby:
                if rcnt > bcnt:
                    nrx, nry = nrx - dx[i], nry - dy[i]
                else:
                    nbx, nby = nbx - dx[i], nby - dy[i]
            if not visited[nrx][nry][nbx][nby]:
                visited[nrx][nry][nbx][nby] = 1
                q.append([nrx, nry, nbx, nby, cnt + 1])
    print(-1)

bfs()
