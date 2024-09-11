from sys import stdin

input = stdin.readline


def solve():
    S = input().strip()

    result = [0, 0]
    for i in range(1, len(S)):
        if S[i - 1] != S[i]:
            result[int(S[i - 1])] += 1

    print(max(result))


if __name__ == "__main__":
    solve()
