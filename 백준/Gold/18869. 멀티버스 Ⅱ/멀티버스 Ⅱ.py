from sys import stdin
from collections import defaultdict
input = stdin.readline

m, n = map(int, input().split())
universe = defaultdict(int)
for _ in range(m):
    planet = list(map(int, input().split()))
    key = sorted(list(set(planet)))
    rank = {key[i]: i for i in range(len(key))}
    universe[tuple([rank[p] for p in planet])] += 1

answer = 0
for v in universe.values():
    answer += v * (v - 1) // 2
print(answer)