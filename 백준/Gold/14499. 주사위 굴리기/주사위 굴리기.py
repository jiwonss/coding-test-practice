from sys import stdin
input = stdin.readline

dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def solve():
    global N, M, board, dice

    N, M, x, y, K = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    op = list(map(int, input().split()))

    dice = [0] * 6
    for i in range(K):
        d = op[i] - 1
        nx = x + dx[d]
        ny = y + dy[d]

        if out_of_bounds(nx, ny):
            continue

        if d == 0:
            dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
        if d == 1:
            dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
        if d == 2:
            dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
        if d == 3:
            dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]

        if board[nx][ny]:
            dice[5] = board[nx][ny]
            board[nx][ny] = 0
        else:
            board[nx][ny] = dice[5]

        x, y = nx, ny
        print(dice[0])


if __name__ == "__main__":
    solve()
