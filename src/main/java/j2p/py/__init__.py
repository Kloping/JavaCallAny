import sys


def m1():
    return "Python 内部方法返回值"


def m2(m="示例输出"):
    return "Python Out: " + m


args = sys.argv
if len(args) != 0:
    print(m1())
    print(m2(args[1]))
