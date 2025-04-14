from sys import stdin

input = stdin.readline

magic_squares = [
    [8, 1, 6, 3, 5, 7, 4, 9, 2],
    [6, 1, 8, 7, 5, 3, 2, 9, 4],
    [4, 9, 2, 3, 5, 7, 8, 1, 6],
    [2, 9, 4, 7, 5, 3, 6, 1, 8],
    [8, 3, 4, 1, 5, 9, 6, 7, 2],
    [4, 3, 8, 9, 5, 1, 2, 7, 6],
    [6, 7, 2, 1, 5, 9, 8, 3, 4],
    [2, 7, 6, 9, 5, 1, 4, 3, 8],
]


def solve():
    A = []
    for _ in range(3):
        A.extend(list(map(int, input().split())))

    result = float("inf")
    for magic_square in magic_squares:
        cost = sum([abs(a - b) for a, b in zip(magic_square, A)])
        result = min(result, cost)
    print(result)


if __name__ == "__main__":
    solve()
