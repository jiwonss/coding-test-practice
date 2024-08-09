from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    time = [list(map(int, input().split())) for _ in range(N)]
    time = sorted(time, key=lambda x: (x[1], x[0]))

    cur, result = 0, 0
    for i in range(N):
        if time[i][0] < cur:
            continue
        cur = time[i][1]
        result += 1
    print(result)


if __name__ == "__main__":
    solve()
