from sys import stdin
input = stdin.readline


def solve():
    num = [int(input()) for _ in range(9)]
    max_index, max_value = 0, 0
    for i, n in enumerate(num):
        if num[i] > max_value:
            max_value = num[i]
            max_index = i
    print(max_value)
    print(max_index + 1)


if __name__ == "__main__":
    solve()
