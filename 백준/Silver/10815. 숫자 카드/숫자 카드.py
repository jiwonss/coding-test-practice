from sys import stdin
input = stdin.readline

n = int(input())
num = set(map(int, input().split()))
m = int(input())
cards = list(map(int, input().split()))

answer = []
for card in cards:
    if card in num:
        answer.append(1)
    else:
        answer.append(0)
print(*answer)