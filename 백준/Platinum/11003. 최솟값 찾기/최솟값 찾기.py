from sys import stdin
from collections import deque
input = stdin.readline


def solve():
    N, L = map(int, input().split())
    A = list(map(int, input().split()))

    q, D = deque(), []
    for i in range(N):
        while q and q[-1][1] > A[i]:
            q.pop()
        while q and q[0][0] < i - L + 1:
            q.popleft()
        q.append([i, A[i]])
        D.append(q[0][1])
    print(*D)


if __name__ == "__main__":
    solve()
