from sys import stdin
input = stdin.readline

dr, dc = [-1, 0, 1, 0], [0, 1, 0, -1]


def out_of_bounds(r, c):
    return not (0 <= r < N and 0 <= c < M)


def clean(r, c, d):
    result = 1
    while True:
        board[r][c] = 2

        check = 0
        for _ in range(4):
            d = (d - 1) % 4
            nr = r + dr[d]
            nc = c + dc[d]
            if out_of_bounds(nr, nc) or board[nr][nc] > 0:
                continue
            check = 1
            result += 1
            r, c = nr, nc
            break

        if not check:
            nr = r - dr[d]
            nc = c - dc[d]
            if out_of_bounds(nr, nc) or board[nr][nc] == 1:
                return result
            r, c = nr, nc


def solve():
    global N, M, board

    N, M = map(int, input().split())
    r, c, d = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]

    print(clean(r, c, d))


if __name__ == "__main__":
    solve()
