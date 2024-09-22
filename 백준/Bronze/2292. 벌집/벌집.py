from sys import stdin

input = stdin.readline


def solve():
    N = int(input())

    room, cnt = 1, 1
    while room < N:
        room += 6 * cnt
        cnt += 1
    print(cnt)


if __name__ == "__main__":
    solve()
