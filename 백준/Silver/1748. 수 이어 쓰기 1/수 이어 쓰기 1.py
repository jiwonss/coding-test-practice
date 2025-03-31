n = int(input())
length = len(str(n))
cnt = 0

for i in range(length - 1):
    cnt += 9 * 10 ** i * (i + 1)

print(cnt + (n - 10 ** (length - 1) + 1) * length)

