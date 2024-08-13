from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    A = sorted(list(map(int, input().split())))
    B = sorted(list(map(int, input().split())), reverse=True)

    result = 0
    for i in range(N):
        result += A[i] * B[i]
    print(result)


if __name__ == "__main__":
    solve()
