from sys import stdin
input = stdin.readline


def check(k, x, y):
    for i in range(x, x + k):
        for j in range(y, y + k):
            if paper[i][j] != paper[x][y]:
                return 0
    return 1


def cut(k, x, y):
    if check(k, x, y):
        result[paper[x][y]] += 1
        return

    k //= 2
    for i in range(2):
        for j in range(2):
            cut(k, x + i * k, y + j * k)


def solve():
    global N, paper, result

    N = int(input())
    paper = [list(map(int, input().split())) for _ in range(N)]

    result = [0, 0]
    cut(N, 0, 0)

    print(result[0])
    print(result[1])


if __name__ == "__main__":
    solve()
