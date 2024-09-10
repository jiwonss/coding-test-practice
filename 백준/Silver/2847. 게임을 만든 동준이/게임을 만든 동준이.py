from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    score = [int(input()) for _ in range(N)]

    if N == 1:
        return 0

    result = 0
    for i in range(N - 2, -1, -1):
        if score[i] < score[i + 1]:
            continue
        result += score[i] - score[i + 1] + 1
        score[i] = score[i + 1] - 1
    print(result)


if __name__ == "__main__":
    solve()
