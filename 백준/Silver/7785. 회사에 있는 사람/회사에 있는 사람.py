from sys import stdin
input = stdin.readline


def solve():
    n = int(input())

    system = {}
    for _ in range(n):
        log = input().split()
        if log[1] == 'enter':
            system[log[0]] = 1
        else:
            system[log[0]] = 0

    result = sorted([k for k, v in system.items() if v], reverse=True)
    for r in result:
        print(r)


if __name__ == "__main__":
    solve()
