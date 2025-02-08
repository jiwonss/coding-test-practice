import re

def solution(new_id):
    # 1단계
    new_id = new_id.lower()
    
    # 2단계
    new_id = ''.join(re.sub("[^a-z0-9-_.]", "", new_id))

    # 3단계
    while ".." in new_id:
        new_id = new_id.replace("..", ".")
    
    # 4단계
    if len(new_id) > 1:
        if new_id[0] == ".":
            new_id = new_id[1:]
        if new_id[-1] == ".":
            new_id = new_id[:-1]
    if len(new_id) == 1 and new_id[0] == '.':
        new_id = ""
                     
    # 5단계
    if new_id == "":
        new_id += "a"
                    
    # 6단계
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[-1] == ".":
            new_id = new_id[:-1]
    
    # 7단계
    if len(new_id) <= 2:
            while len(new_id) != 3:
                new_id += new_id[-1]
    
    return new_id