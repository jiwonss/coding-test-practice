from sys import stdin
from collections import deque
input = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
board = [list(input().strip()) for _ in range(12)]

def bfs(a, b):
    q = deque()
    q.append((a, b))
    temp.append((a, b))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 12 and 0 <= ny < 6:
                if board[nx][ny] == board[a][b] and not visited[nx][ny]:
                    q.append((nx, ny))
                    temp.append((nx, ny))
                    visited[nx][ny] = 1

def down():
    for i in range(6):
        for j in range(10, -1, -1):
            for k in range(11, j, -1):
                if board[j][i] != '.' and board[k][i] == '.':
                    board[k][i] = board[j][i]
                    board[j][i] = '.'
                    break


def delete(temp):
    for x, y in temp:
        board[x][y] = '.'

answer = 0
while True:
    flag = 0
    visited = [[0] * 6 for _ in range(12)]
    
    for i in range(12):
        for j in range(6):
            if board[i][j] != '.' and not visited[i][j]:
                visited[i][j] = 1
                temp = []
                bfs(i, j)

                if len(temp) >= 4:
                    flag = 1
                    delete(temp)

    if not flag:        
        break

    down()
    answer += 1
    
print(answer)