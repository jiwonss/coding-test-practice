from sys import stdin

input = stdin.readline


def check():
    if "0" not in N:
        return 0
    if sum(map(int, N)) % 3 != 0:
        return 0
    return 1


def solve():
    global N, result

    N = list(input().strip())

    if check():
        print("".join(sorted(N, reverse=True)))
    else:
        print(-1)


if __name__ == "__main__":
    solve()
