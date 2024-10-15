from sys import stdin

input = stdin.readline


def binary_search(n):
    start, end = 0, len(stack)
    while start < end:
        mid = (start + end) // 2
        if stack[mid] < n:
            start = mid + 1
        else:
            end = mid
    return start


def solve():
    global stack

    N = int(input())
    A = list(map(int, input().split()))

    stack = []
    for a in A:
        idx = binary_search(a)

        if idx == len(stack):
            stack.append(a)
        else:
            stack[idx] = a

    result = len(stack)
    print(result)


if __name__ == "__main__":
    solve()
