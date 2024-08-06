from sys import stdin
input = stdin.readline

def check(x, y, n):
    for i in range(x, x + n):
        for j in range(y, y + n):
            if video[x][y] != video[i][j]:
                return 0
    return 1

def solve(x, y, n):
    global answer
    if check(x, y, n):
        answer += video[x][y]
        return
    t = n // 2
    answer += '('
    for i in range(2):
        for j in range(2):
            solve(x + i * t, y + j * t, t)
    answer += ')'

N = int(input())
video = [list(input().strip()) for _ in range(N)]

answer = ''
solve(0, 0, N)
print(answer)