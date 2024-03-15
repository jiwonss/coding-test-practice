from sys import stdin
input = stdin.readline

n = int(input())
a = set(map(int, input().split()))
m = int(input())
arr = list(map(int, input().split()))

for num in arr:
    if num in a:
        print(1)
    else:
        print(0) 
