from sys import stdin

input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        X = input().strip()
        result = set()
        for x in X:
            result.add(x)
        print(len(result))


if __name__ == "__main__":
    solve()
