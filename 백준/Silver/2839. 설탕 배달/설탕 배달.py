from sys import stdin

input = stdin.readline


def solve():
    N = int(input())

    result = 0
    while N != 0:
        if N % 5 == 0:
            N -= 5
            result += 1
        else:
            N -= 3
            if N < 0:
                result = -1
                break
            result += 1
    print(result)


if __name__ == "__main__":
    solve()
