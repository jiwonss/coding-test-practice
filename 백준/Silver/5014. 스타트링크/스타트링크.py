from sys import stdin
from collections import deque
input = stdin.readline


def bfs():
    q = deque()
    visited = [0] * (F + U + 1)

    q.append([S, 0])
    visited[S] = 1

    while q:
        x, cnt = q.popleft()
        if x == G:
            print(cnt)
            return
        for v in [x + U, x - D]:
            if v <= 0 or v > F or visited[v]:
                continue
            visited[v] = 1
            q.append([v, cnt + 1])
    print("use the stairs")


def solve():
    global F, S, G, U, D

    F, S, G, U, D = map(int, input().split())
    bfs()


if __name__ == "__main__":
    solve()
