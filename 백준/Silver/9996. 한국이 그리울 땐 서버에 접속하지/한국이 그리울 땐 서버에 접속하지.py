import re
from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    pattern = input().strip().replace("*", ".*")
    p = re.compile(f"^{pattern}$")

    for _ in range(N):
        file_name = input().strip()
        if p.match(file_name):
            print("DA")
        else:
            print("NE")


if __name__ == "__main__":
    solve()
