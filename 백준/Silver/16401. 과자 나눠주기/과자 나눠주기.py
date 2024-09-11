from sys import stdin
input = stdin.readline

m, n = map(int, input().split())
arr = list(map(int, input().split()))

answer = 0
start, end = 1, max(arr)
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in range(n):
        cnt += arr[i] // mid
    if cnt >= m:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1
print(answer)