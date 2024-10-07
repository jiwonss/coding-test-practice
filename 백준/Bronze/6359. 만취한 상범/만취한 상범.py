from sys import stdin

input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        n = int(input())

        room = [1] * (n + 1)
        for i in range(2, n + 1):
            for j in range(i, n + 1, i):
                room[j] *= -1

        result = room[1:].count(1)
        print(result)


if __name__ == "__main__":
    solve()
