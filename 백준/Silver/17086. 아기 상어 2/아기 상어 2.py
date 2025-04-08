from sys import stdin
from collections import deque

input = stdin.readline

dx, dy = [1, 1, 0, -1, -1, -1, 0, 1], [0, 1, 1, 1, 0, -1, -1, -1]


def solve():
    N, M = map(int, input().split())

    baby_shark, board = deque(), []
    for i in range(N):
        board.append(list(map(int, input().split())))
        for j in range(M):
            if board[i][j]:
                baby_shark.append([i, j])

    result = 0
    while baby_shark:
        x, y = baby_shark.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if not (0 <= nx < N and 0 <= ny < M) or board[nx][ny] != 0:
                continue
            board[nx][ny] = board[x][y] + 1
            result = max(result, board[nx][ny])
            baby_shark.append([nx, ny])

    print(result - 1 if result else 0)


if __name__ == "__main__":
    solve()
