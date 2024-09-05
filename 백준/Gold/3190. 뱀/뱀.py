from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < N)


def rotate(c, d):
    if c == 'L':
        d = (d - 1) % 4
    else:
        d = (d + 1) % 4
    return d


def move():
    time = 0
    x, y, d = 0, 0, 0

    while True:
        x += dx[d]
        y += dy[d]

        time += 1

        if out_of_bounds(x, y) or [x, y] in snake:
            return time

        if info.get(time):
            d = rotate(info[time], d)

        if board[x][y]:
            board[x][y] = 0
            snake.append([x, y])
        else:
            snake.append([x, y])
            snake.popleft()


def solve():
    global N, board, info, snake

    N = int(input())
    K = int(input())

    board = [[0] * N for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        board[x - 1][y - 1] = 1

    L = int(input())
    info = {}
    for _ in range(L):
        X, C = input().split()
        info[int(X)] = C

    snake = deque([[0, 0]])
    print(move())


if __name__ == "__main__":
    solve()
