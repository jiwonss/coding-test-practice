def check(s):
    stack = []
    for c in s:
        if c in ['(', '[', '{']:
            stack.append(c)
            continue
        if not stack:
            return 0
        if c == ')' and stack[-1] == '(':
            stack.pop()
        if c == ']' and stack[-1] == '[':
            stack.pop()
        if c == '}' and stack[-1] == '{':
            stack.pop()
    return 0 if stack else 1

def solution(s):
    answer = 0
    for i in range(len(s)):
        if (check(s[i:] + s[:i])):
            answer += 1
    return answer