from sys import stdin
input = stdin.readline


def solve():
    s = input().strip()

    stack, result = [], 0
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(s[i])
        else:
            stack.pop()
            if s[i - 1] == ')':
                result += 1
            else:
                result += len(stack)
    print(result)


if __name__ == "__main__":
    solve()
