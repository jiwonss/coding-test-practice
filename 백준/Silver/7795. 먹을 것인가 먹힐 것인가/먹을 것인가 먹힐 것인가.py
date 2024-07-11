from sys import stdin
from bisect import bisect
input = stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = sorted(list(map(int, input().split())))
    b = sorted(list(map(int, input().split())))
    
    cnt = 0
    for i in range(n):
        cnt += bisect(b, a[i] - 1)
    print(cnt)