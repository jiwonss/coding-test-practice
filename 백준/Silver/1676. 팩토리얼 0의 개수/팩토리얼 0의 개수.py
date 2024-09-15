from sys import stdin

input = stdin.readline


def solve():
    N = int(input())

    factorial = 1
    for i in range(2, N + 1):
        factorial *= i

    result = 0
    while True:
        if factorial % 10 == 0:
            result += 1
            factorial //= 10
        else:
            break
    print(result)


if __name__ == "__main__":
    solve()
