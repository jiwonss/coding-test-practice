from sys import stdin
input = stdin.readline

k, l = map(int, input().split())
waiting_list = {}
for i in range(l):
    t = input().strip()
    waiting_list[t] = i

cnt = 0
for key, value in sorted(waiting_list.items(), key=lambda x : x[1]):
    cnt += 1
    if cnt > k:
        break
    print(key)