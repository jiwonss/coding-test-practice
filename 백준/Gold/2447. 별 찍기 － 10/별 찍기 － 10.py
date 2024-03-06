def draw_star(s):
    matrix = []
    for i in range(3 * len(s)):
        if i // len(s) == 1:
            matrix.append(s[i % len(s)] + " " * len(s) + s[i % len(s)])
        else:
            matrix.append(s[i % len(s)] * 3)
    return list(matrix)


star = ["***", "* *", "***"]
n = int(input())
cnt = 0
while n != 3:
    n = int(n / 3)
    cnt += 1

for i in range(cnt):
    star = draw_star(star)

for i in star:
    print(i)