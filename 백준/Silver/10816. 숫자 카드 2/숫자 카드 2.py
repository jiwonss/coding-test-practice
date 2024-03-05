from sys import stdin
from collections import Counter
input = stdin.readline

n = int(input())
card = Counter(list(map(int, input().split())))
m = int(input())
arr = list(map(int, input().split()))

for a in arr:
    print(card[a], end=' ')
