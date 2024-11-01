from sys import stdin

input = stdin.readline


def solve():
    msg = input().strip()

    N = len(msg)
    R, C = 0, 0
    for i in range(1, int(N**0.5) + 1):
        if N % i == 0:
            R, C = i, N // i

    result = ""
    for i in range(R):
        for j in range(i, N, R):
            result += msg[j]
    print(result)


if __name__ == "__main__":
    solve()
