from sys import stdin

input = stdin.readline


def solve():
    while True:
        M, A, B = map(int, input().split())

        if M == A == B == 0:
            break

        T1, T2 = M / A * 3600, M / B * 3600
        diff = round(abs(T1 - T2))

        h, m, s = diff // 3600, (diff % 3600) // 60, diff % 60
        print(f"{h}:{m:02d}:{s:02d}")


if __name__ == "__main__":
    solve()
