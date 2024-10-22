from sys import stdin, maxsize

input = stdin.readline


def solve():
    N = int(input())
    A = list(map(int, input().split()))

    left, right, min_value = 0, N - 1, maxsize
    result = [0, 0]
    while left < right:
        value = A[left] + A[right]

        if abs(value) < min_value:
            result = [A[left], A[right]]
            min_value = abs(value)

        if value == 0:
            break

        if value < 0:
            left += 1
        else:
            right -= 1

    print(*result)


if __name__ == "__main__":
    solve()
