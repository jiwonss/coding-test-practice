from sys import stdin
input = stdin.readline


def solve():
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    diff = {a: 1 for a in A}

    for b in B:
        if diff.get(b):
            diff.pop(b)

    print(len(diff))
    if diff:
        print(*sorted(diff.keys()))


if __name__ == "__main__":
    solve()
