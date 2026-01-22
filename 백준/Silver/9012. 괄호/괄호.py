from sys import stdin

input = stdin.readline


def check(s):
    stack = []
    for i in range(len(s)):
        if s[i] == "(":
            stack.append(s[i])
        else:
            if not stack:
                return "NO"
            stack.pop()
    return "NO" if stack else "YES"


def solve():
    T = int(input())
    for _ in range(T):
        s = input().strip()
        print(check(s))


if __name__ == "__main__":
    solve()
