from sys import stdin
input = stdin.readline


def solve():
    s = input().strip()

    N = len(s)
    M = int(input())

    left, right = [s[i] for i in range(N)], []

    for _ in range(M):
        op = list(input().split())
        if op[0] == 'L':
            if left:
                right.append(left.pop())
        elif op[0] == 'D':
            if right:
                left.append(right.pop())
        elif op[0] == 'B':
            if left:
                left.pop()
        else:
            left.append(op[1])
    result = left + right[::-1]
    print(''.join(result))


if __name__ == "__main__":
    solve()
