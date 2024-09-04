from sys import stdin
input = stdin.readline


def get_prime_number_list(n, k):
    arr = [1] * (n + 1)
    arr[0] = arr[1] = 0

    idx = 0
    for i in range(2, n + 1):
        for j in range(i, n + 1, i):
            if arr[j]:
                arr[j] = 0
                idx += 1
                if idx == k:
                    return j


def solve():
    N, K = map(int, input().split())

    print(get_prime_number_list(N, K))


if __name__ == "__main__":
    solve()
