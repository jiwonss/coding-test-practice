from sys import stdin
from collections import defaultdict

input = stdin.readline


def solve():
    N, M = map(int, input().split())
    people = defaultdict(int)
    for _ in range(N):
        name = input().strip()
        people[name] = 1
    for _ in range(M):
        name = input().strip()
        people[name] += 1
    
    cnt, result = 0, []
    for k, v in people.items():
        if v == 2:
            cnt += 1
            result.append(k)

    print(cnt)
    for name in sorted(result):
        print(name)


if __name__ == "__main__":
    solve()