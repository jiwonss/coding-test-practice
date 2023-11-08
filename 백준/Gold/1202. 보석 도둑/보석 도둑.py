import heapq
from sys import stdin
input = stdin.readline

n, k = map(int, input().split())
jewelry_list = sorted([list(map(int, input().split())) for _ in range(n)])
bag_list = sorted([int(input()) for _ in range(k)])

heap = []
answer = 0
for bag in bag_list:
    while jewelry_list and bag >= jewelry_list[0][0]:
        heapq.heappush(heap, -jewelry_list[0][1])
        heapq.heappop(jewelry_list)
    if heap:
        answer += heapq.heappop(heap)
print(-answer)