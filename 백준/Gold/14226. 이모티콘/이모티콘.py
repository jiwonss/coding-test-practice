from collections import deque

def bfs():
    q = deque()
    q.append([1, 0])
    emoji[1][0] = 0

    while q:
        s, c = q.popleft()
        if emoji[s][s] == -1:
           emoji[s][s] = emoji[s][c] + 1
           q.append([s, s])
        if s + c <= n and emoji[s + c][c] == -1:
            emoji[s + c][c] = emoji[s][c] + 1
            q.append([s + c, c])
        if s - 1 >= 0 and emoji[s - 1][c] == -1:
            emoji[s - 1][c] = emoji[s][c] + 1
            q.append([s - 1, c])

n = int(input())
emoji = [[-1] * (n + 1) for _ in range(n + 1)]

bfs()

answer = -1
for i in range(n + 1):
    if emoji[n][i] != -1:
        if answer == -1 or answer > emoji[n][i]:
            answer = emoji[n][i]
            
print(answer)