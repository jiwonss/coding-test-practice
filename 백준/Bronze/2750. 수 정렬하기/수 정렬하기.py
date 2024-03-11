from sys import stdin
input = stdin.readline

# input
N = int(input())
num = [int(input()) for _ in range(N)]

# print
for n in sorted(num):
  print(n) 