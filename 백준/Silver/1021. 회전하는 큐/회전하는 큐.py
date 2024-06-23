from sys import stdin
from collections import deque
input = stdin.readline


def solve():
    N, M = map(int, input().split())
    target = deque(map(int, input().split()))
    q = deque(i for i in range(1, N + 1))

    result = 0
    for t in target:
        idx = q.index(t)
        while q[0] != t:
            if idx < len(q) - idx:
                q.append(q.popleft())
            else:
                q.appendleft(q.pop())
            result += 1
        q.popleft()
    print(result)


if __name__ == "__main__":
    solve()
