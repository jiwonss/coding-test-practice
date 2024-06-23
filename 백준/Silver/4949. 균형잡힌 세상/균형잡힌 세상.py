from sys import stdin
input = stdin.readline


def solve():
    while True:
        word = input()
        if word[0] == '.':
            break

        check, stack = 0, []
        for w in word:
            if w == '(' or w == '[':
                stack.append(w)
            elif w == ')':
                if not stack or stack[-1] != '(':
                    check = 1
                    break
                stack.pop()
            elif w == ']':
                if not stack or stack[-1] != '[':
                    check = 1
                    break
                stack.pop()

        if stack or check:
            print('no')
        else:
            print('yes')


if __name__ == "__main__":
    solve()
