from sys import stdin
from collections import deque
input = stdin.readline


def solve():
    n, w, L = map(int, input().split())
    truck = deque(map(int, input().split()))

    time, bridge = 0, deque([0] * w)
    while bridge:
        time += 1
        bridge.popleft()
        if truck:
            if sum(bridge) + truck[0] <= L:
                bridge.append(truck.popleft())
            else:
                bridge.append(0)
    print(time)


if __name__ == "__main__":
    solve()
