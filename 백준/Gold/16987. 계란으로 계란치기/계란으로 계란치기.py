from sys import stdin

input = stdin.readline


def crack(k):
    global cnt, result

    if k == N:
        result = max(result, cnt)
        return

    if egg[k][0] <= 0 or cnt == N - 1:
        crack(k + 1)
        return

    for i in range(N):
        if i == k or egg[i][0] <= 0:
            continue

        egg[i][0] -= egg[k][1]
        egg[k][0] -= egg[i][1]

        if egg[i][0] <= 0:
            cnt += 1
        if egg[k][0] <= 0:
            cnt += 1

        crack(k + 1)

        if egg[i][0] <= 0:
            cnt -= 1
        if egg[k][0] <= 0:
            cnt -= 1

        egg[i][0] += egg[k][1]
        egg[k][0] += egg[i][1]


def solve():
    global N, egg, visited, cnt, result

    N = int(input())
    egg = [list(map(int, input().split())) for _ in range(N)]

    cnt, result = 0, 0
    crack(0)
    print(result)


if __name__ == "__main__":
    solve()
