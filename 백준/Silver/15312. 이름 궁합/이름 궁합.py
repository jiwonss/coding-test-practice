from sys import stdin
from collections import deque

input = stdin.readline


def solve():
    A = input().strip()
    B = input().strip()

    alphabet = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

    name = []
    for i in range(len(A)):
        name.append(A[i])
        name.append(B[i])

    stroke = deque()
    for i in range(len(name)):
        stroke.append(alphabet[ord(name[i]) - 65])

    while len(stroke) > 2:
        temp = [(stroke[i] + stroke[i + 1]) % 10 for i in range(len(stroke) - 1)]
        stroke = temp

    result = "".join(map(str, stroke))
    print(result)


if __name__ == "__main__":
    solve()
