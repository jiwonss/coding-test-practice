def solution(brown, yellow):
    for i in range(1, int(yellow ** 0.5) + 1):
        w, h = yellow // i, i
        if yellow % h == 0 and 2 * (w + h) == brown - 4:
            return [w + 2, h + 2]