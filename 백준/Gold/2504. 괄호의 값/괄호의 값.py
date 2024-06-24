from sys import stdin
input = stdin.readline


def solve():
    s = input().strip()

    check, stack, n, result = 0, [], 1, 0
    for i in range(len(s)):
        if s[i] == '(':
            n *= 2
            stack.append(s[i])
        if s[i] == '[':
            n *= 3
            stack.append(s[i])
        if s[i] == ')':
            if not stack or stack[-1] != '(':
                check = 1
                break
            stack.pop()
            if s[i - 1] == '(':
                result += n
            n //= 2
        if s[i] == ']':
            if not stack or stack[-1] != '[':
                check = 1
                break
            stack.pop()
            if s[i - 1] == '[':
                result += n
            n //= 3

    if check or stack:
        print(0)
    else:
        print(result)


if __name__ == "__main__":
    solve()
