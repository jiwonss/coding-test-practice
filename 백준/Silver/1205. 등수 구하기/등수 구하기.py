from sys import stdin

input = stdin.readline


def solve():
    N, score, P = map(int, input().split())

    rank = []
    if N > 0:
        rank.extend(list(map(int, input().split())))

    if N == 0:
        print(1)
        return

    if N == P and score <= rank[-1]:
        print(-1)
        return

    result = 1
    for i in range(N):
        if score < rank[i]:
            result += 1
        else:
            break
    print(result)


if __name__ == "__main__":
    solve()
