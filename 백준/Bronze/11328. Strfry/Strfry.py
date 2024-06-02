from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    for _ in range(N):
        s1, s2 = input().split()
        check = [0] * 26
        for s in s1:
            check[97 - ord(s)] += 1
        for s in s2:
            check[97 - ord(s)] -= 1

        if check.count(0) == 26:
            print("Possible")
        else:
            print("Impossible")


if __name__ == "__main__":
    solve()
