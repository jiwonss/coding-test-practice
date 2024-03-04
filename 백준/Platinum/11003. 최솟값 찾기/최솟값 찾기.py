from sys import stdin
from collections import deque
input = stdin.readline

n, l = map(int, input().split())
a = list(map(int, input().split()))

q = deque()
for i in range(n):
    while q and q[-1][0] > a[i]:
        q.pop()
    while q and q[0][1] < i - l + 1:
        q.popleft()
    q.append([a[i], i])
    print(q[0][0], end=' ')
