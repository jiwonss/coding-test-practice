from sys import stdin
input = stdin.readline


def solve():
    result = []
    for _ in range(7):
        n = int(input())
        if n % 2 != 0:
            result.append(n)
    if not result:
        print(-1)
        return
    print(sum(result))
    print(min(result))


if __name__ == "__main__":
    solve()
