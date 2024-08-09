from sys import stdin
from collections import deque
input = stdin.readline


def bfs():
    q = deque()
    visited = [0] * (N + 1)

    q.append([N, [N]])

    while q:
        x, log = q.popleft()

        if x == 1:
            print(len(log) - 1)
            print(*log)
            return

        if visited[x]:
            continue

        visited[x] = 1
        if x % 2 == 0:
            nx = x // 2
            q.append([nx, log + [nx]])
        if x % 3 == 0:
            nx = x // 3
            q.append([nx, log + [nx]])
        nx = x - 1
        q.append([nx, log + [nx]])


def solve():
    global N

    N = int(input())

    bfs()


if __name__ == "__main__":
    solve()
