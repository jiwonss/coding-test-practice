MAX = 1200001
pre = [-1] * MAX
nxt = [-1] * MAX

def solution(n, k, cmd):
    status = ['O'] * n
    
    for i in range(n):
        pre[i], nxt[i] = i - 1, i + 1
        
    nxt[n - 1] = -1
    cursor = k
    erased = []
    
    for query in cmd:
        parse = query.split()
        
        if parse[0] == 'U':
            num = int(parse[1])
            for _ in range(num):
                cursor = pre[cursor]
        elif parse[0] == 'D':
            num = int(parse[1])
            for _ in range(num):
                cursor = nxt[cursor]
        elif parse[0] == 'C':
            erased.append((pre[cursor], cursor, nxt[cursor]))
            if pre[cursor] != -1:
                nxt[pre[cursor]] = nxt[cursor]
            if nxt[cursor] != -1:
                pre[nxt[cursor]] = pre[cursor]
            status[cursor] = 'X'
            
            if nxt[cursor] != -1:
                cursor = nxt[cursor]
            else:
                cursor = pre[cursor]
        else:
            p, c, n = erased.pop()
            if p != -1:
                nxt[p] = c
            if n != -1:
                pre[n] = c
            status[c] = 'O'
            
    return ''.join(status)