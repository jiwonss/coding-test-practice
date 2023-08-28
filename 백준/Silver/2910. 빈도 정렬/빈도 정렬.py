from sys import stdin
from collections import defaultdict
input = stdin.readline

N, C = map(int, input().split())
arr = list(map(int, input().split()))

dic = defaultdict(list)
for i, a in enumerate(arr):
    if (dic.get(a, 0)):
        dic[a][1] += 1
    else:
        dic[a].append(i)
        dic[a].append(1)

temp = sorted(dic.items(), key=lambda x : (-x[1][1], x[1][0]))
for k, v in temp:
    for _ in range(v[1]):
        print(k, end=" ")
