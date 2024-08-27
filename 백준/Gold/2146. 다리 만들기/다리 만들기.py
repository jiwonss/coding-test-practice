from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < N)


def find_island():
    q, island = deque(), deque()
    visited = [[0] * N for _ in range(N)]
    distance = [[-1] * N for _ in range(N)]

    idx = 1
    for i in range(N):
        for j in range(N):
            if visited[i][j] or board[i][j] == 0:
                continue

            visited[i][j] = 1
            q.append([i, j])

            while q:
                x, y = q.popleft()
                board[x][y] = idx
                island.append([x, y])
                distance[x][y] = 0
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if out_of_bounds(nx, ny):
                        continue
                    if visited[nx][ny] or board[nx][ny] == 0:
                        continue
                    visited[nx][ny] = 1
                    q.append([nx, ny])
            idx += 1
    return [island, distance]


def get_distance(island, distance):
    global result

    while island:
        x, y = island.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if out_of_bounds(nx, ny) or board[x][y] == board[nx][ny]:
                continue
            if board[nx][ny]:
                result = min(result, distance[x][y] + distance[nx][ny])
            else:
                board[nx][ny] = board[x][y]
                distance[nx][ny] = distance[x][y] + 1
                island.append([nx, ny])


def solve():
    global N, board, result

    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    island, distance = find_island()

    result = 10001
    get_distance(island, distance)
    print(result)


if __name__ == "__main__":
    solve()
