#!/usr/bin/env python3

if __name__ == "__main__":
    bucketCapacity = [7,5,2]
    fishSize = [4,7,4,1,1,69]
    answer = {}

    for bucket in bucketCapacity:
        answer[bucket] = 0
    
    print("[info] bc = ", bucketCapacity)
    print("[info] fs = ", fishSize)
    print("[info] an = ", answer)
    pos = 0

    for bucket in reversed(bucketCapacity):
        for fish in fishSize:
            if fish <= bucket:
                answer[bucket] += 1
                fishSize.pop()

    print("[info] answer = ", answer)
