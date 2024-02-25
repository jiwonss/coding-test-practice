from sys import stdin
input = stdin.readline

n = int(input())
board = []
head = []
for i in range(n):
    board.append(list(input().strip()))
    if not head and '*' in board[i]:
        for j in range(n):
            if board[i][j] == '*':
                head = [i, j]
                break

heart = [head[0] + 1, head[1]]
body = [0, 0, 0, 0, 0]
for i in range(heart[1] - 1, -1, -1):
    if board[heart[0]][i] == '*':
        body[0] += 1
for i in range(heart[1] + 1, n):
    if board[heart[0]][i] == '*':
        body[1] += 1
for i in range(heart[0] + 1, n):
    if board[i][heart[1]] == '*':
        body[2] += 1
for i in range(heart[0] + 1, n):
    if board[i][heart[1] - 1] == '*':
        body[3] += 1
    if board[i][heart[1] + 1] == '*':
        body[4] += 1
print(heart[0] + 1, heart[1] + 1)
print(*body)