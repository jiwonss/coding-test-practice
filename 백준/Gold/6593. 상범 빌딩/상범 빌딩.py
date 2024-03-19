from sys import stdin
from collections import deque
input = stdin.readline

dx = [1, 0, -1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

while True:
    L, R, C = map(int, input().split())

    if L == 0 and R == 0 and C == 0:
        break

    q = deque()
    building = [[] for _ in range(L)]
    end = []
    for k in range(L):
        for i in range(R):
            building[k].append(list(input().strip()))
            if 'S' in building[k][i]:
                for j in range(C):
                    if building[k][i][j] == 'S':
                        q.append([k, i, j, 0])
                        break
            elif 'E' in building[k][i]:
                for j in range(C):
                    if building[k][i][j] == 'E':
                        building[k][i][j] = '.'
                        end.append([k, i, j])
                        break
        input()

    check = 0
    while q:
        z, x, y, s = q.popleft()
        if [z, x, y] == end[0]:
            check = 1
            print(f'Escaped in {s} minute(s).')
            break
        for d in range(6):
            nx = x + dx[d]
            ny = y + dy[d]
            nz = z + dz[d]
            if 0 <= nx < R and 0 <= ny < C and 0 <= nz < L:
                if building[nz][nx][ny] == '.':
                    building[nz][nx][ny] = building[z][x][y]
                    q.append([nz, nx, ny, s + 1])
    
    if not check:
        print('Trapped!')