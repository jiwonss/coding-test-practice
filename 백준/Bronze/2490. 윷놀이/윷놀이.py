from sys import stdin
input = stdin.readline


def check(cnt):
    if cnt == 3:
        return "A"
    if cnt == 2:
        return "B"
    if cnt == 1:
        return "C"
    if cnt == 0:
        return "D"
    return "E"


def solve():
    for _ in range(3):
        arr = list(map(int, input().split()))
        print(check(sum(arr)))


if __name__ == "__main__":
    solve()
