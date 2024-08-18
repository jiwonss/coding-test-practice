from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    P = sorted(list(map(int, input().split())))

    result = [0]
    for i in range(N):
        result.append(result[-1] + P[i])
    print(sum(result))


if __name__ == "__main__":
    solve()
