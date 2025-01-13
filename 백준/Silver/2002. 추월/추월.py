from sys import stdin
from collections import deque

input = stdin.readline


def solve():
    N = int(input())
    q = deque([input().strip() for _ in range(N)])

    result = 0
    for _ in range(N):
        car = input().strip()
        temp = []
        while q and q[0] != car:
            temp.append(q.popleft())
        q.popleft()
        if temp:
            result += 1
            while temp:
                q.appendleft(temp.pop())
    print(result)


if __name__ == "__main__":
    solve()