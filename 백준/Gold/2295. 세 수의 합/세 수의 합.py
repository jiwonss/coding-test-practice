from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    U = set([int(input()) for _ in range(N)])

    temp = set()
    for x in U:
        for y in U:
            temp.add(x + y)

    result = 0
    for x in U:
        for y in U:
            if (x - y) in temp:
                result = max(result, x)
    print(result)


if __name__ == "__main__":
    solve()
