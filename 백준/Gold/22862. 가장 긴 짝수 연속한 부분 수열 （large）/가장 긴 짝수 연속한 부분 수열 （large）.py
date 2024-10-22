from sys import stdin

input = stdin.readline


def solve():
    N, K = map(int, input().split())
    S = list(map(int, input().split()))

    left, right = 0, 0
    odd, even, result = 0, 0, 0
    while right < N:
        if S[right] % 2:
            odd += 1
        else:
            even += 1

        while odd > K:
            if S[left] % 2:
                odd -= 1
            else:
                even -= 1
            left += 1

        result = max(result, even)
        right += 1

    print(result)


if __name__ == "__main__":
    solve()
