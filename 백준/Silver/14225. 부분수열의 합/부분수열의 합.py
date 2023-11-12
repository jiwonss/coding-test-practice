from sys import stdin
input = stdin.readline

N = int(input())
S = list(map(int, input().split()))

result = 0
for i in [*sorted(S)]:
    if result + 1 < i: break
    result += i
print(result + 1)