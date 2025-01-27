def solution(cards1, cards2, goal):
    idx = 0
    while idx < len(goal):
        if cards1 and cards1[0] == goal[idx]:
            cards1.pop(0)
            idx += 1
        elif cards2 and cards2[0] == goal[idx]:
            cards2.pop(0)
            idx += 1
        else:
            break
    return 'Yes' if idx == len(goal) else 'No'