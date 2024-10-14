from sys import stdin

input = stdin.readline

dx, dy = [1, 0, -1, 0, 1, -1, -1, 1], [0, 1, 0, -1, 1, 1, -1, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < N)


def check(x, y):
    for d in range(8):
        nx, ny, stone = x, y, [[x, y]]
        while True:
            nx += dx[d]
            ny += dy[d]
            if out_of_bounds(nx, ny) or board[nx][ny] != board[x][y]:
                break
            stone.append([nx, ny])

        if len(stone) >= 5:
            sx, sy = x - dx[d], y - dy[d]
            ex, ey = nx, ny
            if not out_of_bounds(sx, sy) and board[sx][sy] == board[x][y]:
                stone.append([sx, sy])
            if not out_of_bounds(ex, ey) and board[ex][ey] == board[x][y]:
                stone.append([ex, ey])
        if len(stone) == 5:
            return [1, stone]
    return [0]


def gomoku():
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                continue
            result = check(i, j)
            if result[0]:
                return [1, board[i][j], result[1]]
    return [0]


def solve():
    global N, board

    N = 19
    board = [list(map(int, input().split())) for _ in range(19)]

    result = gomoku()
    if result[0]:
        print(result[1])
        x, y = sorted(result[2], key=lambda x: (x[1], x[0]))[0]
        print(x + 1, y + 1)
    else:
        print(0)


if __name__ == "__main__":
    solve()
