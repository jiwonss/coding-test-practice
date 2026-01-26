from sys import stdin
from collections import deque

input = stdin.readline


def solve():
    N, K = map(int, input().split())
    A = deque(map(int, input().split()))
    robot = deque([False] * N)

    step = 0
    while True:
        step += 1

        A.rotate(1)
        robot.rotate(1)
        robot[N - 1] = False

        for i in range(N - 2, -1, -1):
            if robot[i] and not robot[i + 1] and A[i + 1] > 0:
                robot[i] = False
                robot[i + 1] = True
                A[i + 1] -= 1
        robot[N - 1] = False

        if A[0] > 0:
            robot[0] = True
            A[0] -= 1

        if A.count(0) >= K:
            print(step)
            break


if __name__ == "__main__":
    solve()
