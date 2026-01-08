from sys import stdin

input = stdin.readline


def solve():
    S = input().strip()
    tag, stack = 0, []
    result = ""
    for i in range(len(S)):
        if tag:
            result += S[i]
            if S[i] == ">":
                tag = 0
        else:
            if S[i] == " " or S[i] == "<":
                if stack:
                    result += "".join(stack)[::-1]
                    stack = []
                result += S[i]
                if S[i] == "<":
                    tag = 1
            else:
                stack.append(S[i])
    if stack:
        result += "".join(stack)[::-1]
    print(result)


if __name__ == "__main__":
    solve()
