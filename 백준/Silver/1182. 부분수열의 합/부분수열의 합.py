from sys import stdin
input = stdin.readline


def subsequence(k, total):
    global result

    if k == N:
        if total == S:
            result += 1
        return

    subsequence(k + 1, total)
    subsequence(k + 1, total + arr[k])


def solve():
    global N, S, arr, visited, result

    N, S = map(int, input().split())
    arr = list(map(int, input().split()))

    result = 0
    subsequence(0, 0)

    if S == 0:
        result -= 1
    print(result)


if __name__ == "__main__":
    solve()
