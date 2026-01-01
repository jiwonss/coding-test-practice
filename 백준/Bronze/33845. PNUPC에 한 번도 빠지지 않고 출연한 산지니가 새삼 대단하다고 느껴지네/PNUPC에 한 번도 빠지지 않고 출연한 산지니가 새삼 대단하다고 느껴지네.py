from sys import stdin

input = stdin.readline


def solve():
    S = input().strip()
    T = input().strip()

    result = ""
    for w in T:
        if w in S:
            continue
        result += w
    print(result)


if __name__ == "__main__":
    solve()
