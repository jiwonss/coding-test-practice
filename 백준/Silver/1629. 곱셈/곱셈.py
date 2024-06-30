from sys import stdin
input = stdin.readline


def pow(a, b):
    if b == 1:
        return a % C

    v = pow(a, b // 2)
    v = v * v % C

    if b % 2 == 0:
        return v
    else:
        return v * a % C


def solve():
    global A, B, C

    A, B, C = map(int, input().split())
    print(pow(A, B))


if __name__ == "__main__":
    solve()
