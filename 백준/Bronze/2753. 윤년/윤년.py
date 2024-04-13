from sys import stdin
input = stdin.readline


def solve():
    year = int(input())
    if year % 4 == 0 and (year % 100 != 0 or year % 400 == 0):
        return 1
    return 0


if __name__ == "__main__":
    print(solve())
