from sys import stdin
input = stdin.readline


def solve():
    num = [i for i in range(21)]
    for _ in range(10):
        a, b = map(int, input().split())
        temp = num[a:b + 1]
        for i in range(a, b + 1):
            num[i] = temp[b - i]
    print(*num[1:])


if __name__ == "__main__":
    solve()
