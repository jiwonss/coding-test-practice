def solution(m, n, startX, startY, balls):
    answer = []
    for x, y in balls:
        distance = []
        if not (startY == y and startX > x):
            d = ((-startX) - x) ** 2 + (startY - y) ** 2
            distance.append(d)
        if not (startY == y and startX < x):
            d = ((2 * m - startX) - x) ** 2 + (startY - y) ** 2
            distance.append(d)
        if not (startX == x and startY > y):
            d = (startX - x) ** 2 + ((-startY) - y) ** 2
            distance.append(d)
        if not (startX == x and startY < y):
            d = (startX - x) ** 2 + ((2 * n - startY) - y) ** 2
            distance.append(d)
        answer.append(min(distance))
    return answer