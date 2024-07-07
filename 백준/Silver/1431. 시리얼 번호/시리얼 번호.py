from sys import stdin
input = stdin.readline

n = int(input())
serial_nums = []
for _ in range(n):
    t = input().strip()
    num = sum([int(a) for a in t if a.isdigit()])
    serial_nums.append([t, num])

for num in sorted(serial_nums, key=lambda x: (len(x[0]), x[1], x[0])):
    print(num[0])