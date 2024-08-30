from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    card = set(map(int, input().split()))
    M = int(input())
    arr = list(map(int, input().split()))

    for i in range(M):
        if arr[i] in card:
            print(1, end=' ')
        else:
            print(0, end=' ')


if __name__ == "__main__":
    solve()
