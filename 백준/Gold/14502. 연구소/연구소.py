from sys import stdin
from copy import deepcopy
from collections import deque

input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def bfs(board):
    q = deque(virus)

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if out_of_bounds(nx, ny):
                continue
            if board[nx][ny] != 0:
                continue
            board[nx][ny] = 2
            q.append([nx, ny])


def count_safe_zone(board):
    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                cnt += 1
    return cnt


def build(k, board):
    global result

    if k == 3:
        bfs(board)
        result = max(result, count_safe_zone(board))
        return

    for i in range(N):
        for j in range(M):
            if board[i][j] != 0:
                continue
            board[i][j] = 1
            build(k + 1, deepcopy(board))
            board[i][j] = 0


def solve():
    global N, M, virus, result

    N, M = map(int, input().split())

    board, virus = [], []
    for i in range(N):
        board.append(list(map(int, input().split())))
        for j in range(M):
            if board[i][j] == 2:
                virus.append([i, j])

    result = 0
    build(0, deepcopy(board))
    print(result)


if __name__ == "__main__":
    solve()
