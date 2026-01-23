from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    student = []
    for _ in range(N):
        t = input().split()
        student.append([t[0], int(t[1]), int(t[2]), int(t[3])])

    result = sorted(student, key=lambda x: (-x[1], x[2], -x[3], x[0]))
    for r in result:
        print(r[0])


if __name__ == "__main__":
    solve()
