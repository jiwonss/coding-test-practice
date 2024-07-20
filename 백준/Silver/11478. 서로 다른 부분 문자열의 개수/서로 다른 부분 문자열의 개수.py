from sys import stdin
input = stdin.readline


def solve():
    S = input().strip()

    result = set()
    for i in range(len(S)):
        for j in range(i + 1, len(S) + 1):
            result.add(S[i:j])
    print(len(result))


if __name__ == "__main__":
    solve()
