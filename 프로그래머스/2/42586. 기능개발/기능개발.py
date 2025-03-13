def solution(progresses, speeds):
    release = []
    for p, s in zip(progresses, speeds):
        div, mod = divmod(100 - p, s)
        release.append(div if mod == 0 else div + 1)
        
    stack, answer = [], []
    for r in release:
        if stack and stack[0] < r:
            answer.append(len(stack))
            stack.clear()
        stack.append(r)
    answer.append(len(stack))
    return answer