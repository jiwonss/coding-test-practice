from sys import stdin
from collections import defaultdict
input = stdin.readline


def solve():
    N, M = map(int, input().split())

    group, person = defaultdict(list), {}
    for _ in range(N):
        group_name = input().strip()
        headcount = int(input())
        for _ in range(headcount):
            name = input().strip()
            group[group_name].append(name)
            person[name] = group_name
        group[group_name].sort()

    for _ in range(M):
        problem = input().strip()
        type = int(input())
        if type:
            print(person[problem])
        else:
            for name in group[problem]:
                print(name)


if __name__ == "__main__":
    solve()
