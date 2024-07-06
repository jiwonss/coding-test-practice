from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    user = []
    for i in range(N):
        age, name = input().split()
        user.append([i, int(age), name])

    result = sorted(user, key=lambda x: (x[1], x[0]))
    for r in result:
        print(*r[1:])


if __name__ == "__main__":
    solve()
