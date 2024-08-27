from sys import stdin
input = stdin.readline


def create_password(k, start):
    if k == L:
        cnt = 0
        for i in range(L):
            if result[i] in vowel:
                cnt += 1
        if cnt >= 1 and L - cnt >= 2:
            print(''.join(result))
        return

    for i in range(start, C):
        if visited[i]:
            continue
        result[k] = chars[i]
        visited[i] = 1
        create_password(k + 1, i + 1)
        visited[i] = 0


def solve():
    global L, C, vowel, chars, visited, result

    L, C = map(int, input().split())
    chars = sorted(input().split())

    vowel = 'aeiou'
    visited, result = [0] * C, [0] * L
    create_password(0, 0)


if __name__ == "__main__":
    solve()
