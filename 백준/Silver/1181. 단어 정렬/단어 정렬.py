from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    word = list(set([input().strip() for _ in range(N)]))

    word.sort(key=lambda x: (len(x), x))

    print(*word, sep="\n")


if __name__ == "__main__":
    solve()
