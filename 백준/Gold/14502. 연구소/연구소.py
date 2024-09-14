from sys import stdin
from collections import deque

input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def count_safe_zone(board):
    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                cnt += 1
    return cnt


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
    return count_safe_zone(board)


def build(k):
    global result

    if k == 3:
        result = max(result, bfs([b[:] for b in board]))
        return

    for i in range(N):
        for j in range(M):
            if board[i][j] != 0:
                continue
            board[i][j] = 1
            build(k + 1)
            board[i][j] = 0


def solve():
    global N, M, board, virus, result

    N, M = map(int, input().split())

    board, virus = [], []
    for i in range(N):
        board.append(list(map(int, input().split())))
        for j in range(M):
            if board[i][j] == 2:
                virus.append([i, j])

    result = 0
    build(0)
    print(result)


if __name__ == "__main__":
    solve()
