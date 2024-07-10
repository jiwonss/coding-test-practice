from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    word = {input().strip() for _ in range(N)}

    result = sorted(word, key=lambda x: (len(x), x))
    for r in result:
        print(r)


if __name__ == "__main__":
    solve()
