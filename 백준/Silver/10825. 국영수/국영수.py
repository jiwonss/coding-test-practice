from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    score = []
    for _ in range(N):
        temp = input().split()
        score.append([temp[0], int(temp[1]), int(temp[2]), int(temp[3])])

    result = sorted(score, key=lambda x: (-x[1], x[2], -x[3], x[0]))
    for r in result:
        print(r[0])


if __name__ == "__main__":
    solve()
