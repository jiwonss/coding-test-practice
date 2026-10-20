n = int(input())

# Please write your code here.
def is_bad(arr):
    for i in range(1, len(arr) // 2 + 1):
        if arr[-i:] == arr[-2 * i: -i]:
            return True
    return False 

def dfs(idx, arr):
    if idx == n:
        print(''.join(map(str, arr)))
        return True

    for i in [4, 5, 6]:
        arr.append(i)
        if not is_bad(arr):
            if dfs(idx + 1, arr):
                return True
        arr.pop()
    return False

arr = []
dfs(0, arr)