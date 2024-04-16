from sys import stdin
input = stdin.readline


def check(height):
    total = sum(height)
    for i in range(8):
        for j in range(i + 1, 9):
            if total - (height[i] + height[j]) == 100:
                return [i, j]


def solve():
    height = sorted([int(input()) for _ in range(9)])
    idx = check(height)
    for h in [height[i] for i in range(9) if i not in idx]:
        print(h)


if __name__ == "__main__":
    solve()
