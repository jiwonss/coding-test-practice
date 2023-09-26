from sys import stdin
input = stdin.readline

def row(r, c, n):
    for x in range(9):
        if x != c and sdoku[r][x] == n:
            return 0
    return 1

def col(r, c, n):
    for x in range(9):
        if x != r and sdoku[x][c] == n:
            return 0
    return 1

def square(r, c, n):
    nr, nc = (r // 3) * 3, (c // 3) * 3 
    for x in range(3):
        for y in range(3):
            if not (r == nr + x and c == nc + y) and sdoku[nr + x][nc + y] == n:
                return 0
    return 1

def dfs(k, r, c, n):
    if k > 0:
        if not row(r, c, n): return
        if not col(r, c, n): return
        if not square(r, c, n): return

    if k >= len(zero):
        for i in range(9):
            print("".join(map(str, sdoku[i])))
        exit()
    
    nr, nc = zero[k]
    for i in range(1, 10):
        sdoku[nr][nc] = i
        dfs(k + 1, nr, nc, i)
        sdoku[nr][nc] = 0

sdoku = [list(map(int, input().strip())) for _ in range(9)]
zero = [(i, j) for i in range(9) for j in range(9) if not sdoku[i][j]]

dfs(0, 0, 0, 0)