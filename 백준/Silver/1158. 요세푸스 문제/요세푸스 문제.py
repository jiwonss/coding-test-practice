from sys import stdin
input = stdin.readline

n, k = map(int, input().split())
people = [i for i in range(1, n + 1)]

print('<', end='')
idx = k - 1
for _ in range(n):
    if idx < len(people):
        print(people.pop(idx), end='')
    else:
        idx %= len(people)
        print(people.pop(idx), end='')
    idx += k - 1
    if people:
        print(", ", end='')
print('>')