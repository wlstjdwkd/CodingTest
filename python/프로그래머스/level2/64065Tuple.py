import re
from collections import Counter
s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"

s = Counter(re.findall('\d+', s))
print(s.items())
print(list(map(int, [k for k, v in sorted(
    s.items(), key=lambda x: x[1], reverse=True)])))
